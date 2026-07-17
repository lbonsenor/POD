Componente utilizado en el paradigma de [[MapReduce]] para realizar un **postprocesamiento** sobre los resultados finales emitidos por el [[Reducer]], cuando la consulta requiere un paso adicional que no puede resolverse dentro del propio Reducer.

## Ejemplo de uso

Para resolver la consulta del **top ten de barrios con mayor cantidad de especies distintas de árboles**, luego de que el Reducer devuelve, por cada barrio, la cantidad de especies distintas, se implementa un Collator que:

1. Ordena los resultados de forma descendente según la cantidad de especies.
2. Se queda únicamente con los 10 primeros registros.

De forma similar, se utiliza un Collator para resolver consultas de tipo "top N" en general, como el top 10 de aeropuertos destino con más despegues desde un origen determinado.
