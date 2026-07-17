Base de datos NoSQL distribuida orientada a columnas, construida sobre el ecosistema de Hadoop.

## Consistencia de escritura

A diferencia de bases como [[Cassandra]] (que priorizan disponibilidad y no tienen un nodo master), HBase logra **consistencia de escritura** a pesar de ser un sistema distribuido gracias a un esquema de replicación **master/slave**: un cliente solo puede leer o escribir a través del nodo master, lo que garantiza que siempre se tenga la última escritura confirmada.

Las lecturas, en cambio, no necesariamente pasan por el master: pueden resolverse contra un nodo slave, ya que estos reciben la replicación de los datos escritos en el master.

Esta elección de diseño refleja el trade-off descripto por el [[CAP Theorem]]: HBase prioriza consistencia por sobre disponibilidad (si el master no está disponible, no se pueden hacer escrituras), a diferencia de bases como Cassandra que priorizan disponibilidad.
