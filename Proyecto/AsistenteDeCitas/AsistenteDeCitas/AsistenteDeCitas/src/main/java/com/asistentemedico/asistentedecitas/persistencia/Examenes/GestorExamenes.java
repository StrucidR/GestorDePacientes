package com.asistentemedico.asistentedecitas.persistencia.Examenes;

import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola.Cola;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada.Nodo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorExamenes {
    
        private static Cola<String> colaAutorizaciones = new Cola<>(); 
        private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_autorizacion.txt";
        private static final String RUTA_ARCHIVO_EXAMENES = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/examenes.txt";
        private static final String RUTA_SALA = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_sala_examenes.txt";
        private static final String RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES="src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_atencion_examenes.txt";
        
        public static boolean verificarAutorizacion(String identificadordeAutorizaion,
        String ticketdeAutorizacion){
                try (FileReader fr = new FileReader(RUTA_ARCHIVO);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 10) { // Asegurarse de que haya al menos 10 campos en la línea
                String identificadorActual = campos[7];
                String ticketActual = campos[10];
                String estadoDeAutorizacion = campos[9]; // Suponiendo que el estado de pago está en la posición 9

                if (identificadorActual.equals(identificadordeAutorizaion) &&
                        ticketActual.equals(ticketdeAutorizacion)
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
        
     
        public static boolean examenAgendado(String identificadordeAutorizacion,
                String ticketdeAutorizacion){
                            try (FileReader fr = new FileReader(RUTA_ARCHIVO_EXAMENES);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 4) { // Asegurarse de que haya al menos 10 campos en la línea
                String identificadorActual = campos[2];
                String ticketActual = campos[3];
                String estadoDeAutorizacion = campos[7]; // Suponiendo que el estado de pago está en la posición 9

                if (identificadorActual.equals(identificadordeAutorizacion) &&
                        ticketActual.equals(ticketdeAutorizacion)
                        && estadoDeAutorizacion.equalsIgnoreCase("examenPago")) {
                    return true; // La cita está autorizada
                }
            } else {
                return false;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
            
            return false;
        }
        
        public static boolean examenYaAsistido(String identificadordeAutorizacion,
        String ticketdeAutorizacion){
                                        try (FileReader fr = new FileReader(RUTA_ARCHIVO_EXAMENES);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 4) { // Asegurarse de que haya al menos 10 campos en la línea
                String identificadorActual = campos[2];
                String ticketActual = campos[3];
                String estadoDeAutorizacion = campos[8]; // Suponiendo que el estado de pago está en la posición 9

                if (identificadorActual.equals(identificadordeAutorizacion) &&
                        ticketActual.equals(ticketdeAutorizacion)
                        && estadoDeAutorizacion.equalsIgnoreCase("Asistido")) {
                    return true; // La cita está autorizada
                }
            } else {
                return false;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
            
            return false;
        }
        
        public static void guardarAutorizacion(String nombre, String apellido,
                                     String identificadordeAutorizacion, String ticketDeAutorizacion, String precio,
                                     String tipodeexamen,
                                     String descripcion) {
        // Ruta del archivo
        String rutaArchivo = RUTA_ARCHIVO_EXAMENES;
        
        try {
            // Crear FileWriter con la opción de añadir al archivo si ya existe
            FileWriter escritor = new FileWriter(rutaArchivo, true);
            
            // Escribir los parámetros en el archivo
            escritor.write(nombre + ", " + apellido + ", " +
                           identificadordeAutorizacion + ", " + ticketDeAutorizacion + ", " + precio + ", " +
                           tipodeexamen + ", " +
                           descripcion + ", " +"examenNoPago" + ", " + "NoAsistido"  
                           + "\n");
            
            // Cerrar FileWriter
            escritor.close();

        } catch (IOException e) {
            // Manejar cualquier error de entrada/salida
           
        }
    }
        
        public static void eliminarExamen(String identificadordeExamen, String
        ticketdeExamen){
        String temporalArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/temporal.txt";
        try {
            FileReader lector = new FileReader(RUTA_ARCHIVO_EXAMENES);
            BufferedReader br = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(temporalArchivo);
            PrintWriter pw = new PrintWriter(escritor);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (!(campos[2].equals(identificadordeExamen)
                        && campos[3].equals(ticketdeExamen))) {
                    pw.println(linea);
                }
            }

            br.close();
            lector.close();
            pw.close();
            escritor.close();

            // Renombrar el archivo temporal al archivo original
            java.nio.file.Files.move(java.nio.file.Paths.get(temporalArchivo), java.nio.file.Paths.get(RUTA_ARCHIVO_EXAMENES),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
        }
        }
        
        
        public static String traerDescripcion(String nombreUsuario,
                    String apellidoUsuario, String identificacionUsuario,
                    String identificadorDeCita,String ticketdeAutorizacion){
                    try (FileReader fr = new FileReader(RUTA_ARCHIVO);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            
            String nombreActual = campos[0];
            String apellidoActual = campos[1];
            String identificacionActual = campos[2];
            String identificadorDeCitaActual = campos[7];
            String ticketActual = campos[10];
            // El identificador de la cita está en la posición 3
            if (nombreActual.equals(nombreUsuario) && apellidoActual.equals(apellidoUsuario)
                    && identificacionActual.equals(identificacionUsuario) &&
                    identificadorDeCitaActual.equals(identificadorDeCita) &&
                    ticketActual.equals(ticketdeAutorizacion)) {
                return campos[8];
            }
                }
            } catch (IOException e) {
             e.printStackTrace();
            }
            return null; // Si no se encuentra la cita, devuelve 0
                
            }
        
                public static String traerCosto(String nombreUsuario,
                    String apellidoUsuario,
                    String identificadorDeCita,String ticketdeAutorizacion){
                    try (FileReader fr = new FileReader(RUTA_ARCHIVO);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            
            String nombreActual = campos[0];
            String apellidoActual = campos[1];
            String identificadorDeCitaActual = campos[7];
            String ticketActual = campos[10];
            // El identificador de la cita está en la posición 3
            if (nombreActual.equals(nombreUsuario) && apellidoActual.equals(apellidoUsuario)
                    && 
                    identificadorDeCitaActual.equals(identificadorDeCita) &&
                    ticketActual.equals(ticketdeAutorizacion)) {
                return campos[5];
            }
                }
            } catch (IOException e) {
             e.printStackTrace();
            }
            return null; // Si no se encuentra la cita, devuelve 0
                
            }
                
                
         public static String traerCosto2(String nombreUsuario,
                    String apellidoUsuario,
                    String identificadorDeCita,String ticketdeAutorizacion){
                    try (FileReader fr = new FileReader(RUTA_ARCHIVO_EXAMENES);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            
            String nombreActual = campos[0];
            String apellidoActual = campos[1];
            String identificadorDeCitaActual = campos[2];
            String ticketActual = campos[3];
            // El identificador de la cita está en la posición 3
            if (nombreActual.equals(nombreUsuario) && apellidoActual.equals(apellidoUsuario)
                    && 
                    identificadorDeCitaActual.equals(identificadorDeCita) &&
                    ticketActual.equals(ticketdeAutorizacion)) {
                return campos[4];
            }
                }
            } catch (IOException e) {
             e.printStackTrace();
            }
            return null; // Si no se encuentra la cita, devuelve 0
                
            }
                
                  
            public static String traerTipoExamen(String nombreUsuario,
                    String apellidoUsuario, String identificacionUsuario,
                    String identificadorDeCita,String ticketdeAutorizacion){
                    try (FileReader fr = new FileReader(RUTA_ARCHIVO);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            
            String nombreActual = campos[0];
            String apellidoActual = campos[1];
            String identificacionActual = campos[2];
            String identificadorDeCitaActual = campos[7];
            String ticketActual = campos[10];
            // El identificador de la cita está en la posición 3
            if (nombreActual.equals(nombreUsuario) && apellidoActual.equals(apellidoUsuario)
                    && identificacionActual.equals(identificacionUsuario) &&
                    identificadorDeCitaActual.equals(identificadorDeCita) &&
                    ticketActual.equals(ticketdeAutorizacion)) {
                return campos[6];
            }
                }
            } catch (IOException e) {
             e.printStackTrace();
            }
            return null; // Si no se encuentra la cita, devuelve 0
                
            }
        
            
            
        public static void guardarEnSalaDeEspera(String nombre, String apellido,
            String identificadorDeExamen, String ticketDeExamenes){
            
            String autorizacion = nombre + ", " + apellido + ", " + identificadorDeExamen + ", " +
                          ticketDeExamenes;
            
            colaAutorizaciones.enqueue(autorizacion);
            try{
            writeAutorizacionToFile(autorizacion);
            }catch(IOException e){
                
            }
        }
        
        private static DoblementeEnlazada<String> readAutorizacionesFromFile() throws IOException {
            DoblementeEnlazada<String> autorizaciones = new DoblementeEnlazada<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_SALA))) {
        String line;
        while ((line = reader.readLine()) != null) {
            // Procesa la línea como desees, por ejemplo, imprimiéndola
            autorizaciones.agregarAlFinal(line);
        }
    }
    return autorizaciones;
}
        
        private static void writeAutorizacionToFile(String autorizacion) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA, true))) {
        writer.println(autorizacion);
    }
}

        private static void writeAutorizacionesToFile2(DoblementeEnlazada<String> autorizaciones) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA))) {
        Nodo<String> nodoActual = autorizaciones.getCabeza();
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
        
               
        
        
        public static void guardarEnSalaDeAtencionDeExamenes(String nombre, String apellido,
        String identificadorDeExamen, String ticketDeExamen){
            String autorizacion = nombre + ", " + apellido + ", " + identificadorDeExamen +
            ", " + ticketDeExamen;
            
            colaAutorizaciones.enqueue(autorizacion);
            try{
                writeExamenToFile(autorizacion);
            }catch(IOException e){
                
            }
        }
        
        
        private static DoblementeEnlazada<String> readExamenesSala() throws IOException{
            
            DoblementeEnlazada<String> autorizaciones = new DoblementeEnlazada<>();
            
            try(BufferedReader reader = new BufferedReader(new FileReader(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES))){
                String line;
                while((line = reader.readLine()) != null){
                    autorizaciones.agregarAlFinal(line);
                }
            }
            
            return autorizaciones;
        }
        
        
        private static void writeExamenToFile(String autorizacion) throws IOException{
            try(PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES, true))){
                writer.println(autorizacion);
            }
        }
        
        
        private static void writeExamenToFile2(DoblementeEnlazada<String> autorizaciones) throws IOException{
            try(PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES))){
                Nodo<String> nodoActual = autorizaciones.getCabeza();
                while(nodoActual != null){
                    writer.println(nodoActual.getValor());
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        
        public static void eliminarExamenDeSala(){
            try{
                DoblementeEnlazada<String> autorizaciones =
                readExamenesSala();
                autorizaciones.eliminarDelInicio();
                writeExamenToFile2(autorizaciones);
            }catch(IOException e){
                
            }
        }
        
        
        
        
public static void moverAutorizaciones(String nombreUsuario, String apellidoUsuario, String identificacion, String ticket) {
    StringBuilder nuevasLineas = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO_EXAMENES))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 7 && campos[0].equals(nombreUsuario)
                    && campos[1].equals(apellidoUsuario) && campos[2].equals(identificacion)
                    && campos[3].equals(ticket)) {
                campos[7] = "examenPago";
                linea = String.join(", ", campos);
            }
            nuevasLineas.append(linea).append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_EXAMENES))) {
        writer.write(nuevasLineas.toString().trim()); // Eliminar espacio en blanco al final
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void moverExamenAsistido(String nombreUsuario, String apellidoUsuario,
        String identificacion, String ticket){
        StringBuilder nuevasLineas = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO_EXAMENES))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 7 && campos[0].equals(nombreUsuario)
                    && campos[1].equals(apellidoUsuario) && campos[2].equals(identificacion)
                    && campos[3].equals(ticket)) {
                campos[8] = "Asistido";
                linea = String.join(", ", campos);
            }
            nuevasLineas.append(linea).append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_EXAMENES))) {
        writer.write(nuevasLineas.toString().trim()); // Eliminar espacio en blanco al final
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public static boolean verificaridentificadordeautorizacion(String identificador) {
            try(FileReader fr = new FileReader(RUTA_ARCHIVO_EXAMENES);
            BufferedReader br = new BufferedReader(fr)){
        String linea;
        while((linea = br.readLine()) != null){
            String[] campos = linea.split(", ");
            if(campos.length >= 2){
                String identificadorActual = campos[2];
                String estadoDeAutorizacion = campos[7];
                
                if(identificadorActual.equals(identificador) &&
                   estadoDeAutorizacion.equalsIgnoreCase("examenPago")){
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
    
    public static boolean verificaridentificadordeatenciondeExamen(String identificador){
        try(FileReader fr = new FileReader(RUTA_ARCHIVO_EXAMENES);
       BufferedReader br = new BufferedReader(fr)){
        String linea;
        while((linea = br.readLine()) != null){
            String[] campos = linea.split(", ");
            if(campos.length >= 2){
                String identificadorActual = campos[3];
                String estadoDeAutorizacion = campos[8];
                
                if(identificadorActual.equals(identificador) &&
                   estadoDeAutorizacion.equalsIgnoreCase("Asistido")){
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
        
    //_________________________________________________________________________
    
    
        public static void eliminarAutorizacionDocumento1(String identificadorDeAutorizacion ) {
        String rutaArchivo = RUTA_SALA;
        String temporalArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/temporal.txt";

        try {
            FileReader lector = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(temporalArchivo);
            PrintWriter pw = new PrintWriter(escritor);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (!(campos[2].equals(identificadorDeAutorizacion) )) {
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
        String rutaArchivo = RUTA_ARCHIVO_EXAMENES;
        String temporalArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/temporal.txt";

        try {
            FileReader lector = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(temporalArchivo);
            PrintWriter pw = new PrintWriter(escritor);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (!(campos[2].equals(identificadorDeAutorizacion) )) {
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
   
        public static void eliminarAutorizacionDocumento3(String identificadorDeAutorizacion){
                    String rutaArchivo = RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES;
        String temporalArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/temporal.txt";

        try {
            FileReader lector = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(temporalArchivo);
            PrintWriter pw = new PrintWriter(escritor);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (!(campos[2].equals(identificadorDeAutorizacion) )) {
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
        
        
        public static boolean verificarExamenACancelar(
        String nombre, String apellido, String identificadorDeAutorizacion1, 
        String ticketExamen){
            
            try(FileReader fr = new FileReader(RUTA_ARCHIVO_EXAMENES);
                    BufferedReader br = new BufferedReader(fr)){
                    String linea;
                    while((linea = br.readLine())!= null){
                        String[] campos= linea.split(", ");
                        String nombreActual = campos[0];
                        String apellidoActual = campos[1];
                        String identificacionActual = campos[2];
                        String ticketActual = campos[3];
                        
                        
                        if(nombreActual.equals(nombre) &&
                           apellidoActual.equals(apellido) &&
                           identificacionActual.equals(identificadorDeAutorizacion1) &&
                           ticketActual.equals
                           (ticketExamen)){
                            return true;
                        }
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
                
                return false;
        }
        
                    public static void cancelarExamenDeUsuario(String
            identificadorDeAutorizacion){
                try{
                    FileReader fr = new FileReader(RUTA_ARCHIVO_EXAMENES);
                    BufferedReader br = new BufferedReader(fr);
                    
                    String linea;
                    StringBuilder nuevasLineas = new StringBuilder();
                    while((linea = br.readLine())!= null){
                        String [] campos = linea.split(", ");
                        String identificadorDeExamenActual=campos[2];
                        if(!identificadorDeExamenActual.equals
                        (identificadorDeAutorizacion)){
                            nuevasLineas.append(linea).append("\n");
                        }
                    }
                    br.close();
                    fr.close();
                    
                    FileWriter fw = new FileWriter(RUTA_ARCHIVO_EXAMENES);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.print(nuevasLineas);
                    pw.close();
                    fw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        
        
}
