package com.asistentemedico.asistentedecitas.igu.examenes;

import com.asistentemedico.asistentedecitas.igu.Principal.*;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.autorizacion.PrimeraEntradaAutorizacion;
import com.asistentemedico.asistentedecitas.igu.examenes.saladeespera.EntradadeSaladeEsperaexamenes;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import com.asistentemedico.asistentedecitas.persistencia.Examenes.GestorExamenes;
import com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario.ControladorUsuario;
import java.awt.Image;
import java.awt.Toolkit;

public class EntradadeExamenes extends javax.swing.JFrame {
    
    public EntradadeExamenes() {
        initComponents();
    }
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
        Registrarseboton = new javax.swing.JButton();
        IniciarSesionboton = new javax.swing.JButton();
        Autorizacionboton = new javax.swing.JButton();
        PagoDeCitasboton = new javax.swing.JButton();
        PagoDeCitasboton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nombreEntrada = new javax.swing.JTextField();
        apellidoEntrada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        identifiacionEntrada = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        contraseniaEntrada = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        AgendarBoton = new javax.swing.JButton();
        SalaDeEspera = new javax.swing.JButton();
        identificadordeautorizacionEntrada = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        visualizarAutorizacionesExitosas = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        ticketAutorizacionEntrada = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        verContraseña = new javax.swing.JRadioButton();

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

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
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
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Registrarseboton)
                        .addComponent(IniciarSesionboton)
                        .addComponent(Autorizacionboton)
                        .addComponent(PagoDeCitasboton)
                        .addComponent(PagoDeCitasboton1))
                    .addComponent(jLabel3))
                .addGap(22, 22, 22))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Apellidos:");

        nombreEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nombreEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreEntradaActionPerformed(evt);
            }
        });

        apellidoEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        apellidoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidoEntradaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Nombre(S):");

        identifiacionEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        identifiacionEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identifiacionEntradaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("N° Identificación:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Contraseña:");

        contraseniaEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        contraseniaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseniaEntradaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Identificador de Autorización:");

        AgendarBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AgendarBoton.setForeground(new java.awt.Color(0, 102, 153));
        AgendarBoton.setText("Agendar/PasarAPagar");
        AgendarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgendarBotonActionPerformed(evt);
            }
        });

        SalaDeEspera.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SalaDeEspera.setForeground(new java.awt.Color(0, 102, 153));
        SalaDeEspera.setText("Sala de atención");
        SalaDeEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaDeEsperaActionPerformed(evt);
            }
        });

        identificadordeautorizacionEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        identificadordeautorizacionEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadordeautorizacionEntradaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Si es conciente de que no tiene un examen o autorización no diligensie este formulario");

        visualizarAutorizacionesExitosas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        visualizarAutorizacionesExitosas.setForeground(new java.awt.Color(0, 102, 153));
        visualizarAutorizacionesExitosas.setText("Visualizar Examenes");
        visualizarAutorizacionesExitosas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarAutorizacionesExitosasActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Si deseas visualizar todos los examenes a tu nombre solo completa el campo, nombre,apellido,identificación y contraseña");

        ticketAutorizacionEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ticketAutorizacionEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketAutorizacionEntradaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Ticket de Autorización:");

        verContraseña.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        verContraseña.setForeground(new java.awt.Color(204, 204, 204));
        verContraseña.setText("Mostrar Contraseña");
        verContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verContraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SalaDeEspera)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(visualizarAutorizacionesExitosas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AgendarBoton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(verContraseña)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(contraseniaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(76, 76, 76)
                                    .addComponent(nombreEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(76, 76, 76)
                                    .addComponent(apellidoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(identifiacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(ticketAutorizacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(identificadordeautorizacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nombreEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(identificadordeautorizacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(apellidoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ticketAutorizacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identifiacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel18))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(contraseniaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verContraseña)
                .addGap(18, 18, 18)
                .addComponent(AgendarBoton)
                .addGap(19, 19, 19)
                .addComponent(visualizarAutorizacionesExitosas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(SalaDeEspera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ticketAutorizacionEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketAutorizacionEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketAutorizacionEntradaActionPerformed

    private void visualizarAutorizacionesExitosasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarAutorizacionesExitosasActionPerformed

        String nombeUsuario = nombreEntrada.getText();
        String apellidoUsuario = apellidoEntrada.getText();
        String identificacionUsuario = identifiacionEntrada.getText();
        String contrasenia = new String (contraseniaEntrada.getPassword());
        ControladorUsuario.cargarUsuarios();
        if(ControladorUsuario.validarInicioSesion(nombeUsuario,
            apellidoUsuario, identificacionUsuario, contrasenia)){
        VisualizadorDeExamenes vis = new VisualizadorDeExamenes
        (nombeUsuario, apellidoUsuario);
        this.dispose();
        vis.setVisible(true);
        vis.setLocationRelativeTo(null);
        vis.setResizable(false);
        }
        else{
            this.dispose();
            ErrorAlAgendarPorCredencialesOFaltaDeDatos error = new ErrorAlAgendarPorCredencialesOFaltaDeDatos();
            error.setVisible(true);
            error.setLocationRelativeTo(null);
            error.setResizable(false);
        }
    }//GEN-LAST:event_visualizarAutorizacionesExitosasActionPerformed

    private void identificadordeautorizacionEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadordeautorizacionEntradaActionPerformed

    }//GEN-LAST:event_identificadordeautorizacionEntradaActionPerformed

    private void SalaDeEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaDeEsperaActionPerformed

        String nombeUsuario = nombreEntrada.getText();
        String apellidoUsuario = apellidoEntrada.getText();
        String identificacion = identifiacionEntrada.getText();
        String contrasenia = new String (contraseniaEntrada.getPassword());

        String identificadorDeAutorizacion =
        identificadordeautorizacionEntrada.getText();

        String ticketAutorizacion =
        ticketAutorizacionEntrada.getText();

        ControladorUsuario.cargarUsuarios();
        if(ControladorUsuario.validarInicioSesion(nombeUsuario, apellidoUsuario, identificacion, contrasenia)){

            boolean autorizada = GestorExamenes.verificarAutorizacion(identificadorDeAutorizacion,
                ticketAutorizacion);

            boolean examenAgendado = GestorExamenes.examenAgendado(identificadorDeAutorizacion,
                ticketAutorizacion);

            boolean examenYaAsistido = GestorExamenes.examenYaAsistido(identificadorDeAutorizacion,
                ticketAutorizacion);

            if(autorizada==true && examenAgendado==true && examenYaAsistido==false){

                boolean estaEnSala = 
                GestorExamenes.usuariOEnSala(nombeUsuario, apellidoUsuario, identificadorDeAutorizacion, ticketAutorizacion);
                
                if(estaEnSala){
                EntradadeSaladeEsperaexamenes sal=new EntradadeSaladeEsperaexamenes(ticketAutorizacion);
                this.dispose();
                sal.setVisible(true);
                sal.setLocationRelativeTo(null);
                sal.setResizable(false);
                }else{
                GestorExamenes.guardarEnSalaDeAtencionDeExamenes(nombeUsuario,
                    apellidoUsuario, identificadorDeAutorizacion, ticketAutorizacion);

                EntradadeSaladeEsperaexamenes sal=new EntradadeSaladeEsperaexamenes(ticketAutorizacion);
                this.dispose();
                sal.setVisible(true);
                sal.setLocationRelativeTo(null);
                sal.setResizable(false);
                }
            }
            else{
            this.dispose();
            ErrorAlAgendarPorCredencialesOFaltaDeDatos error = new ErrorAlAgendarPorCredencialesOFaltaDeDatos();
            error.setVisible(true);
            error.setLocationRelativeTo(null);
            error.setResizable(false);
            }
        }
        else{
            this.dispose();
            ErrorAlAgendarPorCredencialesOFaltaDeDatos error = new ErrorAlAgendarPorCredencialesOFaltaDeDatos();
            error.setVisible(true);
            error.setLocationRelativeTo(null);
            error.setResizable(false);
        }
    }//GEN-LAST:event_SalaDeEsperaActionPerformed

    private void AgendarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendarBotonActionPerformed

        if(camposCompletos()){

            String nombreUsuario = nombreEntrada.getText();
            String apellidoUsuario=apellidoEntrada.getText();
            String identificacionUsuario = identifiacionEntrada.getText();
            String contrasenia = new String(contraseniaEntrada.getPassword());

            String identificadorDeAutorizacion =
            identificadordeautorizacionEntrada.getText();

            String ticketAutorizacion =
            ticketAutorizacionEntrada.getText();

            ControladorUsuario.cargarUsuarios();
            if(ControladorUsuario.validarInicioSesion
                (nombreUsuario, apellidoUsuario,
                    identificacionUsuario, contrasenia) == true){

                boolean autorizada = GestorExamenes.verificarAutorizacion(identificadorDeAutorizacion,
                    ticketAutorizacion);

                boolean examenAgendado = GestorExamenes.examenAgendado(identificadorDeAutorizacion,
                    ticketAutorizacion);

                String costo = GestorExamenes.traerCosto(nombreUsuario,
                    apellidoUsuario,
                    identificadorDeAutorizacion, ticketAutorizacion);

                String tipoExamen =
                GestorExamenes.traerTipoExamen(nombreUsuario, apellidoUsuario,
                    identificacionUsuario, identificadorDeAutorizacion, ticketAutorizacion);

                String traerDescripcion =
                GestorExamenes.traerDescripcion(nombreUsuario,
                    apellidoUsuario, identificacionUsuario,
                    identificadorDeAutorizacion, ticketAutorizacion);

                if(autorizada){

                    if(examenAgendado==false){

                        AgendamientoExamenes agend = new AgendamientoExamenes(
                            nombreUsuario, apellidoUsuario, identificacionUsuario,
                            identificadorDeAutorizacion, ticketAutorizacion,  traerDescripcion,
                            costo, tipoExamen);
                        this.dispose();
                        agend.setVisible(true);
                        agend.setLocationRelativeTo(null);
                        agend.setResizable(false);

                    }
                    else
                    {
                        ustedYaCuentaconUnExamen agend = new ustedYaCuentaconUnExamen(
                            nombreUsuario, apellidoUsuario, identificadorDeAutorizacion,
                            ticketAutorizacion, traerDescripcion, costo, tipoExamen);
                        this.dispose();
                        agend.setVisible(true);
                        agend.setLocationRelativeTo(null);
                        agend.setResizable(false);
                    }

                }
                else{
                    this.dispose();
                    ErrorAlAgendarPorCredencialesOFaltaDeDatos error =
                    new ErrorAlAgendarPorCredencialesOFaltaDeDatos();
                    error.setVisible(true);
                    error.setLocationRelativeTo(null);
                    error.setResizable(false);
                }
            }
            else
            {
                this.dispose();
                ErrorAlAgendarPorCredencialesOFaltaDeDatos error =
                new ErrorAlAgendarPorCredencialesOFaltaDeDatos();
                error.setVisible(true);
                error.setLocationRelativeTo(null);
                error.setResizable(false);
            }
        }
        else
        {
            this.dispose();
            ErrorAlAgendarPorCredencialesOFaltaDeDatos error =
            new ErrorAlAgendarPorCredencialesOFaltaDeDatos();
            error.setVisible(true);
            error.setLocationRelativeTo(null);
            error.setResizable(false);
        }

    }//GEN-LAST:event_AgendarBotonActionPerformed

    private void contraseniaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseniaEntradaActionPerformed

    }//GEN-LAST:event_contraseniaEntradaActionPerformed

    private void identifiacionEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identifiacionEntradaActionPerformed

    }//GEN-LAST:event_identifiacionEntradaActionPerformed

    private void apellidoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidoEntradaActionPerformed

    }//GEN-LAST:event_apellidoEntradaActionPerformed

    private void nombreEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreEntradaActionPerformed

    }//GEN-LAST:event_nombreEntradaActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        this.dispose();
        Principal princ = new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
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
        PrimeraEntradaAutorizacion prim = new PrimeraEntradaAutorizacion();
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

    private void RegistrarsebotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarsebotonActionPerformed
        this.dispose();
        Registro ventanaRegistro= new Registro();
        ventanaRegistro.setVisible(true);
        ventanaRegistro.setLocationRelativeTo(null);
        ventanaRegistro.setResizable(false);
    }//GEN-LAST:event_RegistrarsebotonActionPerformed

    private void verContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verContraseñaActionPerformed
        if (verContraseña.isSelected()) {
            contraseniaEntrada.setEchoChar((char)0); // Mostrar la contraseña
        } else {
            contraseniaEntrada.setEchoChar('*'); // Ocultar la contraseña
        }
    }//GEN-LAST:event_verContraseñaActionPerformed

private boolean camposCompletos() {
    // Verifica si todos los campos están completados
    return !nombreEntrada.getText().isEmpty() && 
            !apellidoEntrada.getText().isEmpty() && 
            !identifiacionEntrada.getText().isEmpty() && 
            !identificadordeautorizacionEntrada.getText().isEmpty() &&
            !ticketAutorizacionEntrada.getText().isEmpty();
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgendarBoton;
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JButton Registrarseboton;
    private javax.swing.JButton SalaDeEspera;
    private javax.swing.JTextField apellidoEntrada;
    private javax.swing.JPasswordField contraseniaEntrada;
    private javax.swing.JTextField identifiacionEntrada;
    private javax.swing.JTextField identificadordeautorizacionEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nombreEntrada;
    private javax.swing.JTextField ticketAutorizacionEntrada;
    private javax.swing.JRadioButton verContraseña;
    private javax.swing.JButton visualizarAutorizacionesExitosas;
    // End of variables declaration//GEN-END:variables
}
