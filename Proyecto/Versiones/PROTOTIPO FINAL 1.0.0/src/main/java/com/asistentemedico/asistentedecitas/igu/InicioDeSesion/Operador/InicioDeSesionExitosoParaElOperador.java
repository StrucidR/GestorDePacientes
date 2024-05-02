package com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Operador;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.*;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Operador.salas.SalaDeEsperaDeAtencionMedicaOperador;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Operador.salas.SalaDeEsperaDeAutorizacionesOperador;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Operador.salas.SalaDeEsperaDePagoDeCitasOperador;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Operador.salas.SalaDeEsperaDePagoDeExamenesOperador;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Operador.salas.SalaDeEsperaParaAtencionDeExamenes;
import com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaSencilla.Sencilla;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class InicioDeSesionExitosoParaElOperador extends javax.swing.JFrame {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacion;
    //establecemos unas variables privadas propias de esta clase
    
    DefaultTableModel tablaUsuarios= new DefaultTableModel();
    
    DefaultTableModel tablaCitas = new DefaultTableModel();
    
    DefaultTableModel tablaDeAutorizaciones = new DefaultTableModel();
    
    DefaultTableModel tablaExamenes = new DefaultTableModel();
    
    private Sencilla<String[]> usuarios = new Sencilla<>();
    
    private Sencilla<String[]> citasdeUsuarios = new Sencilla<>();
    
    private Sencilla <String[]> autorizacionesdeUsuarios = new Sencilla<>();
    
    private Sencilla<String[]> examenesDeUsuarios = new Sencilla<>();
    
    public InicioDeSesionExitosoParaElOperador(String nombreUsuario, 
    String apellidoUsuario, String identificacion) {//Y las pasamos al construc
        initComponents();//tor ya que las implementaremos para ciertas funciones
        this.nombreUsuario=nombreUsuario;//con base a la constancia de inicioDeS
        this.apellidoUsuario=apellidoUsuario;//y no repetir el inicio
        this.identificacion=identificacion;
        mostradordeusuario.setText(nombreUsuario + " " + apellidoUsuario);
        mostradordeusuario.setEditable(false);//variable/TextField que nos per
    }//mite visualizar el usuario con las credenciales que dijitamos
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Imagenlogo.png"));
        
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        SalaDeEspera1 = new javax.swing.JButton();
        SalaDeEspera = new javax.swing.JButton();
        SalaDeEspera2 = new javax.swing.JButton();
        SalaDeEspera3 = new javax.swing.JButton();
        SalaDeEspera4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        mostradordeusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        VisualizarAutorizacionesDeUsuario = new javax.swing.JButton();
        VisualizarExamenesDeUsuario = new javax.swing.JButton();
        VisualizarCitasDeUsuario = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        identificadorDeUsuario = new javax.swing.JTextField();
        Usuariosdelsistema = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Asistente de Citas Médicas");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenlogo.png"))); // NOI18N

        SalaDeEspera1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SalaDeEspera1.setForeground(new java.awt.Color(102, 102, 102));
        SalaDeEspera1.setText("Sala de espera de pago");
        SalaDeEspera1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaDeEspera1ActionPerformed(evt);
            }
        });

        SalaDeEspera.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SalaDeEspera.setForeground(new java.awt.Color(102, 102, 102));
        SalaDeEspera.setText("Sala de espera de atención");
        SalaDeEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaDeEsperaActionPerformed(evt);
            }
        });

        SalaDeEspera2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SalaDeEspera2.setForeground(new java.awt.Color(102, 102, 102));
        SalaDeEspera2.setText("Sala de autorizaciones");
        SalaDeEspera2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaDeEspera2ActionPerformed(evt);
            }
        });

        SalaDeEspera3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SalaDeEspera3.setForeground(new java.awt.Color(102, 102, 102));
        SalaDeEspera3.setText("Sala de pago de examenes");
        SalaDeEspera3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaDeEspera3ActionPerformed(evt);
            }
        });

        SalaDeEspera4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SalaDeEspera4.setForeground(new java.awt.Color(102, 102, 102));
        SalaDeEspera4.setText("Sala de atención examenes");
        SalaDeEspera4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaDeEspera4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(SalaDeEspera3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(SalaDeEspera2)
                .addGap(18, 18, 18)
                .addComponent(SalaDeEspera)
                .addGap(18, 18, 18)
                .addComponent(SalaDeEspera1)
                .addGap(18, 18, 18)
                .addComponent(SalaDeEspera4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SalaDeEspera3)
                    .addComponent(SalaDeEspera2)
                    .addComponent(SalaDeEspera)
                    .addComponent(SalaDeEspera1)
                    .addComponent(SalaDeEspera4)))
        );

        jPanel3.setBackground(new java.awt.Color(235, 235, 235));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Bienvenido Operador su deber es gestionar las salas detenerlas cuando");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("cuando un paciente esta siendo atendido y gestionarse que sale para dar paso al siguiente turno ");

        VisualizarAutorizacionesDeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        VisualizarAutorizacionesDeUsuario.setForeground(new java.awt.Color(102, 102, 102));
        VisualizarAutorizacionesDeUsuario.setText("Autorizaciones de usuario");
        VisualizarAutorizacionesDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarAutorizacionesDeUsuarioActionPerformed(evt);
            }
        });

        VisualizarExamenesDeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        VisualizarExamenesDeUsuario.setForeground(new java.awt.Color(102, 102, 102));
        VisualizarExamenesDeUsuario.setText("Exámenes de usuario");
        VisualizarExamenesDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarExamenesDeUsuarioActionPerformed(evt);
            }
        });

        VisualizarCitasDeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        VisualizarCitasDeUsuario.setForeground(new java.awt.Color(102, 102, 102));
        VisualizarCitasDeUsuario.setText("Citas de usuarios");
        VisualizarCitasDeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarCitasDeUsuarioActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("en que rama desea ver la historia clínica");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("y luego seleccione ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Escriba la identificación del usuario ");

        identificadorDeUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        Usuariosdelsistema.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        Usuariosdelsistema.setForeground(new java.awt.Color(102, 102, 102));
        Usuariosdelsistema.setText("Ver Usuarios Vinculados");
        Usuariosdelsistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosdelsistemaActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 153));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Segoe UI Light", 1, 10)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Usuariosdelsistema, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(VisualizarExamenesDeUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(VisualizarAutorizacionesDeUsuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(VisualizarCitasDeUsuario))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(identificadorDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 116, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(Usuariosdelsistema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificadorDeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VisualizarCitasDeUsuario)
                    .addComponent(VisualizarAutorizacionesDeUsuario)
                    .addComponent(VisualizarExamenesDeUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void mostradordeusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostradordeusuarioActionPerformed
       
    }//GEN-LAST:event_mostradordeusuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        InicioDeSesion inic= new InicioDeSesion();
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SalaDeEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaDeEsperaActionPerformed
        this.dispose();
        SalaDeEsperaDeAtencionMedicaOperador inic = 
        new SalaDeEsperaDeAtencionMedicaOperador(nombreUsuario, apellidoUsuario, identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_SalaDeEsperaActionPerformed

    private void SalaDeEspera1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaDeEspera1ActionPerformed
        this.dispose();
        SalaDeEsperaDePagoDeCitasOperador inic = 
        new SalaDeEsperaDePagoDeCitasOperador(nombreUsuario, apellidoUsuario, identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_SalaDeEspera1ActionPerformed

    private void SalaDeEspera2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaDeEspera2ActionPerformed
        this.dispose();
        SalaDeEsperaDeAutorizacionesOperador inic = 
        new SalaDeEsperaDeAutorizacionesOperador(nombreUsuario, apellidoUsuario, identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_SalaDeEspera2ActionPerformed

    private void SalaDeEspera3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaDeEspera3ActionPerformed
        this.dispose();
        SalaDeEsperaDePagoDeExamenesOperador inic = 
        new SalaDeEsperaDePagoDeExamenesOperador(nombreUsuario, apellidoUsuario, identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_SalaDeEspera3ActionPerformed

    private void SalaDeEspera4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaDeEspera4ActionPerformed
        this.dispose();
        SalaDeEsperaParaAtencionDeExamenes inic = 
        new SalaDeEsperaParaAtencionDeExamenes(nombreUsuario, apellidoUsuario, identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_SalaDeEspera4ActionPerformed

    
    class Nodo{
        String dato;
        Nodo siguiente;
        Nodo(String dato){
            this.dato=dato;
            this.siguiente=null;
        }
    }
    
    private void setColumnIdentifiers(DefaultTableModel modelo, Nodo cabecera){
        Nodo actual = cabecera;
        while(actual != null){
            modelo.addColumn(actual.dato);
            actual = actual.siguiente;
        }
    }
    
    private void limpiarCitas(){
        citasdeUsuarios.limpiar();
    }
    
    public void limpiarUsuarios(){
        usuarios.limpiar();
    }
    
    public void limpiarAutorizaciones(){
        autorizacionesdeUsuarios.limpiar();
    }
    
    public void limpiarExamenes(){
        examenesDeUsuarios.limpiar();
    }
    
    //______________________________________________________________________
    
    private void setModeloUsuarios(){
        
        if(!modeloDeUsuariosActivado){
        Nodo cabecera = new Nodo("Nombre");
        cabecera.siguiente = new Nodo("Apellido(s)");
        cabecera.siguiente.siguiente = new Nodo("Ident.");
        cabecera.siguiente.siguiente.siguiente = new Nodo("Edad");
        cabecera.siguiente.siguiente.siguiente.siguiente = new Nodo("Telefono");
        setColumnIdentifiers(tablaUsuarios, cabecera);
        }
        tabla.setModel(tablaUsuarios);
        tabla.setEnabled(false);
    }
    
    private void setDatosUsuarios(){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        
        usuarios.buscar(usuario -> model.addRow(usuario));
        
    }
    
    private void leerUsuariosEnSistema(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/asistentemedico/asistentedecitas/persistencia/usuarios.txt"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            String identificacionUsuario = campos[2];
            String identificacionDeUsuario = identificadorDeUsuario.getText();
            
            if(identificacionUsuario.equals(identificacionDeUsuario)){
                usuarios.agregar(campos);
            }else if(identificacionDeUsuario.equals("")){
                usuarios.agregar(campos);
            }
            
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    
    
    private boolean modeloDeUsuariosActivado = false;
    private void UsuariosdelsistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosdelsistemaActionPerformed
        setModeloUsuarios();
        leerUsuariosEnSistema();
        setDatosUsuarios();
        
        
        VisualizarAutorizacionesDeUsuario.setEnabled(true);
        Usuariosdelsistema.setEnabled(false);
        VisualizarCitasDeUsuario.setEnabled(true);
        VisualizarExamenesDeUsuario.setEnabled(true);
        
        limpiarCitas();
        limpiarAutorizaciones();
        limpiarExamenes();
        
        
        tablaCitas.setRowCount(0);
        tablaDeAutorizaciones.setRowCount(0);
        tablaExamenes.setRowCount(0);
        
        
        modeloDeUsuariosActivado=true;
    }//GEN-LAST:event_UsuariosdelsistemaActionPerformed

    private void setModeloCitas(){
        if(!modeloDeCitasActivado){
        Nodo cabecera = new Nodo("Nombre");
        cabecera.siguiente = new Nodo("Apellido(s)");
        cabecera.siguiente.siguiente = new Nodo("Ident.");
        cabecera.siguiente.siguiente.siguiente = new Nodo("Iden.Cita");
        cabecera.siguiente.siguiente.siguiente.siguiente = new Nodo("Ticket");
        cabecera.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Costo");
        cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Doctor");
        cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Pago?");
        cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Especialidad");
        cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Asistida?");
        cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Motivo");
        setColumnIdentifiers(tablaCitas, cabecera);
        }
        tabla.setModel(tablaCitas);
        tabla.setEnabled(false);
    }
        
    private void setCitasUsuario(){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        citasdeUsuarios.buscar(cita -> model.addRow(cita));
        
    }
    
    private void leerCitasUsuario() {
        try (BufferedReader br = 
        new BufferedReader(new FileReader("src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(", ");
            String identificacionCita = campos[2];
            String identificacionDeUsuario = identificadorDeUsuario.getText();
            if (identificacionCita.equals(identificacionDeUsuario)) {
                citasdeUsuarios.agregar(campos);
            }else if(identificacionDeUsuario.equals("")){
                citasdeUsuarios.agregar(campos);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
    

    private boolean modeloDeCitasActivado = false;
    private void VisualizarCitasDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarCitasDeUsuarioActionPerformed
        setModeloCitas();
        leerCitasUsuario();
        setCitasUsuario();
        
        VisualizarAutorizacionesDeUsuario.setEnabled(true);
        VisualizarCitasDeUsuario.setEnabled(false);
        Usuariosdelsistema.setEnabled(true);
        VisualizarExamenesDeUsuario.setEnabled(true);
        
        limpiarUsuarios();
        limpiarAutorizaciones();
        limpiarExamenes();
        
        tablaUsuarios.setRowCount(0);
        tablaDeAutorizaciones.setRowCount(0);
        tablaExamenes.setRowCount(0);
        
        modeloDeCitasActivado=true;
    }//GEN-LAST:event_VisualizarCitasDeUsuarioActionPerformed

    private void setModeloAutorizacionesParaTabla(){
        if(!modeloDeAutorizacionesActivado){
            Nodo cabecera = new Nodo("Nombre");
            cabecera.siguiente = new Nodo("Apellido(S)");
            cabecera.siguiente.siguiente = new Nodo("IdenT");
            cabecera.siguiente.siguiente.siguiente = new Nodo("Iden.Cta");
            cabecera.siguiente.siguiente.siguiente.siguiente = new Nodo("Tickt");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Costo");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Examen");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Iden.Autori");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Info");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Autorizada?");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("TicktAuto");
            setColumnIdentifiers(tablaDeAutorizaciones, cabecera);
        }
        tabla.setModel(tablaDeAutorizaciones);
        tabla.setEnabled(false);
    }
    
    private void leerAutorizacionesUsuario(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_autorizacion.txt"))){
            String linea;
            while((linea = br.readLine()) != null){
                String [] campos = linea.split(", ");
                String identificacionUsuario = campos[2];
                String identificacionDelUsuario = identificadorDeUsuario.getText();
                if(identificacionUsuario.equals(identificacionDelUsuario)){
                    autorizacionesdeUsuarios.agregar(campos);
                }else if(identificacionDelUsuario.equals("")){
                    autorizacionesdeUsuarios.agregar(campos);
                }

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void setAutorizacionesUsuario(){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        autorizacionesdeUsuarios.buscar(autorizacion -> model.addRow(autorizacion));
    }
    
    
    private boolean modeloDeAutorizacionesActivado = false;
    private void VisualizarAutorizacionesDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarAutorizacionesDeUsuarioActionPerformed

        setModeloAutorizacionesParaTabla();
        leerAutorizacionesUsuario();
        setAutorizacionesUsuario();
        
        VisualizarAutorizacionesDeUsuario.setEnabled(false);
        VisualizarCitasDeUsuario.setEnabled(true);
        Usuariosdelsistema.setEnabled(true);
        VisualizarExamenesDeUsuario.setEnabled(true);
        
        limpiarUsuarios();
        limpiarCitas();
        limpiarExamenes();
        
        tablaUsuarios.setRowCount(0);
        tablaCitas.setRowCount(0);
        tablaExamenes.setRowCount(0);
        
        modeloDeAutorizacionesActivado=true;
    }//GEN-LAST:event_VisualizarAutorizacionesDeUsuarioActionPerformed

    private void setModeloParaExamenesTabla(){
        if(!modeloDeTablaExamenes){
            Nodo cabecera = new Nodo("Nombre");
            cabecera.siguiente = new Nodo("Apellido(s)");
            cabecera.siguiente.siguiente = new Nodo("IdentExamen.");
            cabecera.siguiente.siguiente.siguiente = new Nodo("TicketExamen");
            cabecera.siguiente.siguiente.siguiente.siguiente = new Nodo("Costo");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("TipoExa");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Descripcion");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Pago?");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Asistido?");
            cabecera.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo("Identifi.User");
            setColumnIdentifiers(tablaExamenes, cabecera);
        }
        tabla.setModel(tablaExamenes);
        tabla.setEnabled(false);
    }
    
    private void leerExamenesUsuario(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/asistentemedico/asistentedecitas/persistencia/examenes.txt"))){
            String linea;
            while((linea = br.readLine()) != null){
                String [] campos = linea.split(", ");
                String identificacionUsuario = campos[9];
                String identificacionDelUsuario = identificadorDeUsuario.getText();
                if(identificacionUsuario.equals(identificacionDelUsuario)){
                    examenesDeUsuarios.agregar(campos);
                }else if(identificacionDelUsuario.equals("")){
                    examenesDeUsuarios.agregar(campos);
                }

            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void setExamenesUsuario(){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);
        examenesDeUsuarios.buscar(examenes -> model.addRow(examenes));
    }
        
    private boolean modeloDeTablaExamenes = false;
    private void VisualizarExamenesDeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarExamenesDeUsuarioActionPerformed
    
        setModeloParaExamenesTabla();
        leerExamenesUsuario();
        setExamenesUsuario();
        
        
        VisualizarAutorizacionesDeUsuario.setEnabled(true);
        VisualizarCitasDeUsuario.setEnabled(true);
        Usuariosdelsistema.setEnabled(true);
        VisualizarExamenesDeUsuario.setEnabled(false);
        
        limpiarUsuarios();
        limpiarCitas();
        limpiarAutorizaciones();
        
        tablaUsuarios.setRowCount(0);
        tablaCitas.setRowCount(0);
        tablaDeAutorizaciones.setRowCount(0);
        
        
        modeloDeTablaExamenes=true;
    }//GEN-LAST:event_VisualizarExamenesDeUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SalaDeEspera;
    private javax.swing.JButton SalaDeEspera1;
    private javax.swing.JButton SalaDeEspera2;
    private javax.swing.JButton SalaDeEspera3;
    private javax.swing.JButton SalaDeEspera4;
    private javax.swing.JButton Usuariosdelsistema;
    private javax.swing.JButton VisualizarAutorizacionesDeUsuario;
    private javax.swing.JButton VisualizarCitasDeUsuario;
    private javax.swing.JButton VisualizarExamenesDeUsuario;
    private javax.swing.JTextField identificadorDeUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mostradordeusuario;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
