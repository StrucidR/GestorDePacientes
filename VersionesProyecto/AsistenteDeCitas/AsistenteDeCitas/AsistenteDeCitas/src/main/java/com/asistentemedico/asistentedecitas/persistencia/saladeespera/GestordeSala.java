package com.asistentemedico.asistentedecitas.persistencia.saladeespera;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestordeSala {
    
    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt";

//______________________________________________________________________________
        public static boolean verificarDatosCita(String nombreUsuario, 
                String apellidoUsuario,String identificacion, 
                String identificadorCita,String ticketCita) {
            
        try (FileReader fr = new FileReader(RUTA_ARCHIVO);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) 
            {
                String[] campos = linea.split(", ");
                String nombreActual = campos[0];
                String apellidoActual = campos[1];
                String identificacionActual = campos[2];
                String identificadorActual = campos[3];
                String ticketActual = campos[4];

                if (nombreActual.equals(nombreUsuario) &&
                        apellidoActual.equals(apellidoUsuario) &&
                        identificacionActual.equals(identificacion) &&
                        identificadorActual.equals(identificadorCita) &&
                        ticketActual.equals(ticketCita)) {
                    return true; // Los datos de la cita coinciden
                }
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false; // Los datos de la cita no coinciden
    }
//______________________________________________________________________________
    public static boolean verificarCitaPaga(String identificadorCita) {
        try (FileReader fr = new FileReader(RUTA_ARCHIVO);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (campos.length >= 10) { // Verifica 
                    //que haya al menos 10 campos en la línea
                    String identificadorActual = campos[3];
                    String estadoPago = campos[7]; // Suponiendo que el 
                    //estado de pago está en la posición 7
                    if (identificadorActual.equals(identificadorCita)
                            && estadoPago.equals("Paga")) {
                        return true; // La cita está pagada
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // La cita no está pagada o no se encontró
    }
//______________________________________________________________________________
    public static void guardarUsuarioSalaEspera(String nombre, String apellido, String identificacion, String identificadorCita, String ticketCita) {
        // Verificar si el usuario ya está en la sala de espera
        if (!usuarioEnSalaEspera(nombre, apellido, identificacion, 
                identificadorCita, ticketCita)) {
            // Si el usuario no está en la sala de espera, guardar los datos
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(
                    "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera.txt", true))) {
                bw.write(nombre + ", " + apellido + ", " + identificacion + 
                        ", " + identificadorCita + ", " + ticketCita);
                bw.newLine(); // Agregar nueva línea para el próximo usuario
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//______________________________________________________________________________
    public static boolean usuarioEnSalaEspera(String nombre, String apellido, String identificacion, String identificadorCita, String ticketCita) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(", ");
                if (campos[0].equals(nombre) && 
                        campos[1].equals(apellido) && 
                        campos[2].equals(identificacion) &&
                    campos[3].equals(identificadorCita) && 
                        campos[4].equals(ticketCita)) {
                    return true; // Usuario encontrado en la sala de espera
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Usuario no encontrado en la sala de espera
    }
//______________________________________________________________________________
    public static void eliminarCitaSalaEspera(String nombre, String apellido, String identificacion, String ticketCita) {
    try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera.txt"))) {
        String linea;
        StringBuilder contenidoNuevo = new StringBuilder();
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            // Verificar si la línea actual corresponde a la cita a eliminar
            if (!(campos[0].equals(nombre) && 
                    campos[1].equals(apellido) && 
                    campos[2].equals(identificacion) && 
                    campos[4].equals(ticketCita))) {
                contenidoNuevo.append(linea).append("\n");
            }
        }

        // Escribir el nuevo contenido al archivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera.txt"))) {
            bw.write(contenidoNuevo.toString());
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}
//______________________________________________________________________________        
    public static boolean verificarEstadoCita(String identificadorCita, String estadoEsperado) {
    try (FileReader fr = new FileReader("src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt");
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 11) { // Verifica que haya al menos 11 campos en la línea
                String identificadorActual = campos[3];
                String estadoCita = campos[10]; // Suponiendo que el estado de la cita está en la posición 10
                if (identificadorActual.equals(identificadorCita) && 
                        estadoCita.equals(estadoEsperado)) {
                    return true; // El estado de la cita es el esperado
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false; // El estado de la cita no es el esperado o no se encontró
}
//______________________________________________________________________________
public static void moverCitaACitasTomadas(String nombreUsuario, String apellidoUsuario,
                                          String identificacion, String ticket) {
    // Crear un StringBuilder para almacenar las líneas actualizadas
    StringBuilder nuevasLineas = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] campos = linea.split(", ");
            if (campos.length >= 11 && campos[0].equals(nombreUsuario) &&
                    campos[1].equals(apellidoUsuario) && campos[2].equals(identificacion) &&
                    campos[4].equals(ticket)) {
                // Actualizar el estado de la cita
                campos[10] = "Asistida";
                linea = String.join(", ", campos);
            }
            // Agregar la línea actualizada al StringBuilder
            nuevasLineas.append(linea).append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Escribir las líneas actualizadas en el archivo
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))) {
        writer.write(nuevasLineas.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
