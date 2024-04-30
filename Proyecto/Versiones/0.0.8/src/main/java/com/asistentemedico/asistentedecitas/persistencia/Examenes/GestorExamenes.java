package com.asistentemedico.asistentedecitas.persistencia.Examenes;

import com.asistentemedico.asistentedecitas.logica.Autorizacion.Autorizacion;
import com.asistentemedico.asistentedecitas.logica.Examen.ColaParaElPagoDeExamenes;
import com.asistentemedico.asistentedecitas.logica.Examen.Examen;
import com.asistentemedico.asistentedecitas.logica.Examen.SalaDeExamenes;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola.Cola;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada.DoblementeEnlazada.Nodo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorExamenes {
    
        private static Cola<String> colaAutorizaciones = new Cola<>(); 
        private static final String RUTA_ARCHIVO = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_autorizacion.txt";
        private static final String RUTA_ARCHIVO_EXAMENES = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/examenes.txt";
        private static final String RUTA_SALA = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_sala_examenes.txt";
        private static final String RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES="src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_atencion_examenes.txt";

        private static String obtenerCampo(String linea, int indice){
            int inicio = 0;
            int contador = 0;
            while(contador<indice){
                inicio=linea.indexOf(", ", inicio)+2;
                contador++;
            }
            int fin = linea.indexOf(", " , inicio);
            if(fin == -1){
                fin = linea.length();
            }
            return linea.substring(inicio, fin).trim();
        }
        
        //SECCION DE RUTA_ARCHIVO
        
        public static void writeAutorizacionesToFile(DoblementeEnlazada<Autorizacion> autorizaciones)throws IOException{
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO))){
                Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
                while(nodoActual != null){
                    Autorizacion autorizacion = nodoActual.getValor();
                    bw.write(autorizacion.getNombre()+", " + autorizacion.getApellido() +
                    ", " + autorizacion.getIdentificacion() + ", " + autorizacion.getIdentificadordelacita() + ", " +
                    autorizacion.getTicketdelacita() + ", " + autorizacion.getPrecio() + ", " +
                    autorizacion.getTipoExamen()+", "+autorizacion.getIdentificadordeautorizacion() + ", " +
                    autorizacion.getDescripcion() + ", " + autorizacion.getEstado() + ", " + autorizacion.getTicketDeAutorizacion());
                    bw.newLine();
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        
        public static DoblementeEnlazada<Autorizacion> cargarAutorizacionesDesdeArchivo(String rutaArchivo){
            DoblementeEnlazada<Autorizacion> autorizaciones = new DoblementeEnlazada<>();
            
            try(FileReader fr = new FileReader(rutaArchivo);
                BufferedReader br = new BufferedReader(fr)){
                String linea;
                
                while((linea = br.readLine()) != null){
                    String nombre = obtenerCampo(linea, 0);
                    String apellido = obtenerCampo(linea, 1);
                    String identificacion = obtenerCampo(linea, 2);
                    String identificadorDeCita = obtenerCampo(linea, 3);
                    String ticketDeCita = obtenerCampo(linea, 4);
                    String costo = obtenerCampo(linea, 5);
                    String tipoExamen = obtenerCampo(linea, 6);
                    String identificadorDeAutorizacion = obtenerCampo(linea, 7);
                    String descripcion = obtenerCampo(linea, 8);
                    String estado = obtenerCampo(linea, 9);
                    String ticketDeAutorizacion = obtenerCampo(linea, 10);
                    
                    Autorizacion autorizacion = new Autorizacion(nombre, apellido,
                    identificacion, identificadorDeCita, ticketDeCita, costo,
                    tipoExamen, identificadorDeAutorizacion, descripcion, 
                    estado, ticketDeAutorizacion);
                    autorizaciones.agregarAlFinal(autorizacion);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return autorizaciones;
        }
        
        public static DoblementeEnlazada<ColaParaElPagoDeExamenes> cargarAutorizacionesQueEstanEnSalaParaPago(String rutaArchivo){
            DoblementeEnlazada<ColaParaElPagoDeExamenes> examenes = new DoblementeEnlazada<>();
            try(FileReader fr = new FileReader(rutaArchivo);
                BufferedReader br = new BufferedReader(fr)){
                String linea;
                while((linea=br.readLine()) != null){
                    String nombre = obtenerCampo(linea, 0);
                    String apellido = obtenerCampo(linea, 1);
                    String identificaciondeexamen = obtenerCampo(linea, 2);
                    String ticketdeexamen = obtenerCampo(linea, 3);
                    
                    ColaParaElPagoDeExamenes examen = new ColaParaElPagoDeExamenes(nombre, apellido,
                    identificaciondeexamen, ticketdeexamen);
                    examenes.agregarAlFinal(examen);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return examenes;
        }
        //______________________________________________________________________
        
        //SECCION DE RUTA_ARCHIVO_EXAMENES
        
        public static void writeExamenesToFile(DoblementeEnlazada<Examen> examenes)throws IOException{
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_EXAMENES))){
                Nodo<Examen> nodoActual = examenes.getCabeza();
                while(nodoActual != null){
                    Examen examenespera = nodoActual.getValor();
                    bw.write(examenespera.getNombreUsuario() + ", "+
                    examenespera.getApellidoUsuario() + ", " +
                    examenespera.getIdentificacionDeExamen() + ", " +
                    examenespera.getTicketDeExamen() + ", " +
                    examenespera.getCosto() + ", " +
                    examenespera.getTipoExamen() + ", " +
                    examenespera.getDescripcion() + ", " +
                    examenespera.getEstadoDePago() + ", " +
                    examenespera.getAsistencia());
                    bw.newLine();
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        
        public static DoblementeEnlazada<Examen> cargarExamenesEnEspera(String rutaArchivo){
            DoblementeEnlazada<Examen> examenesenespera = new DoblementeEnlazada<>();
            try(FileReader fr = new FileReader(rutaArchivo);
                BufferedReader br = new BufferedReader(fr)){
                String linea;
                
                while((linea = br.readLine()) != null){
                    String nombre = obtenerCampo(linea, 0);
                    String apellido = obtenerCampo(linea, 1);
                    String identificadorDeExamen =obtenerCampo(linea, 2);
                    String ticketDeExamen =obtenerCampo(linea, 3);
                    String Costo =obtenerCampo(linea, 4);
                    String tipoExamen =obtenerCampo(linea, 5);
                    String descripcion =obtenerCampo(linea, 6);
                    String estadoDePago =obtenerCampo(linea, 7);
                    String asistencia = obtenerCampo(linea, 8);
                            
                    Examen examenes = new Examen(nombre, apellido,
                    identificadorDeExamen, ticketDeExamen, Costo, 
                    tipoExamen, descripcion, estadoDePago, asistencia);
                    examenesenespera.agregarAlFinal(examenes);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return examenesenespera;
        }
        
        //______________________________________________________________________
        
        public static void writeExamenEnSalaToFile(DoblementeEnlazada<ColaParaElPagoDeExamenes> colaParaElpago)throws IOException{
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_SALA))){
                Nodo<ColaParaElPagoDeExamenes> nodoActual = colaParaElpago.getCabeza();
                while(nodoActual != null){
                    ColaParaElPagoDeExamenes pagodeexamenes = nodoActual.getValor();
                    bw.write(pagodeexamenes.getNombreUsuario() + ", " + 
                    pagodeexamenes.getApellidoUsuario() + ", " +
                    pagodeexamenes.getIdentificacionDeExamen() + ", " +
                    pagodeexamenes.getTicketExamen());
                    bw.newLine();
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        
        public static DoblementeEnlazada<ColaParaElPagoDeExamenes> cargarSalaDePagoDeExamenes(String rutaArchivo){
            DoblementeEnlazada<ColaParaElPagoDeExamenes> examenesapagar = new DoblementeEnlazada<>();
            try(FileReader fr = new FileReader(rutaArchivo);
                BufferedReader br = new BufferedReader(fr)){
                String linea;
                
                while((linea = br.readLine()) != null){
                    String nombre = obtenerCampo(linea, 0);
                    String apellido = obtenerCampo(linea, 1);
                    String identificaciondeexamen = obtenerCampo(linea, 2);
                    String ticketdeexamen = obtenerCampo(linea, 3);
                    
                    ColaParaElPagoDeExamenes examenesparapago = new ColaParaElPagoDeExamenes(nombre,
                    apellido, identificaciondeexamen, ticketdeexamen);
                    examenesapagar.agregarAlFinal(examenesparapago);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return examenesapagar;
        }
        
        //______________________________________________________________________
        
        public static void writeExamenQueVaPasarASerAtendido(DoblementeEnlazada<SalaDeExamenes> colaparaatencion)throws IOException{
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES))){
                Nodo<SalaDeExamenes> nodoActual = colaparaatencion.getCabeza();
                while(nodoActual != null){
                    SalaDeExamenes atenciondeexamenes = nodoActual.getValor();
                    bw.write(atenciondeexamenes.getNombreUsuario() + ", " + 
                    atenciondeexamenes.getApellidoUsuario() + ", " +
                    atenciondeexamenes.getIdentificacionDeExamen() + ", " +
                    atenciondeexamenes.getTicketExamen());
                    bw.newLine();
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        
        public static DoblementeEnlazada<SalaDeExamenes> cargarExamenesQueVanAPasarASerAtendidos(String rutaArchivo){
            DoblementeEnlazada<SalaDeExamenes> examenesaseratendidos = new DoblementeEnlazada<>();
            try(FileReader fr = new FileReader(rutaArchivo);
                BufferedReader br = new BufferedReader(fr)){
                String linea;
                
                while((linea = br.readLine()) != null){
                    String nombre = obtenerCampo(linea, 0);
                    String apellido = obtenerCampo(linea, 1);
                    String identificaciondeexamen = obtenerCampo(linea, 2);
                    String ticketdeexamen = obtenerCampo(linea, 3);
                    
                    SalaDeExamenes examenesaatencion = new SalaDeExamenes(nombre,
                    apellido, identificaciondeexamen, ticketdeexamen);
                    examenesaseratendidos.agregarAlFinal(examenesaatencion);
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            return examenesaseratendidos;
        }
        
        //______________________________________________________________________
        
        //AUTORIZACIONES ESPERA_DE_AUTORIZACION RUTA ARCHIVO
        
        public static boolean verificarAutorizacion(String identificadordeAutorizacion,
        String ticketDeAutorizacion){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ARCHIVO);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual!= null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getIdentificadordeautorizacion().equals(identificadordeAutorizacion) &&
                   autorizacionActual.getTicketDeAutorizacion().equals(ticketDeAutorizacion) &&
                   autorizacionActual.getEstado().equalsIgnoreCase("AutorizacionExitosa")){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }
        
        public static String traerDescripcion(String nombreUsuario, 
        String apellidoUsuario, String identificacionUsuario, 
        String identificadorDeAutorizacion,String ticketDeAutorizacion){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ARCHIVO);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getNombre().equals(nombreUsuario) &&
                   autorizacionActual.getApellido().equals(apellidoUsuario) &&
                   autorizacionActual.getIdentificacion().equals(identificacionUsuario) &&
                   autorizacionActual.getIdentificadordeautorizacion().equals(identificadorDeAutorizacion) &&
                   autorizacionActual.getTicketDeAutorizacion().equals(ticketDeAutorizacion)){
                    return autorizacionActual.getDescripcion();
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return null;
        }
        
        public static String traerCosto(String nombreUsuario, 
        String apellidoUsuario, String identificadorDeAutorizacion, String ticketDeAutorizacion){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ARCHIVO);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getNombre().equals(nombreUsuario) &&
                   autorizacionActual.getApellido().equals(apellidoUsuario) &&
                   autorizacionActual.getIdentificadordeautorizacion().equals(identificadorDeAutorizacion) &&
                   autorizacionActual.getTicketDeAutorizacion().equals(ticketDeAutorizacion)){
                    return autorizacionActual.getPrecio();
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return null;
        }  
        
        public static String traerTipoExamen(String nombreUsuario,
        String apellidoUsuario, String identificacionUsuario, 
        String identificadorDeAutorizacion, String ticketDeAutorizacion){
            DoblementeEnlazada<Autorizacion> autorizaciones = cargarAutorizacionesDesdeArchivo(RUTA_ARCHIVO);
            Nodo<Autorizacion> nodoActual = autorizaciones.getCabeza();
            while(nodoActual != null){
                Autorizacion autorizacionActual = nodoActual.getValor();
                if(autorizacionActual.getNombre().equals(nombreUsuario) &&
                   autorizacionActual.getApellido().equals(apellidoUsuario) &&
                   autorizacionActual.getIdentificacion().equals(identificacionUsuario) &&
                   autorizacionActual.getIdentificadordeautorizacion().equals(identificadorDeAutorizacion) &&
                   autorizacionActual.getTicketDeAutorizacion().equals(ticketDeAutorizacion)){
                    return autorizacionActual.getTipoExamen();
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return null;
        }
        
        //______________________________________________________________________
        
        //EXAMENES RUTA_ARCHIVO_EXAMENES METODOS PARA EL FUNCIONAMIENTO Y MANEJO
        //DE USUARIOS Y SOLICITUDES

        public static void guardarAutorizacion(String nombre, String apellido, 
        String identificadordeAutorizacion, String ticketDeAutorizacion,
        String precio, String tipodeexamen, String descripcion){
            String rutaArchivo=RUTA_ARCHIVO_EXAMENES;
            try{
                FileWriter escritor = new FileWriter(rutaArchivo, true);
                escritor.write(nombre + ", " + apellido + ", " + identificadordeAutorizacion +
                ", " + ticketDeAutorizacion + ", " + precio + ", " + tipodeexamen + 
                ", " + descripcion + ", " + "examenNoPago" + ", " + "NoAsistido" +
                "\n");
                escritor.close();
            }catch(IOException e){
            }
        }
        
        public static boolean examenAgendado(String identificadorDeExamen,
        String ticketDeExamen){
            DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
            Nodo<Examen> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                Examen examenActual = nodoActual.getValor();
                if(examenActual.getIdentificacionDeExamen().equals(identificadorDeExamen) &&
                   examenActual.getTicketDeExamen().equals(ticketDeExamen) &&
                   examenActual.getEstadoDePago().equalsIgnoreCase("examenPago")){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }
        
        public static boolean examenYaAsistido(String identificadorDeExamen,
        String ticketDeExamen){
            DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
            Nodo<Examen> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                Examen examenActual = nodoActual.getValor();
                if(examenActual.getIdentificacionDeExamen().equals(identificadorDeExamen) &&
                   examenActual.getTicketDeExamen().equals(ticketDeExamen) &&
                   examenActual.getAsistencia().equalsIgnoreCase("Asistido")){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }
        
        public static void eliminarExamen(String identificadordeExamen, 
        String ticketdeExamen){
            try{
                DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
                examenes.eliminarDelMedioUnExamenEnEspera(identificadordeExamen,
                ticketdeExamen);
                writeExamenesToFile(examenes);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public static String traerCosto2(String nombreUsuario, String apellidoUsuario,
        String identificacionDeExamen, String ticketDeExamen){
            DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
            Nodo<Examen> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                Examen examenActual = nodoActual.getValor();
                if(examenActual.getNombreUsuario().equals(nombreUsuario) &&
                   examenActual.getApellidoUsuario().equals(apellidoUsuario) &&
                   examenActual.getIdentificacionDeExamen().equals(identificacionDeExamen) &&
                   examenActual.getTicketDeExamen().equals(ticketDeExamen)){
                    return examenActual.getCosto();
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return null;
        }
        
        public static void moverAutorizaciones(String nombreUsuario,
        String apellidoUsuario, String identificacion, String ticket){
            DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
            Nodo<Examen> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                Examen examenActual = nodoActual.getValor();
                if(examenActual.getNombreUsuario().equals(nombreUsuario) &&
                   examenActual.getApellidoUsuario().equals(apellidoUsuario) &&
                   examenActual.getIdentificacionDeExamen().equals(identificacion) &&
                   examenActual.getTicketDeExamen().equals(ticket)){
                    examenActual.setEstadoDePago("examenPago");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_EXAMENES))){
                nodoActual = examenes.getCabeza();
                while(nodoActual != null){
                    Examen examenesagrabar = nodoActual.getValor();
                    writer.write(examenesagrabar.toString() +"\n");
                    nodoActual = nodoActual.getSiguiente();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public static void moverExamenAsistido(String nombreUsuario, String apellidoUsuario,
        String identificaciondeExamen, String ticketdeExamen){
            DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
            Nodo<Examen> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                Examen examenActual = nodoActual.getValor();
                if(examenActual.getNombreUsuario().equals(nombreUsuario) &&
                   examenActual.getApellidoUsuario().equals(apellidoUsuario) &&
                   examenActual.getIdentificacionDeExamen().equals(identificaciondeExamen) &&
                   examenActual.getTicketDeExamen().equals(ticketdeExamen)){
                    examenActual.setAsistencia("Asistido");
                }
                nodoActual = nodoActual.getSiguiente();
            }
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_EXAMENES))){
                nodoActual = examenes.getCabeza();
                while(nodoActual != null){
                    Examen examenesagrabar = nodoActual.getValor();
                    writer.write(examenesagrabar.toString()+"\n");
                    nodoActual = nodoActual.getSiguiente();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public static boolean verificaridentificadordeautorizacion(String identificadordeexamen){
            DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
            Nodo<Examen> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                Examen examenActual = nodoActual.getValor();
                if(examenActual.getIdentificacionDeExamen().equals(identificadordeexamen) &&
                   examenActual.getEstadoDePago().equalsIgnoreCase("examenPago")){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }
        
        public static boolean verificaridentificadordeatenciondeExamen(String identificadordeexamen){
            DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
            Nodo<Examen> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                Examen examenActual = nodoActual.getValor();
                if(examenActual.getTicketDeExamen().equals(identificadordeexamen) &&
                   examenActual.getAsistencia().equalsIgnoreCase("Asistido")){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }
        
        public static void eliminarAutorizacionDocumento2(String identificadorDeAutorizacion){
            try{
                DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
                examenes.eliminarDelMedioUnExamenEnSala(identificadorDeAutorizacion);
                writeExamenesToFile(examenes);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public static boolean verificarExamenACancelar(String nombre,
        String apellido, String identificadorDeExamen, String ticketExamen){
            DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
            Nodo<Examen> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                Examen examenActual = nodoActual.getValor();
                if(examenActual.getNombreUsuario().equals(nombre) &&
                   examenActual.getApellidoUsuario().equals(apellido) &&
                   examenActual.getIdentificacionDeExamen().equals(identificadorDeExamen) &&
                   examenActual.getTicketDeExamen().equals(ticketExamen)){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }        
        
        public static void cancelarExamenDeUsuario(String identificadorDeAutorizacion){
            try{
                DoblementeEnlazada<Examen> examenes = cargarExamenesEnEspera(RUTA_ARCHIVO_EXAMENES);
                examenes.eliminarDelMedioUnExamenEnSala(identificadorDeAutorizacion);
                writeExamenesToFile(examenes);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public static boolean usuariOEnSala(String nombre, String apellido, String identificacion,
        String ticket){
            DoblementeEnlazada<SalaDeExamenes> citas = cargarExamenesQueVanAPasarASerAtendidos(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES);
            Nodo<SalaDeExamenes> nodoActual = citas.getCabeza();
            while(nodoActual != null){
                SalaDeExamenes citaActual = nodoActual.getValor();
                if(citaActual.getNombreUsuario().equals(nombre) &&
                   citaActual.getApellidoUsuario().equals(apellido) &&
                   citaActual.getIdentificacionDeExamen().equals(identificacion)&&
                   citaActual.getTicketExamen().equals(ticket)){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false; 
        }
        //_____________________________________________________________________
            
        public static void guardarEnSalaDeEspera(String nombre, String apellido,
        String identificadorDeExamen, String ticketDeExamenes){
            
        String autorizacion = nombre + ", " + apellido + ", " + 
        identificadorDeExamen + ", " + ticketDeExamenes;
        colaAutorizaciones.enqueue(autorizacion);
        try{
            writeAutorizacionToFile(autorizacion);
        }catch(IOException e){ 
            }
        }
        
        private static DoblementeEnlazada<String> readAutorizacionesFromFile() throws IOException {
        DoblementeEnlazada<String> autorizaciones = new DoblementeEnlazada<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_SALA))) {
        String line;
        while ((line = reader.readLine()) != null) {
        // Procesa la línea como desees, por ejemplo, imprimiéndola
        autorizaciones.agregarAlFinal(line);
            }
        }
        return autorizaciones;
        } 
               
        public static void eliminarAutorizacionDocumento1(String identificadorDeAutorizacion){
            try{
                DoblementeEnlazada<ColaParaElPagoDeExamenes> pago = cargarSalaDePagoDeExamenes(RUTA_SALA);
                pago.eliminarDelMedioDeSalaDePago(identificadorDeAutorizacion);
                writeExamenEnSalaToFile(pago);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        private static void writeAutorizacionToFile(String autorizacion) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA, true))) {
        writer.println(autorizacion);
           }
        }

        private static void writeAutorizacionesToFile2(DoblementeEnlazada<String> autorizaciones) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA))) {
        Nodo<String> nodoActual = autorizaciones.getCabeza();
        while (nodoActual != null) {
            writer.println(nodoActual.getValor());
            nodoActual = nodoActual.getSiguiente();
            }
          }
        }

        //______________________________________________________________________
        
        public static void eliminarAutorizacionDeSala(){
            try{
                DoblementeEnlazada<String> autorizaciones =
                readAutorizacionesFromFile();
                autorizaciones.eliminarDelInicio();
                writeAutorizacionesToFile2(autorizaciones);

            }catch(IOException e){
                
            }
        }

        public static void guardarEnSalaDeAtencionDeExamenes(String nombre, String apellido,
        String identificadorDeExamen, String ticketDeExamen){
        String autorizacion = nombre + ", " + apellido + ", " + identificadorDeExamen +
        ", " + ticketDeExamen;
            
        colaAutorizaciones.enqueue(autorizacion);
        try{
            writeExamenToFile(autorizacion);
        }catch(IOException e){
            }
        }
        
        private static DoblementeEnlazada<String> readExamenesSala() throws IOException{
        DoblementeEnlazada<String> autorizaciones = new DoblementeEnlazada<>();
            try(BufferedReader reader = new BufferedReader(new FileReader(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES))){
        String line;
        while((line = reader.readLine()) != null){
        autorizaciones.agregarAlFinal(line);
                }
            }
            return autorizaciones;
        }
        
        private static void writeExamenToFile(String autorizacion) throws IOException{
            try(PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES, true))){
                writer.println(autorizacion);
            }
        }
        
        private static void writeExamenToFile2(DoblementeEnlazada<String> autorizaciones) throws IOException{
            try(PrintWriter writer = new PrintWriter(new FileWriter(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES))){
                Nodo<String> nodoActual = autorizaciones.getCabeza();
                while(nodoActual != null){
                    writer.println(nodoActual.getValor());
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        }
        
        public static void eliminarExamenDeSala(){
            try{
                DoblementeEnlazada<String> autorizaciones =
                readExamenesSala();
                autorizaciones.eliminarDelInicio();
                writeExamenToFile2(autorizaciones);
            }catch(IOException e){ 
            }
        }
        
        public static void eliminarAutorizacionDocumento3(String identificadorDeAutorizacion){
            try{
                DoblementeEnlazada<SalaDeExamenes> sala = cargarExamenesQueVanAPasarASerAtendidos(RUTA_SALA_DE_ESPERA_ATENCION_EXAMENES);
                sala.eliminarDelMedioEnSalaDeAtencionDeExamenes(identificadorDeAutorizacion);
                writeExamenQueVaPasarASerAtendido(sala);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        //______________________________________________________________________
        public static boolean usuarioEnSala(String nombre,
        String apellido, String identificaciondeexamen, String ticketdeexamen){
            DoblementeEnlazada<ColaParaElPagoDeExamenes> examenes = cargarAutorizacionesQueEstanEnSalaParaPago(RUTA_SALA);
            Nodo<ColaParaElPagoDeExamenes> nodoActual = examenes.getCabeza();
            while(nodoActual != null){
                ColaParaElPagoDeExamenes citaActual = nodoActual.getValor();
                if(citaActual.getNombreUsuario().equals(nombre) &&
                   citaActual.getApellidoUsuario().equals(apellido) &&
                   citaActual.getIdentificacionDeExamen().equals(identificaciondeexamen) &&
                   citaActual.getTicketExamen().equals(ticketdeexamen)){
                    return true;
                }
                nodoActual = nodoActual.getSiguiente();
            }
            return false;
        }
}
