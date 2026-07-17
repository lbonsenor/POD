Situación de concurrencia en la que el resultado de una operación depende del orden no determinístico en que se intercalan las ejecuciones de distintos threads sobre un recurso compartido, cuando el acceso a dicho recurso no está correctamente sincronizado.

## Ejemplo

Un caso típico es el uso inconsistente de bloqueos (`synchronized`) sobre distintos objetos para proteger una misma variable compartida. Por ejemplo, si un método sincroniza la escritura de una variable `counter` usando un objeto de lock dedicado (`lockCounterLock`), pero otro método sincroniza su lectura usando el objeto `this`, en realidad se está utilizando **dos locks distintos** para proteger el mismo dato. Esto no protege correctamente la variable, ya que ambos bloqueos no son mutuamente excluyentes entre sí, permitiendo que ocurran race conditions entre la escritura y la lectura de `counter`.
