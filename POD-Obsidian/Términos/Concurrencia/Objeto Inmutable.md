Un objeto es **inmutable** cuando su estado no puede cambiar una vez construido: todos sus campos son `final`, no expone setters, y no ofrece ningún método que modifique sus datos internos.

## Por qué son preferibles en ambientes concurrentes

Los objetos inmutables son thread-safe por naturaleza: como su estado no cambia, pueden ser compartidos entre múltiples threads sin riesgo de [[Race Condition]] y sin necesidad de sincronización (`synchronized`).

## Ejemplo: clase que "modifica" devolviendo una nueva instancia

Un patrón típico de clase inmutable es que las operaciones que "modificarían" el estado en realidad devuelven una **nueva instancia**, dejando la original intacta. Por ejemplo, una clase que envuelve un `String` y expone un método `append(String)` puede implementarse devolviendo `new ClaseInmutable(valorActual + sufijo)` en lugar de modificar un campo interno.

## Cuidado: `final` no implica contenido inmutable

Que un campo sea `final` sólo impide reasignar la referencia, pero **no** garantiza que el objeto referenciado sea en sí mismo inmutable. Un caso típico es un campo `final` de tipo array (por ejemplo `private final String[] estados`): aunque no se puede reasignar el array completo, sí se puede modificar su contenido (`estados[0] = "otro"`) desde afuera si el array se expone directamente mediante un getter.

La solución habitual es reemplazar el array mutable por una colección realmente inmutable, por ejemplo una `List<String>` creada con `List.of(...)` o `Collections.unmodifiableList(...)`, de forma que ningún thread pueda modificar su contenido.

Este análisis forma parte del checklist de [[Análisis de Concurrencia en Código]].
