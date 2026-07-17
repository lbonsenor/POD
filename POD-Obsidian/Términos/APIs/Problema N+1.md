Problema de performance que aparece típicamente en APIs de tipo GraphQL. Se produce cuando, para resolver una consulta, se realiza una primera query para obtener N elementos, y luego se deben realizar N queries adicionales (una por cada elemento) para resolver algún campo relacionado a cada uno.

Esto genera una cantidad de llamados (N+1) que crece linealmente con la cantidad de elementos devueltos por la query inicial, degradando la performance.

La solución habitual a este problema es el uso de un [[Batch Loader]], que agrupa los N pedidos individuales en un único llamado.
