Objeto encargado de realizar "realmente" las operaciones de un servicio remoto (por ejemplo en [[gRPC]]). Reside en el servidor, implementa la interfaz remota (o interfaces) del servicio, y ejecuta la lógica de negocio correspondiente.

Aunque el Servant implementa una interfaz remota, su ejecución es puramente local: no cambia su comportamiento según si fue invocado remotamente o no. Es el [[Skeleton (gRPC)|Skeleton]] quien se encarga de recibir el pedido de red, extraer los parámetros, y llamar al Servant como si fuera una invocación local común.
