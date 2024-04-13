package com.asistentemedico.asistentedecitas.persistencia.saladeespera;

import com.asistentemedico.asistentedecitas.logica.Cita.Cita;
import com.asistentemedico.asistentedecitas.logica.Cita.SalaDeCitas;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola.Cola;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada.Nodo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestordeSala {
    
    //SE EVITO EN SU TOTALIDAD USAR ARRAYLIST Y LIST Y CUALQUIER TIPO DE ARREGLO
    //O VECTOR O HASH MAP O OTRA ESTRUCTURA DE DATOS INTERNA DE JAVA 
    
    //colaAutorizaciones no sera final ya que no deseo que la instancia de está variable
    //sea estatica y final, no sera unica para todas las instancias ya que sera por asi 
    //decirlo modificada al entrar nuevos datos y demas en otras palabras
    //si usamos final no cambiara su referencia después de haber sido inicializada. y si
    //necesito cambiar sus referencias
    private static Cola<String> colaAutorizaciones = new Cola<>();
    private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt";
    private static final String RUTA_SALA_DE_ESPERA = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera.txt";
    

    //ORGANIZAMIENTO DE CODIGO
    
    public static DoblementeEnlazada<Cita> cargarCitasDesdeArchivo(String rutaArchivo) {
    DoblementeEnlazada<Cita> citas = new DoblementeEnlazada<>();
    //CARGAMOS CITAS DESDE ARCHIVO DESDE EL METODO CARGARCITASDESDEARCHIVO ESPERANDO UNA RUTA
    //IMPLEMENTANDO EL METODO DE OBTENERCAMPODE CADA UNA DE ESTAS VARIABLES Y HACIENDO UNA PARAMETRIZACION
    //O CASTEO DE DATOS OBTENIDOS CON BASE AL DOCUMENTO A LA CLASE CITA PARA PODER MANIPULARLOS
    try (FileReader fr = new FileReader(rutaArchivo);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String nombre = obtenerCampo(linea, 0);
            String apellido = obtenerCampo(linea, 1);
            String identificacion = obtenerCampo(linea, 2);
            String identificador = obtenerCampo(linea, 3);
            String ticket = obtenerCampo(linea, 4);
            String costo = obtenerCampo(linea, 5);
            String doctor = obtenerCampo(linea, 6);
            String estado = obtenerCampo(linea, 7);
            String especialidad = obtenerCampo(linea, 8);
            String asistencia = obtenerCampo(linea, 9);
            String motivo = obtenerCampo(linea, 10);

            // Crear una nueva cita con los datos de la línea y agregarla a la lista
            Cita cita = new Cita(nombre, apellido, identificacion, identificador, ticket, costo,
            doctor, estado, especialidad, asistencia, motivo);
            citas.agregarAlFinal(cita);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    

    return citas;
}
    
    private static String obtenerCampo(String linea, int indice){
        //OBTENEMOS EL CAMPO DE INICIO Y CONTADOR Y UN WHILE 
        //INICIAMOS LAS VARIABLES DE INICIO Y CONTADOR
        int inicio=0;
        int contador =0;
        //ITERAMOS SOBRE LA LINEA HASTA ALCANZAR EL INDICE DESEADO
        while(contador < indice){
            //BUSCAMOS LA PROXIMA OCURRENCIA DE ", " DESPUES DEL INDICE ACTUAL
            inicio = linea.indexOf(", " , inicio) +2;
            contador++;
        }
        //BUSCAMOS LA POSICION DEL PROXIMO DELIMITADOR DE CAMPO DESPUES DEL INICIO
        int fin = linea.indexOf(", ", inicio);
        if(fin == -1){
            fin = linea.length();
        }
        //SI NO ES ENCONTRADO NINGUN DELIMITADOR, USAMOS LA LONGITUD DE LA LINEA COMO FUN
        //EXTRAE EL CAMPO COMPRENDIDO ENTRE EL INICIO Y EL FINAL Y SE ELIMINAN LOS ESPACIOS EN BLANCO
        return linea.substring(inicio, fin).trim();
    }    
    
    public static boolean verificarCitaPaga(String identificadorCita, String ticketCita) {
    // Cargar las citas desde el archivo utilizando el método auxiliar
    DoblementeEnlazada<Cita> citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);

    // Verificar si la cita está pagada utilizando la lista de citas cargada
    Nodo<Cita> nodoActual = citas.getCabeza();
    while (nodoActual != null) {
        Cita citaActual = nodoActual.getValor();
        if (citaActual.getIdentificador().equals(identificadorCita) &&
                citaActual.getTicket().equals(ticketCita) &&
                citaActual.getEstado().equalsIgnoreCase("Paga")) {
            return true; // La cita está paga
        }
        nodoActual = nodoActual.getSiguiente();
    }
    return false; // No se encontró ninguna cita con las características especificadas
}

    public static boolean verificarAsistencia(String ticket){
        
        DoblementeEnlazada<Cita> citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);
        Nodo<Cita> nodoActual=citas.getCabeza();
        while(nodoActual != null){
            Cita citaActual = nodoActual.getValor();
            if(citaActual.getTicket().equals(ticket) && 
               citaActual.getAsistencia().equalsIgnoreCase("Asistida")){
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        
        return false;
    }
    
    //HASTA ESTÁ SECCION SE IMPLEMENTA CARGA DE CITAS DESDE ARCHIVO PARA VERIFICACION
    //DE ASISTENCIA Y PAGO

    //METODO PARA GUARDAR EN ARCHIVO
    public static void guardarEnSalaDeEspera(String nombreUsuario, String apellidoUsaurio,
    String identificacion, String identificadorCita, String ticketCita){
            //PASAMOS LOS PARAMETROS A UNA VARIABLE YA QUE GUARDAREMOS EN CADENA DE 
            //TIPO STRING
            String autorizacion = nombreUsuario + ", " + apellidoUsaurio + ", " + identificacion + ", " +
            identificadorCita + ", " + ticketCita;
            //GUARDAMOS DE ULTIMO YA QUE ES UNA COLA 
            colaAutorizaciones.enqueue(autorizacion);
            try{
            //Y LLAMAMOS EL METODO DE WRITETOFILE
            writeAutorizacionToFile(autorizacion);
            }catch(IOException e){
                
            }
            
        }
        
    private static DoblementeEnlazada<String> readAutorizacionesFromFile() throws IOException {
         DoblementeEnlazada<String> autorizaciones = new DoblementeEnlazada<>();
         //TRASAMOS LA RUTA DONDE DESEAMOS QUE SE ALMACENEN LOS DATOS HAY QUE ENTENDER 
         //QUE SE GUARDA UNA LINEA ENTERA DE STRINGS COMO SI FUERA UN NODO INDEPENDIENTE
         try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_SALA_DE_ESPERA))) {
         String line;
         while ((line = reader.readLine()) != null) {
            //PROCESA LA LINEA
            autorizaciones.agregarAlFinal(line);
        }
    }
    return autorizaciones;
}
         
    private static void writeAutorizacionToFile(String autorizacion) throws IOException {
    try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_ESPERA, true))) {
        writer.println(autorizacion);
        //LE PASAMOS LOS PARAMETROS Y GRABAMOS EN EL ARCHIVO DE TEXTO
    }
}
                 
    private static void writeAutorizacionesToFile2(DoblementeEnlazada<String> autorizaciones) throws IOException {
    //MUY DISTINTO ESTE METODO A WRITETOFILE YA QUE ESTE SOBRE ESCRIBIRA LOS DATOS ANTERIORES POR NUEVOS DATOS
    //CON BASE A LOS NODOS ACTUALIZADOS YA SEA PARA AGREGAR O ELIMINAR
    try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_ESPERA))) {
        DoblementeEnlazada.Nodo<String> nodoActual = autorizaciones.getCabeza();
        while (nodoActual != null) {
            writer.println(nodoActual.getValor());
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
                         
    public static void eliminarAutorizacionDeSala(){
            try{//INICIAMOS UNA VARIABLE DE autorizaciones CON BASE A UNA CADENA DE STRINGS
                //EN LA ESTRUCTURA DE DOBLEMENTE ENLAZADA PARA REUTILIZAR METODOS DE READ Y WRITE
                //ELIMINANDO SOLO DEL INICIO DE UNA FORMA SENCILLA PASANDO DATOS GENERICOS
                //Y ELIMINANDO LA LISTA INTERNA Y LUEGO ACTUALIZANDO Y SOBRE ESCRIBIENDO EL DOCUMENTO
                //CON LO QUE TENGAMOS ACTUALMENTE
                DoblementeEnlazada<String> autorizaciones =
                readAutorizacionesFromFile();
                autorizaciones.eliminarDelInicio();
                writeAutorizacionesToFile2(autorizaciones);

            }catch(IOException e){
                
            }
        }
          
    //HASTA ESTÁ SECCION SE IMPLEMENTO UNA PARAMETRIZACION DE LA CLASE DE LISTADOBLEMENTEENLAZADA
    //QUE ALMACENABA DATOS DE TIPO STRING FUNCIONAMIENTO PARA GUARDAR CAMBIOS DE ELIMINACION
    //DE INICIO Y GUARDADO DE CAMBIOS RECIENTE
    
    public static void eliminarDeSalaDelMedio(String ticket){
        try{
            DoblementeEnlazada<SalaDeCitas> citas = cargarDatosDesdeSala(RUTA_SALA_DE_ESPERA);
            citas.eliminarDelMedioPorTicket(ticket);
            writeCitasToFile(citas);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void writeCitasToFile(DoblementeEnlazada<SalaDeCitas> citas)throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_SALA_DE_ESPERA))){
            Nodo<SalaDeCitas> nodoActual = citas.getCabeza();
            while(nodoActual != null){
                SalaDeCitas cita = nodoActual.getValor();
                bw.write(cita.getNombre() + ", " + cita.getApellido() + ", " +
                cita.getIdentificacion() + ", " + cita.getIdentificadordecita() +
                ", " + cita.getTicketDeCita());
                bw.newLine();
                nodoActual = nodoActual.getSiguiente();
            }
        }
    }
    
    public static DoblementeEnlazada<SalaDeCitas> cargarDatosDesdeSala(String rutaArchivo){
    DoblementeEnlazada<SalaDeCitas> citas = new DoblementeEnlazada<>();

    try (FileReader fr = new FileReader(rutaArchivo);
        BufferedReader br = new BufferedReader(fr)) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String nombre = obtenerCampoSala(linea, 0);
            String apellido = obtenerCampoSala(linea, 1);
            String identificacion = obtenerCampoSala(linea, 2);
            String identificador = obtenerCampoSala(linea, 3);
            String ticket = obtenerCampoSala(linea, 4);

            // Crear una nueva cita con los datos de la línea y agregarla a la lista
            SalaDeCitas cita = new SalaDeCitas(nombre, apellido, identificacion, identificador, ticket);
            citas.agregarAlFinal(cita);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return citas;
    }
    
    private static String obtenerCampoSala(String linea, int indice){
    int inicio = 0;
    int contador = 0;
    while(contador < indice){
        inicio = linea.indexOf(", ", inicio) + 2;
        contador++;
    }
    int fin = linea.indexOf(", ", inicio);
    if(fin == -1){
        fin = linea.length();
    }
    return linea.substring(inicio, fin).trim();
    }
    
    //HASTA ESTA SECCION ELIMINA DEL MEDIO POR SI UN USUARIO ABANDONA LA COLA CON UNA LOGICA IMPLEMENTADA DISTINTA YA QUE SE NECESITAN CARGAR DATOS DESDE SALA
    //MAS NO DESDEARCHIVO
    
    //MARCAR CITA COMO ASISTIDA
    public static void moverAutorizaciones(String nombreUsuario, String apellidoUsuario, String identificacion, String ticket) {
        DoblementeEnlazada<Cita>  citas = cargarCitasDesdeArchivo(RUTA_ARCHIVO);
        //INICIALMENTE PARAMETRIZAMOS LOS DATOS LEIDOS LUEGO REESCRIBIMOS CON BASE AL TO.STRING
        //EN EL DOCUMENTO Y EL FUNCIONAMIENTO CONTINUA IGUAL, CLAVE DE ESTE PROYECTO EL ORDEN
        //Y ASIGNACION DE RESPONSABILIDADES Y TAREAS INDEPENDIENTES POR METODO SIN LA NECESIDAD DE INTERVENIR
        //O REUTILIZAR METODOS QUE SON EXCLUSIVOS PARA EL FUNCIONAMIENTO Y LECTURA DE DATOS INTERNOS
        Nodo<Cita> nodoActual = citas.getCabeza();
        while(nodoActual != null){
            Cita citaActual = nodoActual.getValor();
            if(citaActual.getNombre().equals(nombreUsuario) && 
               citaActual.getApellido().equals(apellidoUsuario) && 
               citaActual.getTicket().equals(ticket)){
                citaActual.setAsistencia("Asistida");
            }
            nodoActual = nodoActual.getSiguiente();   
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))){
            nodoActual = citas.getCabeza();
            while(nodoActual != null){
                Cita cita = nodoActual.getValor();
                writer.write(cita.toString() + "\n");
                nodoActual = nodoActual.getSiguiente();
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
} 
}
