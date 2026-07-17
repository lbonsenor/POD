Parámetro (habitualmente abreviado **RF**) que determina el número de copias de un dato que deben ser guardadas en una base de datos distribuida, como parte de la estrategia de [[Replicación]]. Por ejemplo, con un RF de 3, cada dato vivirá en 3 nodos distintos.

## Impacto en latencia y consistencia

- Si se **aumenta** el factor de replicación, se obtiene una consistencia mayor a la hora de realizar escrituras, pero al mismo tiempo aumenta la latencia, ya que se requiere la confirmación de más nodos antes de avisar al cliente que la escritura fue exitosa.
- Si se **disminuye** el factor de replicación, ocurre lo contrario en ambos casos: menor latencia, pero también menor consistencia/disponibilidad ante fallos.

Este trade-off está directamente relacionado con el nivel de consistencia configurado (consistency level) en bases de datos como [[Cassandra]], y con el concepto de [[Consistencia Eventual]].
