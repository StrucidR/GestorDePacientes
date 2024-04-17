package com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Saladeespera;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita.cancelacion.cancelacionDeCitas;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita.visualizadordecitas.visualizarCitas;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesionExitoso;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.autorizacion.PrimeraEntradaAutorizacion;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import com.asistentemedico.asistentedecitas.logica.Cita.SalaDeCitas;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoParaSalaDeCitasAtencionMedica;
import com.asistentemedico.asistentedecitas.persistencia.saladeespera.GestordeSala;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class SalaDeEspera extends javax.swing.JFrame {
    
        private static final String RUTA_SALA_DE_ESPERA = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera.txt";
        private static final String RUTA_SALA_DE_ATENCION ="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoAtencionDeCitas.txt";
    
        private String nombreUsuario;
        private String apellidoUsaurio;
        private String identificacion;
        private String ticket;
        private Timer timer;
        private DefaultTableModel modeloTabla;

        private String nombreOperador = "";
        private String apellidoOperador = "";
        private String identificacionOperador = "";
        private String estadoOperador = "";
    public SalaDeEspera(String nombreUsuario,String apellidoUsaurio, 
        String identificacion, String ticket) {
        
        initComponents();
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsaurio=apellidoUsaurio;
        this.identificacion=identificacion;
        this.ticket=ticket;
        
        modeloTabla = new DefaultTableModel();        
        setModelo();

        ticketEntrada.setText(ticket);
        ticketEntrada.setEditable(false);
        
        mostradordeusuario.setText(nombreUsuario + " " + apellidoUsaurio);
        mostradordeusuario.setEditable(false);

        tabla.setModel(modeloTabla);
        iniciarTimerActualizacion();
        iniciarTemporizador();
    }
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Imagenlogo.png"));
        
        return retValue;
    }
    class Nodo{
        String dato;
        Nodo siguiente;
        Nodo(String dato){
            this.dato=dato;
            this.siguiente= null;
        }
    }
    
    private void setModelo(){
        Nodo cabecera= new Nodo("Nombre");
        cabecera.siguiente = new Nodo("Apellido(s)");
        cabecera.siguiente.siguiente = new Nodo("Ticket");
        
        setColumnIdentifiers(modeloTabla, cabecera);
        tabla.setModel(modeloTabla);
        tabla.setEnabled(false);
    }
    
    private void setColumnIdentifiers(DefaultTableModel modelo, Nodo cabecera){
        Nodo actual = cabecera;
        while(actual != null){
            modelo.addColumn(actual.dato);
            actual = actual.siguiente;
        }
    }
    
    private void iniciarTemporizador(){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(()->{
            saberEstado();
            if(estadoOperador.equals("Flujo Continuo")){
            moverPrimerCita();
            pasarAlFrameDeCitaAsistida();
            }
        }, 1, 2, TimeUnit.MINUTES);
    }
    
    private void saberEstado(){
        EstadoParaSalaDeCitasAtencionMedica estadodeAtencion =
        estado(RUTA_SALA_DE_ATENCION);
        if(estadodeAtencion != null){
            nombreOperador = estadodeAtencion.getNombre();
            apellidoOperador = estadodeAtencion.getApellido();
            identificacionOperador = estadodeAtencion.getIdentificacion();
            estadoOperador = estadodeAtencion.getEstadoDeFlujo();
        }
    }
    
    public static EstadoParaSalaDeCitasAtencionMedica estado(String rutaArchivo){
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            if((linea = br.readLine()) != null){
                String nombre1 = obtenerCampoOperador(linea, 0);
                String apellido1 = obtenerCampoOperador(linea, 1);
                String identificacion1 = obtenerCampoOperador(linea, 2);
                String estado1 = obtenerCampoOperador(linea, 3);
                
                return new EstadoParaSalaDeCitasAtencionMedica(nombre1,
                apellido1, identificacion1, estado1);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    private static String obtenerCampoOperador(String linea, int indice){
    int inicio = 0;
    int contador = 0;
    while (contador < indice) {
        inicio = linea.indexOf(", ", inicio) + 2;
        contador++;
    }
    int fin = linea.indexOf(", ", inicio);
    if (fin == -1) {
        fin = linea.length();
    }
    return linea.substring(inicio, fin).trim();
    }
    
    
    private void cargarDatosDesdeArchivo(){
        String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while((linea = br.readLine()) != null ){
                String [] campos = linea.split(", ");
                if(campos.length >= 2 ){
                    Object[] fila = {campos[0] , campos[1] , campos[4]};
                    modeloTabla.addRow(fila); //POR ESTE MOTIVO EN ESPECIFICO 
                    //FUE NECESARIO HACER ESTE UNICO METODO CON ARREGLOS
                    //PERO EL FUNCIONAMIENTO GENERAL DEL PROYECTO TIENE SUS PROPIAS ESTRUCTURAS
                    
                }
                else{  
                }
            }
        }catch(IOException e){  
        } 
    }
    
    private void actualizarTabla(){
        modeloTabla.setRowCount(0);
        cargarDatosDesdeArchivo();
    }
    
    private void iniciarTimerActualizacion(){
        int intervaloActualizacion = 2000;
        timer = new Timer(intervaloActualizacion, (e) -> {
            actualizarTabla();
        });
        timer.start();
    }
    
    private void moverPrimerCita(){
        SalaDeCitas primeraCita = obtenerPrimerCitaDesdeArchivo(RUTA_SALA_DE_ESPERA);
        if(primeraCita!= null){
            String nombre = primeraCita.getNombre();
            String apellido = primeraCita.getApellido();
            String identificacion1 = primeraCita.getIdentificacion();
            String ticket1 = primeraCita.getTicketDeCita();
            
            
            GestordeSala.moverAutorizaciones(nombre, 
apellido, identificacion1, ticket1);
            
            GestordeSala.eliminarAutorizacionDeSala(); 
        }
    }
    
    private boolean frameMostrado = false;
    private void pasarAlFrameDeCitaAsistida(){
        String identificador = ticketEntrada.getText();
        if(!frameMostrado){
            boolean pasoalotroframe = GestordeSala.verificarAsistencia
            (identificador);
            if(pasoalotroframe==true){
                CitaAtendidaConExito exit = new CitaAtendidaConExito(nombreUsuario,
                apellidoUsaurio,identificacion, identificador);
                this.dispose();
                exit.setVisible(true);
                exit.setLocationRelativeTo(null);
                exit.setResizable(false);
                
                frameMostrado=true;
            }
        }
    }
    
public static SalaDeCitas obtenerPrimerCitaDesdeArchivo(String rutaArchivo) {
    try (FileReader fr = new FileReader(rutaArchivo);
         BufferedReader br = new BufferedReader(fr)) {
        String linea;
        if ((linea = br.readLine()) != null) {
            String nombre = obtenerCampo(linea, 0);
            String apellido = obtenerCampo(linea, 1);
            String identificacion = obtenerCampo(linea, 2);
            String identificadorCita = obtenerCampo(linea, 3);
            String ticket = obtenerCampo(linea, 4);

            // Crear una nueva sala de citas con los datos de la línea y devolverla
            return new SalaDeCitas(nombre, apellido, identificacion, identificadorCita, ticket);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}

private static String obtenerCampo(String linea, int indice) {
    int inicio = 0;
    int contador = 0;
    while (contador < indice) {
        inicio = linea.indexOf(", ", inicio) + 2;
        contador++;
    }
    int fin = linea.indexOf(", ", inicio);
    if (fin == -1) {
        fin = linea.length();
    }
    return linea.substring(inicio, fin).trim();
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lobbyboton = new javax.swing.JButton();
        IniciarSesionboton = new javax.swing.JButton();
        Autorizacionboton = new javax.swing.JButton();
        PagoDeCitasboton = new javax.swing.JButton();
        PagoDeCitasboton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sobreNosotros1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        DoctorFree2 = new javax.swing.JLabel();
        ticketEntrada = new javax.swing.JTextField();
        VisualizarCita = new javax.swing.JButton();
        mostradordeusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CancelarCita = new javax.swing.JButton();
        salirDeCola = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));

        lobbyboton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lobbyboton.setForeground(new java.awt.Color(102, 102, 102));
        lobbyboton.setText("Registrarse");
        lobbyboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lobbybotonActionPerformed(evt);
            }
        });

        IniciarSesionboton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IniciarSesionboton.setForeground(new java.awt.Color(102, 102, 102));
        IniciarSesionboton.setText("Lobby");
        IniciarSesionboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionbotonActionPerformed(evt);
            }
        });

        Autorizacionboton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Autorizacionboton.setForeground(new java.awt.Color(102, 102, 102));
        Autorizacionboton.setText("Autorización");
        Autorizacionboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutorizacionbotonActionPerformed(evt);
            }
        });

        PagoDeCitasboton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PagoDeCitasboton.setForeground(new java.awt.Color(102, 102, 102));
        PagoDeCitasboton.setText("Pago de Citas");
        PagoDeCitasboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoDeCitasbotonActionPerformed(evt);
            }
        });

        PagoDeCitasboton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        PagoDeCitasboton1.setForeground(new java.awt.Color(102, 102, 102));
        PagoDeCitasboton1.setText("Exámenes");
        PagoDeCitasboton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoDeCitasboton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Asistente de Citas Médicas");

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PagoDeCitasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PagoDeCitasboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Autorizacionboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IniciarSesionboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lobbyboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lobbyboton)
                        .addComponent(IniciarSesionboton)
                        .addComponent(Autorizacionboton)
                        .addComponent(PagoDeCitasboton)
                        .addComponent(PagoDeCitasboton1))
                    .addComponent(jLabel3)))
        );

        jPanel3.setBackground(new java.awt.Color(229, 229, 229));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Email: asistentedecitasmedicas@gmail.com");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Derechos de autor © 2024 AsistenteDeCitasSA. Todos los derechos reservados. Prohibida la reproducción total o parcial de este sitio , incluidos textos, imágenes y diseño, sin la autorización previa por escrito de AsistenteDeCitasMedicasSA.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        sobreNosotros1.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        sobreNosotros1.setForeground(new java.awt.Color(0, 102, 153));
        sobreNosotros1.setText("SALA DE ESPERA");

        tabla.setFont(new java.awt.Font("Segoe UI Variable", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        DoctorFree2.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        DoctorFree2.setForeground(new java.awt.Color(0, 102, 153));
        DoctorFree2.setText("Tu Ticket");

        ticketEntrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ticketEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketEntradaActionPerformed(evt);
            }
        });

        VisualizarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VisualizarCita.setForeground(new java.awt.Color(102, 102, 102));
        VisualizarCita.setText("Visualizar Citas");
        VisualizarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarCitaActionPerformed(evt);
            }
        });

        mostradordeusuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mostradordeusuario.setForeground(new java.awt.Color(0, 102, 102));
        mostradordeusuario.setCaretColor(new java.awt.Color(255, 255, 255));
        mostradordeusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostradordeusuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Espacio de ");

        CancelarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelarCita.setForeground(new java.awt.Color(102, 102, 102));
        CancelarCita.setText("Cancelar Cita");
        CancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarCitaActionPerformed(evt);
            }
        });

        salirDeCola.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salirDeCola.setForeground(new java.awt.Color(102, 102, 102));
        salirDeCola.setText("Salir de cola");
        salirDeCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirDeColaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ten en cuenta que si sales de la cola perderás tu posición");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 153));
        jButton2.setText("Inicio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 153));
        jButton1.setText("Agendar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sobreNosotros1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DoctorFree2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ticketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(CancelarCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(VisualizarCita, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(mostradordeusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(salirDeCola)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(7, 7, 7)
                        .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(CancelarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VisualizarCita))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sobreNosotros1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DoctorFree2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ticketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salirDeCola)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lobbybotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lobbybotonActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        this.dispose();
        Registro regis= new Registro();
        regis.setVisible(true);
        regis.setLocationRelativeTo(null);
        regis.setResizable(false);
    }//GEN-LAST:event_lobbybotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        this.dispose();
        Principal princ=new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);;
        this.dispose();
        PrimeraEntradaAutorizacion prim = new PrimeraEntradaAutorizacion();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void PagoDeCitasbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasbotonActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        this.dispose();
        pagodeCitasPrimeraEntrada prim = new pagodeCitasPrimeraEntrada();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasbotonActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        this.dispose();
        EntradadeExamenes prim = new EntradadeExamenes();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasboton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        InicioDeSesionExitoso agend= new InicioDeSesionExitoso(nombreUsuario,
      apellidoUsaurio, identificacion);
        this.dispose();
        agend.setVisible(true);
        agend.setLocationRelativeTo(null);
        agend.setResizable(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        this.dispose();
        InicioDeSesionExitoso inic = new InicioDeSesionExitoso(nombreUsuario,
       apellidoUsaurio, identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void VisualizarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarCitaActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        this.dispose();
        visualizarCitas view=new visualizarCitas(nombreUsuario, 
        apellidoUsaurio,identificacion);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setResizable(false);
    }//GEN-LAST:event_VisualizarCitaActionPerformed

    private void mostradordeusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostradordeusuarioActionPerformed
       
    }//GEN-LAST:event_mostradordeusuarioActionPerformed

    private void CancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarCitaActionPerformed
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        cancelacionDeCitas cancel=new cancelacionDeCitas(nombreUsuario,
        apellidoUsaurio, identificacion
        );
        cancel.setVisible(true);
        cancel.setLocationRelativeTo(null);
        cancel.setResizable(false);
    }//GEN-LAST:event_CancelarCitaActionPerformed

    private void ticketEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketEntradaActionPerformed
        
    }//GEN-LAST:event_ticketEntradaActionPerformed

    private void salirDeColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirDeColaActionPerformed
        this.dispose();
        String ticketAEliminarDeSala = ticketEntrada.getText();
        GestordeSala.eliminarDeSalaDelMedio(ticketAEliminarDeSala);
        EntradadePasarASalaDeEspera entr = new EntradadePasarASalaDeEspera
        (nombreUsuario,
        apellidoUsaurio, identificacion);
        entr.setVisible(true);
        entr.setLocationRelativeTo(null);
        entr.setResizable(false);  
    }//GEN-LAST:event_salirDeColaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JButton CancelarCita;
    private javax.swing.JLabel DoctorFree2;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JButton VisualizarCita;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lobbyboton;
    private javax.swing.JTextField mostradordeusuario;
    private javax.swing.JButton salirDeCola;
    private javax.swing.JLabel sobreNosotros1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField ticketEntrada;
    // End of variables declaration//GEN-END:variables
}
