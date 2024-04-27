package com.asistentemedico.asistentedecitas.igu.examenes.saladeespera;

import com.asistentemedico.asistentedecitas.igu.examenes.*;
import com.asistentemedico.asistentedecitas.igu.Principal.*;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import static com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Saladeespera.SalaDeEspera.estado;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.autorizacion.PrimeraEntradaAutorizacion;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import com.asistentemedico.asistentedecitas.logica.Examen.SalaDeExamenes;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoDeFlujoParaAtencionDeExamenes;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoParaSalaDeCitasAtencionMedica;
import com.asistentemedico.asistentedecitas.persistencia.Examenes.GestorExamenes;
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

public class EntradadeSaladeEsperaexamenes extends javax.swing.JFrame {
    
    private static final String RUTA_SALA_DE_ATENCION_EXAMENES = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_atencion_examenes.txt";
    private static final String RUTA_SALA_DE_ATENCION ="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoAtencionDeExamenes.txt";
    
    private String ticketAutorizacion;
    
    private Timer timer;
    private Timer timer2;
    
    private DefaultTableModel modeloTabla;
    
    private String nombreOperador = "";
    private String apellidoOperador = "";
    private String identificacionOperador = "";
    private String estadoOperador = "";
    public EntradadeSaladeEsperaexamenes(String ticketAutorizacion) {
        
        initComponents();
        this.ticketAutorizacion=ticketAutorizacion;
        ticketEntrada.setText(ticketAutorizacion);
        ticketEntrada.setEditable(false);
        
        modeloTabla = new DefaultTableModel();
        setModelo();
        
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
        cabecera.siguiente.siguiente = new Nodo("Ticket.Examen");
        
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
            moverPrimerExamen();
            pasarAlFramedeExamenAtendido();
            }
        }, 1, 2, TimeUnit.MINUTES);
    }
    
    private void saberEstado(){
        EstadoDeFlujoParaAtencionDeExamenes estadodeAtencion =
        estado(RUTA_SALA_DE_ATENCION);
        if(estadodeAtencion != null){
            nombreOperador = estadodeAtencion.getNombre();
            apellidoOperador = estadodeAtencion.getApellido();
            identificacionOperador = estadodeAtencion.getIdentificacion();
            estadoOperador = estadodeAtencion.getEstadoDeFlujo();
        }
    }
    
    public static EstadoDeFlujoParaAtencionDeExamenes estado(String rutaArchivo){
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            if((linea = br.readLine()) != null){
                String nombre1 = obtenerCampoOperador(linea, 0);
                String apellido1 = obtenerCampoOperador(linea, 1);
                String identificacion1 = obtenerCampoOperador(linea, 2);
                String estado1 = obtenerCampoOperador(linea, 3);
                
                return new EstadoDeFlujoParaAtencionDeExamenes(nombre1,
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
        String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_atencion_examenes.txt";
        
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            
            while((linea = br.readLine()) != null ){
                String [] campos = linea.split(", ");
                if(campos.length >= 2 ){
                    Object[] fila = {campos[0] , campos[1] , campos[3]};
                    modeloTabla.addRow(fila);
                }else{
                    
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
        timer = new Timer(intervaloActualizacion , (e) ->{
           actualizarTabla();
        });
        
        timer.start();
    }
    
    private void moverPrimerExamen(){
        SalaDeExamenes primeraCita = obtenerPrimerExamenDesdeArchivo(RUTA_SALA_DE_ATENCION_EXAMENES);
        
        if(primeraCita!= null){
            String nombre = primeraCita.getNombreUsuario();
            String apellido = primeraCita.getApellidoUsuario();
            String identificacionDeExamen = primeraCita.getIdentificacionDeExamen();
            String ticketDeExamen = primeraCita.getTicketExamen();
            
            GestorExamenes.moverExamenAsistido(nombre, 
apellido, identificacionDeExamen, ticketDeExamen);
            
            GestorExamenes.eliminarExamenDeSala();
            
        }   
    }
    
       
    
    private boolean frameMostrado = false;
    private void pasarAlFramedeExamenAtendido(){
        String identificador = ticketEntrada.getText();
        
        if(!frameMostrado){
            boolean pasoalotroframe = GestorExamenes.verificaridentificadordeatenciondeExamen(identificador);
        
        if(pasoalotroframe == true){
            ExamenAtendidoConExito exit = new ExamenAtendidoConExito(identificador);
            this.dispose();
            exit.setVisible(true);
            exit.setLocationRelativeTo(null);
            exit.setResizable(false);

            frameMostrado=true;
        }
        
        }
    }
    
    
    public static SalaDeExamenes obtenerPrimerExamenDesdeArchivo(String rutaArchivo){
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            if((linea = br.readLine()) != null){
                String nombre=obtenerCampo(linea, 0);
                String apellido = obtenerCampo(linea, 1);
                String identificadorDeExamen = obtenerCampo(linea, 2);
                String ticketExamen = obtenerCampo(linea, 3);
                
                return new SalaDeExamenes(nombre,apellido,identificadorDeExamen,ticketExamen); 
            }
            
        }catch(IOException e){
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
        Registrarseboton = new javax.swing.JButton();
        IniciarSesionboton = new javax.swing.JButton();
        Autorizacionboton = new javax.swing.JButton();
        PagoDeCitasboton = new javax.swing.JButton();
        PagoDeCitasboton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        AgendarBoton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ticketEntrada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        Registrarseboton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Registrarseboton.setForeground(new java.awt.Color(102, 102, 102));
        Registrarseboton.setText("Registrarse");
        Registrarseboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarsebotonActionPerformed(evt);
            }
        });

        IniciarSesionboton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IniciarSesionboton.setForeground(new java.awt.Color(102, 102, 102));
        IniciarSesionboton.setText("Iniciar Sesión");
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
        PagoDeCitasboton1.setText("Lobby");
        PagoDeCitasboton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoDeCitasboton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Asistente de Citas Médicas");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(Registrarseboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(11, 11, 11))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Registrarseboton)
                        .addComponent(IniciarSesionboton)
                        .addComponent(Autorizacionboton)
                        .addComponent(PagoDeCitasboton)
                        .addComponent(PagoDeCitasboton1))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(229, 229, 229));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Email: asistentedecitasmedicas@gmail.com");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 8)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Derechos de autor © 2024 AsistenteDeCitasSA. Todos los derechos reservados. Prohibida la reproducción total o parcial de este sitio web, incluidos textos, imágenes y diseño, sin la autorización previa por escrito de AsistenteDeCitasMedicasSA.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
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

        AgendarBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AgendarBoton.setForeground(new java.awt.Color(0, 102, 153));
        AgendarBoton.setText("Volver");
        AgendarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendarBotonActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("BIENVENIDO A LA SALA DE ESPERA");

        ticketEntrada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Su ticket es");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Por favor permanezca en sala y no salga si desea ser atendido ya que si sale perdera");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("su turno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ticketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(AgendarBoton))
                .addGap(0, 171, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ticketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendarBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarsebotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarsebotonActionPerformed
        String ticket = ticketEntrada.getText();
        GestorExamenes.eliminarAutorizacionDocumento3(ticket);
        this.dispose();
        Registro ventanaRegistro= new Registro();
        ventanaRegistro.setVisible(true);
        ventanaRegistro.setLocationRelativeTo(null);
        ventanaRegistro.setResizable(false);
    }//GEN-LAST:event_RegistrarsebotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
        String ticket = ticketEntrada.getText();
        GestorExamenes.eliminarAutorizacionDocumento3(ticket);
        this.dispose();
        InicioDeSesion inc= new InicioDeSesion();
        inc.setVisible(true);
        inc.setLocationRelativeTo(null);
        inc.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        String ticket = ticketEntrada.getText();
        GestorExamenes.eliminarAutorizacionDocumento3(ticket);
        this.dispose();
        PrimeraEntradaAutorizacion prim = new PrimeraEntradaAutorizacion();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void PagoDeCitasbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasbotonActionPerformed
        String ticket = ticketEntrada.getText();
        GestorExamenes.eliminarAutorizacionDocumento3(ticket);
        this.dispose();
        pagodeCitasPrimeraEntrada prim = new pagodeCitasPrimeraEntrada();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasbotonActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        String ticket = ticketEntrada.getText();
        GestorExamenes.eliminarAutorizacionDocumento3(ticket);
        this.dispose();
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasboton1ActionPerformed

    private void AgendarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendarBotonActionPerformed
        String ticket = ticketEntrada.getText();
        GestorExamenes.eliminarAutorizacionDocumento3(ticket);
        EntradadeExamenes EX= new EntradadeExamenes();
        this.dispose();
        EX.setVisible(true);
        EX.setLocationRelativeTo(null);
        EX.setResizable(false);
    }//GEN-LAST:event_AgendarBotonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgendarBoton;
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JButton Registrarseboton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField ticketEntrada;
    // End of variables declaration//GEN-END:variables
}
