Base de datos NoSQL distribuida. Cualquier nodo del cluster puede recibir una escritura por parte del cliente.

## Estrategia de escritura y replicación

1. El nodo que recibe la escritura verifica primero a qué [[Particionado|partición]] corresponde el dato (aplicando una función de hash sobre la clave).
2. Envía el dato a dicho nodo y a los siguientes nodos del anillo, determinados según el [[Factor de Replicación]] definido en la base de datos.
3. Una vez que recibe el ACK de la cantidad de nodos definida en el **consistency level** configurado, confirma la escritura al cliente.

Este comportamiento hace que Cassandra pueda ofrecer distintos niveles de consistencia según cómo se configuren el factor de replicación y el consistency level, acercándose más a un modelo de [[Consistencia Eventual]] o a uno de consistencia fuerte según el caso.
