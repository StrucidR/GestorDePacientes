package com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita.cancelacion.cancelacionDeCitas;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita.visualizadordecitas.visualizarCitas;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Saladeespera.EntradadePasarASalaDeEspera;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesionExitoso;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.autorizacion.PrimeraEntradaAutorizacion;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;

public class agendamientoExitoso extends javax.swing.JFrame {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacion;
    
    private int identificador;
    private String ticket;
    private int costo1;
    
    private boolean pagarSeleccionado;
    private String doctorSeleccionado;
    
    public agendamientoExitoso(String nombreUsuario, 
            String apellidoUsuario, String identificacion,
            String especialidadMotivoSeleccionados, int identificador, 
            String ticket, 
            int costo1, boolean pagarSeleccionado, String doctorSeleccionado, String motivo) {
        
        initComponents();
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.identificacion=identificacion;
        this.identificador = identificador;
        this.ticket = ticket;
        this.costo1 = costo1;
        this.pagarSeleccionado = pagarSeleccionado;
        this.doctorSeleccionado = doctorSeleccionado;
        
        mostradordeusuario.setText(nombreUsuario + " " + apellidoUsuario);
        mostradordeusuario.setEditable(false);
        identificadorDeCita.setText(String.valueOf(identificador));
        Ticket.setText(ticket);
        Costo1.setText(String.valueOf(costo1));
        PagarBoton.setSelected(pagarSeleccionado);

        
        marcarBotonesPorEspecialidad(especialidadMotivoSeleccionados);
        marcarBotonesPorMotivo(motivo);
        marcarBotonesDoctor(doctorSeleccionado);
        
        
        disableComponents();
    }
    
        private void disableComponents() {
        boton1.setEnabled(false);
        boton2.setEnabled(false);
        boton3.setEnabled(false);
        boton4.setEnabled(false);
        boton5.setEnabled(false);
        motivo1.setEnabled(false);
        motivo2.setEnabled(false);
        motivo3.setEnabled(false);
        doctorArango.setEnabled(false);
        doctorJeison.setEnabled(false);
        doctorJuanCarlos.setEnabled(false);
        PagarBoton.setEnabled(false);
        identificadorDeCita.setEnabled(false);
        Ticket.setEnabled(false);
        Costo1.setEnabled(false);
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
        jPanel4 = new javax.swing.JPanel();
        sobreNosotros2 = new javax.swing.JLabel();
        sobreNosotros3 = new javax.swing.JLabel();
        boton5 = new javax.swing.JRadioButton();
        boton1 = new javax.swing.JRadioButton();
        boton2 = new javax.swing.JRadioButton();
        boton3 = new javax.swing.JRadioButton();
        boton4 = new javax.swing.JRadioButton();
        sobreNosotros = new javax.swing.JLabel();
        motivo1 = new javax.swing.JRadioButton();
        motivo2 = new javax.swing.JRadioButton();
        motivo3 = new javax.swing.JRadioButton();
        volverBoton = new javax.swing.JButton();
        SaladeEspera = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        DoctorFree = new javax.swing.JLabel();
        doctorArango = new javax.swing.JRadioButton();
        doctorJeison = new javax.swing.JRadioButton();
        doctorJuanCarlos = new javax.swing.JRadioButton();
        DoctorFree1 = new javax.swing.JLabel();
        identificadorDeCita = new javax.swing.JTextField();
        DoctorFree2 = new javax.swing.JLabel();
        Ticket = new javax.swing.JTextField();
        costo = new javax.swing.JLabel();
        Costo1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        PagarBoton = new javax.swing.JRadioButton();
        mostradordeusuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CancelarCita2 = new javax.swing.JButton();
        VisualizarCita = new javax.swing.JButton();

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
        IniciarSesionboton.setText("Lobby");
        IniciarSesionboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarSesionbotonActionPerformed(evt);
            }
        });

        Autorizacionboton.setForeground(new java.awt.Color(102, 102, 102));
        Autorizacionboton.setText("Autorización");
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

        jPanel4.setBackground(new java.awt.Color(229, 229, 229));

        sobreNosotros2.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        sobreNosotros2.setForeground(new java.awt.Color(0, 102, 102));
        sobreNosotros2.setText("Especialidad Requerida");

        sobreNosotros3.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        sobreNosotros3.setForeground(new java.awt.Color(0, 102, 102));
        sobreNosotros3.setText("Motivo de Cita");

        boton5.setBackground(new java.awt.Color(229, 229, 229));
        boton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton5.setForeground(new java.awt.Color(102, 102, 102));
        boton5.setText("Dermátologia");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });

        boton1.setBackground(new java.awt.Color(229, 229, 229));
        boton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton1.setForeground(new java.awt.Color(102, 102, 102));
        boton1.setText("Médicina General");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setBackground(new java.awt.Color(229, 229, 229));
        boton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton2.setForeground(new java.awt.Color(102, 102, 102));
        boton2.setText("Pedíatria");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.setBackground(new java.awt.Color(229, 229, 229));
        boton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton3.setForeground(new java.awt.Color(102, 102, 102));
        boton3.setText("Ginecología");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        boton4.setBackground(new java.awt.Color(229, 229, 229));
        boton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton4.setForeground(new java.awt.Color(102, 102, 102));
        boton4.setText("Cardiología");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        sobreNosotros.setFont(new java.awt.Font("Segoe UI Variable", 1, 30)); // NOI18N
        sobreNosotros.setForeground(new java.awt.Color(0, 102, 102));
        sobreNosotros.setText("Bienvenido");

        motivo1.setBackground(new java.awt.Color(229, 229, 229));
        motivo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        motivo1.setForeground(new java.awt.Color(102, 102, 102));
        motivo1.setText("Valoración");
        motivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivo1ActionPerformed(evt);
            }
        });

        motivo2.setBackground(new java.awt.Color(229, 229, 229));
        motivo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        motivo2.setForeground(new java.awt.Color(102, 102, 102));
        motivo2.setText("Asesoramiento");
        motivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivo2ActionPerformed(evt);
            }
        });

        motivo3.setBackground(new java.awt.Color(229, 229, 229));
        motivo3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        motivo3.setForeground(new java.awt.Color(102, 102, 102));
        motivo3.setText("Control");
        motivo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivo3ActionPerformed(evt);
            }
        });

        volverBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        volverBoton.setForeground(new java.awt.Color(0, 102, 102));
        volverBoton.setText("Volver");
        volverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBotonActionPerformed(evt);
            }
        });

        SaladeEspera.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SaladeEspera.setForeground(new java.awt.Color(0, 102, 102));
        SaladeEspera.setText("Sala de espera");
        SaladeEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaladeEsperaActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 102));
        jButton3.setText("Cerrar Sesión");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sobreNosotros2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sobreNosotros3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volverBoton)
                    .addComponent(motivo3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sobreNosotros, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SaladeEspera))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sobreNosotros)
                .addGap(18, 18, 18)
                .addComponent(sobreNosotros2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton5)
                .addGap(18, 18, 18)
                .addComponent(sobreNosotros3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(motivo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motivo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motivo3)
                .addGap(26, 26, 26)
                .addComponent(volverBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SaladeEspera)
                .addGap(12, 12, 12)
                .addComponent(jButton3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        DoctorFree.setFont(new java.awt.Font("Segoe UI Variable", 1, 28)); // NOI18N
        DoctorFree.setForeground(new java.awt.Color(0, 102, 102));
        DoctorFree.setText("Doctores Disponibles");

        doctorArango.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        doctorArango.setForeground(new java.awt.Color(102, 102, 102));
        doctorArango.setText("Doctor Arango");
        doctorArango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorArangoActionPerformed(evt);
            }
        });

        doctorJeison.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        doctorJeison.setForeground(new java.awt.Color(102, 102, 102));
        doctorJeison.setText("Doctor Jeison");
        doctorJeison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorJeisonActionPerformed(evt);
            }
        });

        doctorJuanCarlos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        doctorJuanCarlos.setForeground(new java.awt.Color(102, 102, 102));
        doctorJuanCarlos.setText("Doctor Juan Carlos");
        doctorJuanCarlos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorJuanCarlosActionPerformed(evt);
            }
        });

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
        DoctorFree2.setText("Ticket");

        Ticket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketActionPerformed(evt);
            }
        });

        costo.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        costo.setForeground(new java.awt.Color(0, 102, 102));
        costo.setText("Costo");

        Costo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Costo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Costo1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("AGENDAMIENTO EXITOSO DE CITA");

        PagarBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PagarBoton.setForeground(new java.awt.Color(102, 102, 102));
        PagarBoton.setText("PAGO");

        mostradordeusuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mostradordeusuario.setForeground(new java.awt.Color(0, 102, 102));
        mostradordeusuario.setCaretColor(new java.awt.Color(255, 255, 255));
        mostradordeusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostradordeusuarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Espacio de ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("IVA Incluido");

        CancelarCita2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelarCita2.setForeground(new java.awt.Color(0, 102, 102));
        CancelarCita2.setText("Cancelar Cita");
        CancelarCita2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarCita2ActionPerformed(evt);
            }
        });

        VisualizarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VisualizarCita.setForeground(new java.awt.Color(0, 102, 102));
        VisualizarCita.setText("Visualizar Citas");
        VisualizarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarCitaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DoctorFree, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostradordeusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DoctorFree1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identificadorDeCita, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DoctorFree2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Costo1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(PagarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(doctorArango, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doctorJuanCarlos, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(doctorJeison, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(618, 618, 618)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CancelarCita2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(VisualizarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DoctorFree)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(7, 7, 7)
                                        .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(doctorArango)
                                            .addComponent(doctorJuanCarlos)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(CancelarCita2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(doctorJeison)
                                    .addComponent(VisualizarCita))
                                .addGap(31, 31, 31)
                                .addComponent(DoctorFree1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(identificadorDeCita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DoctorFree2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(costo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(PagarBoton)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Costo1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
       
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
       
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
      
    }//GEN-LAST:event_boton5ActionPerformed

    private void motivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivo1ActionPerformed

    }//GEN-LAST:event_motivo1ActionPerformed

    private void motivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivo2ActionPerformed
      
    }//GEN-LAST:event_motivo2ActionPerformed

    private void motivo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivo3ActionPerformed
 
    }//GEN-LAST:event_motivo3ActionPerformed

    private void volverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBotonActionPerformed
        InicioDeSesionExitoso inix= new InicioDeSesionExitoso(nombreUsuario, 
        apellidoUsuario, identificacion);
        this.dispose();
        inix.setVisible(true);
        inix.setLocationRelativeTo(null);
        inix.setResizable(false);
    }//GEN-LAST:event_volverBotonActionPerformed

    private void identificadorDeCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorDeCitaActionPerformed

    }//GEN-LAST:event_identificadorDeCitaActionPerformed

    private void TicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketActionPerformed
       
    }//GEN-LAST:event_TicketActionPerformed

    private void Costo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Costo1ActionPerformed

    }//GEN-LAST:event_Costo1ActionPerformed

    private void SaladeEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaladeEsperaActionPerformed
        this.dispose();
        EntradadePasarASalaDeEspera inic = 
        new EntradadePasarASalaDeEspera(nombreUsuario,
                            apellidoUsuario,
        identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_SaladeEsperaActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
       
    }//GEN-LAST:event_boton1ActionPerformed

    
        private void marcarBotonesPorEspecialidad(String especialidadMotivoSeleccionados){
        if(especialidadMotivoSeleccionados.equals(boton1.getText())){
            boton1.setSelected(true);
        }
        else if(especialidadMotivoSeleccionados.equals(boton2.getText())){
            boton2.setSelected(true);
        }
        else if(especialidadMotivoSeleccionados.equals(boton3.getText())){
            boton3.setSelected(true);
        }
        else if(especialidadMotivoSeleccionados.equals(boton4.getText())){
            boton4.setSelected(true);
        }
        else if(especialidadMotivoSeleccionados.equals(boton5.getText())){
            boton5.setSelected(true);
        }
    }
    
    private void marcarBotonesPorMotivo(String motivoSeleccionado){
        if(motivoSeleccionado.equals(motivo1.getText())){
            motivo1.setSelected(true);
            PagarBoton.setSelected(false);
            PagarBoton.setEnabled(false);
        }
        else if(motivoSeleccionado.equals(motivo2.getText())){
            motivo2.setSelected(true);
            PagarBoton.setSelected(false);
            PagarBoton.setEnabled(false);
        }
        else if(motivoSeleccionado.equals(motivo3.getText())){
            motivo3.setSelected(true);
            PagarBoton.setSelected(true);
            PagarBoton.setEnabled(false);
        }
    }
    
    private void marcarBotonesDoctor(String doctor){
        if(doctor.equals(doctorArango.getText())){
            doctorArango.setSelected(true);
            doctorArango.setEnabled(false);
        }
        else if(doctor.equals(doctorJuanCarlos.getText())){
            doctorJuanCarlos.setSelected(true);
            doctorJuanCarlos.setEnabled(false);
        }
        else if(doctor.equals(doctorJeison.getText())){
            doctorJeison.setSelected(true);
            doctorJeison.setEnabled(false);
        }
    }
    
    
    
    
    private void doctorArangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorArangoActionPerformed
    doctorJuanCarlos.setSelected(false);
    doctorJeison.setSelected(false);
    }//GEN-LAST:event_doctorArangoActionPerformed

    private void doctorJuanCarlosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorJuanCarlosActionPerformed
    doctorArango.setSelected(false);
    doctorJeison.setSelected(false);
    }//GEN-LAST:event_doctorJuanCarlosActionPerformed

    private void doctorJeisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorJeisonActionPerformed
    doctorArango.setSelected(false);
    doctorJuanCarlos.setSelected(false);
    }//GEN-LAST:event_doctorJeisonActionPerformed

    private void mostradordeusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostradordeusuarioActionPerformed

    }//GEN-LAST:event_mostradordeusuarioActionPerformed

    private void CancelarCita2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarCita2ActionPerformed
        this.dispose();
        cancelacionDeCitas cancel=new cancelacionDeCitas(nombreUsuario,
        apellidoUsuario,identificacion);
        cancel.setVisible(true);
        cancel.setLocationRelativeTo(null);
        cancel.setResizable(false);
    }//GEN-LAST:event_CancelarCita2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        InicioDeSesion inic= new InicioDeSesion();
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void VisualizarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarCitaActionPerformed
        this.dispose();
        visualizarCitas view=new visualizarCitas(nombreUsuario, apellidoUsuario,
        identificacion);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setResizable(false);
    }//GEN-LAST:event_VisualizarCitaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JButton CancelarCita2;
    private javax.swing.JTextField Costo1;
    private javax.swing.JLabel DoctorFree;
    private javax.swing.JLabel DoctorFree1;
    private javax.swing.JLabel DoctorFree2;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JRadioButton PagarBoton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JButton SaladeEspera;
    private javax.swing.JTextField Ticket;
    private javax.swing.JButton VisualizarCita;
    private javax.swing.JRadioButton boton1;
    private javax.swing.JRadioButton boton2;
    private javax.swing.JRadioButton boton3;
    private javax.swing.JRadioButton boton4;
    private javax.swing.JRadioButton boton5;
    private javax.swing.JLabel costo;
    private javax.swing.JRadioButton doctorArango;
    private javax.swing.JRadioButton doctorJeison;
    private javax.swing.JRadioButton doctorJuanCarlos;
    private javax.swing.JTextField identificadorDeCita;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton lobbyboton;
    private javax.swing.JTextField mostradordeusuario;
    private javax.swing.JRadioButton motivo1;
    private javax.swing.JRadioButton motivo2;
    private javax.swing.JRadioButton motivo3;
    private javax.swing.JLabel sobreNosotros;
    private javax.swing.JLabel sobreNosotros2;
    private javax.swing.JLabel sobreNosotros3;
    private javax.swing.JButton volverBoton;
    // End of variables declaration//GEN-END:variables
}
