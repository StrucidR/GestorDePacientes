package com.asistentemedico.asistentedecitas.persistencia.Autorizacion;

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

    
    public static void guardarAutorizacion(String nombre, String apellido, String identificacion,
                                     String identificadordelacita, String ticket, int precio,
                                     String tipodeexamen, int identificadordeautorizacion,
                                     String descripcion, String ticketDeAutorizacion) {
        // Ruta del archivo
        String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_autorizacion.txt";
        
        try {
            // Crear FileWriter con la opción de añadir al archivo si ya existe
            FileWriter escritor = new FileWriter(rutaArchivo, true);
            
            // Escribir los parámetros en el archivo
            escritor.write(nombre + ", " + apellido + ", " + identificacion + ", " +
                           identificadordelacita + ", " + ticket + ", " + precio + ", " +
                           tipodeexamen + ", " + identificadordeautorizacion + ", " +
                           descripcion + ", " +"NoAutorizada" + ", " + ticketDeAutorizacion 
                           + "\n");
            
            // Cerrar FileWriter
            escritor.close();

        } catch (IOException e) {
            // Manejar cualquier error de entrada/salida
           
        }
    }
//_______________________________________________________________________________  
        public static void eliminarAutorizacion(String nombre, String apellido, String identificacion,
                                            String identificadordelacita, String ticket ) {
        String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_autorizacion.txt";
        String temporalArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/temporal.txt";

        try {
            FileReader lector = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(temporalArchivo);
            PrintWriter pw = new PrintWriter(escritor);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (!(campos[0].equals(nombre) && campos[1].equals(apellido) && campos[2].equals(identificacion)
                        && campos[3].equals(identificadordelacita) && campos[4].equals(ticket))) {
                    pw.println(linea);
                }
            }

            br.close();
            lector.close();
            pw.close();
            escritor.close();

            // Renombrar el archivo temporal al archivo original
            java.nio.file.Files.move(java.nio.file.Paths.get(temporalArchivo), java.nio.file.Paths.get(rutaArchivo),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        }
    }
//______________________________________________________________________________
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
        writeAutorizacionesToFile(autorizacionesActuales);
    } catch (IOException e) {
        System.err.println("Error al guardar la autorización: " + e.getMessage());
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

public static void writeAutorizacionesToFile(DoblementeEnlazada<String> autorizaciones) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
        Nodo<String> nodoActual = autorizaciones.getCabeza();
        while (nodoActual != null) {
            writer.println(nodoActual.getValor());
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
//_______________________________________________________________________________

        public static void eliminarAutorizacionDocumento1(String identificadorDeAutorizacion ) {
        String rutaArchivo = RUTA_ARCHIVO;
        String temporalArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/temporal.txt";

        try {
            FileReader lector = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(temporalArchivo);
            PrintWriter pw = new PrintWriter(escritor);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (!(campos[7].equals(identificadorDeAutorizacion) )) {
                    pw.println(linea);
                }
            }

            br.close();
            lector.close();
            pw.close();
            escritor.close();

            // Renombrar el archivo temporal al archivo original
            java.nio.file.Files.move(java.nio.file.Paths.get(temporalArchivo), java.nio.file.Paths.get(rutaArchivo),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        }
    }
        
        public static void eliminarAutorizacionDocumento2(String identificadorDeAutorizacion ) {
        String rutaArchivo = RUTA_ESPERA_AUTORIZACION;
        String temporalArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/temporal.txt";

        try {
            FileReader lector = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(temporalArchivo);
            PrintWriter pw = new PrintWriter(escritor);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (!(campos[7].equals(identificadorDeAutorizacion) )) {
                    pw.println(linea);
                }
            }

            br.close();
            lector.close();
            pw.close();
            escritor.close();

            // Renombrar el archivo temporal al archivo original
            java.nio.file.Files.move(java.nio.file.Paths.get(temporalArchivo), java.nio.file.Paths.get(rutaArchivo),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        }
    }
   
//_______________________________________________________________________________
    
        //ARREGLAR ESTO CON BASE A GESTORSALA Y SALA DE ESPERA
        
        public static void moverAutorizaciones(String nombreUsuario,
                String apellidoUsuario, String identificacion, String ticket){
            StringBuilder nuevasLineas = new StringBuilder();
            
            try(BufferedReader reader = new BufferedReader(new FileReader(RUTA_ESPERA_AUTORIZACION))){
                String linea;
                while((linea = reader.readLine()) != null){
                    String [] campos = linea.split(", ");
                    if(campos.length>= 9 && campos[0].equals(nombreUsuario)
                            && campos[1].equals(apellidoUsuario)  && 
                            campos[2].equals(identificacion) && 
                            campos[4].equals(ticket)){
                        campos[9] = "AutorizacionExitosa";
                        linea = String.join(", ", campos);
                    }
                    nuevasLineas.append(linea).append("\n");
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ESPERA_AUTORIZACION))){
                writer.write(nuevasLineas.toString());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public static void eliminarAutorizacionDeSala(){
            try{
                DoblementeEnlazada<String> autorizaciones =
                        readAutorizacionesFromFile();
                autorizaciones.eliminarDelInicio();
                writeAutorizacionesToFile(autorizaciones);

            }catch(IOException e){
                
            }
        }
 
//_______________________________________________________________________________
        
public static boolean verficicarAutorizacion(String identificadorCita, String ticket) {
    try (FileReader fr = new FileReader(RUTA_ESPERA_AUTORIZACION);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 10) { // Asegurarse de que haya al menos 10 campos en la línea
                String identificadorActual = campos[3];
                String ticketActual = campos[4];
                String estadoDeAutorizacion = campos[9]; // Suponiendo que el estado de pago está en la posición 9

                if (identificadorActual.equals(identificadorCita) &&
                        ticketActual.equals(ticket)
                        && estadoDeAutorizacion.equalsIgnoreCase("AutorizacionExitosa")) {
                    return true; // La cita está autorizada
                }
            } else {
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
}

public static boolean verificaridentificadordeautorizacion(String identificador){
    
    try(FileReader fr = new FileReader(RUTA_ESPERA_AUTORIZACION);
            BufferedReader br = new BufferedReader(fr)){
        String linea;
        while((linea = br.readLine()) != null){
            String[] campos = linea.split(", ");
            if(campos.length >= 5){
                String identificadorActual = campos[7];
                String estadoDeAutorizacion = campos[9];
                
                if(identificadorActual.equals(identificador) &&
                   estadoDeAutorizacion.equalsIgnoreCase("AutorizacionExitosa")){
                    return true;
                }
            }else{
                
            }
        }
    }catch(IOException e){
        e.printStackTrace();
    }
    
    return false;
} 

            
public static boolean verificarExamen(String tipoExamen) {
    try (FileReader fr = new FileReader(RUTA_ESPERA_AUTORIZACION);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 7) { // Asegurémonos de tener al menos 7 campos en la línea
                String examenActual = campos[6]; // Tipo de examen en la séptima posición
                if (examenActual.equalsIgnoreCase(tipoExamen)) {
                    return true; // El tipo de examen coincide
                }
            } else {
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false; // No se encontró el tipo de examen o hubo un error de lectura
}
        
            public static String traerCosto(String nombreUsuario,
                    String apellidoUsuario, String identificacionUsuario,
                    String identificadorDeCita,String ticket){
                    try (FileReader fr = new FileReader(RUTA_ESPERA_AUTORIZACION);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            
            String nombreActual = campos[0];
            String apellidoActual = campos[1];
            String identificacionActual = campos[2];
            String identificadorDeCitaActual = campos[3];
            String ticketActual = campos[4];
            // El identificador de la cita está en la posición 3
            if (nombreActual.equals(nombreUsuario) && apellidoActual.equals(apellidoUsuario)
                    && identificacionActual.equals(identificacionUsuario) &&
                    identificadorDeCitaActual.equals(identificadorDeCita) &&
                    ticketActual.equals(ticket)) {
                return campos[5];
            }
                }
            } catch (IOException e) {
             e.printStackTrace();
            }
            return null; // Si no se encuentra la cita, devuelve 0
                
            }
            
        public static String traerIdentificadordeAutorizacion(String nombreUsuario,
                    String apellidoUsuario, String identificacionUsuario,
                    String identificadorDeCita,String ticket){
                    try (FileReader fr = new FileReader(RUTA_ESPERA_AUTORIZACION);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            
            String nombreActual = campos[0];
            String apellidoActual = campos[1];
            String identificacionActual = campos[2];
            String identificadorDeCitaActual = campos[3];
            String ticketActual = campos[4];
            // El identificador de la cita está en la posición 3
            if (nombreActual.equals(nombreUsuario) && apellidoActual.equals(apellidoUsuario)
                    && identificacionActual.equals(identificacionUsuario) &&
                    identificadorDeCitaActual.equals(identificadorDeCita) &&
                    ticketActual.equals(ticket)) {
                return campos[7];
            }
                }
            } catch (IOException e) {
             e.printStackTrace();
            }
            return null; // Si no se encuentra la cita, devuelve 0
                
            }
        
        
            public static String traerDescripcion(String nombreUsuario,
                    String apellidoUsuario, String identificacionUsuario,
                    String identificadorDeCita,String ticket){
                    try (FileReader fr = new FileReader(RUTA_ESPERA_AUTORIZACION);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            
            String nombreActual = campos[0];
            String apellidoActual = campos[1];
            String identificacionActual = campos[2];
            String identificadorDeCitaActual = campos[3];
            String ticketActual = campos[4];
            // El identificador de la cita está en la posición 3
            if (nombreActual.equals(nombreUsuario) && apellidoActual.equals(apellidoUsuario)
                    && identificacionActual.equals(identificacionUsuario) &&
                    identificadorDeCitaActual.equals(identificadorDeCita) &&
                    ticketActual.equals(ticket)) {
                return campos[8];
            }
                }
            } catch (IOException e) {
             e.printStackTrace();
            }
            return null; // Si no se encuentra la cita, devuelve 0
                
            } 
        
            public static boolean verificarAutorizacionParaCancelar(
            String nombreUsuario, String apellidoUsuario, String identificacion,
            String identificadorDeAutorizacion, String ticket){
                try(FileReader fr = new FileReader(RUTA_ESPERA_AUTORIZACION);
                    BufferedReader br = new BufferedReader(fr)){
                    String linea;
                    while((linea = br.readLine())!= null){
                        String[] campos= linea.split(", ");
                        String nombreActual = campos[0];
                        String apellidoActual = campos[1];
                        String identificacionActual = campos[2];
                        String identificadorDeAutorizacionActual = campos[7];
                        String ticketActual = campos[4];
                        
                        if(nombreActual.equals(nombreUsuario) &&
                           apellidoActual.equals(apellidoUsuario) &&
                           identificacionActual.equals(identificacion) &&
                           identificadorDeAutorizacionActual.equals
                           (identificadorDeAutorizacion) &&
                            ticketActual.equals(ticket)){
                            return true;
                        }
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                
                return false;
            }
            
            public static void cancelarAutorizaciondeUnUsuario(String
            identificadorDeAutorizacion){
                try{
                    FileReader fr = new FileReader(RUTA_ESPERA_AUTORIZACION);
                    BufferedReader br = new BufferedReader(fr);
                    
                    String linea;
                    StringBuilder nuevasLineas = new StringBuilder();
                    while((linea = br.readLine())!= null){
                        String [] campos = linea.split(", ");
                        String identificadorDeAutorizacionActual=campos[7];
                        if(!identificadorDeAutorizacionActual.equals
                        (identificadorDeAutorizacion)){
                            nuevasLineas.append(linea).append("\n");
                        }
                    }
                    br.close();
                    fr.close();
                    
                    FileWriter fw = new FileWriter(RUTA_ESPERA_AUTORIZACION);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.print(nuevasLineas);
                    pw.close();
                    fw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
}
