Situación de concurrencia en la que dos (o más) procesos intentan acceder a dos (o más) recursos/locks, tomándolos en distinto orden, y como consecuencia ninguno logra avanzar: cada uno queda esperando indefinidamente a que el otro libere el recurso que necesita.

Un intento ingenuo de solucionar un deadlock mediante tiempo de espera y reintento puede derivar en un [[LiveLock]], si el ciclo de espera y reintento se repite infinitamente sin que ningún proceso logre avanzar.

## Ejemplo: locks por instancia con llamadas cruzadas

Un caso clásico de deadlock ocurre cuando dos objetos tienen métodos `synchronized` que se llaman mutuamente. Por ejemplo, una clase `Friend` con métodos `synchronized void bow(Friend bower)` (que internamente llama a `bower.bowBack(this)`) y `synchronized void bowBack(Friend bower)`:

- El Thread 1 ejecuta `f1.bow(f2)`, tomando el lock de `f1`.
- El Thread 2 ejecuta `f2.bow(f1)`, tomando el lock de `f2`.
- El Thread 1 necesita ahora ejecutar `f2.bowBack(f1)`, pero el lock de `f2` lo tiene el Thread 2 → se bloquea.
- El Thread 2 necesita ejecutar `f1.bowBack(f2)`, pero el lock de `f1` lo tiene el Thread 1 → se bloquea.

Ambos threads quedan esperando indefinidamente el lock que tiene el otro: deadlock.

### Solución

Reemplazar el lock implícito por instancia (`this`, distinto para cada `Friend`) por un **único lock compartido** entre todas las instancias (por ejemplo, un campo `static final Object lock`), y sincronizar ambos métodos con ese mismo lock. De esta manera, sólo un thread a la vez puede estar dentro de cualquier combinación de `bow`/`bowBack` sobre cualquier par de `Friend`, eliminando la posibilidad de que dos threads tomen locks distintos y se bloqueen mutuamente esperando el del otro.

Este análisis forma parte del checklist de [[Análisis de Concurrencia en Código]].
