Mecanismo utilizado en **GraphQL** cuya utilidad es mitigar el [[Problema N+1]] de queries.

El problema N+1 se produce cuando se realiza una primera query para obtener N elementos, y luego es necesario realizar N queries adicionales, una por cada elemento, para resolver algún campo relacionado.

El **Batch Loader** resuelve esto acumulando (batching) los pedidos realizados sobre un mismo campo. En lugar de hacer N llamados, cada uno con 1 elemento, agrupa todos los pedidos y realiza un único llamado con los N elementos juntos en un array.
