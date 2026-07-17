Modelo de API que se contrapone al modelo tradicional de request-response utilizado por [[API REST]].

En este modelo, el cliente se registra (se suscribe) para la recepción de cierto tipo de eventos, como por ejemplo la creación de un nuevo usuario, de forma que el servidor le envíe una notificación una vez que dicho evento sucede, en lugar de que el cliente deba consultar (hacer polling) periódicamente al servidor.

Un ejemplo típico de este tipo de API son las APIs **pub/sub** (publicador/suscriptor).
