Situación de concurrencia en la que el resultado de una operación depende del orden no determinístico en que se intercalan las ejecuciones de distintos threads sobre un recurso compartido, cuando el acceso a dicho recurso no está correctamente sincronizado.

## Ejemplo: locks distintos para el mismo dato

Un caso típico es el uso inconsistente de bloqueos (`synchronized`) sobre distintos objetos para proteger una misma variable compartida. Por ejemplo, si un método sincroniza la escritura de una variable `counter` usando un objeto de lock dedicado (`lockCounterLock`), pero otro método sincroniza su lectura usando el objeto `this`, en realidad se está utilizando **dos locks distintos** para proteger el mismo dato. Esto no protege correctamente la variable, ya que ambos bloqueos no son mutuamente excluyentes entre sí, permitiendo que ocurran race conditions entre la escritura y la lectura de `counter`. La solución es sincronizar ambos accesos bajo el **mismo** objeto lock.

## Ejemplo: check-then-act (TOCTOU)

Otro patrón habitual de race condition ocurre cuando una operación se compone de un "check" (verificar una condición) seguido de un "act" (actuar en base a esa condición), sin que ambos pasos sean atómicos entre sí. Esto se conoce como **TOCTOU** (Time-Of-Check to Time-Of-Use).

Por ejemplo, una clase `Locker` que implementa `lock(path)` verificando `if (!map.containsKey(path))` y, si no existe, recién ahí hace `map.put(path, "locked")`, tiene este problema aunque internamente use un `ConcurrentHashMap` (que es thread-safe *para cada operación individual*, pero no para la secuencia completa de "verificar y luego escribir"). Dos threads pueden entrar casi al mismo tiempo, ambos ver que la clave no existe todavía, y ambos terminar creyendo que obtuvieron el lock.

La solución típica es sincronizar el método completo (`lock`/`unlock`) con `synchronized`, o reemplazar la secuencia check-then-act por una operación atómica equivalente, como `map.putIfAbsent(path, "locked")`, que devuelve si la clave ya existía en una única operación atómica.

Este análisis forma parte del checklist de [[Análisis de Concurrencia en Código]].
