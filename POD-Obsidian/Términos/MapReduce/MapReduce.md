Paradigma de programación distribuida utilizado para procesar grandes volúmenes de datos en paralelo a través de múltiples nodos, mediante una cadena de jobs compuestos por dos etapas principales: [[Mapper]] y [[Reducer]].

## Etapas del paradigma

- **[[Mapper]]**: recibe los registros de entrada (clave-valor) y emite pares clave-valor intermedios según la lógica de la consulta a resolver.
- **[[Combiner]]** (opcional): realiza una agregación local de los datos emitidos por el Mapper, en el mismo nodo, antes de la etapa de sort/shuffle, para optimizar el tráfico de red.
- **[[Reducer]]**: recibe, para cada clave, todos los valores emitidos por los mappers, y produce el resultado agregado final para esa clave.
- **[[Collator]]** (opcional): realiza un postprocesamiento sobre el resultado final de los reducers, por ejemplo para ordenar resultados o quedarse con un top-N.

## Encadenamiento de jobs

Un proceso de MapReduce puede estar compuesto por una **cadena de varios jobs**, donde la salida de un job (Mapper + Reducer) es la entrada del siguiente. Esto permite resolver consultas que requieren más de una etapa de agregación, como por ejemplo obtener un top-N por categoría, donde primero se calcula un valor agregado por grupo, y luego se requiere un procesamiento posterior (postproceso, usualmente vía [[Collator]]) para ordenar y filtrar los resultados finales.
