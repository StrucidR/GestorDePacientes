package com.asistentemedico.asistentedecitas.igu.autorizacion;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import com.asistentemedico.asistentedecitas.logica.Autorizacion.SalaDeAutorizaciones;
import com.asistentemedico.asistentedecitas.persistencia.Autorizacion.GestorAutorizacion;
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

public class SalaDeEsperaDeAutorizaciones extends javax.swing.JFrame {
    private static final String RUTA_SALA_DE_ESPERA_AUTORIZACION = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera_autorizacion.txt";
    
    private int identificadordeautorizacion;
    
    private Timer timer;
    private Timer timer2;
        
    private DefaultTableModel  modeloTabla;
    
    public SalaDeEsperaDeAutorizaciones(int identificadordeautorizacion) {
        initComponents();
        this.identificadordeautorizacion=identificadordeautorizacion;
        
        modeloTabla = new DefaultTableModel();        
        setModelo();
        identificadorEntrada.setText(String.valueOf(identificadordeautorizacion));
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
            moverPrimeraAutorizacion();
            pasarAlframedeAutorizacionExitosa();
        },1,2, TimeUnit.MINUTES);
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
        cabecera.siguiente.siguiente = new Nodo("Indetifi.Autor");
        
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
    String rutaArchivo = "src/main/java/com/asistentemedico/asistentedecitas/persistencia/sala_de_espera_autorizacion.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(",");
            if (campos.length >= 3) { // Asumiendo que hay al menos 3 campos en cada línea
                Object[] fila = {campos[0], campos[1], campos[7]}; // Tomando los primeros 7 campos
                modeloTabla.addRow(fila);
            } else {
                System.err.println("La línea no contiene suficientes campos: " + linea);
            }
        }
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
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
            SalaDeAutorizaciones primeraCita = obtenerPrimeraCitaEnSalaDeAutorizacion2(RUTA_SALA_DE_ESPERA_AUTORIZACION);
            if(primeraCita!=null){
                String nombre = primeraCita.getNombreUsuario();
                String apellido = primeraCita.getApellidoUsuario();
                String identificacion = primeraCita.getIdentificacion();
                String ticket = primeraCita.getTicketdecita();
                
                GestorAutorizacion.moverAutorizaciones(nombre, 
                        apellido, identificacion, ticket);
                        
                GestorAutorizacion.eliminarAutorizacionDeSala();
            }
    }
    
    private boolean frameMostrado = false;
    private void pasarAlframedeAutorizacionExitosa(){
        
        String identificador = identificadorEntrada.getText();
        
        if(!frameMostrado){
        boolean pasoalotroframe = 
        GestorAutorizacion.verificaridentificadordeautorizacion(identificador);
        
        if(pasoalotroframe==true){
        AutorizacionAutorizadaConExito Exit = 
        new AutorizacionAutorizadaConExito(identificador);
        this.dispose();
        Exit.setVisible(true);
        Exit.setLocationRelativeTo(null);
        Exit.setResizable(false);
        frameMostrado=true;
        }
        }
    }
    
    public static SalaDeAutorizaciones obtenerPrimeraCitaEnSalaDeAutorizacion2(String rutaArchivo){
        try(FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea;
            if((linea=br.readLine()) != null){
                String nombre=obtenerCampo(linea, 0);
                String apellido=obtenerCampo(linea, 1);
                String identificacion=obtenerCampo(linea, 2);
                String identificadordecita=obtenerCampo(linea, 3);
                String ticketCita = obtenerCampo(linea, 4);
                String costo=obtenerCampo(linea, 5);
                String tipoExamen=obtenerCampo(linea, 6);
                String identificadordeautorizacion1=obtenerCampo(linea, 7);
                String descripcion=obtenerCampo(linea, 8);
                String estadodeautorizacion=obtenerCampo(linea, 9);
                return new SalaDeAutorizaciones(nombre, apellido, identificacion,
                identificadordecita,ticketCita,costo,tipoExamen,identificadordeautorizacion1,
                descripcion,estadodeautorizacion);
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
        Autorizacionboton.setText("Lobby");
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

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lobbyboton)
                                .addComponent(IniciarSesionboton)
                                .addComponent(Autorizacionboton)
                                .addComponent(PagoDeCitasboton)
                                .addComponent(PagoDeCitasboton1))
                            .addComponent(jLabel3)))
                    .addComponent(jLabel18))
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

        sobreNosotros1.setFont(new java.awt.Font("Segoe UI Variable", 1, 34)); // NOI18N
        sobreNosotros1.setForeground(new java.awt.Color(0, 102, 153));
        sobreNosotros1.setText("SALA DE ESPERA");

        tabla.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
                    .addComponent(sobreNosotros1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(identificadorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(salirDeCola)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DoctorFree2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(sobreNosotros1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DoctorFree2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(identificadorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(salirDeCola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
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
        String textoIdentificador = identificadorEntrada.getText();
        
        GestorAutorizacion.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorAutorizacion.eliminarAutorizacionDocumento2(textoIdentificador);
        
        this.dispose();
        Registro regis= new Registro();
        regis.setVisible(true);
        regis.setLocationRelativeTo(null);
        regis.setResizable(false);
    }//GEN-LAST:event_lobbybotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        
        GestorAutorizacion.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorAutorizacion.eliminarAutorizacionDocumento2(textoIdentificador);
        
        this.dispose();
        InicioDeSesion inc= new InicioDeSesion();
        inc.setVisible(true);
        inc.setLocationRelativeTo(null);
        inc.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        
        GestorAutorizacion.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorAutorizacion.eliminarAutorizacionDocumento2(textoIdentificador);
        
        this.dispose();
        Principal prim = new Principal();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void PagoDeCitasbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasbotonActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        
        GestorAutorizacion.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorAutorizacion.eliminarAutorizacionDocumento2(textoIdentificador);
        
        this.dispose();
        pagodeCitasPrimeraEntrada prim = new pagodeCitasPrimeraEntrada();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasbotonActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        GestorAutorizacion.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorAutorizacion.eliminarAutorizacionDocumento2(textoIdentificador);
        this.dispose();
        EntradadeExamenes prim = new EntradadeExamenes();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasboton1ActionPerformed

    private void identificadorEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorEntradaActionPerformed

    }//GEN-LAST:event_identificadorEntradaActionPerformed

    private void salirDeColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirDeColaActionPerformed
        String textoIdentificador = identificadorEntrada.getText();
        GestorAutorizacion.eliminarAutorizacionDocumento1(textoIdentificador);
        GestorAutorizacion.eliminarAutorizacionDocumento2(textoIdentificador);
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
