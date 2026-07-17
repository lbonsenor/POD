Modelo de API que se contrapone al modelo tradicional de request-response utilizado por [[API REST]].

En este modelo, el cliente se registra (se suscribe) para la recepción de cierto tipo de eventos, como por ejemplo la creación de un nuevo usuario, de forma que el servidor le envíe una notificación una vez que dicho evento sucede, en lugar de que el cliente deba consultar (hacer polling) periódicamente al servidor.

Un ejemplo típico de este tipo de API son las APIs **pub/sub** (publicador/suscriptor). Otro ejemplo concreto de este modelo es el patrón [[Webhook]] (o "reverse API"), donde es el servidor quien realiza una petición HTTP hacia el cliente cuando ocurre el evento de interés.

## Alternativas para obtener actualizaciones de forma no bloqueante

Además de los modelos basados en eventos propiamente dichos, existen otras estrategias para que un cliente obtenga actualizaciones de un servicio remoto sin bloquearse esperando la respuesta:

- **[[Server-Sent Events (SSE)]]**: el servidor empuja los datos al cliente de forma unidireccional a medida que están disponibles.
- **[[Client-Side Polling]]**: el cliente pregunta periódicamente al servidor si hay novedades.
