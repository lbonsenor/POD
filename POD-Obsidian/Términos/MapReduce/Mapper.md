Primera etapa de un job de [[MapReduce]]. El **Mapper** recibe cada registro de entrada como un par clave-valor, y por cada uno de ellos emite uno o más pares clave-valor intermedios, según la lógica necesaria para resolver la consulta.

## Ejemplos de uso (según la consulta a resolver)

- Para calcular el **top de barrios con mayor cantidad de especies distintas de árboles**: el mapper emite, por cada árbol, el barrio como clave y la especie como valor.
- Para calcular el **director más taquillero por década**: el mapper emite, por cada película, la década (calculada a partir de la fecha de estreno) como clave, y el director junto con la taquilla como valor.
- Para calcular el **reviewer más popular de películas de los 80s**: el mapper itera sobre la lista de reviews de cada película y emite, para las películas de los 80s, el username como clave y los likes como valor.
- Para calcular el **top de aeropuertos destino con despegues desde EZE**: el mapper emite el id del aeropuerto destino como clave y un 1 como valor, omitiendo los vuelos cuyo origen no sea EZE.

El resultado emitido por el Mapper (clave y valor) es luego agrupado por clave y enviado al [[Reducer]] correspondiente, opcionalmente pasando antes por un [[Combiner]].
