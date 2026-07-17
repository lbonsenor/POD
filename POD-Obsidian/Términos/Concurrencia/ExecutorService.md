Componente del framework de concurrencia de Java cuyo objetivo buscado es desacoplar la creación y gestión de threads de la ejecución de las tareas en sí.

En lugar de crear y manejar manualmente instancias de `Thread`, el `ExecutorService` permite enviar tareas (`Runnable`/`Callable`) a un pool de threads administrado por el propio framework, que se encarga de la asignación de recursos, el reciclado de threads y la gestión del ciclo de vida de la ejecución concurrente, simplificando el manejo de concurrencia por parte del desarrollador.
