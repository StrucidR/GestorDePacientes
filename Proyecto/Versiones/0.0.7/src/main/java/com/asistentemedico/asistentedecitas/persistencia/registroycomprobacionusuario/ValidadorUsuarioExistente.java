package com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario;

import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada.Nodo;
import com.asistentemedico.asistentedecitas.logica.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidadorUsuarioExistente {

    private static final String RUTA_USUARIOS = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/usuarios.txt";
    
    /**
     * Comprueba si un usuario ya existe en un archivo de registros.
     *
     * @param identificacion El usuario a verificar.
     * @return true si el usuario existe en el archivo, false en caso contrario.
     */
public static boolean usuarioExiste(String identificacion) {
    DoblementeEnlazada<Usuario> usuarios = cargarCitasDesdeArchivo(RUTA_USUARIOS);
    Nodo<Usuario> nodoActual = usuarios.getCabeza();
    
    while(nodoActual != null){
        
        Usuario usuarioActual = nodoActual.getValor();
        
        if(usuarioActual.getIdentificacion().equals(identificacion)){
            return true;
        }
        
        
        nodoActual = nodoActual.getSiguiente();
    }
    
    return false;
}

        public static DoblementeEnlazada<Usuario>cargarCitasDesdeArchivo(String rutaArchivo){
        DoblementeEnlazada<Usuario> citas = new DoblementeEnlazada<>();
        
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            
            while((linea = br.readLine()) != null){
                String nombre = obtenerCampo(linea, 0);
                String apellido = obtenerCampo(linea, 1);
                String identificacion = obtenerCampo(linea, 2);
                String edad = obtenerCampo(linea, 3);
                String telefono = obtenerCampo(linea, 4);
                String contrasenia = obtenerCampo(linea, 5);
                
                Usuario cita = new Usuario(nombre, apellido, identificacion, edad,
                telefono, contrasenia);
                citas.agregarAlFinal(cita);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        return citas;
    }
    
private static String obtenerCampo(String linea, int indice) {
    int inicio = 0;
    int fin;
    int contador = 0;
    
    while (contador < indice) {
        inicio = linea.indexOf(", ", inicio);
        
        // Si no se encuentra la coma, significa que hemos llegado al final de la línea
        if (inicio == -1) {
            return ""; // Devolver una cadena vacía si el índice está fuera del rango
        }
        
        inicio += 2; // Avanzar más allá de la coma y el espacio
        contador++;
    }
    
    fin = linea.indexOf(", ", inicio);
    
    // Si no hay más comas después del campo actual, establecer fin al final de la línea
    if (fin == -1) {
        fin = linea.length();
    }
    
    return linea.substring(inicio, fin).trim();
}

}