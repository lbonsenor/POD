Sistema compuesto por múltiples nodos (procesos/máquinas) que se comunican entre sí a través de una red, colaborando para lograr un objetivo común, y que idealmente se comporta ante el usuario como un único sistema coherente.

## Problemas y propiedades asociadas

- **[[Split Brain]]**: problema que surge cuando, por una falla de comunicación, el sistema queda dividido en particiones autónomas que operan de forma independiente.
- **[[Consistencia Eventual]]**: modelo de consistencia habitual en sistemas distribuidos de almacenamiento, donde las lecturas convergen al último valor escrito pasado un tiempo, en lugar de reflejarlo de forma inmediata.
- **[[Elasticidad]]**: capacidad de un sistema distribuido de modificar su cantidad de nodos sin necesidad de detener el servicio.
- **[[Particionado]]** y **[[Replicación]]**: técnicas utilizadas para distribuir y duplicar la información entre los distintos nodos, buscando eficiencia y tolerancia a fallos respectivamente.

## Frameworks y tecnologías relacionadas

Ejemplos de tecnologías utilizadas para construir sistemas distribuidos incluyen [[Hazelcast]] (in-memory data grid, usado también para procesos de [[MapReduce]]) y [[Cassandra]] (base de datos NoSQL distribuida).
