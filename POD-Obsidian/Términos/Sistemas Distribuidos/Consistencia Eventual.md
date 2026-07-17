Modelo de consistencia utilizado en algunos sistemas de almacenamiento distribuido ([[Sistema Distribuido]]), en contraposición a la consistencia fuerte.

Un sistema de store cumple con el modelo de **consistencia eventual** si, pasado un cierto tiempo desde una escritura (sin que ocurran otras escrituras en el medio), todas las lecturas posteriores reflejan ese mismo valor escrito.

En otras palabras: no se garantiza que una lectura inmediatamente posterior a una escritura devuelva el último valor, pero sí se garantiza que, eventualmente, todas las réplicas convergen al mismo estado.

Este modelo suele adoptarse en bases NoSQL distribuidas (por ejemplo [[Cassandra]]) como forma de mejorar la disponibilidad y reducir la latencia de escritura, a costa de una consistencia inmediata más débil. Está directamente relacionado con el concepto de [[Factor de Replicación]] y [[Replicación]].
