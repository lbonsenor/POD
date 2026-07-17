Técnica implementada del lado del **cliente** para obtener actualizaciones de un servidor de forma no bloqueante. Consiste en enviar solicitudes periódicas (a intervalos fijos) preguntando si hay novedades.

A diferencia de [[Server-Sent Events (SSE)]], los datos obtenidos mediante polling no son en tiempo real: se solicitan en los intervalos configurados, por lo que el cliente termina enviando solicitudes incluso cuando no hay actualizaciones disponibles en el servidor, generando tráfico innecesario.

Hoy en día esta técnica prácticamente no se usa, habiendo sido reemplazada por alternativas como long-polling, [[Server-Sent Events (SSE)]] o WebSockets.
