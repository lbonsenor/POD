Problema que puede darse en cualquier [[Sistema Distribuido]] compuesto por varios nodos. Surge cuando, por una falla de comunicación en la red, el cluster queda dividido en dos (o más) partes autónomas que continúan operando de manera independiente, sin saber una de la existencia de la otra.

El problema principal aparece al reconectar los nodos: dado que ambas partes siguieron operando y modificando datos por separado, es necesario **mergear** la información generada en cada partición, lo cual puede generar conflictos.

## Ejemplo: Hazelcast

Este fenómeno puede ocurrir en [[Hazelcast]], por ejemplo ante una falla de red que aísla a un subconjunto de nodos del resto del cluster. Cada parte aislada puede llegar a elegir su propio coordinador y seguir aceptando escrituras de forma autónoma. Por este motivo, el framework provee mecanismos propios de recuperación (elección de un nuevo coordinador único, merge de la parte más chica hacia la más grande, o directamente impedir operar si una partición queda con muy pocos nodos) para manejar la reunificación una vez restablecida la comunicación entre los nodos. Ver el detalle completo en [[Hazelcast]].
