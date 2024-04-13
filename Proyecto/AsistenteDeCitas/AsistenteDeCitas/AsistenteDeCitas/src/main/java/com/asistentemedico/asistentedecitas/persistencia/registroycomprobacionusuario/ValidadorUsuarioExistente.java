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
    int primeraComa = linea.indexOf(',');
    int segundaComa = linea.indexOf(',', primeraComa+1);
    if(primeraComa != -1 && segundaComa != -1){
        String nombre = linea.substring(0, primeraComa).trim();
        String apellido = linea.substring(primeraComa +1 , segundaComa).trim();
        String identificacion = linea.substring(segundaComa+1).trim();
        
        return new Usuario(nombre, apellido, identificacion, "","","");
    }else{
        return null;
    }
}
}