package com.asistentemedico.asistentedecitas.igu.examenes;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.autorizacion.*;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;

public class ErrorAlCancelarExamen extends javax.swing.JFrame {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    
    public ErrorAlCancelarExamen(String nombreUsuario, String apellidoUsuario) {
        
        initComponents();
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsuario=apellidoUsuario;
        mostradordeusuario.setText(nombreUsuario + " " + apellidoUsuario);
        mostradordeusuario.setEditable(false);
        
        Autorizacion.setSelected(false);
        Autorizacion.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lobbyboton = new javax.swing.JButton();
        IniciarSesionboton = new javax.swing.JButton();
        Autorizacionboton = new javax.swing.JButton();
        PagoDeCitasboton = new javax.swing.JButton();
        PagoDeCitasboton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        DoctorFree1 = new javax.swing.JLabel();
        identificadorDeCita = new javax.swing.JTextField();
        DoctorFree2 = new javax.swing.JLabel();
        TicketTexto = new javax.swing.JTextField();
        regresar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mostradordeusuario = new javax.swing.JTextField();
        Autorizacion = new javax.swing.JRadioButton();
        CancelarCita = new javax.swing.JButton();
        VisualizarCita = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(229, 229, 229));

        jLabel3.setFont(new java.awt.Font("Segoe UI Variable", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("Asistente de Citas Médicas");

        lobbyboton.setForeground(new java.awt.Color(102, 102, 102));
        lobbyboton.setText("Registrarse");
        lobbyboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lobbybotonActionPerformed(evt);
            }
        });

        IniciarSesionboton.setForeground(new java.awt.Color(102, 102, 102));
        IniciarSesionboton.setText("Iniciar Sesión");
        IniciarSesionboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionbotonActionPerformed(evt);
            }
        });

        Autorizacionboton.setForeground(new java.awt.Color(102, 102, 102));
        Autorizacionboton.setText("Lobby");
        Autorizacionboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutorizacionbotonActionPerformed(evt);
            }
        });

        PagoDeCitasboton.setForeground(new java.awt.Color(102, 102, 102));
        PagoDeCitasboton.setText("Pago de Citas");
        PagoDeCitasboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoDeCitasbotonActionPerformed(evt);
            }
        });

        PagoDeCitasboton1.setForeground(new java.awt.Color(102, 102, 102));
        PagoDeCitasboton1.setText("Exámenes");
        PagoDeCitasboton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoDeCitasboton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lobbyboton)
                            .addComponent(IniciarSesionboton)
                            .addComponent(Autorizacionboton)
                            .addComponent(PagoDeCitasboton)
                            .addComponent(PagoDeCitasboton1))))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(229, 229, 229));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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

        DoctorFree1.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        DoctorFree1.setForeground(new java.awt.Color(0, 102, 102));
        DoctorFree1.setText("Identificador de Cita");

        identificadorDeCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        identificadorDeCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorDeCitaActionPerformed(evt);
            }
        });

        DoctorFree2.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        DoctorFree2.setForeground(new java.awt.Color(0, 102, 102));
        DoctorFree2.setText("Ticket de examen");

        TicketTexto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TicketTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketTextoActionPerformed(evt);
            }
        });

        regresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regresar.setForeground(new java.awt.Color(0, 102, 102));
        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Debe autorizar el boton de cancelacion de cita por favor y verificar si ticket e ");

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

        Autorizacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Autorizacion.setForeground(new java.awt.Color(102, 102, 102));
        Autorizacion.setText("Autorizo la cancelación de mi cita");
        Autorizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutorizacionActionPerformed(evt);
            }
        });

        CancelarCita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CancelarCita.setForeground(new java.awt.Color(0, 102, 102));
        CancelarCita.setText("Salir");
        CancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarCitaActionPerformed(evt);
            }
        });

        VisualizarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VisualizarCita.setForeground(new java.awt.Color(0, 102, 102));
        VisualizarCita.setText("Visualizar Examenes");
        VisualizarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarCitaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("identificador son correctos y verifique si selecciono una especialidad y motivo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DoctorFree1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identificadorDeCita, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TicketTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regresar)
                            .addComponent(Autorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DoctorFree2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(625, 625, 625)
                                .addComponent(CancelarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mostradordeusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(VisualizarCita, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VisualizarCita)
                        .addGap(12, 12, 12)
                        .addComponent(CancelarCita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DoctorFree1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(identificadorDeCita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DoctorFree2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TicketTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(3, 3, 3)
                        .addComponent(Autorizacion)
                        .addGap(11, 11, 11)
                        .addComponent(regresar)
                        .addGap(0, 268, Short.MAX_VALUE))))
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
        this.dispose();
        Registro regis= new Registro();
        regis.setVisible(true);
        regis.setLocationRelativeTo(null);
        regis.setResizable(false);
    }//GEN-LAST:event_lobbybotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
        this.dispose();
        InicioDeSesion princ=new InicioDeSesion();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        this.dispose();
        Principal prim = 
        new Principal();
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

    private void identificadorDeCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorDeCitaActionPerformed

    }//GEN-LAST:event_identificadorDeCitaActionPerformed

    private void TicketTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketTextoActionPerformed
      
    }//GEN-LAST:event_TicketTextoActionPerformed

    private void mostradordeusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostradordeusuarioActionPerformed

    }//GEN-LAST:event_mostradordeusuarioActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
        CancelacionDeExamenesPagos cancel= new CancelacionDeExamenesPagos(nombreUsuario, 
        apellidoUsuario);
        cancel.setVisible(true);
        cancel.setLocationRelativeTo(null);
        cancel.setResizable(false);
    }//GEN-LAST:event_regresarActionPerformed

    private void CancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarCitaActionPerformed
        this.dispose();
        EntradadeExamenes inic=new EntradadeExamenes();
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_CancelarCitaActionPerformed

    private void VisualizarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarCitaActionPerformed
        this.dispose();
        VisualizadorDeExamenes view=new VisualizadorDeExamenes
        (nombreUsuario, apellidoUsuario);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setResizable(false);
    }//GEN-LAST:event_VisualizarCitaActionPerformed

    private void AutorizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AutorizacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Autorizacion;
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JButton CancelarCita;
    private javax.swing.JLabel DoctorFree1;
    private javax.swing.JLabel DoctorFree2;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JTextField TicketTexto;
    private javax.swing.JButton VisualizarCita;
    private javax.swing.JTextField identificadorDeCita;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton lobbyboton;
    private javax.swing.JTextField mostradordeusuario;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}