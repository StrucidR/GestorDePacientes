package com.asistentemedico.asistentedecitas.igu.autorizacion;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import com.asistentemedico.asistentedecitas.persistencia.Autorizacion.GestorAutorizacion;
import java.awt.Image;
import java.awt.Toolkit;

public class cancelacionDeAutorizaciones extends javax.swing.JFrame {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacion;
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Imagenlogo.png"));
        
        return retValue;
    }
    
    public cancelacionDeAutorizaciones(String nombreUsuario, String apellidoUsuario,
        String identificacion) {
        initComponents();
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsuario=apellidoUsuario;
        this.identificacion=identificacion;
        mostradordeusuario.setText(nombreUsuario + " " + apellidoUsuario);
        mostradordeusuario.setEditable(false);
        
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
        DoctorFree1 = new javax.swing.JLabel();
        identificadorDeAutorizacion = new javax.swing.JTextField();
        DoctorFree2 = new javax.swing.JLabel();
        TicketTexto = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Autorizacion = new javax.swing.JRadioButton();
        volverBoton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mostradordeusuario = new javax.swing.JTextField();

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
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
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
        jLabel15.setText("Derechos de autor © 2024 AsistenteDeCitasSA. Todos los derechos reservados. Prohibida la reproducción total o parcial de este sitio web, incluidos textos, imágenes y diseño, sin la autorización previa por escrito de AsistenteDeCitasMedicasSA.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
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

        DoctorFree1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DoctorFree1.setForeground(new java.awt.Color(0, 102, 153));
        DoctorFree1.setText("Identificador de autorización");

        identificadorDeAutorizacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        identificadorDeAutorizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorDeAutorizacionActionPerformed(evt);
            }
        });

        DoctorFree2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DoctorFree2.setForeground(new java.awt.Color(0, 102, 153));
        DoctorFree2.setText("Ticket de Cita");

        TicketTexto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TicketTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketTextoActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar.setForeground(new java.awt.Color(0, 102, 153));
        cancelar.setText("CONFIRMAR CANCELACION");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Por favor verifique los datos del agendamiento de autorización");

        Autorizacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Autorizacion.setForeground(new java.awt.Color(102, 102, 102));
        Autorizacion.setText("Autorizo la cancelación de mi cita");

        volverBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        volverBoton.setForeground(new java.awt.Color(0, 102, 153));
        volverBoton.setText("Volver");
        volverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBotonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Espacio de ");

        mostradordeusuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mostradordeusuario.setForeground(new java.awt.Color(0, 102, 102));
        mostradordeusuario.setCaretColor(new java.awt.Color(255, 255, 255));
        mostradordeusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostradordeusuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(volverBoton)
                        .addContainerGap(1134, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(identificadorDeAutorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DoctorFree2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TicketTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelar)
                            .addComponent(Autorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DoctorFree1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(DoctorFree1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(identificadorDeAutorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DoctorFree2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TicketTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Autorizacion)
                .addGap(11, 11, 11)
                .addComponent(cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volverBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
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

    private void volverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBotonActionPerformed
        VisualizadorDeAutorizacionesExitosas inix= new VisualizadorDeAutorizacionesExitosas(
        nombreUsuario, apellidoUsuario, identificacion);
        this.dispose();
        inix.setVisible(true);
        inix.setLocationRelativeTo(null);
        inix.setResizable(false);
    }//GEN-LAST:event_volverBotonActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        String identificadorDeAutorizacion1 = identificadorDeAutorizacion.getText();
        String ticketCita = TicketTexto.getText();
        String nombre = nombreUsuario;
        String apellido = apellidoUsuario;
        String identificacion1 = identificacion;

        if(Autorizacion.isSelected() &&
            GestorAutorizacion.verificarAutorizacionParaCancelar
            (nombre, apellido, identificacion1,
                identificadorDeAutorizacion1, ticketCita) == true){
            GestorAutorizacion.cancelarAutorizaciondeUnUsuario
            (identificadorDeAutorizacion1);

            this.dispose();
            AutorizacionCanceladaCorrectamente cancel =
            new AutorizacionCanceladaCorrectamente(nombreUsuario, apellidoUsuario,
                identificacion,identificadorDeAutorizacion1,ticketCita);
            cancel.setVisible(true);
            cancel.setLocationRelativeTo(null);
            cancel.setResizable(false);
        }else{
            this.dispose();
            ErrorAlCancelarUnaAutorizacion error =
            new ErrorAlCancelarUnaAutorizacion(nombreUsuario, apellidoUsuario,
                identificacion1);
            error.setVisible(true);
            error.setLocationRelativeTo(null);
            error.setResizable(false);
        }

    }//GEN-LAST:event_cancelarActionPerformed

    private void TicketTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketTextoActionPerformed

    }//GEN-LAST:event_TicketTextoActionPerformed

    private void identificadorDeAutorizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorDeAutorizacionActionPerformed

    }//GEN-LAST:event_identificadorDeAutorizacionActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        this.dispose();
        EntradadeExamenes prim = new EntradadeExamenes();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasboton1ActionPerformed

    private void PagoDeCitasbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasbotonActionPerformed
        this.dispose();
        pagodeCitasPrimeraEntrada prim = new pagodeCitasPrimeraEntrada();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        this.dispose();
        Principal prim = new Principal();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
        this.dispose();
        InicioDeSesion inc= new InicioDeSesion();
        inc.setVisible(true);
        inc.setLocationRelativeTo(null);
        inc.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void lobbybotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lobbybotonActionPerformed
        this.dispose();
        Registro regis= new Registro();
        regis.setVisible(true);
        regis.setLocationRelativeTo(null);
        regis.setResizable(false);
    }//GEN-LAST:event_lobbybotonActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Autorizacion;
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JLabel DoctorFree1;
    private javax.swing.JLabel DoctorFree2;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JTextField TicketTexto;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField identificadorDeAutorizacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton lobbyboton;
    private javax.swing.JTextField mostradordeusuario;
    private javax.swing.JButton volverBoton;
    // End of variables declaration//GEN-END:variables
}
