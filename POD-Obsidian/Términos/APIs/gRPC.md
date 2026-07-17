Sistema de comunicación open source basado en **RPC** (Remote Procedure Call), desarrollado inicialmente por Google, que permite ejecutar funciones remotas sin que el desarrollador tenga que preocuparse explícitamente por los detalles de la comunicación entre cliente y servidor.

Apunta a ser multiplataforma, multilenguaje, de alto rendimiento y de uso general.

## Componentes principales

- **[[Stub]]**: proxy de objetos remotos ubicado en el cliente, encargado de enviar las invocaciones por la red y devolver los resultados.
- **[[Skeleton (gRPC)|Skeleton]]**: componente del lado del servidor, encargado de recibir el pedido de red, interpretar los parámetros y llamar al Servant.
- **[[Servant]]**: objeto que implementa la lógica real del servicio, en el servidor.

## repeated vs stream

Ambos son formas de enviar más de un elemento en la comunicación, pero no son lo mismo:

- **`repeated`**: modificador aplicado a un **campo dentro de un mensaje**. Se usa típicamente para listas de datos que se obtienen de forma inmediata (ya están disponibles completas).
- **`stream`**: modificador aplicado a un **mensaje completo** (de entrada y/o de salida). Se usa cuando la obtención de los elementos toma tiempo, es decir, cuando los datos se van a ir enviando progresivamente en el tiempo en vez de estar todos disponibles de una vez.

Técnicamente se pueden intercambiar en algunos casos, pero cada uno está pensado para un escenario distinto.
