Segunda etapa de un job de [[MapReduce]]. El **Reducer** recibe, para cada clave emitida por el [[Mapper]] (posiblemente resumida antes por un [[Combiner]]), la lista completa de valores asociados a esa clave, y produce como salida un par clave-valor agregado.

## Ejemplos de uso (según la consulta a resolver)

- Para el **top de barrios con mayor cantidad de especies distintas de árboles**: el reducer arma un set con las especies de cada barrio, y devuelve el tamaño de ese set.
- Para el **director más taquillero por década**: el reducer mantiene un mapa con el director como clave y la taquilla acumulada como valor (sumando taquillas si el director ya fue registrado), y al final retorna el director con la mayor suma total.
- Para el **reviewer más popular de películas de los 80s**: el reducer suma todos los likes recibidos por cada reviewer y retorna esa suma.
- Para el **top de aeropuertos destino**: el reducer suma todos los "1" recibidos para cada aeropuerto destino, obteniendo así la cantidad total de vuelos hacia ese destino.

En muchos casos, la salida del Reducer no es el resultado final de la consulta, sino que requiere de un postprocesamiento adicional mediante un [[Collator]] (por ejemplo, para ordenar y quedarse con los primeros N registros).
