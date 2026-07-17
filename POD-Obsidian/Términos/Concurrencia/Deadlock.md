Situación de concurrencia en la que dos (o más) procesos intentan acceder a dos (o más) recursos/locks, tomándolos en distinto orden, y como consecuencia ninguno logra avanzar: cada uno queda esperando indefinidamente a que el otro libere el recurso que necesita.

Un intento ingenuo de solucionar un deadlock mediante tiempo de espera y reintento puede derivar en un [[LiveLock]], si el ciclo de espera y reintento se repite infinitamente sin que ningún proceso logre avanzar.
