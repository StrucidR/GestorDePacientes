package com.asistentemedico.asistentedecitas.igu.examenes;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.autorizacion.*;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import com.asistentemedico.asistentedecitas.logica.Examen.ColaParaElPagoDeExamenes;
import com.asistentemedico.asistentedecitas.logica.Operador.EstadoDeFlujoParaAutorizaciones;
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

public class ColaParaElPagoDeExamen extends javax.swing.JFrame {
    
    private static final String RUTA_SALA_DE_ESPERA = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_sala_examenes.txt";
    private static final String RUTA_SALA_DE_EXAMENES="src/main/java/com/asistentemedico/asistentedecitas/persistencia/estadoDeFlujoParaPagoDeExamenes.txt";
    
    private String identificadordeautorizacion;
    
    private Timer timer;
    private Timer timer2;
        
    private DefaultTableModel  modeloTabla;
    
    private String nombreOperador = "";
    private String apellidoOperador = "";
    private String identificacionOperador = "";
    private String estadoOperador = "";
    public ColaParaElPagoDeExamen(String identificadordeautorizacion) {
        initComponents();
        this.identificadordeautorizacion=identificadordeautorizacion;
        
        modeloTabla = new DefaultTableModel();        
        setModelo();
        identificadorEntrada.setText(identificadordeautorizacion);
        identificadorEntrada.setEditable(false);
        
       
        tabla.setModel(modeloTabla);
        iniciarTimerActualizacion();
        iniciarTemporizador();
    }
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Imagenlogo.png"));
        
        return retValue;
    }
    private void iniciarTemporizador(){
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(()->{
            saberEstado();
            if(estadoOperador.equals("Flujo Continuo")){
            moverPrimeraAutorizacion();
            pasarAlframedeAutorizacionExitosa();
            }
        },1,2, TimeUnit.MINUTES);
    }
    
    private void saberEstado(){
        EstadoDeFlujoParaAutorizaciones estadodeAtencion =
        estado(RUTA_SALA_DE_EXAMENES);
        if(estadodeAtencion != null){
            nombreOperador = estadodeAtencion.getNombre();
            apellidoOperador = estadodeAtencion.getApellido();
            identificacionOperador = estadodeAtencion.getIdentificacion();
            estadoOperador = estadodeAtencion.getEstadoDeFlujo();
        }
    }
    
    public static EstadoDeFlujoParaAutorizaciones estado(String rutaArchivo){
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            if((linea = br.readLine()) != null){
                String nombre1 = obtenerCampoOperador(linea, 0);
                String apellido1 = obtenerCampoOperador(linea, 1);
                String identificacion1 = obtenerCampoOperador(linea, 2);
                String estado1 = obtenerCampoOperador(linea, 3);
                
                return new EstadoDeFlujoParaAutorizaciones(nombre1,
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
        cabecera.siguiente.siguiente = new Nodo("Indetifi.Examen");
        
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
    
private void cargarDatosDesdeArchivo() {
    String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_sala_examenes.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            if (campos.length >= 3) { // Asumiendo que hay al menos 3 campos en cada línea
                Object[] fila = {campos[0], campos[1], campos[3]}; // Tomando los primeros 3 campos
                modeloTabla.addRow(fila);
            } else {
                
            }
        }
    } catch (IOException e) {
    }
}
    private void actualizarTabla() {
        modeloTabla.setRowCount(0); // Limpiar la tabla antes de actualizarla
        cargarDatosDesdeArchivo(); // Cargar nuevamente los datos desde el archivo
    }

    private void iniciarTimerActualizacion() {
        int intervaloActualizacion = 2000; // Intervalo de actualización en milisegundos (30 segundos)
        timer = new Timer(intervaloActualizacion, (e) -> {
            actualizarTabla(); // Llamar al método de actualización cada vez que se active el temporizador
        });
        timer.start(); // Iniciar el temporizador
    }
    
    private void moverPrimeraAutorizacion(){
            
        ColaParaElPagoDeExamenes primeraCita = obtenerPrimeraCitaDesdeArchivo(RUTA_SALA_DE_ESPERA);
            
            if(primeraCita!=null){
                String nombre = primeraCita.getNombreUsuario();
                String apellido = primeraCita.getApellidoUsuario();
                String identificacion = primeraCita.getIdentificacionDeExamen();
                String ticket = primeraCita.getTicketExamen();
                
                GestorExamenes.moverAutorizaciones(nombre, 
                        apellido, identificacion, ticket);
                        
                GestorExamenes.eliminarAutorizacionDeSala();
            }
    }
    
    private boolean frameMostrado = false;
    private void pasarAlframedeAutorizacionExitosa(){
        
        String identificador = identificadorEntrada.getText();
        
        System.out.println("Identificador: " +  identificador );
        
        if(!frameMostrado){
        boolean pasoalotroframe = 
        GestorExamenes.verificaridentificadordeautorizacion(identificador);
        
        if(pasoalotroframe==true){
        ExamenPagoConExito Exit = 
        new ExamenPagoConExito(identificador);
        this.dispose();
        Exit.setVisible(true);
        Exit.setLocationRelativeTo(null);
        Exit.setResizable(false);
        frameMostrado=true;
        }
        }
    }

    public static ColaParaElPagoDeExamenes obtenerPrimeraCitaDesdeArchivo(String rutaArchivo){
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            if((linea = br.readLine()) != null){
                String nombre = obtenerCampo(linea, 0);
                String apellido =obtenerCampo(linea, 1);
                String identificadorDeExamen =obtenerCampo(linea, 2);
                String ticketExamen = obtenerCampo(linea, 3);
                
                return new ColaParaElPagoDeExamenes(nombre, apellido,identificadorDeExamen,ticketExamen);
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
        lobbyboton = new javax.swing.JButton();
        IniciarSesionboton = new javax.swing.JButton();
        Autorizacionboton = new javax.swing.JButton();
        PagoDeCitasboton = new javax.swing.JButton();
        PagoDeCitasboton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sobreNosotros1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        DoctorFree2 = new javax.swing.JLabel();
        identificadorEntrada = new javax.swing.JTextField();
        salirDeCola = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

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

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(lobbyboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lobbyboton)
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
        jLabel15.setText("Derechos de autor © 2024 AsistenteDeCitasSA. Todos los derechos reservados. Prohibida la reproducción total o parcial de este sitio , incluidos textos, imágenes y diseño, sin la autorización previa por escrito de AsistenteDeCitasMedicasSA.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
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

        DoctorFree2.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        DoctorFree2.setForeground(new java.awt.Color(0, 102, 153));
        DoctorFree2.setText("Identificador De Autorizacion");

        identificadorEntrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        identificadorEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorEntradaActionPerformed(evt);
            }
        });

        salirDeCola.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salirDeCola.setForeground(new java.awt.Color(102, 102, 102));
        salirDeCola.setText("Salir");
        salirDeCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirDeColaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Ten en cuenta que si sales de la cola perderás tu posición");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Por favor espere a que su autorización sea autorizada y sera redireccionado");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("a una pestaña que confirma que su autorización ha sido autorizada con exito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(identificadorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(salirDeCola)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DoctorFree2))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))))
                    .addComponent(sobreNosotros1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sobreNosotros1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DoctorFree2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(identificadorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salirDeCola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lobbybotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lobbybotonActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        
        GestorExamenes.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorExamenes.eliminarAutorizacionDocumento2(textoIdentificador);
        
        this.dispose();
        Registro regis= new Registro();
        regis.setVisible(true);
        regis.setLocationRelativeTo(null);
        regis.setResizable(false);
    }//GEN-LAST:event_lobbybotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        
        GestorExamenes.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorExamenes.eliminarAutorizacionDocumento2(textoIdentificador);
        
        this.dispose();
        InicioDeSesion princ=new InicioDeSesion();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        
        GestorExamenes.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorExamenes.eliminarAutorizacionDocumento2(textoIdentificador);
        
        this.dispose();
        PrimeraEntradaAutorizacion prim = new PrimeraEntradaAutorizacion();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void PagoDeCitasbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasbotonActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        
        GestorExamenes.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorExamenes.eliminarAutorizacionDocumento2(textoIdentificador);
        
        this.dispose();
        pagodeCitasPrimeraEntrada prim = new pagodeCitasPrimeraEntrada();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasbotonActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        GestorExamenes.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorExamenes.eliminarAutorizacionDocumento2(textoIdentificador);
        this.dispose();
        Principal prim = new Principal();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasboton1ActionPerformed

    private void identificadorEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorEntradaActionPerformed

    }//GEN-LAST:event_identificadorEntradaActionPerformed

    private void salirDeColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirDeColaActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        GestorExamenes.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorExamenes.eliminarAutorizacionDocumento2(textoIdentificador);
        this.dispose();
        Principal sala = new Principal();
        sala.setVisible(true);
        sala.setLocationRelativeTo(null);
        sala.setResizable(false);
    }//GEN-LAST:event_salirDeColaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JLabel DoctorFree2;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JTextField identificadorEntrada;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lobbyboton;
    private javax.swing.JButton salirDeCola;
    private javax.swing.JLabel sobreNosotros1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
