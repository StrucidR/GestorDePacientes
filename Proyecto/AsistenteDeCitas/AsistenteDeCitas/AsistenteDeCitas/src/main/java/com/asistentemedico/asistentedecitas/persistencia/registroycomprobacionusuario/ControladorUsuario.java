package com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario;

import com.asistentemedico.asistentedecitas.logica.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControladorUsuario {

    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/usuarios.txt";
    private static NodoUsuario ultimo;
    
        public static boolean validarInicioSesion(String nombre, String apellido, String identificacion, String contrasenia) {
        NodoUsuario actual = ultimo;
        if (actual == null) return false; // No hay usuarios cargados
        do {
            if (actual.getUsuario().getNombre().equalsIgnoreCase(nombre)
                && actual.getUsuario().getApellido().equalsIgnoreCase(apellido)
                && actual.getUsuario().getIdentificacion().equals(identificacion)
                && actual.getUsuario().getContrasenia().equals(contrasenia)) {
                return true; // Usuario encontrado, inicio de sesión exitoso
            }
            actual = actual.getSiguiente();
        } while (actual != ultimo);
        return false; // Usuario no encontrado, inicio de sesión fallido
    }

    private static void agregarUsuario(Usuario usuario) {
        NodoUsuario nuevo = new NodoUsuario(usuario);
        if (ultimo == null) {
            nuevo.setSiguiente(nuevo);
            ultimo = nuevo;
        } else {
            nuevo.setSiguiente(ultimo.getSiguiente());
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    public static void cargarUsuarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Usuario usuario = parsearUsuario(linea);
                if (usuario != null) {
                    agregarUsuario(usuario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Usuario parsearUsuario(String linea) {
        int primeraComa = linea.indexOf(',');
        int segundaComa = linea.indexOf(',' , primeraComa + 1);
        int terceraComa = linea.indexOf(',' , segundaComa + 1);
        int cuartaComa = linea.indexOf(',' , terceraComa + 1 );
        int quintaComa = linea.indexOf(',' , cuartaComa + 1 );

        if(primeraComa != -1 && segundaComa!= -1 && terceraComa !=-1
        && cuartaComa!=-1 && quintaComa != -1){
            
            String nombre = linea.substring(0, primeraComa).trim();
            String apellido = linea.substring(primeraComa + 1, segundaComa).trim();
            String identificacion = linea.substring(segundaComa+1, terceraComa).trim();
            String edad = linea.substring(terceraComa+1, cuartaComa).trim();
            String telefono = linea.substring(cuartaComa +1, quintaComa).trim();
            String contrasenia = linea.substring(quintaComa +1).trim();
            
            return new Usuario(nombre, apellido, identificacion, edad, telefono,
            contrasenia);
        }
        else{
        return null;
    }
    }
    
        static class NodoUsuario {
        private Usuario usuario;
        private NodoUsuario siguiente;

        NodoUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        Usuario getUsuario() {
            return usuario;
        }

        NodoUsuario getSiguiente() {
            return siguiente;
        }

        void setSiguiente(NodoUsuario siguiente) {
            this.siguiente = siguiente;
        }
    }
}
