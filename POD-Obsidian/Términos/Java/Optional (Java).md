Clase de Java 8 (`java.util.Optional`) utilizada para representar de forma explícita la posible ausencia de un valor, evitando el uso de `null` y los `NullPointerException` asociados.

## Métodos de instancia habituales

- **`Optional.ofNullable(valor)`**: crea un Optional que puede o no contener un valor, según si `valor` es `null`.
- **`.map(función)`**: si el Optional contiene un valor, aplica la función y devuelve un nuevo `Optional` con el resultado; si está vacío, devuelve un `Optional` vacío sin ejecutar la función.
- **`.orElse(valorPorDefecto)`**: devuelve el valor contenido si existe, o el valor por defecto indicado si el Optional está vacío.

## Ejemplo de uso encadenado

Un patrón típico es encadenar `.map()` seguido de `.orElse()` para navegar una cadena de relaciones opcionales y devolver un valor por defecto al final, por ejemplo: obtener el país de un ciudadano y, dentro de este, el nombre de dicho país, devolviendo `"Unavailable"` si el ciudadano no tiene país asociado.

Este patrón se usa frecuentemente dentro de [[Java Streams]], por ejemplo al agrupar registros donde algún campo es opcional (`.orElse("Desconocido")`).
