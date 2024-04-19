package com.asistentemedico.asistentedecitas.persistencia.salasoperador;

import com.asistentemedico.asistentedecitas.logica.Operador.EstadoParaPagoDeCitasMedicas;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoParaSalaDeCitasAtencionMedica;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada.Nodo;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoDeFlujoParaAtencionDeExamenes;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoDeFlujoParaAutorizaciones;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoDeFlujoParaPagoDeExamenes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlujoDeLasSalas {
    private static final String RUTA_SALA_DE_ATENCION ="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoAtencionDeCitas.txt";
    private static final String RUTA_SALA_DE_PAGO_DE_CITAS="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoPagoDeCitas.txt";
    private static final String RUTA_SALA_DE_AUTORIZACIONES="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoDeAutorizaciones.txt";
    private static final String RUTA_SALA_DE_EXAMENES="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoParaPagoDeExamenes.txt";
    private static final String RUTA_SALA_DE_ATENCION_EXAMENES="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoAtencionDeExamenes.txt";
    
 //METODO PARA OBTENER CAMPO DEL .TXT 
 /**
 * Método utilizado para extraer un campo específico de una línea de texto que contiene datos separados por comas (,).
 *
 * @param linea   La línea de texto de la que se va a extraer el campo.
 * @param indice  El índice del campo que se desea extraer de la línea de texto.
 * @return        El campo extraído de la línea de texto en el índice especificado. Se devuelve sin espacios adicionales al principio y al final.
 */
    private static String obtenerCampo(String linea, int indice){
        // Inicialización de variables
        int inicio = 0;
        int contador = 0;
        // Bucle de búsqueda
        while(contador < indice){
            inicio = linea.indexOf(", " , inicio) + 2;
            contador++;
        }
        // Determinación del índice de finalización
        int fin = linea.indexOf(", ", inicio);
        if(fin == -1){
            fin = linea.length();
        }
        // Extracción del campo y retorno
        return linea.substring(inicio, fin).trim();
    }
   
    //ATENCION DE CITAS MEDICAS DE FLUJO________________________________________
    
    //FUNCIONAMIENTO carga el flujo de la sala de atencion desde una ruta que le pasemos
    //espera como parametros la ruta del archivo y retorna con base a una lista doble
    //de estados de la sala de atencion parametrizando los datos con base a
    //EstadoParaSalaDeCitasAtencionMedica
    public static DoblementeEnlazada<EstadoParaSalaDeCitasAtencionMedica> cargarFlujoDeSalaDeAtencion(String rutaArchivo){
    // Crea una lista doblemente enlazada para almacenar los estados de la sala de atención médica
    DoblementeEnlazada<EstadoParaSalaDeCitasAtencionMedica> estados = new DoblementeEnlazada<>();
    try(FileReader fr = new FileReader(rutaArchivo);
        BufferedReader br = new BufferedReader(fr)){
        String linea;    
        // Lee cada línea del archivo
        while((linea = br.readLine()) != null){
            // Obtiene los campos de la línea (nombre, apellido, identificación, estado)
            String nombre = obtenerCampo(linea, 0);
            String apellido = obtenerCampo(linea, 1);
            String identificacion = obtenerCampo(linea, 2);
            String estado = obtenerCampo(linea, 3);           
            // Crea un nuevo estado inicial para la sala de citas de atención médica
            EstadoParaSalaDeCitasAtencionMedica estadoinicial = 
                new EstadoParaSalaDeCitasAtencionMedica(nombre, apellido,
                identificacion, estado);
            
            // Agrega el estado inicial a la lista doblemente enlazada
            estados.agregarAlFinal(estadoinicial);
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
    // Devuelve la lista de estados de la sala de atención médica
    return estados;
}   
    //FUNCIONAMIENTO cambia el estado de una sala de atencion medica a flujo continuo
    //con base a una lsita doblemente enlazada parametrizando los datos con la clase
    //EstadoParaSalaDeCitasAtencionMedica para el funcionamiento adecuado internamente
    //y luego volver a grabar sobre escribiendo la informacion
    //NO RETORNADA SOLAMENTE ES UNA ACCION 
    public static void cambiarEstadoDeSalaDeAtencionMedicaAFlujoContinuo(String nombre,
        String apellido, String identificacion){
    // Carga los estados de la sala de atención médica desde el archivo
    DoblementeEnlazada<EstadoParaSalaDeCitasAtencionMedica> estados = cargarFlujoDeSalaDeAtencion(RUTA_SALA_DE_ATENCION);
    
    // Inicia en el primer nodo de la lista de estados
    Nodo<EstadoParaSalaDeCitasAtencionMedica> nodoActual = estados.getCabeza();
    
    // Recorre la lista de estados
    while(nodoActual != null){
        // Obtiene el estado actual
        EstadoParaSalaDeCitasAtencionMedica estadoActual = nodoActual.getValor();
        
        // Comprueba si el estado coincide con el nombre, apellido e identificación proporcionados
        if(estadoActual.getNombre().equals(nombre) &&
           estadoActual.getApellido().equals(apellido) &&
           estadoActual.getIdentificacion().equals(identificacion)){
            // Cambia el estado a "Flujo Continuo"
            estadoActual.setEstadoDeFlujo("Flujo Continuo");
        }
        // Avanza al siguiente nodo
        nodoActual = nodoActual.getSiguiente();
    }
    
    // Escribe los estados actualizados de vuelta al archivo
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_ATENCION))){
        // Reinicia la iteración desde el primer nodo
        nodoActual = estados.getCabeza();
        // Escribe cada estado en una nueva línea del archivo
        while(nodoActual != null){
            EstadoParaSalaDeCitasAtencionMedica estadoEspecifico = nodoActual.getValor();
            writer.write(estadoEspecifico.toString() + "\n");
            // Avanza al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
}

    
    //MISMA LOGICA QUE EL METODO DE cambiarEstadoDeSalaDeAtencionMedicaAFlujoContinuo
    //PERO EN VEZ DE VOLVERLO CONTINUO LO DETIENE
    //FUNCIONAMIENTO cambia el estado de una sala de atencion medica a flujo continuo
    //con base a una lsita doblemente enlazada parametrizando los datos con la clase
    //EstadoParaSalaDeCitasAtencionMedica para el funcionamiento adecuado internamente
    //y luego volver a grabar sobre escribiendo la informacion
    //NO RETORNADA SOLAMENTE ES UNA ACCION 
    public static void cambiarEstadoDeSalaDeAtencionMedicaAFlujoDetenido(String nombre,
        String apellido, String identificacion){
    // Carga los estados de la sala de atención médica desde el archivo
    DoblementeEnlazada<EstadoParaSalaDeCitasAtencionMedica> estados = cargarFlujoDeSalaDeAtencion(RUTA_SALA_DE_ATENCION);
    
    // Inicia en el primer nodo de la lista de estados
    Nodo<EstadoParaSalaDeCitasAtencionMedica> nodoActual = estados.getCabeza();
    
    // Recorre la lista de estados
    while(nodoActual != null){
        // Obtiene el estado actual
        EstadoParaSalaDeCitasAtencionMedica estadoActual = nodoActual.getValor();
        
        // Comprueba si el estado coincide con el nombre, apellido e identificación proporcionados
        if(estadoActual.getNombre().equals(nombre) &&
           estadoActual.getApellido().equals(apellido) &&
           estadoActual.getIdentificacion().equals(identificacion)){
            // Cambia el estado a "Detenido"
            estadoActual.setEstadoDeFlujo("Detenido");
        }
        // Avanza al siguiente nodo
        nodoActual = nodoActual.getSiguiente();
    }
    
    // Escribe los estados actualizados de vuelta al archivo
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_ATENCION))){
        // Reinicia la iteración desde el primer nodo
        nodoActual = estados.getCabeza();
        // Escribe cada estado en una nueva línea del archivo
        while(nodoActual != null){
            EstadoParaSalaDeCitasAtencionMedica estadoEspecifico = nodoActual.getValor();
            writer.write(estadoEspecifico.toString() + "\n");
            // Avanza al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
}

    
    //IMPORTANTE!!!!!!!!!
    
    //LOS METODOS HACIA ABAJO SIGUEN LA MISMA LOGICA PERO SON PARA CONTROLAR SALAS
    //DIFERENTES ES TODO PORQUE DE ESTA FORMA
    //PUES CADA SALA ES INDEPENDIENTE POR EJEMPLO LA DE PAGO NO DEBE SER LA MISMA
    //QUE LA DE ATENCION DE CITAS Y ASI SUCESIVAMENTE
    
    
    //PAGO DE CITAS DE FLUJO____________________________________________________
    
    public static DoblementeEnlazada<EstadoParaPagoDeCitasMedicas> cargarFlujoDeSalaDePagos(String rutaArchivo){
    // Crea una lista doblemente enlazada para almacenar los estados de la sala de pagos de citas médicas
    DoblementeEnlazada<EstadoParaPagoDeCitasMedicas> estados = new DoblementeEnlazada<>();
    try(FileReader fr = new FileReader(rutaArchivo);
        BufferedReader br = new BufferedReader(fr)){
        String linea;
        // Lee cada línea del archivo
        while((linea = br.readLine()) != null){
            // Obtiene los campos de la línea (nombre, apellido, identificación, estado)
            String nombre = obtenerCampo(linea, 0);
            String apellido = obtenerCampo(linea, 1);
            String identificacion = obtenerCampo(linea, 2);
            String estado = obtenerCampo(linea, 3);
            // Crea un nuevo estado inicial para la sala de pagos de citas médicas
            EstadoParaPagoDeCitasMedicas estadoInicial = 
                new EstadoParaPagoDeCitasMedicas(nombre, apellido, 
                identificacion, estado);
            // Agrega el estado inicial a la lista doblemente enlazada
            estados.agregarAlFinal(estadoInicial);
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
    // Devuelve la lista de estados de la sala de pagos de citas médicas
    return estados;
}

    
    public static void cambiarEstadoDeSalaDePagoDeCitasAFlujoContinuo(String nombre,
        String apellido, String identificacion){
    // Carga los estados de la sala de pago de citas médicas desde el archivo
    DoblementeEnlazada<EstadoParaPagoDeCitasMedicas> estados = cargarFlujoDeSalaDePagos(RUTA_SALA_DE_PAGO_DE_CITAS);
    
    // Inicia en el primer nodo de la lista de estados
    Nodo<EstadoParaPagoDeCitasMedicas> nodoActual = estados.getCabeza();
    
    // Recorre la lista de estados
    while(nodoActual != null){
        // Obtiene el estado actual
        EstadoParaPagoDeCitasMedicas estadoActual = nodoActual.getValor();
        
        // Comprueba si el estado coincide con el nombre, apellido e identificación proporcionados
        if(estadoActual.getNombre().equals(nombre) &&
           estadoActual.getApellido().equals(apellido) &&
           estadoActual.getIdentificacion().equals(identificacion)){
            // Cambia el estado a "Flujo Continuo"
            estadoActual.setEstadoDeFlujo("Flujo Continuo");
        }
        // Avanza al siguiente nodo
        nodoActual = nodoActual.getSiguiente();
    }
    
    // Escribe los estados actualizados de vuelta al archivo
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_PAGO_DE_CITAS))){
        // Reinicia la iteración desde el primer nodo
        nodoActual = estados.getCabeza();
        // Escribe cada estado en una nueva línea del archivo
        while(nodoActual != null){
            EstadoParaPagoDeCitasMedicas estadoEspecifico = nodoActual.getValor();
            writer.write(estadoEspecifico.toString() + "\n");
            // Avanza al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
}

    
    public static void cambiarEstadoDeSalaDePagoDeCitasAFlujoDetenido(String nombre,
            String apellido, String identificacion){
    // Carga los estados de la sala de pago de citas médicas desde el archivo
    DoblementeEnlazada<EstadoParaPagoDeCitasMedicas> estados = cargarFlujoDeSalaDePagos(RUTA_SALA_DE_PAGO_DE_CITAS);
    
    // Inicia en el primer nodo de la lista de estados
    Nodo<EstadoParaPagoDeCitasMedicas> nodoActual = estados.getCabeza();
    
    // Recorre la lista de estados
    while(nodoActual != null){
        // Obtiene el estado actual
        EstadoParaPagoDeCitasMedicas estadoActual = nodoActual.getValor();
        
        // Comprueba si el estado coincide con el nombre, apellido e identificación proporcionados
        if(estadoActual.getNombre().equals(nombre) &&
           estadoActual.getApellido().equals(apellido) &&
           estadoActual.getIdentificacion().equals(identificacion)){
            // Cambia el estado a "Detenido"
            estadoActual.setEstadoDeFlujo("Detenido");
        }
        // Avanza al siguiente nodo
        nodoActual = nodoActual.getSiguiente();
    }
    
    // Escribe los estados actualizados de vuelta al archivo
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_PAGO_DE_CITAS))){
        // Reinicia la iteración desde el primer nodo
        nodoActual = estados.getCabeza();
        // Escribe cada estado en una nueva línea del archivo
        while(nodoActual != null){
            EstadoParaPagoDeCitasMedicas estadoEspecifico = nodoActual.getValor();
            writer.write(estadoEspecifico.toString() + "\n");
            // Avanza al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
}

    
    //SALA DE AUTORIZACIONES FLUJO______________________________________________
    
    public static DoblementeEnlazada<EstadoDeFlujoParaAutorizaciones> cargarFlujoDeLaSalaDeAutorizacione(String rutaArchivo){
    // Crea una lista doblemente enlazada para almacenar los estados de flujo de la sala de autorizaciones
    DoblementeEnlazada<EstadoDeFlujoParaAutorizaciones> estados = new DoblementeEnlazada<>();
    try(FileReader fr = new FileReader(rutaArchivo);
        BufferedReader br = new BufferedReader(fr)){
        String linea;
        // Lee cada línea del archivo
        while((linea = br.readLine()) != null){
            // Obtiene los campos de la línea (nombre, apellido, identificación, estado)
            String nombre = obtenerCampo(linea, 0);
            String apellido = obtenerCampo(linea, 1);
            String identificacion = obtenerCampo(linea, 2);
            String estado = obtenerCampo(linea, 3);
            // Crea un nuevo estado inicial para la sala de autorizaciones
            EstadoDeFlujoParaAutorizaciones estadoInicial = 
                new EstadoDeFlujoParaAutorizaciones(nombre, apellido, identificacion,
                estado);
            // Agrega el estado inicial a la lista doblemente enlazada
            estados.agregarAlFinal(estadoInicial);
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
    // Devuelve la lista de estados de flujo de la sala de autorizaciones
    return estados;
}
    
    public static void cambiarEstadoDeSalaDeAutorizacionesAFlujoContinuo(String nombre,
        String apellido, String identificacion){
    // Carga los estados de flujo de la sala de autorizaciones desde el archivo
    DoblementeEnlazada<EstadoDeFlujoParaAutorizaciones> estados = cargarFlujoDeLaSalaDeAutorizacione(RUTA_SALA_DE_AUTORIZACIONES);
    
    // Inicia en el primer nodo de la lista de estados
    Nodo<EstadoDeFlujoParaAutorizaciones> nodoActual = estados.getCabeza();
    
    // Recorre la lista de estados
    while(nodoActual != null){
        // Obtiene el estado actual
        EstadoDeFlujoParaAutorizaciones estadoActual = nodoActual.getValor();
        
        // Comprueba si el estado coincide con el nombre, apellido e identificación proporcionados
        if(estadoActual.getNombre().equals(nombre) &&
           estadoActual.getApellido().equals(apellido) &&
           estadoActual.getIdentificacion().equals(identificacion)){
            // Cambia el estado a "Flujo Continuo"
            estadoActual.setEstadoDeFlujo("Flujo Continuo");
        }
        // Avanza al siguiente nodo
        nodoActual = nodoActual.getSiguiente();
    }
    
    // Escribe los estados actualizados de vuelta al archivo
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_AUTORIZACIONES))){
        // Reinicia la iteración desde el primer nodo
        nodoActual = estados.getCabeza();
        // Escribe cada estado en una nueva línea del archivo
        while(nodoActual != null){
            EstadoDeFlujoParaAutorizaciones estadoEspecifico = nodoActual.getValor();
            writer.write(estadoEspecifico.toString() + "\n");
            // Avanza al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
}

    
    public static void cambiarEstadoDeSalaDeAutorizacionesAFlujoDetenido(String nombre,
        String apellido, String identificacion){
    // Carga los estados de flujo de la sala de autorizaciones desde el archivo
    DoblementeEnlazada<EstadoDeFlujoParaAutorizaciones> estados = cargarFlujoDeLaSalaDeAutorizacione(RUTA_SALA_DE_AUTORIZACIONES);
    
    // Inicia en el primer nodo de la lista de estados
    Nodo<EstadoDeFlujoParaAutorizaciones> nodoActual = estados.getCabeza();
    
    // Recorre la lista de estados
    while(nodoActual != null){
        // Obtiene el estado actual
        EstadoDeFlujoParaAutorizaciones estadoActual = nodoActual.getValor();
        
        // Comprueba si el estado coincide con el nombre, apellido e identificación proporcionados
        if(estadoActual.getNombre().equals(nombre) &&
           estadoActual.getApellido().equals(apellido) &&
           estadoActual.getIdentificacion().equals(identificacion)){
            // Cambia el estado a "Detenido"
            estadoActual.setEstadoDeFlujo("Detenido");
        }
        // Avanza al siguiente nodo
        nodoActual = nodoActual.getSiguiente();
    }
    
    // Escribe los estados actualizados de vuelta al archivo
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_AUTORIZACIONES))){
        // Reinicia la iteración desde el primer nodo
        nodoActual = estados.getCabeza();
        // Escribe cada estado en una nueva línea del archivo
        while(nodoActual != null){
            EstadoDeFlujoParaAutorizaciones estadoEspecifico = nodoActual.getValor();
            writer.write(estadoEspecifico.toString() + "\n");
            // Avanza al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
}
    
    //SALA DE PAGO DE EXAMENES FLUJO_______________________________________
    
    public static DoblementeEnlazada<EstadoDeFlujoParaPagoDeExamenes> cargarFlujoDeLaSalaDePagoDeExamenes(String rutaArchivo){
        DoblementeEnlazada<EstadoDeFlujoParaPagoDeExamenes> estados = new DoblementeEnlazada<>();
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            while((linea = br.readLine()) != null){
                String nombre = obtenerCampo(linea, 0);
                String apellido = obtenerCampo(linea, 1);
                String identificacion = obtenerCampo(linea, 2);
                String estado = obtenerCampo(linea, 3);
                EstadoDeFlujoParaPagoDeExamenes estadoInicial = new
                EstadoDeFlujoParaPagoDeExamenes(nombre, apellido, identificacion,
                estado);
                estados.agregarAlFinal(estadoInicial);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return estados;
    }
        
    public static void cambiarEstadoDeSalaDePagoDeExamenesAFlujoContinuo(String nombre,
        String apellido, String identificacion){
        DoblementeEnlazada<EstadoDeFlujoParaPagoDeExamenes> estados = cargarFlujoDeLaSalaDePagoDeExamenes(RUTA_SALA_DE_EXAMENES);
        Nodo<EstadoDeFlujoParaPagoDeExamenes> nodoActual = estados.getCabeza();
        
        while(nodoActual != null){
            EstadoDeFlujoParaPagoDeExamenes estadoActual = nodoActual.getValor();
            if(estadoActual.getNombre().equals(nombre) &&
               estadoActual.getApellido().equals(apellido) &&
               estadoActual.getIdentificacion().equals(identificacion)){
                estadoActual.setEstadoDeFlujo("Flujo Continuo");
            }
            nodoActual = nodoActual.getSiguiente();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_EXAMENES))){
            nodoActual = estados.getCabeza();
            while(nodoActual != null){
                EstadoDeFlujoParaPagoDeExamenes estadoespecifico = nodoActual.getValor();
                writer.write(estadoespecifico.toString() + "\n");
                nodoActual = nodoActual.getSiguiente();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void cambiarEstadoDeSalaDePagoDeExamenesAFlujoDetenido(String nombre,
        String apellido, String identificacion){
        DoblementeEnlazada<EstadoDeFlujoParaPagoDeExamenes> estados = cargarFlujoDeLaSalaDePagoDeExamenes(RUTA_SALA_DE_EXAMENES);
        Nodo<EstadoDeFlujoParaPagoDeExamenes> nodoActual = estados.getCabeza();
        
        while(nodoActual != null){
            EstadoDeFlujoParaPagoDeExamenes estadoActual = nodoActual.getValor();
            if(estadoActual.getNombre().equals(nombre) &&
               estadoActual.getApellido().equals(apellido) &&
               estadoActual.getIdentificacion().equals(identificacion)){
                estadoActual.setEstadoDeFlujo("Detenido");
            }
            nodoActual = nodoActual.getSiguiente();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_EXAMENES))){
            nodoActual = estados.getCabeza();
            while(nodoActual != null){
                EstadoDeFlujoParaPagoDeExamenes estadoespecifico = nodoActual.getValor();
                writer.write(estadoespecifico.toString() + "\n");
                nodoActual = nodoActual.getSiguiente();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //SALA DE ATENCION DE EXAMENES FLUJO_______________________________________
    
    public static DoblementeEnlazada<EstadoDeFlujoParaAtencionDeExamenes> cargarFlujoDeSalaDeAtencionDeExamenes(String rutaArchivo){
    DoblementeEnlazada<EstadoDeFlujoParaAtencionDeExamenes> estados = new DoblementeEnlazada<>();
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            while((linea = br.readLine()) != null){
                String nombre = obtenerCampo(linea, 0);
                String apellido = obtenerCampo(linea, 1);
                String identificacion = obtenerCampo(linea, 2);
                String estado = obtenerCampo(linea, 3);
                EstadoDeFlujoParaAtencionDeExamenes estadoInicial = new
                EstadoDeFlujoParaAtencionDeExamenes(nombre, apellido, identificacion,
                estado);
                estados.agregarAlFinal(estadoInicial);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return estados;
    }
    
    public static void cambiarEstadoDeSalaDeAtencionDeExamenesAFlujoContinuo(String nombre,
        String apellido, String identificacion){
        DoblementeEnlazada<EstadoDeFlujoParaAtencionDeExamenes> estados = cargarFlujoDeSalaDeAtencionDeExamenes(RUTA_SALA_DE_ATENCION_EXAMENES);
        Nodo<EstadoDeFlujoParaAtencionDeExamenes> nodoActual = estados.getCabeza();
        
        while(nodoActual != null){
            EstadoDeFlujoParaAtencionDeExamenes estadoActual = nodoActual.getValor();
            if(estadoActual.getNombre().equals(nombre) &&
               estadoActual.getApellido().equals(apellido) &&
               estadoActual.getIdentificacion().equals(identificacion)){
                estadoActual.setEstadoDeFlujo("Flujo Continuo");
            }
            nodoActual = nodoActual.getSiguiente();
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_ATENCION_EXAMENES))){
            nodoActual = estados.getCabeza();
            while(nodoActual != null){
                EstadoDeFlujoParaAtencionDeExamenes estadoespecifico = nodoActual.getValor();
                writer.write(estadoespecifico.toString() + "\n");
                nodoActual = nodoActual.getSiguiente();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
   public static void cambiarEstadoDeSalaDeAtencionDeExamenesAFlujoDetenido(String nombre,
        String apellido, String identificacion){
    // Carga los estados de flujo de la sala de atención de exámenes desde el archivo
    DoblementeEnlazada<EstadoDeFlujoParaAtencionDeExamenes> estados = cargarFlujoDeSalaDeAtencionDeExamenes(RUTA_SALA_DE_ATENCION_EXAMENES);
    
    // Inicia en el primer nodo de la lista de estados
    Nodo<EstadoDeFlujoParaAtencionDeExamenes> nodoActual = estados.getCabeza();
    
    // Recorre la lista de estados
    while(nodoActual != null){
        // Obtiene el estado actual
        EstadoDeFlujoParaAtencionDeExamenes estadoActual = nodoActual.getValor();
        
        // Comprueba si el estado coincide con el nombre, apellido e identificación proporcionados
        if(estadoActual.getNombre().equals(nombre) &&
           estadoActual.getApellido().equals(apellido) &&
           estadoActual.getIdentificacion().equals(identificacion)){
            // Cambia el estado a "Detenido"
            estadoActual.setEstadoDeFlujo("Detenido");
        }
        // Avanza al siguiente nodo
        nodoActual = nodoActual.getSiguiente();
    }
    
    // Escribe los estados actualizados de vuelta al archivo
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SALA_DE_ATENCION_EXAMENES))){
        // Reinicia la iteración desde el primer nodo
        nodoActual = estados.getCabeza();
        // Escribe cada estado en una nueva línea del archivo
        while(nodoActual != null){
            EstadoDeFlujoParaAtencionDeExamenes estadoEspecifico = nodoActual.getValor();
            writer.write(estadoEspecifico.toString() + "\n");
            // Avanza al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }
    }catch(IOException e){
        // Maneja cualquier excepción de E/S imprimiendo el rastreo de la pila
        e.printStackTrace();
    }
}
}

