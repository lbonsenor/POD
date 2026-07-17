Fenómeno de concurrencia que se produce cuando se intenta solucionar un [[Deadlock]] (situación en la que dos procesos intentan acceder a dos locks, uno luego del otro, y nunca logran tomar el segundo) mediante una estrategia de tiempo de espera y reintento.

El problema surge cuando este ciclo de espera y reintento se repite infinitamente: ambos procesos siguen "vivos" (no están bloqueados esperando indefinidamente como en un deadlock), pero tampoco logran avanzar, ya que continuamente liberan y vuelven a intentar tomar los mismos locks sin éxito.
