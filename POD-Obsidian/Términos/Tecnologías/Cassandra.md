Base de datos NoSQL distribuida orientada a columnas. Cualquier nodo del cluster puede recibir una escritura por parte del cliente; no existe un nodo master (a diferencia de bases como [[HBase]]).

## Estrategia de escritura y replicación

1. El nodo que recibe la escritura verifica primero a qué [[Particionado|partición]] corresponde el dato, aplicando [[Consistent Hashing]] sobre la partition key.
2. Envía el dato a dicho nodo y a los siguientes nodos del anillo, determinados según el [[Factor de Replicación]] definido en la base de datos.
3. Una vez que recibe el ACK de la cantidad de nodos definida en el **consistency level** configurado, confirma la escritura al cliente.

Este comportamiento hace que Cassandra pueda ofrecer distintos niveles de consistencia según cómo se configuren el factor de replicación y el consistency level, acercándose más a un modelo de [[Consistencia Eventual]] o a uno de consistencia fuerte según el caso (ver [[CAP Theorem]]).

## Proceso interno de escritura en un nodo

Dentro de cada nodo que recibe una escritura, esta se registra en dos lugares en paralelo antes de confirmarse:

1. **Commit Log** (en disco): un log de escrituras append-only, usado para poder recuperar el estado en caso de una caída antes de que los datos se hayan volcado a disco de forma definitiva.
2. **Memtable** (en memoria): estructura en memoria donde se aplica la escritura para que esté disponible para lecturas inmediatas.

Cuando la Memtable alcanza cierto tamaño, se hace un **flush**: su contenido se vuelca a disco en una **SSTable** (Sorted String Table), un archivo inmutable optimizado para lectura.

## Restricción en los filtros de las queries

Al realizar consultas, Cassandra restringe los filtros a poder aplicarse únicamente sobre la **partition key**. Esta restricción existe justamente para poder resolver lecturas de forma rápida: al conocer la partition key, el nodo sabe exactamente en qué nodo(s) buscar el registro, sin necesidad de recorrer todo el cluster.

El desafío que trae esta restricción es que, si se necesita consultar por distintos campos (distintos a la partition key), es necesario modelar una tabla distinta por cada patrón de consulta (query), desnormalizando los datos según el acceso requerido.
