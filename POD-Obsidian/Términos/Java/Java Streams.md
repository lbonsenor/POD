API de Java 8 para procesar colecciones de forma declarativa, mediante una cadena de operaciones sobre un `Stream`.

## Operaciones típicas

- **`filter(predicado)`**: se queda solo con los elementos que cumplen una condición.
- **`map(función)`**: transforma cada elemento en otro valor (por ejemplo, de `Employee` a su nombre).
- **`sorted()`** / **`distinct()`**: ordena (por default, orden natural/alfabético ascendente) y elimina duplicados respectivamente.
- **`collect(Collectors...)`**: junta el resultado del stream en una estructura final. Los más usados:
  - `Collectors.toList()`: arma una lista.
  - `Collectors.joining(separador)`: concatena Strings en uno solo, separados por el separador indicado.
  - `Collectors.groupingBy(clasificador, downstream)`: agrupa elementos según una clave, aplicando opcionalmente una operación adicional a cada grupo (por ejemplo `Collectors.counting()` para contar elementos por grupo).
  - `Collectors.toMap(claveFn, valorFn, funciónDeMerge)`: arma un mapa a partir del stream; la función de merge es necesaria para indicar qué hacer si dos elementos generan la misma clave (por ejemplo, sumar sus valores).
- **`mapToInt(función).sum()`**: variante para streams numéricos, útil para sumar directamente sin pasar por un `Collector`.

## Uso de Optional dentro de streams

Cuando un campo es un [[Optional (Java)]] (por ejemplo un barrio opcional), es común resolverlo dentro del stream con `.orElse("valorPorDefecto")`, en vez de acceder directamente al valor, para no propagar el `Optional` ni arriesgarse a un `null`.

## Variables externas y lambdas ("effectively final")

Un error común es intentar modificar, dentro de un `forEach`/lambda, una variable local declarada fuera del stream (por ejemplo, un `int sum` que se va incrementando). Esto **no compila**, porque Java exige que toda variable local usada dentro de una lambda sea `final` o *effectively final* (es decir, que nunca se reasigne luego de su inicialización). Esto ocurre porque tipos como `Integer`/`int` son inmutables: cada operación de "modificación" en realidad genera una nueva instancia, por lo que no hay una variable mutable real que la lambda pueda capturar y modificar de forma segura.

### Formas de resolverlo

- Reemplazar el acumulado manual por la operación de stream equivalente: `list.stream().collect(Collectors.summingInt(String::length))` o `list.stream().mapToInt(String::length).sum()`.
- Acumular el estado en un campo mutable de un objeto (por ejemplo, seteando un atributo de una instancia dentro del lambda), en vez de una variable local primitiva.
- Usar una clase pensada para ser mutada de forma segura desde una lambda, como `AtomicInteger`, invocando `addAndGet(...)` en lugar de un `+=` sobre una variable local.
