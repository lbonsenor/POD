Propiedad deseable de un [[Sistema Distribuido]]. Un sistema distribuido es **elástico** si tiene la capacidad de modificar la cantidad de nodos que lo componen (agregar o quitar), y los nuevos nodos pueden comenzar a procesar trabajo sin necesidad de desconectar o detener todo el servicio.

Esta propiedad es clave para poder escalar horizontalmente un sistema en función de la demanda, sin generar downtime.

## Qué implica en la práctica

- **Agregar un nodo**: el cluster debe detectar el nuevo nodo, asignarle [[Particionado|particiones]] (tanto como owner/dueño de algunas, como backup/réplica de otras), coordinar la transferencia de esas particiones desde los nodos que las tenían, y recién luego marcarlo como disponible para atender operaciones.
- **Quitar un nodo**: suele ser más complejo, ya que antes de removerlo hay que asegurarse de que no contenga datos actualizados que se perderían si se elimina sin haber sido antes replicados/promovidos a otro nodo (por ejemplo, promoviendo una réplica existente a nuevo owner de esas particiones).
