#  Proyecto GestionDePacientes

## Propósito del Sistema
Implementación de un centro de salud privado abierto para el acceso a la ciudadania con el único requisito de registrarse  y solicitar una cita con especialidad deseada. El sistema debe estar en capacidad de gestión de colas de espera y exámenes de distintas especialidades y el proceso de autorización de órdenes para exámenes dentro de las mismas especialidades disponibles.

## Requerimientos
El sistema cuenta con los siguientes requisitos

**-1** Una funcionalidad para el registro de pacientes tomando sus datos personales como son el Nombre, Apellidos, Edad, Identificación, número de teléfono y un ID asociado de historia clínica en caso de tratarse de una primera visita

**-2** El sistema de gestión de citas, el cual recibirá como insumo la siguiente información

    Especialidad requerida
    Profesional asignado
    Motivo de la cita(valoración, examen o control)
    Tener en cuenta que para la creación de la cita de tipo examen se debe contar con autorización(punto 6)

**-3** Una taquilla de pagos donde se ingrese el identificador de la cita y al registrar la transacción se actualice el flag de pago, este proceso deberá añadir cada uno de los IDs a una cola de espera en el orden que fueron pagados. Todos los tickets independientemente del costo o tipo de visita deben pasar por la caja para ingresar a la cola de espera.

#### NOTA: Tener en cuenta que el metodo de transacciones se lleva a cabo en la caja no es necesario aplicar un sistema de pagos

**-4** Un sistema llamado de pacientes a través del cual se notifique,  través del identificador de su ticket, que ya se encuentran habilitados para ser atendidos. Este proceso debe, tras ingresar un comando específico por especialidad, tomar un ID de la cola de espera (respetando el orden de ingreso). Mostrando en pantalla. Una vez se haya tomado un ID, este debe abandonar la cola para dar paso al siguiente ticket.

**-5** Un módulo de registro de órdenes, donde cada paciente se acerque para ingresar todo los exámenes que le hayan sido ordenados y deban autorizarse. Cada registro de orden deberá contener un identificador único, la especialidad a la que pertenece, el tipo de examen, Una breve descripción y un flag que indique su estado (inicialmente nulo).

**-6** Una funcionalidad de autorización de exámenes desde la cual accediendo por paciente. Se pueda evaluar si se autorizo o no los exámenes que tenga pendiente. El resultado de este proceso debe ser la actualización del flag de estado de cada órden según la decisión tomada. 

#### NOTA: Tener en cuenta que solo se puede autorizar un examen a la vez, el acceso a las órdenes registradas debe realizarse usando un esquema LIFE

## Requisitos del producto

**1** El sistema debe incluir un módulo de gestión de usuarios y permite la autenticación mediante la contraseña designada. Cada acción debe permitir la trazabilidad asociada al usuario de manera que se pueda garantizar el no repudio de sus acciones

**2** La aplicación debe funcionar para el sistema operativo Ubuntu 23.04 LTS o Debian 12 o superior

**3** Las vistas del sistema deben tener una distribución suficiente 23.04 LTS o Debian 12 o superior

**4** La base de datos debe ser centralizada, se recomienda utilizar archivos de texto, XML o JSON o en lo posible un gestor de base de datos

## Requisitos del proyecto 
El lenguaje de programación es JAVA

El desarrollo debe respetar un patrón de diseño modelo vista controlador o MVC para cada módulo

Todo el proceso de diseño e implementación de diferentes vistas de la aplicación debe contar con la opinión del cliente y este será quien autorice su puesta en marcha

Las únicas estructuras de datos autorizadas y la implementación de los algoritmos deberán ser de autoría de los miembros del equipo

El proyecto consta de los siguientes entregables: Especificación de requerimientos, diseño, código fuente, validación del software y evidencia de la puesta tendrán máximo 3 estudiantes

Metodología de desarrollo es libre

El desarrollo del proyecto deberá estar enmarcado en el cronograma de las 11 semanas

El alcance de la propuesta estará en el marco de las competencias del proyecto descrito en este documento 

Los equipos deben presentar un informe de seguimiento o bitácoria semanal de avance del proyecto. La bitácora debe exponer en detalle la actividad desarrollada por cada miembro del equipo y el poorcentaje como Git

### La primera Entrega
Será la propuesta de proyecto con formato (APA). Que incluye: portadas, introducción , planteamiento del problema, justificación , objetivos, marcos referenciales (conceptual, tecnológico y diseños) cronograma de actividades, referencias bibliográficas. Solo será aceptado si se evidencia el seguimientoo mencionado en el item anterior

### La segunda Entrega 
Será derivada de un documentoo con formato (APA). Con todas las seccione que este requiera tales como: Introducción, planteamiento del problema, justificación, objetivos, marcos referenciales (conceptual, tecnológico y/o legal), metología, resultados  (Especificación de requerimientos, diseños e implementaciones). Cronograma de actividades, referencia bibliográfica, etc

### Las referencias bibliográficas deben manejar un porcentaje de 60% en  inglés


