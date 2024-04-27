package com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario;

import com.asistentemedico.asistentedecitas.logica.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidadorUsuarioExistente {

    /**
     * Comprueba si un usuario ya existe en un archivo de registros.
     *
     * @param usuario El usuario a verificar.
     * @return true si el usuario existe en el archivo, false en caso contrario.
     */
    public static boolean usuarioExiste(Usuario usuario) {
    String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/usuarios.txt";

    try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            Usuario usuarioGuardado = parsearUsuario(linea);
            if (usuarioGuardado != null && usuario.getIdentificacion().equals(usuarioGuardado.getIdentificacion())) {
                return true; // El usuario ya existe en el archivo
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return false; // El usuario no existe en el archivo
}
    /**
     * Parsea una línea del archivo de registros a un objeto Usuario.
     *
     * @param linea La línea del archivo a parsear.
     * @return El objeto Usuario parseado o null si la línea no es válida.
     */
private static Usuario parsearUsuario(String linea) {
    int primeraComa = linea.indexOf(',');
    int segundaComa = linea.indexOf(',', primeraComa+1);
    if(primeraComa != -1 && segundaComa != -1){
        String nombre = linea.substring(0, primeraComa).trim();
        String apellido = linea.substring(primeraComa +1 , segundaComa).trim();
        String identificacion = linea.substring(segundaComa+1).trim();
        // Crear y devolver un nuevo objeto Usuario
        return new Usuario(nombre, apellido, identificacion, "","","");
    }else{
        return null;
    }
}
}