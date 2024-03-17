package com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario;

import com.asistentemedico.asistentedecitas.logica.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorArchivo {
    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/usuarios.txt";
    
    public static boolean guardarUsuario(Usuario usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) {
            String usuarioStr = formatUsuario(usuario); // Formatear el usuario como una cadena
            writer.write(usuarioStr);
            writer.newLine();
            return true; // Indicar que el usuario se guardó correctamente
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de la excepción: imprimir la traza en caso de error
            return false; // Indicar que hubo un error al guardar el usuario
        }
    }

    private static String formatUsuario(Usuario usuario) {
        // Formato personalizado para escribir el usuario en el archivo
        StringBuilder sb = new StringBuilder();
        sb.append(usuario.getNombre()).append(", ");
        sb.append(usuario.getApellido()).append(", ");
        sb.append(usuario.getIdentificacion()).append(", ");
        sb.append(usuario.getEdad()).append(", ");
        sb.append(usuario.getTelefono()).append(", ");
        sb.append(usuario.getContrasenia());
        // No se incluye la contraseña por razones de seguridad
        return sb.toString();
    } 
}
