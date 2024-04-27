package Test.JUnit;

import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoParaSalaDeCitasAtencionMedica;
import com.asistentemedico.asistentedecitas.logica.Usuario;
import com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario.ManejadorArchivo;
import com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario.ValidadorUsuarioExistente;
import com.asistentemedico.asistentedecitas.persistencia.salasoperador.FlujoDeLasSalas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTest {
    
    private static final String RUTA_PRUEBA_ATENCION = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoAtencionDeCitas.txt";
    private static final String RUTA_PRUEBA = "src/test/resources/prueba_usuarios.txt";

    
    @Test
    public void testCargarFlujoDeSalaDeAtencion(){
        DoblementeEnlazada<EstadoParaSalaDeCitasAtencionMedica> flujo;
       
        flujo = FlujoDeLasSalas.cargarFlujoDeSalaDeAtencion(RUTA_PRUEBA_ATENCION);

        assertNotNull(flujo);
        assertFalse(flujo.estaVacia());
    }

    @Test
    public void testCambiarEstadoDeSalaDeAtencionMedicaAFlujoContinuo(){    
        String nombre = "Juan";
        String apellido = "Pérez";
        String identificacion = "12345";

        FlujoDeLasSalas.cambiarEstadoDeSalaDeAtencionMedicaAFlujoContinuo(nombre, apellido, identificacion);
    }
    
    @Test
    public void testCambiarEstadoDeSalaDeAtencionMedicaAFlujoDetenido() {
        String nombre = "Juan";
        String apellido = "Pérez";
        String identificacion = "12345";
        
        FlujoDeLasSalas.cambiarEstadoDeSalaDeAtencionMedicaAFlujoDetenido(nombre, apellido, identificacion);
    }
     
    @Test
    public void testUsuarioExiste_CuandoUsuarioExiste_DeberiaRetornarTrue() {
        Usuario usuarioExistente = new Usuario("Nombre", "Apellido", "12345", "", "", "");

        boolean resultado = ValidadorUsuarioExistente.usuarioExiste(usuarioExistente);

        assertTrue(resultado);
    }
    
    @Test
    public void testUsuarioExiste_CuandoUsuarioNoExiste_DeberiaRetornarFalse() {
        Usuario usuarioNoExistente = new Usuario("NombreNoExistente", "ApellidoNoExistente", "IDNoExistente", "", "", "");

        boolean resultado = ValidadorUsuarioExistente.usuarioExiste(usuarioNoExistente);

        assertFalse(resultado);
    }
    
    @Test
    public void testGuardarUsuario_DeberiaGuardarUsuarioCorrectamente() {
        Usuario usuario = new Usuario("Nombre", "Apellido", "ID", "Edad", "Telefono", "Contrasenia");

        boolean resultado = ManejadorArchivo.guardarUsuario(usuario);

        assertTrue(resultado);
        assertTrue(usuarioExisteEnArchivo(usuario));
    }

    @Test
    public void testGuardarUsuario_DeberiaRetornarFalseSiHuboError() {
        Usuario usuario = null; // Usuario inválido

        boolean resultado = ManejadorArchivo.guardarUsuario(usuario);

        assertFalse(resultado);
    }
    
    private boolean usuarioExisteEnArchivo(Usuario usuario) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_PRUEBA))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Usuario usuarioGuardado = parsearUsuario(linea);
                if (usuarioGuardado != null && usuario.getIdentificacion().equals(usuarioGuardado.getIdentificacion())) {
                    return true; // El usuario se encuentra en el archivo
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // El usuario no se encuentra en el archivo
    }
    
    private Usuario parsearUsuario(String linea) {
        String[] partes = linea.split(", ");
        if (partes.length == 6) {
            return new Usuario(partes[0], partes[1], partes[2], partes[3], partes[4], partes[5]);
        }
        return null;
    }
    
}
