# ticonipaRonald_pruebatec2
El script para la base de datos se llama entidad_gob.sql, el usuario es root la contraseña es Root123!, éste script se encuentra el archivo raíz.

Funcionalidades Clave:
Usuarios: La aplicación mantiene un registro de los usuarios que pueden ser personas que requieren realizar trámites. Cada usuario tiene un nombre y un apellido.

Trámites: Los trámites son los procesos administrativos disponibles para los usuarios. Estos incluyen, por ejemplo, la solicitud de pasaporte, renovación de licencia de conducir, y el pago de impuestos.

Turnos: Los usuarios pueden generar un turno para realizar un trámite. Un turno tiene un código único y una fecha asignada. Además, cada turno tiene un estado que indica si ha sido atendido o si está en espera. Cada turno está vinculado a un usuario y un trámite específico.

Flujo de la Aplicación:
Un usuario se registra en el sistema.
El usuario elige un trámite (por ejemplo, "Solicitud de Pasaporte").
El sistema genera un turno para el trámite seleccionado, asignando una fecha y un código único.
El turno puede estar en estado de "ESPERA" (a la espera de ser atendido) o "ATENDIDO" (cuando el trámite ha sido completado).
Los administradores o responsables del sistema pueden cambiar el estado de los turnos conforme se gestionan los trámites.