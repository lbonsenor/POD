Estrategia de **server side pushing** que permite a un cliente obtener la respuesta de un servicio remoto de forma no bloqueante, sin necesidad de estar consultando periódicamente al servidor.

**SSE (Server-Sent Events)** facilita la comunicación asincrónica entre servidores y clientes haciendo uso del protocolo HTTP: el servidor envía mensajes o eventos de manera unidireccional (servidor → cliente), actualizándolo de forma asíncrona a medida que hay novedades.

Esto elimina la necesidad de recurrir a [[Client-Side Polling]] o long-polling (que implican requests periódicos del cliente), simplificando la comunicación.

## Desventajas principales

- **Formato de datos limitado**: SSE está restringido a transportar mensajes en formato UTF-8, por lo que no se pueden enviar datos binarios directamente.
- **Límite de conexiones concurrentes**: cuando no se utiliza sobre HTTP/2, los navegadores solo permiten hasta 6 conexiones SSE concurrentes abiertas al mismo tiempo.

SSE es unidireccional; si se necesita comunicación bidireccional entre cliente y servidor, se recurre en cambio a WebSockets, lo cual también permite implementar una [[API Basada en Eventos]] donde el propio cliente publica eventos hacia el backend.
