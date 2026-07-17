En un ambiente cliente-servidor que utiliza [[gRPC]], el **Stub** es un proxy de objetos remotos ubicado en el cliente, que implementa los mismos métodos que la interfaz remota.

Su rol principal es garantizar que las llamadas al servicio sean lo más "transparentes" posibles, de modo que no se distingan de las llamadas a métodos locales. Concretamente, se encarga de:

1. Recibir las invocaciones realizadas por el cliente.
2. Pasarlas por la red, junto con el método invocado y sus parámetros.
3. Esperar los resultados devueltos por el servidor.
4. Leer y transmitir dichos resultados de vuelta al cliente.

Su contraparte del lado del servidor es el [[Skeleton (gRPC)|Skeleton]], que recibe el pedido de red y llama al [[Servant]] (el objeto que ejecuta la lógica real).

## Tipos de Stub en gRPC

El middleware de gRPC provee 3 variantes de stub para el cliente, según cómo se quiera manejar la respuesta:

- **BlockingStub**: stub sincrónico. El thread que hace la llamada queda bloqueado esperando la respuesta.
- **Stub (asincrónico)**: stub asincrónico basado en *observers*, que van procesando los resultados a medida que llegan (útil junto con streaming).
- **FutureStub**: stub asincrónico que retorna un `Future`, permitiendo consultar el resultado más adelante sin bloquear el thread actual.
