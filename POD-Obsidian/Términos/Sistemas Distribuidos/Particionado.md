Técnica utilizada en el trabajo distribuido que consiste en distribuir la información en distintos nodos de un [[Sistema Distribuido]], en lugar de almacenarla completa en un único nodo.

Esto permite tener escrituras y lecturas más eficientes, ya que la carga se reparte entre varios nodos en paralelo.

Sin embargo, al tener una única copia de cada dato en un solo nodo, el particionado por sí solo puede traer problemas de disponibilidad si, por ejemplo, ese nodo se cae. Para contemplar esta situación, el particionado suele combinarse con [[Replicación]], de forma que cada dato quede guardado repetido en distintos nodos.

En bases de datos como [[Cassandra]], el particionado suele determinarse aplicando una función de hash sobre la clave del objeto, y utilizando el resultado (por ejemplo, módulo de un número fijo de particiones) para decidir a qué partición pertenece.
