Teorema que establece que un [[Sistema Distribuido]] no puede garantizar simultáneamente más de dos de las siguientes tres propiedades:

- **Consistency (Consistencia)**: todos los nodos devuelven el último dato escrito, sin importar a qué nodo se consulte.
- **Availability (Disponibilidad)**: todo request recibe una respuesta inmediata (que puede ser exitosa o de error, pero siempre hay respuesta).
- **Partition tolerance (Tolerancia a particiones)**: el sistema sigue funcionando a pesar de que la red esté particionada (algunos nodos no pueden comunicarse entre sí) o de que se pierdan mensajes/nodos.

## Implicancia práctica

Dado que los sistemas que escalan horizontalmente necesariamente deben tolerar particiones de red (Partition tolerance no es realmente opcional en la práctica), el trade-off real termina siendo entre **Consistencia** y **Disponibilidad**.

En general (aunque no siempre) las bases de datos NoSQL priorizan disponibilidad por sobre consistencia fuerte, optando por brindar [[Consistencia Eventual]] en su lugar. Ejemplos de esta elección son [[Cassandra]] (prioriza disponibilidad) frente a sistemas como [[HBase]] (prioriza consistencia mediante un esquema master/slave).
