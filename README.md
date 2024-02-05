#  Proyecto GestionDePacientes

## Propósito del Sistema
Implementación de un centro de salud privado abierto para el acceso a la ciudadania con el único requisito de registrarse  y solicitar una cita con especialidad deseada. El sistema debe estar en capacidad de gestión de colas de espera y exámenes de distintas especialidades y el proceso de autorización de órdenes para exámenes dentro de las mismas especialidades disponibles.

## Requerimientos
El sistema cuenta con los siguientes requisitos

**-1** Una funcionalidad para el registro de pacientes tomando sus datos personales como son el Nombre, Apellidos, Edad, Identificación, número de teléfono y un ID asociado de historia clínica en caso de tratarse de una primera visita

**-2** El sistema de gestión de citas, el cual recibirá como insumo la siguiente información

    -Especialidad requerida
    -Profesional asignado
    -Motivo de la cita(valoración, examen o control)
    Tener en cuenta que para la creación de la cita de tipo examen se debe contar con autorización(punto 6)

**-3** Una taquilla de pagos donde se ingrese el identificador de la cita y al registrar la transacción se actualice el flag de pago, este proceso deberá añadir cada uno de los IDs a una cola de espera en el orden que fueron pagados. Todos los tickets independientemente del costo o tipo de visita deben pasar por la caja para ingresar a la cola de espera.

#### NOTA: Tener en cuenta que el metodo de transacciones se lleva a cabo en la caja no es necesario aplicar un sistema de pagos

**-4** Un sistema llamado de pacientes a través del cual se notifique,  través del identificador de su ticket, que ya se encuentran habilitados para ser atendidos. Este proceso debe, tras ingresar un comando específico por especialidad, tomar un ID de la cola de espera (respetando el orden de ingreso). Mostrando en pantalla. Una vez se haya tomado un ID, este debe abandonar la cola para dar paso al siguiente ticket.

**-5** Un módulo de registro de órdenes, donde cada paciente se acerque para ingresar todo los exámenes que le hayan sido ordenados y deban autorizarse. Cada registro de orden deberá contener un identificador único, la especialidad a la que pertenece, el tipo de examen, Una breve descripción y un flag que indique su estado (inicialmente nulo).

**-6** Una funcionalidad de autorización de exámenes desde la cual accediendo por paciente. Se pueda evaluar si se autorizo o no los exámenes que tenga pendiente. El resultado de este proceso debe ser la actualización del flag de estado de cada órden según la decisión tomada. 

#### NOTA: Tener en cuenta que solo se puede autorizar un examen a la vez, el acceso a las órdenes registradas debe realizarse usando un esquema LIFE