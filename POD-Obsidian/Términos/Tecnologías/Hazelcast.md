Framework para la construcción de [[Sistema Distribuido|sistemas distribuidos]] en memoria (in-memory data grid), utilizado entre otras cosas para implementar procesos de [[MapReduce]].

## Split Brain

En Hazelcast puede ocurrir el fenómeno de [[Split Brain]], por ejemplo cuando se cae el nodo maestro del cluster. Ante esta situación, el framework provee un mecanismo propio de recuperación para reconectar los nodos y mergear los datos generados durante la división.

## Combiner y reset()

Al implementar un [[Combiner]] en Hazelcast, es necesario definir el método `reset()`, dado que la misma instancia del Combiner puede ser reutilizada para procesar distintas claves, por lo que necesita reiniciar su estado interno entre una clave y otra.
