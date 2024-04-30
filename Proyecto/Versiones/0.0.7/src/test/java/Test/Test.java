package Test;

import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoParaSalaDeCitasAtencionMedica;
import static com.asistentemedico.asistentedecitas.persistencia.salasoperador.FlujoDeLasSalas.cargarFlujoDeSalaDeAtencion;
import java.util.Iterator;

//PARA PROBAR LOS TEST QUITAR LOS COMENTARIOS  LAS //

public class Test {

    //public static void main(String[] args) {
        // Ruta del archivo a cargar
        String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoAtencionDeCitas.txt";

        // Llamada al método para cargar el flujo de sala de atención médica
        DoblementeEnlazada<EstadoParaSalaDeCitasAtencionMedica> estados = cargarFlujoDeSalaDeAtencion(rutaArchivo);

        // Imprimir el contenido de la lista de estados cargada desde el archivo
        //System.out.println("Estados cargados desde el archivo:");
        Iterator<EstadoParaSalaDeCitasAtencionMedica> iterator = estados.iterator();
        //while(iterator.hasNext()){
            EstadoParaSalaDeCitasAtencionMedica estado = iterator.next();
            //System.out.println(estado);
        //}
    //}
}
