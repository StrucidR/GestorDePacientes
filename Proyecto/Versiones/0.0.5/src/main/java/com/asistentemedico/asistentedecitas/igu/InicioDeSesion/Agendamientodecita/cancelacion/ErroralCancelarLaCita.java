package com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita.cancelacion;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita.visualizadordecitas.visualizarCitas;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Saladeespera.EntradadePasarASalaDeEspera;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesionExitoso;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.autorizacion.PrimeraEntradaAutorizacion;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import java.awt.Image;
import java.awt.Toolkit;

public class ErroralCancelarLaCita extends javax.swing.JFrame {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacion;
    
    public ErroralCancelarLaCita(String nombreUsuario, String apellidoUsuario,
        String identificacion, String especialidadMotivoSeleccionados) {
        //El constructor de los frames contiene parametros ya que espera
        //que le pasemos informacion que sera constante con base a los frames
        //algo asi como una persistencia de la informacion de forma independiente
        //para cada pantalla evitando errores o intervencion de una pantalla con otra
        initComponents();
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsuario=apellidoUsuario;
        this.identificacion=identificacion;
        mostradordeusuario.setText(nombreUsuario + " " + apellidoUsuario);
        mostradordeusuario.setEditable(false);
        disableComponents();
    }
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Imagenlogo.png"));
        
        return retValue;
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
        Autorizacion.setEnabled(false);
        TicketTexto.setEditable(false);
        identificadorDeCita.setEditable(false);
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
        jLabel22 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        volverBoton = new javax.swing.JButton();
        boton5 = new javax.swing.JRadioButton();
        boton1 = new javax.swing.JRadioButton();
        boton2 = new javax.swing.JRadioButton();
        boton3 = new javax.swing.JRadioButton();
        boton4 = new javax.swing.JRadioButton();
        motivo1 = new javax.swing.JRadioButton();
        motivo2 = new javax.swing.JRadioButton();
        motivo3 = new javax.swing.JRadioButton();
        sobreNosotros2 = new javax.swing.JLabel();
        sobreNosotros3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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
        SalaDeEspera = new javax.swing.JButton();

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

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel22)
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
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        volverBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        volverBoton.setForeground(new java.awt.Color(0, 102, 102));
        volverBoton.setText("Inicio");
        volverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBotonActionPerformed(evt);
            }
        });

        boton5.setBackground(new java.awt.Color(255, 255, 255));
        boton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton5.setForeground(new java.awt.Color(102, 102, 102));
        boton5.setText("Dermátologia");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });

        boton1.setBackground(new java.awt.Color(255, 255, 255));
        boton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton1.setForeground(new java.awt.Color(102, 102, 102));
        boton1.setText("Médicina General");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setBackground(new java.awt.Color(255, 255, 255));
        boton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton2.setForeground(new java.awt.Color(102, 102, 102));
        boton2.setText("Pedíatria");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        boton3.setBackground(new java.awt.Color(255, 255, 255));
        boton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton3.setForeground(new java.awt.Color(102, 102, 102));
        boton3.setText("Ginecología");
        boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton3ActionPerformed(evt);
            }
        });

        boton4.setBackground(new java.awt.Color(255, 255, 255));
        boton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        boton4.setForeground(new java.awt.Color(102, 102, 102));
        boton4.setText("Cardiología");
        boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton4ActionPerformed(evt);
            }
        });

        motivo1.setBackground(new java.awt.Color(255, 255, 255));
        motivo1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        motivo1.setForeground(new java.awt.Color(102, 102, 102));
        motivo1.setText("Valoración");
        motivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivo1ActionPerformed(evt);
            }
        });

        motivo2.setBackground(new java.awt.Color(255, 255, 255));
        motivo2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        motivo2.setForeground(new java.awt.Color(102, 102, 102));
        motivo2.setText("Asesoramiento");
        motivo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivo2ActionPerformed(evt);
            }
        });

        motivo3.setBackground(new java.awt.Color(255, 255, 255));
        motivo3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        motivo3.setForeground(new java.awt.Color(102, 102, 102));
        motivo3.setText("Control");
        motivo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivo3ActionPerformed(evt);
            }
        });

        sobreNosotros2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sobreNosotros2.setForeground(new java.awt.Color(0, 102, 153));
        sobreNosotros2.setText("Especialidad Requerida");

        sobreNosotros3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sobreNosotros3.setForeground(new java.awt.Color(0, 102, 153));
        sobreNosotros3.setText("Motivo de Cita");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sobreNosotros2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sobreNosotros3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motivo3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(volverBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sobreNosotros2)
                .addGap(18, 18, 18)
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
                .addGap(29, 29, 29)
                .addComponent(motivo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motivo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motivo3)
                .addGap(18, 18, 18)
                .addComponent(volverBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        DoctorFree1.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        DoctorFree1.setForeground(new java.awt.Color(0, 102, 153));
        DoctorFree1.setText("Identificador de Cita");

        identificadorDeCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        identificadorDeCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorDeCitaActionPerformed(evt);
            }
        });

        DoctorFree2.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        DoctorFree2.setForeground(new java.awt.Color(0, 102, 153));
        DoctorFree2.setText("Ticket");

        TicketTexto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TicketTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketTextoActionPerformed(evt);
            }
        });

        regresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regresar.setForeground(new java.awt.Color(0, 102, 153));
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

        CancelarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelarCita.setForeground(new java.awt.Color(102, 102, 102));
        CancelarCita.setText("Cancelar Cita");
        CancelarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarCitaActionPerformed(evt);
            }
        });

        VisualizarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VisualizarCita.setForeground(new java.awt.Color(102, 102, 102));
        VisualizarCita.setText("Visualizar Citas");
        VisualizarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarCitaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("identificador son correctos y verifique si selecciono una especialidad y motivo");

        SalaDeEspera.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SalaDeEspera.setForeground(new java.awt.Color(102, 102, 102));
        SalaDeEspera.setText("Sala de espera");
        SalaDeEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalaDeEsperaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(regresar)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DoctorFree1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(identificadorDeCita, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Autorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(55, 55, 55)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TicketTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(DoctorFree2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(VisualizarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CancelarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SalaDeEspera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DoctorFree1)
                            .addComponent(SalaDeEspera)
                            .addComponent(DoctorFree2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(identificadorDeCita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TicketTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(Autorizacion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(regresar)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CancelarCita)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VisualizarCita)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void SalaDeEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalaDeEsperaActionPerformed
        this.dispose();
        EntradadePasarASalaDeEspera inic =
        new EntradadePasarASalaDeEspera(nombreUsuario, apellidoUsuario,
        identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_SalaDeEsperaActionPerformed

    private void VisualizarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarCitaActionPerformed
        this.dispose();
        visualizarCitas view=new visualizarCitas(nombreUsuario, apellidoUsuario,
        identificacion);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setResizable(false);
    }//GEN-LAST:event_VisualizarCitaActionPerformed

    private void CancelarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarCitaActionPerformed
        this.dispose();
        //obtenemos el respectivo texto de especi y motivo 
        //para pasarlo al otro frame de cancelacion de citas
        //con los parametros ya escogidos
        String especialidadSeleccionadaTexto = "";
        String motivoSeleccionadoTexto="";
        if (boton1.isSelected()) especialidadSeleccionadaTexto = boton1.getText();
        else if (boton2.isSelected()) especialidadSeleccionadaTexto = boton2.getText();
        else if (boton3.isSelected()) especialidadSeleccionadaTexto = boton3.getText();
        else if (boton4.isSelected()) especialidadSeleccionadaTexto = boton4.getText();
        else if (boton5.isSelected()) especialidadSeleccionadaTexto = boton5.getText();

        // Verificamos el motivo seleccionado
        if (motivo1.isSelected()) motivoSeleccionadoTexto = motivo1.getText();
        else if (motivo2.isSelected()) motivoSeleccionadoTexto = motivo2.getText();
        else if (motivo3.isSelected()) motivoSeleccionadoTexto = motivo3.getText();

        cancelacionDeCitas cancel=new cancelacionDeCitas(nombreUsuario,
        apellidoUsuario,identificacion,especialidadSeleccionadaTexto,motivoSeleccionadoTexto);
        cancel.setVisible(true);
        cancel.setLocationRelativeTo(null);
        cancel.setResizable(false);
    }//GEN-LAST:event_CancelarCitaActionPerformed

    private void mostradordeusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostradordeusuarioActionPerformed

    }//GEN-LAST:event_mostradordeusuarioActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        this.dispose();
        cancelacionDeCitas cancel= new cancelacionDeCitas(nombreUsuario,
        apellidoUsuario, identificacion);
        cancel.setVisible(true);
        cancel.setLocationRelativeTo(null);
        cancel.setResizable(false);
    }//GEN-LAST:event_regresarActionPerformed

    private void TicketTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketTextoActionPerformed

    }//GEN-LAST:event_TicketTextoActionPerformed

    private void identificadorDeCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorDeCitaActionPerformed

    }//GEN-LAST:event_identificadorDeCitaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        InicioDeSesion inic= new InicioDeSesion();
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void motivo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivo3ActionPerformed
        motivo1.setSelected(false);
        motivo2.setSelected(false);
    }//GEN-LAST:event_motivo3ActionPerformed

    private void motivo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivo2ActionPerformed
        motivo1.setSelected(false);
        motivo3.setSelected(false);
    }//GEN-LAST:event_motivo2ActionPerformed

    private void motivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivo1ActionPerformed
        motivo2.setSelected(false);
        motivo3.setSelected(false);
    }//GEN-LAST:event_motivo1ActionPerformed

    private void boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton4ActionPerformed
        boton1.setSelected(false);
        boton2.setSelected(false);
        boton3.setSelected(false);
        boton5.setSelected(false);
    }//GEN-LAST:event_boton4ActionPerformed

    private void boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton3ActionPerformed
        boton1.setSelected(false);
        boton2.setSelected(false);
        boton4.setSelected(false);
        boton5.setSelected(false);
    }//GEN-LAST:event_boton3ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        boton3.setSelected(false);
        boton4.setSelected(false);
        boton5.setSelected(false);
        boton1.setSelected(false);
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        boton2.setSelected(false);
        boton3.setSelected(false);
        boton4.setSelected(false);
        boton5.setSelected(false);
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed
        boton1.setSelected(false);
        boton2.setSelected(false);
        boton3.setSelected(false);
        boton4.setSelected(false);
    }//GEN-LAST:event_boton5ActionPerformed

    private void volverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBotonActionPerformed
        InicioDeSesionExitoso inix= new InicioDeSesionExitoso(nombreUsuario,
        apellidoUsuario, identificacion);
        this.dispose();
        inix.setVisible(true);
        inix.setLocationRelativeTo(null);
        inix.setResizable(false);
    }//GEN-LAST:event_volverBotonActionPerformed

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
        PrimeraEntradaAutorizacion prim =
        new PrimeraEntradaAutorizacion();
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
        this.dispose();
        Principal princ=new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
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
    private javax.swing.JButton CancelarCita;
    private javax.swing.JLabel DoctorFree1;
    private javax.swing.JLabel DoctorFree2;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JButton SalaDeEspera;
    private javax.swing.JTextField TicketTexto;
    private javax.swing.JButton VisualizarCita;
    private javax.swing.JRadioButton boton1;
    private javax.swing.JRadioButton boton2;
    private javax.swing.JRadioButton boton3;
    private javax.swing.JRadioButton boton4;
    private javax.swing.JRadioButton boton5;
    private javax.swing.JTextField identificadorDeCita;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JButton regresar;
    private javax.swing.JLabel sobreNosotros2;
    private javax.swing.JLabel sobreNosotros3;
    private javax.swing.JButton volverBoton;
    // End of variables declaration//GEN-END:variables
}
