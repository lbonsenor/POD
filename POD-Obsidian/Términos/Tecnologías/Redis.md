Base de datos NoSQL del tipo **key-value**, utilizada habitualmente como store en memoria (cache, colas, estructuras compartidas).

## Diferencia respecto a otras key-value

El tratamiento del valor en Redis es más avanzado que en otras bases key-value tradicionales, ya que Redis le agrega **semántica** a sus valores: en vez de tratarlos como un blob opaco, ofrece tipos de datos específicos (strings, listas, sets, hashes, sorted sets, etc.) sobre los cuales se pueden ejecutar operaciones propias de cada tipo directamente en el servidor.

Sin embargo, Redis conserva algunas características propias de las key-value tradicionales: en muchos casos los valores siguen siendo tratados como opacos desde la perspectiva de indexación (no se puede, por ejemplo, hacer una query por el contenido interno de un valor sin usar el tipo de dato adecuado para eso).
