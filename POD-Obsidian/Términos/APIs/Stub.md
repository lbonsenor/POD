En un ambiente cliente-servidor que utiliza [[gRPC]], el **Stub** es un proxy de objetos remotos ubicado en el cliente.

Su rol principal es garantizar que las llamadas al servicio sean lo más "transparentes" posibles, de modo que no se distingan de las llamadas a métodos locales. Concretamente, se encarga de:

1. Recibir las invocaciones realizadas por el cliente.
2. Pasarlas por la red, junto con el método invocado y sus parámetros.
3. Esperar los resultados devueltos por el servidor.
4. Leer y transmitir dichos resultados de vuelta al cliente.
