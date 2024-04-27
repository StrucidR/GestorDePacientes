package com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Operador.salas;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Operador.InicioDeSesionExitosoParaElOperador;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.autorizacion.PrimeraEntradaAutorizacion;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoParaPagoDeCitasMedicas;
import static com.asistentemedico.asistentedecitas.persistencia.salasoperador.FlujoDeLasSalas.cambiarEstadoDeSalaDePagoDeCitasAFlujoContinuo;
import static com.asistentemedico.asistentedecitas.persistencia.salasoperador.FlujoDeLasSalas.cambiarEstadoDeSalaDePagoDeCitasAFlujoDetenido;
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

public class SalaDeEsperaDePagoDeCitasOperador extends javax.swing.JFrame {
    
        private static final String RUTA_SALA_DE_ATENCION_PARAPAGO ="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoPagoDeCitas.txt";
        private String nombreUsuario;
        private String apellidoUsaurio;
        private String identificacion;
        private Timer timer;
        private DefaultTableModel modeloTabla;
        
        private String nombre1 = "";
        private String apellido1 = "";
        private String identificacion1 = "";
        private String estado1 = "";

    public SalaDeEsperaDePagoDeCitasOperador(String nombreUsuario,String apellidoUsaurio, 
        String identificacion) {
        
        initComponents();
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsaurio=apellidoUsaurio;
        this.identificacion=identificacion;
        
        modeloTabla = new DefaultTableModel();        
        setModelo();
        
        mostradordeusuario.setText(nombreUsuario + " " + apellidoUsaurio);
        mostradordeusuario.setEditable(false);

        tabla.setModel(modeloTabla);
        iniciarTimerActualizacion();
        iniciarTemporizador();
        saberEstado();
    }
    
    private void saberEstado(){
        EstadoParaPagoDeCitasMedicas primeraCita = 
        estado(RUTA_SALA_DE_ATENCION_PARAPAGO);
        if(primeraCita != null){
            nombre1 = primeraCita.getNombre();
            apellido1 = primeraCita.getApellido();
            identificacion1 = primeraCita.getIdentificacion();
            estado1 = primeraCita.getEstadoDeFlujo();
        }
        if(estado1.equals("Detenido")){
             ContinuarFlujo.setEnabled(true);
             DetenerFlujo.setEnabled(false);
             EstadoDeSala.setText("Detenido");
        }else{
            ContinuarFlujo.setEnabled(false);
            DetenerFlujo.setEnabled(true);
            EstadoDeSala.setText("Flujo Continuo");
        }
    }
    
    public static EstadoParaPagoDeCitasMedicas estado(String rutaArchivo){
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            if((linea = br.readLine()) != null){
                String nombre1 = obtenerCampo(linea, 0);
                String apellido1 = obtenerCampo(linea, 1);
                String identificacion1 = obtenerCampo(linea, 2);
                String estado1 = obtenerCampo(linea, 3);
                
                return new EstadoParaPagoDeCitasMedicas(nombre1,
                apellido1, identificacion1, estado1);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
    private static String obtenerCampo(String linea, int indice){
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
            actualizarTabla();
        }, 1, 2, TimeUnit.MINUTES);
    }
    
    private void cargarDatosDesdeArchivo(){
        String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/cola_de_pagos.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while((linea = br.readLine()) != null ){
                String [] campos = linea.split(", ");
                if(campos.length >= 2 ){
                    Object[] fila = {campos[0] , campos[1] , campos[3]};
                    modeloTabla.addRow(fila);
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
        mostradordeusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        DetenerFlujo = new javax.swing.JButton();
        ContinuarFlujo = new javax.swing.JButton();
        EstadoDeSala = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

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
        sobreNosotros1.setText("SALA DE ESPERA PAGO DE CITAS");

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

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 153));
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        DetenerFlujo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DetenerFlujo.setForeground(new java.awt.Color(0, 102, 153));
        DetenerFlujo.setText("Detener Flujo");
        DetenerFlujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetenerFlujoActionPerformed(evt);
            }
        });

        ContinuarFlujo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ContinuarFlujo.setForeground(new java.awt.Color(0, 102, 153));
        ContinuarFlujo.setText("Continuar Flujo");
        ContinuarFlujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarFlujoActionPerformed(evt);
            }
        });

        EstadoDeSala.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EstadoDeSala.setForeground(new java.awt.Color(0, 102, 102));
        EstadoDeSala.setCaretColor(new java.awt.Color(255, 255, 255));
        EstadoDeSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadoDeSalaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Estado de la sala");

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
                        .addComponent(sobreNosotros1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mostradordeusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(EstadoDeSala, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ContinuarFlujo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DetenerFlujo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sobreNosotros1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(EstadoDeSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(7, 7, 7)
                            .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2)
                            .addGap(18, 18, 18)
                            .addComponent(ContinuarFlujo)
                            .addGap(12, 12, 12)
                            .addComponent(DetenerFlujo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
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
        this.dispose();
        Registro regis= new Registro();
        regis.setVisible(true);
        regis.setLocationRelativeTo(null);
        regis.setResizable(false);
    }//GEN-LAST:event_lobbybotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
        this.dispose();
        Principal princ=new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        this.dispose();
        PrimeraEntradaAutorizacion prim = new PrimeraEntradaAutorizacion();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void PagoDeCitasbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasbotonActionPerformed
        this.dispose();
        pagodeCitasPrimeraEntrada prim = new pagodeCitasPrimeraEntrada();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasbotonActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        this.dispose();
        EntradadeExamenes prim = new EntradadeExamenes();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasboton1ActionPerformed

    private void mostradordeusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostradordeusuarioActionPerformed
       
    }//GEN-LAST:event_mostradordeusuarioActionPerformed

    private void DetenerFlujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetenerFlujoActionPerformed
        saberEstado();
        if(estado1 != null && estado1.equals("Flujo Continuo")){
        ContinuarFlujo.setEnabled(true);
        DetenerFlujo.setEnabled(false);
        EstadoDeSala.setText("Detenido");
        cambiarEstadoDeSalaDePagoDeCitasAFlujoDetenido(nombreUsuario,
        apellidoUsaurio, identificacion);
        }
    }//GEN-LAST:event_DetenerFlujoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
       InicioDeSesionExitosoParaElOperador inic = 
       new InicioDeSesionExitosoParaElOperador(nombreUsuario, apellidoUsaurio,
       identificacion);
       inic.setVisible(true);
       inic.setLocationRelativeTo(null);
       inic.setResizable(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ContinuarFlujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarFlujoActionPerformed
        saberEstado();
        if(estado1 != null && estado1.equals("Detenido")){
        ContinuarFlujo.setEnabled(false);
        DetenerFlujo.setEnabled(true);
        EstadoDeSala.setText("Flujo Continuo");
        cambiarEstadoDeSalaDePagoDeCitasAFlujoContinuo(nombreUsuario,
        apellidoUsaurio, identificacion);
        }
    }//GEN-LAST:event_ContinuarFlujoActionPerformed

    private void EstadoDeSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadoDeSalaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EstadoDeSalaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JButton ContinuarFlujo;
    private javax.swing.JButton DetenerFlujo;
    private javax.swing.JTextField EstadoDeSala;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
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
    private javax.swing.JLabel sobreNosotros1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
