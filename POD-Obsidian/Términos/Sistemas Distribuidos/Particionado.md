Técnica utilizada en el trabajo distribuido que consiste en dividir los datos de un sistema en unidades más pequeñas e independientes, llamadas **particiones**, y distribuirlas entre los distintos nodos de un [[Sistema Distribuido]], en lugar de almacenar toda la información en un único nodo. Cada nodo es responsable de atender las solicitudes (lectura o escritura) de los datos asociados a las particiones que le fueron asignadas.

Cuando se hace correctamente, el particionado trae 3 beneficios principales:

- **Fault tolerance**: al dividir los datos, una falla puede afectar solo a una parte del sistema y no a su totalidad.
- **Scalability**: permite crecer horizontalmente agregando más nodos, cada uno responsable de un subconjunto de particiones.
- **Performance**: las escrituras y lecturas pueden resolverse en paralelo entre distintos nodos, en vez de cuellos de botella en un único nodo.

Sin embargo, al tener una única copia de cada dato en un solo nodo, el particionado por sí solo puede traer problemas de disponibilidad si, por ejemplo, ese nodo se cae. Para contemplar esta situación, el particionado suele combinarse con [[Replicación]], de forma que cada dato quede guardado repetido en distintos nodos.

En bases de datos como [[Cassandra]], el particionado suele determinarse mediante [[Consistent Hashing]]: se aplica una función de hash sobre la clave del objeto (partition key), y el resultado determina a qué nodo del anillo pertenece esa partición.
