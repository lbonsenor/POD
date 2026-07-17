En el paradigma de programación distribuida [[MapReduce]], el **Combiner** es una etapa opcional que se ejecuta en el mismo nodo del [[Mapper]], luego de su ejecución y previo a la etapa de sort del framework.

Su objetivo principal es optimizar la eficiencia del procesamiento, resumiendo o acumulando **localmente** los datos generados por el Mapper antes de que sean transmitidos a través de la red hacia los [[Reducer]]s, reduciendo así el tráfico de red entre nodos. Tiene sentido emplearlo especialmente cuando la salida del Mapper es considerablemente extensa: si esa gran cantidad de datos llegara directamente al Reducer sin resumir, se produciría congestión en la red.

El Combiner suele ser similar en lógica al Reducer, pero trabaja de forma reutilizable y **por chunks**: en vez de recibir de una sola vez todos los valores de una clave, va procesando los valores a medida que llegan en distintos chunks, y emite resultados parciales.

## Particularidad en Hazelcast: el método reset()

En [[Hazelcast]], se instancia un Combiner por cada clave. Como el Combiner trabaja de a chunks, cuando termina de procesar un chunk emite su resultado parcial (mediante `finalizeChunk` o equivalente) y luego debe volver a un estado limpio para poder procesar el siguiente chunk de la misma clave. Es necesario implementar el método `reset()` justamente para eso: reiniciar el estado interno del Combiner una vez emitido el resultado parcial, de forma que los datos de un chunk no se mezclen con los del siguiente.
