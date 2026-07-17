Guía práctica para resolver ejercicios del tipo "indicar en palabras (o pseudocódigo) qué haría el Mapper y el Reducer para resolver la consulta X", típicos de [[MapReduce]].

## Pasos para encarar el ejercicio

1. **Identificar qué necesita "ver junto" el Reducer para calcular la respuesta.** Esto define la **clave** que debe emitir el Mapper. Por ejemplo, si la consulta agrupa por barrio, la clave es el barrio; si agrupa por línea y estación, la clave puede ser compuesta (una tupla `[línea, estación]`).
2. **Definir qué dato mínimo necesita el Reducer para agregar.** Esto define el **valor** que emite el Mapper (no hace falta emitir el registro completo, solo lo estrictamente necesario: un contador `1`, una especie, un monto, una tupla `[campo, valor]`, etc.).
3. **Filtrar en el Mapper, no en el Reducer.** Si la consulta tiene una condición (ej: "solo el año 2021", "solo despegues desde EZE"), esa condición se evalúa dentro del Mapper: si no se cumple, no se emite nada para ese registro. Esto reduce el volumen de datos que viaja por la red.
4. **Definir la lógica de agregación del Reducer**, que recibe la clave y **todos** los valores emitidos por los distintos mappers para esa clave. Los patrones más comunes son:
   - **Sumar/contar**: recorrer los valores y acumular un total (ej: sumar pasajeros, contar apariciones).
   - **Armar un Set**: cuando se pide "cantidad de X distintos" (ej: especies distintas por barrio), se arma un `Set` con los valores para eliminar duplicados, y se devuelve su tamaño.
   - **Máximo/mínimo**: recorrer los valores y quedarse con el mayor o menor (ej: mayor cantidad de likes).
   - **Mapa auxiliar interno**: cuando hay una segunda dimensión de agrupamiento dentro de la misma clave (ej: sumar taquilla por director dentro de una década), se arma un mapa intermedio dentro del propio reducer.
5. **Determinar si hace falta un [[Collator]] (postprocesamiento).** Es necesario cuando, después de tener un resultado por clave, la consulta pide algo más sobre el conjunto completo de resultados, típicamente:
   - Ordenar (ascendente/descendente por algún campo).
   - Quedarse con un top-N.
   - Quedarse con el máximo/mínimo por cada valor de otra dimensión (ej: "la estación con más pasajeros de **cada** línea", donde el reducer ya agregó por estación-línea, pero falta elegir una estación por línea).
   - Filtrar resultados que no cumplen una condición sobre el valor agregado (ej: "que aparezca en al menos N provincias").
6. **Verificar si se necesita más de un job encadenado.** Si la consulta requiere dos niveles de agregación que no pueden resolverse con un solo par Mapper-Reducer (por ejemplo, agregar primero por una clave, y sobre ese resultado volver a agregar por otra clave), se arma una cadena de jobs, donde la salida de un job (Mapper+Reducer) es la entrada del siguiente.

## Plantilla de respuesta

Para escribir la respuesta de forma ordenada, conviene declarar explícitamente:

- **Mapper**: comportamiento + clave que emite + valor que emite.
- **Reducer**: comportamiento + clave que emite + valor que emite.
- **Postprocesamiento**: si hace falta o no, y qué hace (ordenar, filtrar, top-N).

Ejemplo de pseudocódigo típico usado en las respuestas:

```
function map(id, ...campos) {
  if (condición_de_filtro) {
    emit(clave, valor);
  }
}

function reduce(clave, values) {
  let total = 0;
  for (v of values) { total += v; }
  return (clave, total);
}
```
