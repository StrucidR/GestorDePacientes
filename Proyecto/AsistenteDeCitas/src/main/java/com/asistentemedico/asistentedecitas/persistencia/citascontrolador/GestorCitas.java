package com.asistentemedico.asistentedecitas.persistencia.citascontrolador;

import com.asistentemedico.asistentedecitas.logica.Cita.Cita;
import com.asistentemedico.asistentedecitas.logica.Cita.SalaDePago;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola.Cola;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada.Nodo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorCitas {

    // Constante que indica la ruta del archivo donde se escribirán las citas
    private static Cola<String> colaAutorizaciones = new Cola<>(); 
    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt";
    private static final String RUTA_SALA_DE_PAGOS = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/cola_de_pagos.txt";

    
    //ORGANIZAMIENTO DE CODIGO METODOS DE CARGA
    
    //Cargamoss desde archivo este metodo espera que le pasemos una ruta
    //y almacenaremos los datos en una lista doblemente enlazada
    //con base a los parametros de cita
    //que quiere decir?? una cita se almaacenara en un nodo
    //con toda la informacion respectiva de la clase
    public static DoblementeEnlazada<Cita>cargarCitasDesdeArchivo(String rutaArchivo){
        DoblementeEnlazada<Cita> citas = new DoblementeEnlazada<>();
        
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            
            while((linea = br.readLine()) != null){
                String nombre = obtenerCampo(linea, 0);
                String apellido = obtenerCampo(linea, 1);
                String identificacion = obtenerCampo(linea, 2);
                String identificador = obtenerCampo(linea, 3);
                String ticket = obtenerCampo(linea, 4);
                String costo = obtenerCampo(linea, 5);
                String doctor = obtenerCampo(linea, 6);
                String estado = obtenerCampo(linea, 7);
                String especialidad = obtenerCampo(linea, 8);
                String asistencia = obtenerCampo(linea, 9);
                String motivo = obtenerCampo(linea, 10);
                
                Cita cita = new Cita(nombre, apellido, identificacion, identificador,
                ticket, costo, doctor, estado, especialidad, asistencia, motivo);
                citas.agregarAlFinal(cita);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return citas;
    }
    //Misma logica para la carga de datos esperando una ruta
    //aprovechando los beneficios de la lista doble y 
    //la diferencia que con los parametros de la clase SalaDePago
    public static DoblementeEnlazada<SalaDePago> cargarCitasParaPagoDesdeArchivo(String rutaArchivo){
        
        DoblementeEnlazada<SalaDePago> citas = new DoblementeEnlazada<>();
        
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            
            while((linea = br.readLine()) != null){
                String nombre = obtenerCampo(linea, 0);
                String apellido = obtenerCampo(linea, 1);
                String identificacion = obtenerCampo(linea, 2);
                String ticket = obtenerCampo(linea, 3);
                SalaDePago saladepago = new SalaDePago(nombre, apellido, identificacion, ticket);
                citas.agregarAlFinal(saladepago);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return citas;
    }
    //El funcionamiento del metodo obtenerCampo es repititivo en diferentes clases
    //con la misma logica estructura pero para diferentes casos lo hice de esta forma
    //para una mayor estructura. El funcionamiento esta en
    //@param FlujoDeLaSala
    private static String obtenerCampo(String linea, int indice){
        int inicio = 0;
        int contador = 0;
        while(contador < indice){
            inicio = linea.indexOf(", " , inicio) + 2;
            contador++;
        }
        int fin = linea.indexOf(", ", inicio);
        if(fin == -1){
            fin = linea.length();
        }
        return linea.substring(inicio, fin).trim();
    }
    // Método para escribir las citas en un archivo
    public static void writeCitasToFile(DoblementeEnlazada<Cita> citas) throws IOException{
        // Se utiliza un try-with-resources para garantizar que el BufferedWriter se cierre correctamente al finalizar
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))){
            // Se obtiene la cabeza de la lista de cita
            Nodo<Cita> nodoActual = citas.getCabeza();
            // Se recorre la lista de citas
            while(nodoActual != null){
                 // Se obtiene la cita actual
                Cita cita = nodoActual.getValor();
                 // Se escribe la información de la cita en el archivo, separada por comas
                bw.write(cita.getNombre()+", " + cita.getApellido() + ", " + 
                cita.getIdentificacion() + ", " + cita.getIdentificador() + ", " +
                cita.getTicket() + ", " + cita.getCosto() + ", " + cita.getDoctor() +
                ", " + cita.getEstado() + ", " + cita.getEspecialidad() + ", " + 
                cita.getAsistencia() + ", " + cita.getMotivo());
                // Se escribe una nueva línea después de cada cita
                bw.newLine();
                // Se avanza al siguiente nodo de la lista
                nodoActual=nodoActual.getSiguiente();
            }
        }
    }
    
    /**
    * Este método estático se utiliza para escribir las citas en espera de pago en un archivo de texto.
    * Toma una lista doblemente enlazada de objetos SalaDePago y escribe la información de cada objeto
    * en el archivo especificado por la constante RUTA_SALA_DE_PAGOS.
    *
    * @param citas Una lista doblemente enlazada de objetos SalaDePago que contiene las citas en espera de pago.
    * @throws IOException Si ocurre un error de E/S al escribir en el archivo.
    */
    public static void writeCitasEnEsperaDePagoToFile(DoblementeEnlazada<SalaDePago> citas)throws IOException{
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_SALA_DE_PAGOS))){
            Nodo<SalaDePago> nodoActual = citas.getCabeza();
            // Se recorre la lista de citas en espera de pago
            while(nodoActual != null){
                // Se obtiene la cita en espera de pago actual
                SalaDePago cita = nodoActual.getValor();
                bw.write(cita.getNombre() + ", " + cita.getApellido()+ 
                ", " +  cita.getIdentificacion() + ", " + cita.getTicket());
                // Se escribe una nueva línea después de cada cita en espera de pago
                bw.newLine();
                // Se avanza al siguiente nodo de la lista
                nodoActual = nodoActual.getSiguiente();
            }
        }
    }
    
    
    
    public static void guardarCita(String cita) {
        
        try (FileWriter fw = new FileWriter(RUTA_ARCHIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(cita);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //SE LOGRO LA ELIMINACION DE UNA CITA DEL MEDIO CON METODOS COMO cargarCitasDesdeArchivo,obtenerCampo,writeCitasToFile,
    //CLASE CITA , eliminarDelMedioPorIdentificador DE LA CLASE DOBLEMENTE ENLAZADA AUNQUE ES MAS EXTENSO
    //ES MAS ROBUSTO Y MODULAR Y HACEMOS IMPLEMENTACION DE LAS ESTRUCTURAS DE DATOS Y DELEGAMOS
    //ENTRE LA MANIPULACION DE INFORMACION A METODOS ESPECIFICOS MIENTRAS QUE SI LO TRABAJABAMOS
    /**
     *     public static void eliminarCita2(String identificadorCita) {
        try {
            FileReader fr = new FileReader(RUTA_ARCHIVO);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            StringBuilder nuevasLineas = new StringBuilder();
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                String identificadorActual = campos[3];
                // El identificador de la cita está en la posición 3
                if (!identificadorActual.equals(identificadorCita)) {
                    nuevasLineas.append(linea).append("\n");
                }
            }

            br.close();
            fr.close();

            FileWriter fw = new FileWriter(RUTA_ARCHIVO);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(nuevasLineas);
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     * @param identificadorCita 
     */
    //CON ARREGLOS DE ESTA FORMA SE CONSIDERA MAS PRACTICO EN ASPECTOS COMO SIMPLICIDAD
    //EFICIENCIA MENOR COMPLEJIDAD , MENOS MODULARIDAD Y FLEXIBILIDAD YA QUE IMPIDE MANIPULACION
    //ESCRITURA DE DATOS EN UN SOLO METODO LO QUE DIFICULTA LA REUTILIZACION DE CODIGO
    //MANTENIMIENTO Y FLEXIBILIDAD YA QUE NO PROPORCIONA CAPACIDAD DE REALIZAR OTRAS OPERACIONES
    //EN LAS CITAS SANTES O DESPUES DE ELIMINAR UNA CITA COMO ORDENARLAS FILTRARLAS ETC

    
    //METODO GUIA PARA CANCELAR CITAS U AUTORIZACIONES U EXAMENES
    public static void eliminarCita(String identificadorCita){
        
        try{
            
            DoblementeEnlazada<Cita> citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);
            citas.eliminarDelMedioPorIdentificador(identificadorCita);
            writeCitasToFile(citas);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    //METODO GUIA PARA ELIMINAR CITAS DE SALA CUANDO LOS USUARIOS SALEN DE ELLA
    public static void eliminarDeSalaDePago(String ticket){
        
        try{
            
            DoblementeEnlazada<SalaDePago> citas =  cargarCitasParaPagoDesdeArchivo(RUTA_SALA_DE_PAGOS);
            citas.eliminarDelMedioPorTicketCitasEnEsperaDePago(ticket);
            writeCitasEnEsperaDePagoToFile(citas);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //ESTE METODO VERIFICA LA EXISTENCIA DE UNA CITA POR LOS PARAMETROS DESIGNADO
    //ABAJO Y HACE EL LLAMADO DEL METODO DE CARGAR CITAS DESDE ARCHIVI
    //PASANDO LA RUTA Y PARAMETRIZANDO CON LA CLASE CITA
    //QUE CUENTA CON LOS PARAMETROS PARA GESTIONAR ADECUADAMENTE LOS DATOS
    //Y ENLAZANDO CON UNA LISTA DOBLEMENTE
    public static boolean verificarCita(String nombreUsuario, String apellidoUsuario,
            String identificacion, String identificadorCita, String ticketCita, String
            especialidad, String motivo){
        
        DoblementeEnlazada<Cita> citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);
        Nodo<Cita> nodoActual = citas.getCabeza();
       
        while(nodoActual != null){
            
            Cita citaActual = nodoActual.getValor();
            
            if(citaActual.getNombre().equals(nombreUsuario) && 
               citaActual.getApellido().equals(apellidoUsuario) &&
               citaActual.getIdentificacion().equals(identificacion) &&
               citaActual.getIdentificador().equals(identificadorCita) &&
               citaActual.getTicket().equals(ticketCita) && 
               citaActual.getEspecialidad().equals(especialidad) &&
               citaActual.getMotivo().equals(motivo)){
               return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }

    public static double obtenerValorCita(String identifiadorCita){
        
        DoblementeEnlazada<Cita> citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);
        Nodo<Cita> nodoActual = citas.getCabeza();
        
        while(nodoActual != null){
            
            Cita citaActual = nodoActual.getValor();
            
            if(citaActual.getIdentificador().equals(identifiadorCita)){
                return Double.parseDouble(citaActual.getCosto());
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return 0;
    }

    public static boolean verificarCitaPagada(String identificadorCita, String ticket){
        
        DoblementeEnlazada<Cita> citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);
        Nodo<Cita> nodoActual = citas.getCabeza();
        
        while(nodoActual != null){
            
            Cita citaActual = nodoActual.getValor();
            
            if(citaActual.getIdentificador().equals(identificadorCita) &&
               citaActual.getTicket().equals(ticket) && 
               citaActual.getEstado().equalsIgnoreCase("Paga")){
                return true;
            }
            
            nodoActual = nodoActual.getSiguiente();
        }
        
        return false;
    }

    public static boolean verificarAsistenciaCita(String identificadorCita, String
    ticket){
        
        DoblementeEnlazada<Cita> citas=cargarCitasDesdeArchivo(RUTA_ARCHIVO);
        Nodo<Cita> nodoActual = citas.getCabeza();
        
        while(nodoActual != null){
            Cita citaActual = nodoActual.getValor();
            
            if(citaActual.getIdentificador().equals(identificadorCita) &&
               citaActual.getTicket().equals(ticket) && 
               citaActual.getAsistencia().equalsIgnoreCase("Asistida")){
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }

    public static void marcarCitaComoPagada(String ticket){
        
        DoblementeEnlazada<Cita> citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);
        Nodo<Cita> nodoActual = citas.getCabeza();
        
        while(nodoActual != null){
            Cita citaActual = nodoActual.getValor();
            if(citaActual.getTicket().equals(ticket)){
                citaActual.setEstado("Paga");
            }
            nodoActual = nodoActual.getSiguiente();
        }
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))){
            nodoActual = citas.getCabeza();
            
            while(nodoActual != null){
                Cita cita = nodoActual.getValor();
                writer.write(cita.toString() + "\n");
                nodoActual = nodoActual.getSiguiente();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static boolean usuarioEnSala(String nombre, String apellido, String 
     identifiacion, String ticket){
        
        DoblementeEnlazada<SalaDePago> citas = cargarCitasParaPagoDesdeArchivo(RUTA_SALA_DE_PAGOS);
        Nodo<SalaDePago> nodoActual = citas.getCabeza();
        
        while(nodoActual != null){
            SalaDePago citaActual = nodoActual.getValor();
            
            if(citaActual.getNombre().equals(nombre) && citaActual.getApellido().equals(apellido) &&
               citaActual.getIdentificacion().equals(identifiacion) && citaActual.getTicket().equals(ticket)){
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }
    
    public static void guardarEnSalaDePagos(String nombre, String apellido, String identificacion,
    String ticket){
            String autorizacion = nombre + ", " + apellido + 
            ", " + identificacion + ", " + ticket;
            colaAutorizaciones.enqueue(autorizacion);
            try{
            writeAutorizacionToFile(autorizacion);
            }catch(IOException e){
            }
    }
    
    private static DoblementeEnlazada<String> readAutorizacionesFromFile() throws IOException {
    DoblementeEnlazada<String> autorizaciones = new DoblementeEnlazada<>();
    
    try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_SALA_DE_PAGOS))) {
        String line;
        
        while ((line = reader.readLine()) != null) {
            // Procesa la línea como desees, por ejemplo, imprimiéndola
            autorizaciones.agregarAlFinal(line);
        }
    }
    return autorizaciones;
    }

    private static void writeAutorizacionToFile(String autorizacion) throws IOException {
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_PAGOS, true))) {
             writer.println(autorizacion);
        }
    }

    private static void writeAutorizacionesToFile2(DoblementeEnlazada<String> autorizaciones) throws IOException {
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_PAGOS))) {
        
            DoblementeEnlazada.Nodo<String> nodoActual = autorizaciones.getCabeza();
        
            while (nodoActual != null) {
            
                writer.println(nodoActual.getValor());
            
                nodoActual = nodoActual.getSiguiente();
        }
    }
}

    public static void eliminarAutorizacionDeSala(){
        
            try{
                DoblementeEnlazada<String> autorizaciones =
                readAutorizacionesFromFile();
                autorizaciones.eliminarDelInicio();
                writeAutorizacionesToFile2(autorizaciones);

            }catch(IOException e){
            }
        }
    
    public static boolean verificaridentificadordeautorizacion(String ticket){
        
        DoblementeEnlazada<Cita> citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);
        Nodo<Cita> nodoActual = citas.getCabeza();
        
        while(nodoActual != null){
            Cita citaActual = nodoActual.getValor();
            if(citaActual.getTicket().equals(ticket) &&
               citaActual.getEstado().equalsIgnoreCase("Paga")){
             return true;   
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }
    
}