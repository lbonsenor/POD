Técnica utilizada en el trabajo distribuido que consiste en guardar copias repetidas de un mismo dato en distintos nodos, con el objetivo de contemplar situaciones problemáticas como la caída de alguno de los nodos que forman parte del [[Particionado]] de los datos.

La cantidad de copias que se guardan de cada dato está determinada por el [[Factor de Replicación]] configurado en la base de datos.

En bases de datos NoSQL como [[Cassandra]], la replicación se combina con un consistency level configurable, que determina cuántas de las réplicas deben confirmar (ACK) una escritura antes de considerarla exitosa y confirmarla al cliente.
