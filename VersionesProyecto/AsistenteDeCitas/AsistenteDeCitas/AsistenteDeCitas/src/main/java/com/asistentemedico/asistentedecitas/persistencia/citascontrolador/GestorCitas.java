package com.asistentemedico.asistentedecitas.persistencia.citascontrolador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorCitas {

    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt";

    public static void guardarCita(String cita) {
        try (FileWriter fw = new FileWriter(RUTA_ARCHIVO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(cita);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarCita(String identificadorCita) {
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

    public static boolean verificarCita(String nombreUsuario, String apellidoUsuario,
                                         String identificacion, String identificadorCita,
                                         String ticketCita, String especialidad, String motivo) {
        try (FileReader fr = new FileReader(RUTA_ARCHIVO);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");

                String nombreActual = campos[0];
                String apellidoActual = campos[1];
                String identificacionActual = campos[2];
                String identificadorActual = campos[3];
                String ticketActual = campos[4];
                String especialidadActual = campos[8];
                String motivoActual = campos[9];

                if (nombreActual.equals(nombreUsuario) &&
                        apellidoActual.equals(apellidoUsuario) &&
                        identificacionActual.equals(identificacion) &&
                        identificadorActual.equals(identificadorCita) &&
                        ticketActual.equals(ticketCita) &&
                        especialidadActual.equals(especialidad) &&
                        motivoActual.equals(motivo)) {
                    return true; // La cita se encontró
                }
            }
        } catch (IOException e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
        return false; // La cita no se encontró
    }
    
    public static double obtenerValorCita(String identificadorCita) {
    try (FileReader fr = new FileReader(RUTA_ARCHIVO);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            String identificadorActual = campos[3];
            // El identificador de la cita está en la posición 3
            if (identificadorActual.equals(identificadorCita)) {
                // El valor de la cita está en la posición 5
                return Double.parseDouble(campos[5]);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return 0; // Si no se encuentra la cita, devuelve 0
}
    
    public static boolean verificarCitaPagada(String identificadorCita, String ticket) {
    try (FileReader fr = new FileReader(RUTA_ARCHIVO);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            String identificadorActual = campos[3]; // Suponiendo que el identificador de la cita está en la posición 3
            String ticketActual = campos[4];
            String estadoPago = campos[7]; // Suponiendo que el estado de pago está en la posición 6

            if (identificadorActual.equals(identificadorCita) &&
                    ticketActual.equals(ticket)
                    && estadoPago.equalsIgnoreCase("Paga")) {
                return true; // La cita está pagada
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false; // La cita no está pagada o no se encontró
}
    
    public static boolean verificarAsistenciaCita(String identificadorCita, 
            String ticket){
        try(FileReader fr = new FileReader(RUTA_ARCHIVO); 
                BufferedReader br = new BufferedReader(fr)){
            String linea;
            while((linea = br.readLine()) != null){
                String [] campos = linea.split(", ");
                String identificadorActual = campos[3];
                String ticketActual = campos[4];
                String estadoAsistido = campos[10];
                if(identificadorActual.equals(identificadorCita) &&
                        ticketActual.equals(ticket) && 
                        estadoAsistido.equalsIgnoreCase("Asistida")){
                    return true;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
                
                return false;
    }
    
    public static void marcarCitaComoPagada(String identificadorCita, String ticket) {
    try {
        FileReader fr = new FileReader(RUTA_ARCHIVO);
        BufferedReader br = new BufferedReader(fr);

        String linea;
        StringBuilder nuevasLineas = new StringBuilder();
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            String identificadorActual = campos[3];
            String ticketActual = campos[4];
            String estadoPago = campos[7]; // Suponiendo que el estado de pago está en la posición 7

            if (identificadorActual.equals(identificadorCita) && ticketActual.equals(ticket)) {
                // Cambia el estado de pago de "No Paga" a "Paga"
                campos[7] = "Paga";
            }
            // Reconstruye la línea con el estado de pago actualizado
            String nuevaLinea = String.join(", ", campos);
            nuevasLineas.append(nuevaLinea).append("\n");
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
    
    
    
}
