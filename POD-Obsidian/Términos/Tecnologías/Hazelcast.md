Framework para la construcción de [[Sistema Distribuido|sistemas distribuidos]] en memoria (in-memory data grid), utilizado entre otras cosas para implementar procesos de [[MapReduce]].

## Selección del nodo coordinador y dueño de partición

Por defecto, Hazelcast selecciona como **coordinador** del cluster al nodo de mayor antigüedad (el que lleva más tiempo activo). Este coordinador mantiene una tabla de particiones que indica qué nodo es *owner* (dueño) o *backup* (réplica) de cada partición, y se encarga de distribuir esa tabla a todos los nodos del cluster.

Cuando un nodo se suma o se retira del cluster, el coordinador actualiza la tabla de particiones (reasignando ownership/backups según corresponda) y la vuelve a distribuir a todos los nodos. Si el coordinador se cae, se selecciona como nuevo coordinador al siguiente nodo más antiguo, que recalcula la tabla de particiones.

## Split Brain

En Hazelcast puede ocurrir el fenómeno de [[Split Brain]], por ejemplo cuando se pierde comunicación entre partes del cluster (no necesariamente por la caída del nodo maestro/coordinador, sino por cualquier problema de red que deje al cluster dividido en partes que no pueden verse entre sí). Cada parte aislada puede seguir operando de forma autónoma —incluso eligiendo su propio coordinador si el original quedó en la otra partición— y aceptar escrituras, lo que puede generar conflictos (por ejemplo, dos valores distintos para la misma key) al momento de reconectar las partes.

Hazelcast provee mecanismos para resolver esta situación al reconectar:

- Se elige, entre los coordinadores de ambas partes, al de mayor antigüedad como nuevo coordinador del cluster reunificado.
- Por defecto, se mergea el cluster más chico (en cantidad de nodos) hacia el más grande, aunque esta política es configurable.
- Se puede configurar un tamaño mínimo de cluster requerido para poder operar: si una partición del cluster queda con menos nodos que ese mínimo, Hazelcast lanza una `SplitBrainException` en lugar de permitir que esa partición siga aceptando operaciones.

## Combiner y reset()

Al implementar un [[Combiner]] en Hazelcast, es necesario definir el método `reset()`. El Combiner se instancia por cada clave y trabaja procesando los valores por chunks; `reset()` permite reiniciar su estado interno luego de emitir el resultado parcial de un chunk, para no mezclarlo con el siguiente.
