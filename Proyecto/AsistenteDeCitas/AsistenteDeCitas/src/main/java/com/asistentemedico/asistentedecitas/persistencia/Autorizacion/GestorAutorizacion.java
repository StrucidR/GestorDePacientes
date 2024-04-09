package com.asistentemedico.asistentedecitas.persistencia.Autorizacion;

import com.asistentemedico.asistentedecitas.logica.Autorizacion.Autorizacion;
import com.asistentemedico.asistentedecitas.logica.Autorizacion.SalaDeAutorizaciones;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada.Nodo;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Pila.Pila;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorAutorizacion {
    
    private static Pila<String> pilaAutorizaciones = new Pila<>();
    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera_autorizacion.txt";
    private static final String RUTA_ESPERA_AUTORIZACION= "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_autorizacion.txt";

    
    public static DoblementeEnlazada<SalaDeAutorizaciones> cargarSalaDeAutorizacionesDesdeArchivo(String rutaArchivo){
        DoblementeEnlazada<SalaDeAutorizaciones> salaDeAutorizaciones = new DoblementeEnlazada<>();
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            
            while((linea = br.readLine())!= null){
                String nombre = obtenerCampo(linea, 0);
                String apellido= obtenerCampo(linea, 1);
                String identificacion = obtenerCampo(linea, 2);
                String identificadorDeCita = obtenerCampo(linea, 3);
                String ticketDeCita = obtenerCampo(linea, 4);
                String costo = obtenerCampo(linea, 5);
                String tipoExamen = obtenerCampo(linea, 6);
                String identificadorDeAutorizacion = obtenerCampo(linea, 7);
                String descripcion = obtenerCampo(linea, 8);
                String estadoDeAutorizacion = obtenerCampo(linea, 9);
                
                SalaDeAutorizaciones saladeautorizaciones = new SalaDeAutorizaciones(nombre,
                apellido, identificacion, identificadorDeCita, ticketDeCita,
                costo, tipoExamen,identificadorDeAutorizacion,descripcion,
                estadoDeAutorizacion);
                salaDeAutorizaciones.agregarAlInicio(saladeautorizaciones);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return salaDeAutorizaciones;
    }
    
    public static void writeSalaDeAutorizacionesToFile(DoblementeEnlazada<SalaDeAutorizaciones> saladeautorizaciones)throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))){
            Nodo<SalaDeAutorizaciones> nodoActual = saladeautorizaciones.getCabeza();
            while(nodoActual != null){
                SalaDeAutorizaciones saladeautorizacion = nodoActual.getValor();
                bw.write(saladeautorizacion.getNombreUsuario() + ", " +
                saladeautorizacion.getApellidoUsuario() + ", " + 
                saladeautorizacion.getIdentificacion() + ", " +
                saladeautorizacion.getIdentificadordecita() + ", " +
                saladeautorizacion.getTicketdecita()+ ", " +
                saladeautorizacion.getCosto() + ", " +
                saladeautorizacion.getTipoExamen() + ", " +
                saladeautorizacion.getIdentificadordeautorizacion() + ", " +
                saladeautorizacion.getDescripcion()+ ", " +
                saladeautorizacion.getEstadodeautorizacion());
                bw.newLine();
                nodoActual = nodoActual.getSiguiente();
            }
        }
    } 
    
    public static DoblementeEnlazada<Autorizacion> cargarAutorizacionesDesdeArchivo(String rutaArchivo){
        DoblementeEnlazada<Autorizacion> autorizaciones = new DoblementeEnlazada<>();
        
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            
            while((linea = br.readLine()) != null){
                String nombre=obtenerCampo(linea, 0);
                String apellido=obtenerCampo(linea, 1);
                String identificacion=obtenerCampo(linea, 2);
                String identificadorDeCita=obtenerCampo(linea, 3);
                String ticketDeCita=obtenerCampo(linea, 4);
                String costo =obtenerCampo(linea, 5);
                String tipoExamen =obtenerCampo(linea, 6);
                String identificadorDeautorizacion=obtenerCampo(linea, 7);
                String descripcion=obtenerCampo(linea, 8);
                String estado=obtenerCampo(linea, 9);
                String ticketDeAutorizacion =obtenerCampo(linea, 10);
                
                Autorizacion autorizacion = new Autorizacion(nombre, apellido,
                identificacion, identificadorDeCita, ticketDeCita, costo, tipoExamen,
                identificadorDeautorizacion, descripcion, estado, ticketDeAutorizacion);
                autorizaciones.agregarAlFinal(autorizacion);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return autorizaciones;
    }

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
    
    public static void writeAutorizacionestofile(DoblementeEnlazada<Autorizacion> autorizaciones) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ESPERA_AUTORIZACION))){
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacion = nodoActual.getValor();
                bw.write(autorizacion.getNombre()+", " + autorizacion.getApellido() +
                ", " + autorizacion.getIdentificacion() + ", " + autorizacion.getIdentificadordelacita() + ", " +
                autorizacion.getTicketdelacita() + ", " + autorizacion.getPrecio() + ", " +
                autorizacion.getTipoExamen()+", "+autorizacion.getIdentificadordeautorizacion() + ", " +
                autorizacion.getDescripcion() + ", " + autorizacion.getEstado() + ", " + autorizacion.getTicketDeAutorizacion());
                bw.newLine();
                nodoActual=nodoActual.getSiguiente();
            }
        }
    }
    
    public static void guardarAutorizacion(String nombre, String apellido, String identificacion,
        String identificadordelacita, String ticket, int precio,String tipodeexamen, int identificadordeautorizacion,
        String descripcion, String ticketDeAutorizacion) {
        // Ruta del archivo
        String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_autorizacion.txt";
        try {// Crear FileWriter con la opción de añadir al archivo si ya existe
        FileWriter escritor = new FileWriter(rutaArchivo, true);
        // Escribir los parámetros en el archivo
        escritor.write(nombre + ", " + apellido + ", " + identificacion + ", " +
        identificadordelacita + ", " + ticket + ", " + precio + ", " +
        tipodeexamen + ", " + identificadordeautorizacion + ", " +
        descripcion + ", " +"NoAutorizada" + ", " + ticketDeAutorizacion+ "\n");
        // Cerrar FileWriter
        escritor.close();
        } catch (IOException e) {// Manejar cualquier error de entrada/salida
        }
    }

    public static void guardarEnSalaDeEspera(String nombre, String apellido, String identificacion,
                                          String identificadordelacita, String ticket, int precio,
                                          String tipodeexamen, int identificadordeautorizacion,
                                          String descripcion) {
    String autorizacion = nombre + ", " + apellido + ", " + identificacion + ", " +
                          identificadordelacita + ", " + ticket + ", " + precio + ", " +
                          tipodeexamen + ", " + identificadordeautorizacion + ", " +
                          descripcion + ", " + "NoAutorizada";
    // Guardar la autorización en la pila
    pilaAutorizaciones.push(autorizacion);
    try {
        // Leer todas las autorizaciones del archivo
        DoblementeEnlazada<String> autorizacionesActuales = readAutorizacionesFromFile();
        // Agregar la nueva autorización al principio de la lista
        autorizacionesActuales.agregarAlInicio(autorizacion);
        // Escribir las autorizaciones actualizadas en el archivo
        writeAutorizacionEnSala(autorizacionesActuales);
    } catch (IOException e) {
    }
}

    private static DoblementeEnlazada<String> readAutorizacionesFromFile() throws IOException {
    DoblementeEnlazada<String> autorizaciones = new DoblementeEnlazada<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
        String line;
        while ((line = reader.readLine()) != null) {
            autorizaciones.agregarAlFinal(line);
        }
    }
    return autorizaciones;
}

    public static void writeAutorizacionEnSala(DoblementeEnlazada<String> autorizaciones) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
        Nodo<String> nodoActual = autorizaciones.getCabeza();
        while (nodoActual != null) {
            writer.println(nodoActual.getValor());
            nodoActual = nodoActual.getSiguiente();
        }
    }
}

    //ARREGLAR ESTO CON BASE A GESTORSALA Y SALA DE ESPERA
    public static void moverAutorizaciones(String nombreUsuario,
            String apellidoUsuario, String identificacionUsuario, String ticket){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getNombre().equals(nombreUsuario) &&
                   autorizacionActual.getApellido().equals(apellidoUsuario) &&
                   autorizacionActual.getIdentificacion().equals(identificacionUsuario) &&
                   autorizacionActual.getTicketdelacita().equals(ticket)){
                    autorizacionActual.setEstado("AutorizacionExitosa");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ESPERA_AUTORIZACION))){
                nodoActual = autorizaciones.getCabeza();
                while(nodoActual != null){
                    Autorizacion autorizacion = nodoActual.getValor();
                    writer.write(autorizacion.toString()+"\n");
                    nodoActual = nodoActual.getSiguiente();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
    public static void eliminarAutorizacionDeSala(){
        try{
        DoblementeEnlazada<String>autorizaciones=readAutorizacionesFromFile();
        autorizaciones.eliminarDelInicio();
        writeAutorizacionEnSala(autorizaciones);
        }catch(IOException e){
        }
        }
 
    public static boolean verficicarAutorizacion(String identificadorCita, String ticket){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getIdentificadordelacita().equals(identificadorCita) &&
                   autorizacionActual.getTicketdelacita().equals(ticket) &&
                   autorizacionActual.getEstado().equalsIgnoreCase("AutorizacionExitosa")){
                    return true;
                }
                
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
    }

    public static boolean verificaridentificadordeautorizacion(String identificador){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getIdentificadordeautorizacion().equals(identificador) &&
                   autorizacionActual.getEstado().equalsIgnoreCase("AutorizacionExitosa")){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }
        
    public static boolean verificarExamen(String tipoExamen){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getTipoExamen().equalsIgnoreCase(tipoExamen)){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }

    public static String traerCosto(String nombreUsuario,String apellidoUsuario,
                String identificacionUsuario, String identificadorDeCita, String ticket){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getNombre().equals(nombreUsuario) &&
                   autorizacionActual.getApellido().equals(apellidoUsuario) &&
                   autorizacionActual.getIdentificacion().equals(identificacionUsuario) &&
                   autorizacionActual.getIdentificadordelacita().equals(identificadorDeCita) &&
                   autorizacionActual.getTicketdelacita().equals(ticket)){
                    return autorizacionActual.getPrecio();
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return null;
        }
            
    public static String traerIdentificadordeAutorizacion(String nombreUsuario,
                String apellidoUsuario, String identificacionUsuario, String identificadorDeCita,
                String ticket){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getNombre().equals(nombreUsuario) &&
                   autorizacionActual.getApellido().equals(apellidoUsuario) &&
                   autorizacionActual.getIdentificacion().equals(identificacionUsuario) &&
                   autorizacionActual.getIdentificadordelacita().equals(identificadorDeCita) &&
                   autorizacionActual.getTicketdelacita().equals(ticket)){
                    return autorizacionActual.getIdentificadordeautorizacion();
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return null;
        }
            
    public static String traerDescripcion(String nombreUsuario,
            String apellidoUsuario, String identificacionUsuario,
            String identificadorDeCita, String ticket){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getNombre().equals(nombreUsuario) &&
                   autorizacionActual.getApellido().equals(apellidoUsuario) &&
                   autorizacionActual.getIdentificacion().equals(identificacionUsuario) &&
                   autorizacionActual.getIdentificadordelacita().equals(identificadorDeCita) &&
                   autorizacionActual.getTicketdelacita().equals(ticket)){
                    return autorizacionActual.getDescripcion();
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return null;
        }
        
            //METODOS PARA EL FUNCIONAMIENTO ADECUADO DE ESPERA_DE_AUTORIZACION
            //LOGICA IGUAL A LA CLASE DE GESTORCITAS PERO DIVISION DE RESPONSABILIDADES
            //POR METODOS DE UNA FORMA MAS COMPLETA PARA LA ASIGNACION DE USO UNICO
            //COMPLEMENTANDO O CUMPLIENDO UN DISEÑO ESCALABLE A FUTURO PARA
            //HACER MANTENIMIENTO DE CODIGO O MEJORAS MISMA LOGICA
            //METODOS SIMILARES FUNCIONAMIENTO DISTINTOS
            
    public static boolean verificarAutorizacionParaCancelar(
            String nombreUsuario, String apellidoUsuario, String identificacion,
            String identificadorDeAutorizacion, String ticket){
                
                DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
                Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
                while(nodoActual != null){
                    Autorizacion autorizacionActual = nodoActual.getValor();
                    if(autorizacionActual.getNombre().equals(nombreUsuario) &&
                       autorizacionActual.getApellido().equals(apellidoUsuario) &&
                       autorizacionActual.getIdentificacion().equals(identificacion) &&
                       autorizacionActual.getIdentificadordeautorizacion().equals(identificadorDeAutorizacion) &&
                       autorizacionActual.getTicketdelacita().equals(ticket)){
                        return true;
                    }
                    nodoActual = nodoActual.getSiguiente();
                }
                return false;
            }
           
    public static void eliminarAutorizacion(String nombreUsuario,
            String apellidoUsuario, String identificacionUsuario,
            String identificadorDeCita, String ticketCita){
                try{
                    DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
                    autorizaciones.eliminarDelMedioUnaAutorizacionAlProcederASala
                    (nombreUsuario, apellidoUsuario, 
                     identificacionUsuario, identificadorDeCita,
                     ticketCita);
                    writeAutorizacionestofile(autorizaciones);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            
    public static void cancelarAutorizaciondeUnUsuario(String identificadorDeAutorizacion){
                try{
                    DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
                    autorizaciones.eliminarDelMedioUnaAutorizacion(identificadorDeAutorizacion);
                    writeAutorizacionestofile(autorizaciones);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            
    public static void eliminarAutorizacionDocumento2(String identificadorDeAutorizacion){
                try{
                    DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ESPERA_AUTORIZACION);
                    autorizaciones.eliminarDelMedioUnaAutorizacion(identificadorDeAutorizacion);
                    writeAutorizacionestofile(autorizaciones);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            
    public static void eliminarAutorizacionDocumento1(String identificadorDeAutorizacion){
                try{
                    DoblementeEnlazada<SalaDeAutorizaciones> saladeautorizaciones = cargarSalaDeAutorizacionesDesdeArchivo(RUTA_ARCHIVO);
                    saladeautorizaciones.eliminarDelMedioUnaAutorizacionEnSala(identificadorDeAutorizacion);
                    writeSalaDeAutorizacionesToFile(saladeautorizaciones);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
}