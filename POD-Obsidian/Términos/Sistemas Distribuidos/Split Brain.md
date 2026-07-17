Problema que puede darse en cualquier [[Sistema Distribuido]] compuesto por varios nodos. Surge cuando, por una falla de comunicación en la red, el cluster queda dividido en dos (o más) partes autónomas que continúan operando de manera independiente, sin saber una de la existencia de la otra.

El problema principal aparece al reconectar los nodos: dado que ambas partes siguieron operando y modificando datos por separado, es necesario **mergear** la información generada en cada partición, lo cual puede generar conflictos.

## Ejemplo: Hazelcast

Este fenómeno puede ocurrir en [[Hazelcast]], por ejemplo cuando se cae el nodo maestro del cluster. Por este motivo, el framework provee un mecanismo propio de recuperación para manejar el merge de datos una vez restablecida la comunicación entre los nodos.
