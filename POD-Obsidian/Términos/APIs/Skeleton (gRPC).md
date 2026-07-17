Componente del lado del **servidor** en un esquema de comunicación RPC como [[gRPC]], contraparte del [[Stub]] del lado del cliente.

Se encarga de recibir el pedido enviado por el cliente a través de la red, interpretarlo, extraer los parámetros correspondientes, y llamar al [[Servant]] (el objeto remoto real que implementa la lógica del servicio) con esos parámetros. Una vez que obtiene la respuesta del Servant, la transmite de vuelta al cliente a través de la red.

De esta manera, el Skeleton aísla al objeto remoto (el Servant) de los detalles de la comunicación: el Servant no necesita saber cómo llegaron los datos por la red, sólo ejecuta su lógica de negocio de forma local.
