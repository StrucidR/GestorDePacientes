package com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario;

import com.asistentemedico.asistentedecitas.logica.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidadorUsuarioExistente {

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

private static Usuario parsearUsuario(String linea) {
    String[] partes = linea.split(",");
    if (partes.length >= 3) {
        String identificacion = partes[2].trim(); // La identificación es la tercera parte, eliminamos espacios en blanco alrededor
        return new Usuario("", "", identificacion, "", "", ""); // Creamos un usuario solo con la identificación
    } else {
        // Manejar el caso de que la línea no tenga el formato esperado
        // Por ejemplo, podrías lanzar una excepción o devolver un usuario inválido
        return null;
    }
}
}