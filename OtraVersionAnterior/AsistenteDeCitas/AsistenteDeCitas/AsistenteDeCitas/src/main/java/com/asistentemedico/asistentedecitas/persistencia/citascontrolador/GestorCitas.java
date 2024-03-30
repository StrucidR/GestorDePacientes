package com.asistentemedico.asistentedecitas.persistencia.citascontrolador;

import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola.Cola;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorCitas {

    private static Cola<String> colaAutorizaciones = new Cola<>(); 
    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt";
    private static final String RUTA_SALA_DE_PAGOS = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/cola_de_pagos.txt";

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
                String motivoActual = campos[10];

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
                String estadoAsistido = campos[9];
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
    
    public static void marcarCitaComoPagada(String ticket) {
        StringBuilder nuevasLineas = new StringBuilder();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))){
            String linea;
            while((linea = reader.readLine()) != null ){
                String [] campos = linea.split(", ");
                if(campos.length >=3 && campos[4].equals(ticket)){
                    campos[7] ="Paga";
                    linea = String.join(", ", campos);
                }
                nuevasLineas.append(linea).append("\n");
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))){
            writer.write(nuevasLineas.toString().trim());
        }catch(IOException e){
            e.printStackTrace();
        }
}
    
    
    public static void guardarEnSalaDePagos(String nombre, String apellido, String identificacion,
    String ticket){
        
            String autorizacion = nombre + ", " + apellido + ", " + identificacion + ", " +
                          ticket;
            
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

    public static boolean verificaridentificadordeautorizacion(String identificador) {
                    try(FileReader fr = new FileReader(RUTA_ARCHIVO);
            BufferedReader br = new BufferedReader(fr)){
        String linea;
        while((linea = br.readLine()) != null){
            String[] campos = linea.split(", ");
            if(campos.length >= 2){
                String identificadorActual = campos[4];
                String estadoDeAutorizacion = campos[7];
                
                if(identificadorActual.equals(identificador) &&
                   estadoDeAutorizacion.equalsIgnoreCase("Paga")){
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
    
    
    
}
