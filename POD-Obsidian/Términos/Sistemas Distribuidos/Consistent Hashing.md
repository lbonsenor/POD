Técnica de [[Particionado]] utilizada por bases de datos distribuidas como [[Cassandra]] para determinar en qué nodo vive cada dato.

Consiste en aplicar una función de hash sobre la partition key del dato, ubicando el resultado en un espacio de hashes organizado como un anillo (ring). Cada nodo del cluster es responsable de un rango de ese anillo.

## Ventaja principal

Permite, al momento de querer acceder a un dato, encontrar en qué nodo está usando únicamente el hash de la partition key, sin necesidad de una consulta previa a un nodo coordinador o índice central.

Esto también permite que **cualquier nodo** del cluster pueda recibir y procesar un pedido de escritura (a diferencia de bases de datos con esquema master/slave, como [[HBase]], donde las escrituras solo puede realizarlas el master): el nodo que recibe la escritura simplemente calcula el hash, determina el nodo dueño de esa partición, y redirige el dato según el [[Factor de Replicación]] configurado.
