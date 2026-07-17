Guía práctica para resolver ejercicios del tipo "analizar si esta clase es thread-safe / hacerla concurrente". Este tipo de ejercicio da una clase que será usada por varios threads y pide indicar si tiene riesgos, explicar cómo falla, y proponer una solución.

## Checklist de análisis

Al analizar una clase, conviene revisar en orden:

1. **¿El objeto es inmutable?** Si todos sus campos son `final`, no tiene setters, y el estado no puede modificarse luego de construido, es automáticamente thread-safe: no necesita sincronización. Ver [[Objeto Inmutable]].
   - Cuidado: un campo `final` no implica que su **contenido** sea inmutable (por ejemplo un `String[]` o una `List` mutable guardada en un campo final). Ver [[Objeto Inmutable]].
2. **¿Hay estado mutable compartido entre threads?** Si sí, buscar todos los puntos donde ese estado se lee o escribe.
3. **¿Todos los accesos (lectura Y escritura) están protegidos con el mismo lock?** Un error muy común es sincronizar con dos locks distintos (por ejemplo, un método `synchronized` de instancia usa `this` como lock, mientras otro bloque usa un `Object` dedicado). Si los locks no son el mismo, la protección es inútil. Ver [[Race Condition]].
4. **¿Hay una secuencia "check-then-act"?** Es decir, ¿se pregunta algo (`if (!map.containsKey(x))`) y luego se actúa (`map.put(x, ...)`) en pasos separados, sin que ambos pasos sean atómicos? Aunque se use una colección thread-safe como `ConcurrentHashMap`, la secuencia completa puede no serlo. Ver [[Race Condition]].
5. **¿Hay riesgo de Deadlock o LiveLock?** Esto aparece típicamente cuando dos threads necesitan tomar dos locks en distinto orden (p. ej. dos objetos que se llaman mutuamente con métodos `synchronized`). Ver [[Deadlock]] y [[LiveLock]].
6. **¿El método `synchronized` es demasiado abarcativo?** Sincronizar un método entero (en vez de solo la sección crítica) serializa innecesariamente el acceso a la instancia completa, degradando la concurrencia real del sistema.

## Soluciones típicas

- Sincronizar todos los accesos (lectura y escritura) bajo el **mismo** objeto lock.
- Reemplazar una operación check-then-act por una operación atómica (por ejemplo `putIfAbsent` en vez de `containsKey` + `put`), o envolver ambos pasos dentro de un mismo bloque `synchronized`.
- Usar clases pensadas para concurrencia como `AtomicInteger`/`AtomicLong` para contadores, en vez de variables primitivas modificadas desde lambdas o múltiples threads.
- Preferir objetos inmutables cuando sea posible: son thread-safe por naturaleza y no requieren sincronización porque su estado no cambia luego de construidos.
- Si dos objetos se llaman mutuamente bajo lock, usar un único lock compartido (por ejemplo un objeto estático común a ambas instancias) en lugar de un lock por instancia, para evitar el deadlock.
- Acotar el `synchronized` al bloque mínimo necesario (la sección crítica), no al método completo.
