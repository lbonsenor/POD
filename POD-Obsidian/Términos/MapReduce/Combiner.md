En el paradigma de programación distribuida [[MapReduce]], el **Combiner** es una etapa opcional que se ejecuta en el mismo nodo del [[Mapper]], luego de su ejecución y previo a la etapa de sort del framework.

Su objetivo principal es optimizar la eficiencia del procesamiento, resumiendo o acumulando **localmente** los datos generados por el Mapper antes de que sean transmitidos a través de la red hacia los [[Reducer]]s, reduciendo así el tráfico de red entre nodos.

## Particularidad en Hazelcast

En [[Hazelcast]], es necesario implementar el método `reset()` al escribir un Combiner, ya que el mismo objeto Combiner puede ser reutilizado para procesar los datos de distintas claves, por lo que se necesita reiniciar su estado interno entre una clave y la siguiente para evitar que los resultados se mezclen entre sí.
