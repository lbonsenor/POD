Estilo arquitectónico para la construcción de APIs. Entre las características que deben cumplir las API REST se destacan:

- **Stateless**: el estado/contexto de la petición es mantenido por el cliente, no por el servidor. Cada request debe contener toda la información necesaria para ser procesada, sin depender de un estado guardado en el servidor de peticiones anteriores.
- **Cacheable**: todos los recursos deben ser cacheables, mientras y por el tiempo que tenga sentido, para mejorar la performance y reducir la carga sobre el servidor.
- **Arquitectura Cliente-Servidor (Client-Server)**: separación de responsabilidades entre el cliente (interfaz/consumo) y el servidor (lógica de negocio y datos), permitiendo que evolucionen de forma independiente.

Se contrasta habitualmente con modelos [[API Basada en Eventos]], donde en vez de un modelo de request-response el cliente se suscribe a eventos que el servidor emite.
