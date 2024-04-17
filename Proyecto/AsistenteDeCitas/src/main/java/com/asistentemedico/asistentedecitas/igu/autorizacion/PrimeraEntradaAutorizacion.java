package com.asistentemedico.asistentedecitas.igu.autorizacion;

import com.asistentemedico.asistentedecitas.igu.pagodecitas.*;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.persistencia.Autorizacion.GestorAutorizacion;
import com.asistentemedico.asistentedecitas.persistencia.citascontrolador.GestorCitas;
import com.asistentemedico.asistentedecitas.persistencia.registroycomprobacionusuario.ControladorUsuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrimeraEntradaAutorizacion extends javax.swing.JFrame {
    
    public PrimeraEntradaAutorizacion() {
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
        jLabel4 = new javax.swing.JLabel();
        nombreEntrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ApellidoEntrada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        IdentificacionEntrada = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        IdentificacionDeCitaEntrada = new javax.swing.JTextField();
        AutorizarExamenes = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        TicketEntrada = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        examen1 = new javax.swing.JRadioButton();
        examen2 = new javax.swing.JRadioButton();
        examen3 = new javax.swing.JRadioButton();
        examen4 = new javax.swing.JRadioButton();
        examen5 = new javax.swing.JRadioButton();
        examen6 = new javax.swing.JRadioButton();
        ContraseniaEntrada = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        visualizarAutorizacionesExitosas = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        verContraseña = new javax.swing.JRadioButton();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(85, 85, 85)
                .addComponent(PagoDeCitasboton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PagoDeCitasboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Autorizacionboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(IniciarSesionboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lobbyboton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Nombre(S):");

        nombreEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nombreEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreEntradaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Apellido(S):");

        ApellidoEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ApellidoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoEntradaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Identificación:");

        IdentificacionEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        IdentificacionEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdentificacionEntradaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Identificador de la cita:");

        IdentificacionDeCitaEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        IdentificacionDeCitaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdentificacionDeCitaEntradaActionPerformed(evt);
            }
        });

        AutorizarExamenes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AutorizarExamenes.setForeground(new java.awt.Color(0, 102, 153));
        AutorizarExamenes.setText("Registro");
        AutorizarExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutorizarExamenesActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Ticket:");

        TicketEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        TicketEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketEntradaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Tipo de Examen a Autorizar");

        examen1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen1.setForeground(new java.awt.Color(0, 102, 153));
        examen1.setText("Sangíneo");
        examen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen1ActionPerformed(evt);
            }
        });

        examen2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen2.setForeground(new java.awt.Color(0, 102, 153));
        examen2.setText("Cenfálico");
        examen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen2ActionPerformed(evt);
            }
        });

        examen3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen3.setForeground(new java.awt.Color(0, 102, 153));
        examen3.setText("Cráneo");
        examen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen3ActionPerformed(evt);
            }
        });

        examen4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen4.setForeground(new java.awt.Color(0, 102, 153));
        examen4.setText("Radiográfia");
        examen4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen4ActionPerformed(evt);
            }
        });

        examen5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen5.setForeground(new java.awt.Color(0, 102, 153));
        examen5.setText("Orína");
        examen5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen5ActionPerformed(evt);
            }
        });

        examen6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen6.setForeground(new java.awt.Color(0, 102, 153));
        examen6.setText("Próstata");
        examen6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen6ActionPerformed(evt);
            }
        });

        ContraseniaEntrada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Contraseña:");

        visualizarAutorizacionesExitosas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        visualizarAutorizacionesExitosas.setForeground(new java.awt.Color(0, 102, 153));
        visualizarAutorizacionesExitosas.setText("Visualizar Autorizaciones Exitosas");
        visualizarAutorizacionesExitosas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualizarAutorizacionesExitosasActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Si deseas visualizar todas las autorizaciones a tu nombre solo completa el campo, nombre,apellido,identificación y contraseña");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Recuerda tambien que el tipo de examen se asignara automaticamente dependiendo del ticket de tu cita ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("y esperar a ser autorizado en sala");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("Este espacio es para registrar su orden ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("para posteriormente pasar a examenes");

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
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(AutorizarExamenes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visualizarAutorizacionesExitosas)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IdentificacionDeCitaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(IdentificacionEntrada)
                                .addComponent(ApellidoEntrada))
                            .addComponent(nombreEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(examen1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(examen4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(examen2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(examen5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(examen6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(examen3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(ContraseniaEntrada, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TicketEntrada, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(verContraseña, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel13))
                                .addGap(190, 190, 190))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nombreEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TicketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel5)
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ApellidoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ContraseniaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addComponent(verContraseña, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(IdentificacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IdentificacionDeCitaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(examen1)
                            .addComponent(examen2)
                            .addComponent(examen3))
                        .addGap(41, 41, 41)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(examen4)
                    .addComponent(examen5)
                    .addComponent(examen6))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(visualizarAutorizacionesExitosas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutorizarExamenes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(101, 101, 101)
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
        InicioDeSesion princ=new InicioDeSesion();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        this.dispose();
        Principal princ=new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void PagoDeCitasbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasbotonActionPerformed
        this.dispose();
        pagodeCitasPrimeraEntrada princ=new pagodeCitasPrimeraEntrada();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasbotonActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        this.dispose();
        EntradadeExamenes prim = new EntradadeExamenes();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasboton1ActionPerformed

    private void nombreEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreEntradaActionPerformed
        validarCampos();
    }//GEN-LAST:event_nombreEntradaActionPerformed

    private void ApellidoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApellidoEntradaActionPerformed
         validarCampos();
    }//GEN-LAST:event_ApellidoEntradaActionPerformed

    private void IdentificacionEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdentificacionEntradaActionPerformed
        validarCampos();
    }//GEN-LAST:event_IdentificacionEntradaActionPerformed

    private void IdentificacionDeCitaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdentificacionDeCitaEntradaActionPerformed
         validarCampos();
    }//GEN-LAST:event_IdentificacionDeCitaEntradaActionPerformed

    private void AutorizarExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizarExamenesActionPerformed
        verificarTicket();
        
        boolean examenSeleccionado = examen1.isSelected() || 
        examen2.isSelected() || examen3.isSelected() || 
        examen4.isSelected() || examen5.isSelected() || 
        examen6.isSelected();
        if(camposCompletos() && examenSeleccionado)
        {
            String nombreUsuario= nombreEntrada.getText();
            String apellidoUsuario = ApellidoEntrada.getText();
            String identificacion = IdentificacionEntrada.getText();
            String contrasenia = new String(ContraseniaEntrada.getPassword());
            String identificadorCita = IdentificacionDeCitaEntrada.getText();
            String ticket = TicketEntrada.getText();
            
            ControladorUsuario.cargarUsuarios();
            if(ControladorUsuario.validarInicioSesion(nombreUsuario,
                    apellidoUsuario, identificacion, contrasenia))
            {
                boolean citaPaga=GestorCitas.verificarCitaPagada
                (identificadorCita, ticket);
                boolean citaAsistida=GestorCitas.verificarAsistenciaCita
               (identificadorCita, ticket);
                boolean autorizada=GestorAutorizacion.verficicarAutorizacion(
                identificadorCita, ticket);
                
                if(citaPaga && citaAsistida && !autorizada)
                {
                String especialidadMotivoSeleccionados = "";
                 if (examen1.isSelected()) especialidadMotivoSeleccionados 
                     = examen1.getText();
                 if (examen2.isSelected()) especialidadMotivoSeleccionados 
                     = examen2.getText();
                 if (examen3.isSelected()) especialidadMotivoSeleccionados 
                     = examen3.getText() ;
                 if (examen4.isSelected()) especialidadMotivoSeleccionados 
                     = examen4.getText() ;
                 if (examen5.isSelected()) especialidadMotivoSeleccionados 
                     = examen5.getText() ;
                 if (examen6.isSelected()) especialidadMotivoSeleccionados 
                     = examen6.getText() ;
                
                 int costo = generarCosto();
                 
                 String descripcion = generarDescripcion();
                 
                 int identificadordeautorizacion = generarIdentificadordeAuto();
                 
                 String ticketAutorizacion = generarTicket();
                
                 this.dispose();
                 FiltroDeAutorizacion sala = 
                 new FiltroDeAutorizacion(
                 nombreUsuario, apellidoUsuario, identificacion, 
   identificadorCita,ticket,
                 especialidadMotivoSeleccionados, costo,descripcion,
                 identificadordeautorizacion, ticketAutorizacion
                 );
                 sala.setVisible(true);
                 sala.setLocationRelativeTo(null);
                 sala.setResizable(false);

                }
                else{
                     String verificarExamen = "";
                     if (examen1.isSelected()) verificarExamen = 
                             examen1.getText().trim();
                     if (examen2.isSelected()) verificarExamen = 
                             examen2.getText().trim();
                     if (examen3.isSelected()) verificarExamen = 
                             examen3.getText().trim();
                     if (examen4.isSelected()) verificarExamen = 
                             examen4.getText().trim();
                     if (examen5.isSelected()) verificarExamen = 
                             examen5.getText().trim();
                     if (examen6.isSelected()) verificarExamen = 
                             examen6.getText().trim();
                   
                    boolean examenTipoCorrecto = 
                    GestorAutorizacion.verificarExamen(verificarExamen);
                    if(examenTipoCorrecto)
                    {
                        
                        String costo = GestorAutorizacion.traerCosto(nombreUsuario,
                        apellidoUsuario, identificacion, 
          identificadorCita, ticket);
                        
                        String identificadorDeAutorizacion = 
                        GestorAutorizacion.traerIdentificadordeAutorizacion(
                        nombreUsuario, apellidoUsuario, 
        identificacion, identificadorCita, ticket);
                        
                        String traerDescripcion = 
                        GestorAutorizacion.traerDescripcion(nombreUsuario, 
                        apellidoUsuario, identificacion, 
          identificadorCita, ticket);
                        
                    this.dispose();
                    ustedYaCuentaConUnaAutorizacion check = new ustedYaCuentaConUnaAutorizacion
                    (nombreUsuario, apellidoUsuario, identificacion, 
       identificadorCita,ticket,
 verificarExamen, costo,
                    traerDescripcion,identificadorDeAutorizacion);
                    
                    check.setVisible(true);
                    check.setLocationRelativeTo(null);
                    check.setResizable(false); 
                    }
                    else{
                     this.dispose();
                     ErrorAlAgendar error = new ErrorAlAgendar();
                     error.setVisible(true);
                     error.setLocationRelativeTo(null);
                     error.setResizable(false);
                    }
                    
                }
            }
            
            else{
            this.dispose();
            ErrorAlAgendar error = new ErrorAlAgendar();
            error.setVisible(true);
            error.setLocationRelativeTo(null);
            error.setResizable(false);
            }
        }
        else{
            this.dispose();
            ErrorAlAgendar error = new ErrorAlAgendar();
            error.setVisible(true);
            error.setLocationRelativeTo(null);
            error.setResizable(false);
        }
    
    }//GEN-LAST:event_AutorizarExamenesActionPerformed

    private void TicketEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketEntradaActionPerformed
        validarCampos();
        verificarTicket();
    }//GEN-LAST:event_TicketEntradaActionPerformed

    private void verificarTicket(){
        String ticket = TicketEntrada.getText().toUpperCase();
        
        if(ticket.startsWith("GV") || ticket.startsWith("GA")){
            examen1.setSelected(true);
            examen2.setSelected(false);
            examen3.setSelected(false);
            examen4.setSelected(false);
            examen5.setSelected(false);
            examen6.setSelected(false);
        }
        else if(ticket.startsWith("PV") || ticket.startsWith("PA")){
            examen2.setSelected(true);
            examen1.setSelected(false);
            examen3.setSelected(false);
            examen4.setSelected(false);
            examen5.setSelected(false);
            examen6.setSelected(false);
        }
        else if(ticket.startsWith("GIV") || ticket.startsWith("GIA")){
            examen3.setSelected(true);
            examen1.setSelected(false);
            examen2.setSelected(false);
            examen4.setSelected(false);
            examen5.setSelected(false);
            examen6.setSelected(false);
        }
        else if(ticket.startsWith("CV") || ticket.startsWith("CA")){
            examen4.setSelected(true);
            examen1.setSelected(false);
            examen2.setSelected(false);
            examen3.setSelected(false);
            examen5.setSelected(false);
            examen6.setSelected(false);
        }
        else if(ticket.startsWith("DV") || ticket.startsWith("DA")){
            examen5.setSelected(true);
            examen1.setSelected(false);
            examen2.setSelected(false);
            examen3.setSelected(false);
            examen4.setSelected(false);
            examen6.setSelected(false);
        }
        else if(ticket.startsWith("DC") || ticket.startsWith("CC") ||
                ticket.startsWith("GIC") || ticket.startsWith("PC") ||
                ticket.startsWith("GC")){
            examen1.setEnabled(true);
            examen2.setEnabled(true);
            examen3.setEnabled(true);
            examen4.setEnabled(true);
            examen5.setEnabled(true);
            examen6.setEnabled(true);
        }
    }

    private void examen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examen1ActionPerformed
    examen2.setSelected(false);
    examen3.setSelected(false);
    examen4.setSelected(false);
    examen5.setSelected(false);
    examen6.setSelected(false);
    }//GEN-LAST:event_examen1ActionPerformed

    private void examen2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examen2ActionPerformed
    examen1.setSelected(false);
    examen3.setSelected(false);
    examen4.setSelected(false);
    examen5.setSelected(false);
    examen6.setSelected(false);
    }//GEN-LAST:event_examen2ActionPerformed

    private void examen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examen3ActionPerformed
    examen2.setSelected(false);
    examen1.setSelected(false);
    examen4.setSelected(false);
    examen5.setSelected(false);
    examen6.setSelected(false);
    }//GEN-LAST:event_examen3ActionPerformed

    private void examen4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examen4ActionPerformed
    examen2.setSelected(false);
    examen3.setSelected(false);
    examen1.setSelected(false);
    examen5.setSelected(false);
    examen6.setSelected(false);
    }//GEN-LAST:event_examen4ActionPerformed

    private void examen5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examen5ActionPerformed
    examen2.setSelected(false);
    examen3.setSelected(false);
    examen4.setSelected(false);
    examen1.setSelected(false);
    examen6.setSelected(false);
    }//GEN-LAST:event_examen5ActionPerformed

    private void examen6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examen6ActionPerformed
    examen2.setSelected(false);
    examen3.setSelected(false);
    examen4.setSelected(false);
    examen5.setSelected(false);
    examen1.setSelected(false);
    }//GEN-LAST:event_examen6ActionPerformed

    private void visualizarAutorizacionesExitosasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualizarAutorizacionesExitosasActionPerformed
            String nombreUsuario= nombreEntrada.getText();
            String apellidoUsuario = ApellidoEntrada.getText();
            String identificacionUsuario = IdentificacionEntrada.getText();
            String contrasenia = new String(ContraseniaEntrada.getPassword());
            ControladorUsuario.cargarUsuarios();
            if(ControladorUsuario.validarInicioSesion(nombreUsuario,
                    apellidoUsuario, identificacionUsuario,
                    contrasenia))
            {
       VisualizadorDeAutorizacionesExitosas vis = 
       new VisualizadorDeAutorizacionesExitosas(nombreUsuario, apellidoUsuario,
       identificacionUsuario);
       this.dispose();
       vis.setVisible(true);
       vis.setLocationRelativeTo(null);
       vis.setResizable(false);
            }
            else{
                this.dispose();
                ErrorAlAgendar error = new ErrorAlAgendar();
                error.setVisible(true);
                error.setLocationRelativeTo(null);
                error.setResizable(false);
            }
    }//GEN-LAST:event_visualizarAutorizacionesExitosasActionPerformed

    private void verContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verContraseñaActionPerformed
        if (verContraseña.isSelected()) {
            ContraseniaEntrada.setEchoChar((char)0); // Mostrar la contraseña
        } else {
            ContraseniaEntrada.setEchoChar('*'); // Ocultar la contraseña
        }
    }//GEN-LAST:event_verContraseñaActionPerformed

    private void validarCampos() {
    // Verifica si los campos están completados correctamente
    boolean camposValidos = true;
    try {
        Integer.parseInt(IdentificacionEntrada.getText());
        Integer.parseInt(IdentificacionDeCitaEntrada.getText());
    } catch (NumberFormatException e) {
        // Si alguno de los campos no es un número, marca los campos como no válidos
        camposValidos = false;
    }

}

private boolean camposCompletos() {
    // Verifica si todos los campos están completados
    return !nombreEntrada.getText().isEmpty() && 
            !ApellidoEntrada.getText().isEmpty() && 
            !IdentificacionEntrada.getText().isEmpty() && 
            !IdentificacionDeCitaEntrada.getText().isEmpty();
}

private int generarCosto() {
    int costo = -1; // Valor por defecto si ningún examen está seleccionado

    if (examen1.isSelected()) {
        costo = 80000; // Precio para el examen Sangíneo
    } else if (examen2.isSelected()) {
        costo = 85000; // Precio para el examen Cenfálico
    } else if (examen3.isSelected()) {
        costo = 90000; // Precio para el examen Cráneo
    } else if (examen4.isSelected()) {
        costo = 95000; // Precio para el examen Radiográfia
    } else if (examen5.isSelected()) {
        costo = 100000; // Precio para el examen Orína
    } else if (examen6.isSelected()) {
        costo = 150000; // Precio para el examen Próstata
    }

    return costo;
}

private String generarDescripcion() {
    String descripcion = null;
    String examen = null;

    if (examen1.isSelected()) {
        examen = examen1.getText();
    } else if (examen2.isSelected()) {
        examen = examen2.getText();
    } else if (examen3.isSelected()) {
        examen = examen3.getText();
    } else if (examen4.isSelected()) {
        examen = examen4.getText();
    } else if (examen5.isSelected()) {
        examen = examen5.getText();
    } else if (examen6.isSelected()) {
        examen = examen6.getText();
    }

    if (examen != null) {
        switch (examen) {
            case "Sangíneo":
                descripcion = "Un examen de sangre que evalúa diversos parámetros\n"
                        + "como células sanguíneas niveles de glucosa lípidos electrolitos\n"
                        + "y función de órganos como el hígado y los riñones entre otros";
                break;
            case "Cenfálico":
                descripcion = "Un examen que se enfoca en la región de la cabeza\n"
                        + "incluyendo el cerebro los nervios craneales y la\n"
                        + "circulación sanguínea en esta área Puede involucrar\n"
                        + "técnicas de imagen como la resonancia magnética o la\n"
                        + "tomografía computarizada";
                break;
            case "Cráneo":
                descripcion = "Un examen radiográfico que se centra específicamente en los\n"
                        + "huesos del cráneo para evaluar su estructura integridad\n"
                        + "y posibles lesiones como fracturas o anomalías óseas";
                break;
            case "Radiográfia":
                descripcion = "Un examen de imagen que utiliza rayos X para\n"
                        + "producir imágenes de estructuras internas del cuerpo\n"
                        + "como huesos órganos y tejidos blandos con el fin de\n"
                        + "diagnosticar diversas condiciones médicas";
                break;
            case "Orína":
                descripcion = "Un análisis de la composición y características\n"
                        + "de la orina que puede proporcionar información sobre\n"
                        + "la función renal presencia de infecciones del\n"
                        + "tracto urinario presencia de sangre u otras anormalidades";
                break;
            case "Próstata":
                descripcion = "Un examen que evalúa la salud de la próstata,\n"
                        + "especialmente en hombres a menudo realizado mediante\n"
                        + "un examen físico (toque rectal) y análisis de sangre\n"
                        + "para medir el antígeno prostático específico (PSA)\n"
                        + "que puede indicar problemas como la hiperplasia\n"
                        + "prostática benigna o el cáncer de próstata";
                break;
        }
    }
    return descripcion;
}

private int generarIdentificadordeAuto(){
    return (int)(Math.random()*554680)+1;
}


    private String generarTicket() {
    StringBuilder ticket = new StringBuilder();
    
    // Agregar la identificación de especialidad y motivo (por ejemplo, GV001)
    ticket.append(obtenerIdentificacionEspecialidadMotivo());
    
    // Agregar un número aleatorio como secuencia
    ticket.append(obtenerSiguienteNumeroCita());
    return ticket.toString();
    }


private String obtenerIdentificacionEspecialidadMotivo() {
    StringBuilder identificacion = new StringBuilder();

    if (examen1.isSelected()) {
        identificacion.append("SA"); // Sangíneo
    }
    if (examen2.isSelected()) {
        identificacion.append("CE"); // Cenfálico
    }
    if (examen3.isSelected()) {
        identificacion.append("CR"); // Cráneo
    }
    if (examen4.isSelected()) {
        identificacion.append("RA"); // Radiográfia
    }
    if (examen5.isSelected()) {
        identificacion.append("OR"); // Orína
    }
    if (examen6.isSelected()) {
        identificacion.append("PR"); // Próstata
    }

    return identificacion.toString();
}

    private String obtenerSiguienteNumeroCita() {
    //Obtenemos la identificacion de la cita para la cual se necesia
    String identificacion = obtenerIdentificacionEspecialidadMotivo();
    String siguienteNumeroCita = "";

    try {
        //Abrimos el archivo de citas para leer
        FileReader fr = new FileReader(
"src/main/java/com/asistentemedico/asistentedecitas/persistencia/espera_de_autorizacion.txt");
        BufferedReader br = new BufferedReader(fr);

        //necesitamos un contador para revisar las citas existentes
        int contador = 0;

        // Leer cada línea del archivo y contar las citas existentes 
        //para la identificación actual
        String linea;
        while ((linea = br.readLine()) != null) {
            //Si la linea contiene la identificacion, incrementaremos de 1 en 1
            //respecto a lo solicitado y con base a las letras especialidad,
            //motivo
            if (linea.contains(identificacion)) 
            {
                contador++;
            }
        }

        // Construir el siguiente número de cita cumpliendo con el requerimiento
        siguienteNumeroCita = String.format("%03d", contador + 1);
        //Construir el siguiente numero de cita(Se suma 1 al contador y se for
        br.close();//matea
        fr.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //Devolver el siguiente numero de cita Generado
    return siguienteNumeroCita;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoEntrada;
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JButton AutorizarExamenes;
    private javax.swing.JPasswordField ContraseniaEntrada;
    private javax.swing.JTextField IdentificacionDeCitaEntrada;
    private javax.swing.JTextField IdentificacionEntrada;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JTextField TicketEntrada;
    private javax.swing.JRadioButton examen1;
    private javax.swing.JRadioButton examen2;
    private javax.swing.JRadioButton examen3;
    private javax.swing.JRadioButton examen4;
    private javax.swing.JRadioButton examen5;
    private javax.swing.JRadioButton examen6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton lobbyboton;
    private javax.swing.JTextField nombreEntrada;
    private javax.swing.JRadioButton verContraseña;
    private javax.swing.JButton visualizarAutorizacionesExitosas;
    // End of variables declaration//GEN-END:variables
}
