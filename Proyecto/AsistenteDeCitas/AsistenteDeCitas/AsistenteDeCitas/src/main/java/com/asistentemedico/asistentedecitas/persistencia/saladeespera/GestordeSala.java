package com.asistentemedico.asistentedecitas.persistencia.saladeespera;

import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola.Cola;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestordeSala {
    
    private static Cola<String> colaAutorizaciones = new Cola<>();
    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt";
    private static final String RUTA_SALA_DE_ESPERA = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera.txt";
    
    public static boolean verificarCitaPaga(String identificadorCita,
    String ticketCita){
                       try (FileReader fr = new FileReader(RUTA_ARCHIVO);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 4) { // Asegurarse de que haya al menos 10 campos en la línea
                String identificadorActual = campos[3];
                String ticketActual = campos[4];
                String estadoDeAutorizacion = campos[7]; // Suponiendo que el estado de pago está en la posición 9

                if (identificadorActual.equals(identificadorCita) &&
                        ticketActual.equals(ticketCita)
                        && estadoDeAutorizacion.equalsIgnoreCase("Paga")) {
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
    
        public static boolean verificarAsistencia(String identificadorCita){
                       try (FileReader fr = new FileReader(RUTA_ARCHIVO);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 3) { // Asegurarse de que haya al menos 10 campos en la línea
                String identificadorActual = campos[4];
                String estadoDeAutorizacion = campos[9]; // Suponiendo que el estado de pago está en la posición 9

                if (identificadorActual.equals(identificadorCita)
                        && estadoDeAutorizacion.equalsIgnoreCase("Asistida")) {
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
    
        
        public static void guardarEnSalaDeEspera(String nombreUsuario, String apellidoUsaurio,
            String identificacion, String identificadorCita, String ticketCita){
            
            String autorizacion = nombreUsuario + ", " + apellidoUsaurio + ", " + identificacion + ", " +
            identificadorCita + ", " + ticketCita;
            
            colaAutorizaciones.enqueue(autorizacion);
            try{
            writeAutorizacionToFile(autorizacion);
            }catch(IOException e){
                
            }
            
        }
        
         private static DoblementeEnlazada<String> readAutorizacionesFromFile() throws IOException {
         DoblementeEnlazada<String> autorizaciones = new DoblementeEnlazada<>();
         try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_SALA_DE_ESPERA))) {
         String line;
         while ((line = reader.readLine()) != null) {
            // Procesa la línea como desees, por ejemplo, imprimiéndola
            autorizaciones.agregarAlFinal(line);
        }
    }
    return autorizaciones;
}
         
                 private static void writeAutorizacionToFile(String autorizacion) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_ESPERA, true))) {
        writer.println(autorizacion);
    }
}
                 
                         private static void writeAutorizacionesToFile2(DoblementeEnlazada<String> autorizaciones) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_ESPERA))) {
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
                
                                 
        public static void moverAutorizaciones(String nombreUsuario, String apellidoUsuario, String identificacion, String ticket) {
    StringBuilder nuevasLineas = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 5 && campos[0].equals(nombreUsuario)
                    && campos[1].equals(apellidoUsuario) && campos[2].equals(identificacion)
                    && campos[4].equals(ticket)) {
                campos[9] = "Asistida";
                linea = String.join(", ", campos);
            }
            nuevasLineas.append(linea).append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
        writer.write(nuevasLineas.toString().trim()); // Eliminar espacio en blanco al final
    } catch (IOException e) {
        e.printStackTrace();
    }
}

        
        
    public static void eliminarCitaSalaEspera(String nombreUsuario, String apellidoUsaurio, String identificacion, String ticket) {
                String rutaArchivo = RUTA_SALA_DE_ESPERA;
        String temporalArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/temporal.txt";

        try {
            FileReader lector = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(lector);

            FileWriter escritor = new FileWriter(temporalArchivo);
            PrintWriter pw = new PrintWriter(escritor);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (!(campos[4].equals(ticket) )) {
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
                
        
}
