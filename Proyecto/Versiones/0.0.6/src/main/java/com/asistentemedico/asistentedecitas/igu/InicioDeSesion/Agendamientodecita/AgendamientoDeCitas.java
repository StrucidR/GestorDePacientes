package com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita;

import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita.cancelacion.cancelacionDeCitas;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Agendamientodecita.visualizadordecitas.visualizarCitas;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.Saladeespera.EntradadePasarASalaDeEspera;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesionExitoso;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.autorizacion.PrimeraEntradaAutorizacion;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.igu.pagodecitas.pagodeCitasPrimeraEntrada;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AgendamientoDeCitas extends javax.swing.JFrame {
    
    private String nombreUsuario;//variables que usaremos para establecer
    private String apellidoUsaurio;//texto u manipular acciones o datos
    private String identificacion;
    
    public AgendamientoDeCitas(String nombreUsuario,String apellidoUsaurio, 
    String identificacion,String especialidadMotivoSeleccionados, String motivoSeleccionado) {
        //le pasamos al constructor los parametros que espera
        initComponents();
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsaurio=apellidoUsaurio;
        this.identificacion=identificacion;
        //Establecemos en el recuadro de mostradordeUsuario para que el usuario
        //tenga una experiencia mas personal
        mostradordeusuario.setText(nombreUsuario + " " + apellidoUsaurio);
        mostradordeusuario.setEditable(false);
        
        marcarBotonesporespecialidad(especialidadMotivoSeleccionados);
        marcarBotonespormotivo(motivoSeleccionado);
        //desactivamos botones que ya vienen marcados y marcamos botones
        disableComponents();//por medio del text que le pasamos a la variable
        
        //Configuramos el campo con el valor que se genera y hacemos una 
        //conversion de int a String para visualizar y establecer en el campo
        identificadorDeCita.setText(String.valueOf(
        generarIdentificadorDeCita()));
        //Configuracion del campo Ticket con el valor respectivo
        Ticket.setText(generarTicket());
        //Establecemos la cadena haciendo una conversion de int a String
        Costo.setText(String.valueOf(generarCosto()));
        identificadorDeCita.setEditable(false);
        Ticket.setEditable(false);
        Costo.setEditable(false);
        
    }
    
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Imagenlogo.png"));
        
        return retValue;
    }//DESHABILITA COMPONENTES PARA EL CORRECTO FUNCIONAMIENTO
        private void disableComponents() {
        boton1.setEnabled(false);
        boton2.setEnabled(false);
        boton3.setEnabled(false);
        boton4.setEnabled(false);
        boton5.setEnabled(false);
        motivo1.setEnabled(false);
        motivo2.setEnabled(false);
        motivo3.setEnabled(false);
        
        if(boton2.isSelected() || boton3.isSelected()){
            doctorJuanCarlos.setEnabled(true);
            doctorJeison.setEnabled(true);
            doctorArango.setEnabled(false);
        }else if(boton4.isSelected() || boton5.isSelected()){
            doctorJuanCarlos.setEnabled(false);
            doctorJeison.setEnabled(true);
            doctorArango.setEnabled(true); 
        }else{
            doctorJuanCarlos.setEnabled(false);
            doctorJeison.setEnabled(false);
            doctorArango.setEnabled(true); 
        }
    }
        
        public AgendamientoDeCitas(){
            initComponents();
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
        jLabel22 = new javax.swing.JLabel();
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
        motivo1 = new javax.swing.JRadioButton();
        motivo2 = new javax.swing.JRadioButton();
        motivo3 = new javax.swing.JRadioButton();
        volverBoton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        DoctorFree = new javax.swing.JLabel();
        doctorArango = new javax.swing.JRadioButton();
        doctorJeison = new javax.swing.JRadioButton();
        doctorJuanCarlos = new javax.swing.JRadioButton();
        DoctorFree1 = new javax.swing.JLabel();
        identificadorDeCita = new javax.swing.JTextField();
        DoctorFree2 = new javax.swing.JLabel();
        Ticket = new javax.swing.JTextField();
        costo = new javax.swing.JLabel();
        Costo = new javax.swing.JTextField();
        PagarBoton = new javax.swing.JRadioButton();
        ConfirmarCita = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mostradordeusuario = new javax.swing.JTextField();
        CancelarCita1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        VisualizarCita = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        jPanel2.setBackground(new java.awt.Color(235, 235, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Asistente de Citas Médicas");

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

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenlogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel22)
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
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lobbyboton)
                        .addComponent(IniciarSesionboton)
                        .addComponent(Autorizacionboton)
                        .addComponent(PagoDeCitasboton)
                        .addComponent(PagoDeCitasboton1))
                    .addComponent(jLabel3)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
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

        sobreNosotros2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sobreNosotros2.setForeground(new java.awt.Color(0, 102, 153));
        sobreNosotros2.setText("Especialidad Requerida");

        sobreNosotros3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sobreNosotros3.setForeground(new java.awt.Color(0, 102, 153));
        sobreNosotros3.setText("Motivo de Cita");

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

        volverBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        volverBoton.setForeground(new java.awt.Color(0, 102, 153));
        volverBoton.setText("Volver");
        volverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBotonActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sobreNosotros2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sobreNosotros3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motivo3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motivo2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motivo1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(volverBoton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(motivo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motivo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(motivo3)
                .addGap(45, 45, 45)
                .addComponent(volverBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        DoctorFree.setFont(new java.awt.Font("Segoe UI Variable", 1, 28)); // NOI18N
        DoctorFree.setForeground(new java.awt.Color(0, 102, 153));
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
        DoctorFree1.setForeground(new java.awt.Color(0, 102, 153));
        DoctorFree1.setText("Identificador de Cita");

        identificadorDeCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        identificadorDeCita.setForeground(new java.awt.Color(102, 102, 102));
        identificadorDeCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorDeCitaActionPerformed(evt);
            }
        });

        DoctorFree2.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        DoctorFree2.setForeground(new java.awt.Color(0, 102, 153));
        DoctorFree2.setText("Ticket");

        Ticket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ticket.setForeground(new java.awt.Color(102, 102, 102));
        Ticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TicketActionPerformed(evt);
            }
        });

        costo.setFont(new java.awt.Font("Segoe UI Variable", 1, 24)); // NOI18N
        costo.setForeground(new java.awt.Color(0, 102, 153));
        costo.setText("Costo");

        Costo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Costo.setForeground(new java.awt.Color(102, 102, 102));
        Costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostoActionPerformed(evt);
            }
        });

        PagarBoton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PagarBoton.setForeground(new java.awt.Color(102, 102, 102));
        PagarBoton.setText("PAGAR");
        PagarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarBotonActionPerformed(evt);
            }
        });

        ConfirmarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ConfirmarCita.setForeground(new java.awt.Color(0, 102, 153));
        ConfirmarCita.setText("CONFIRMAR");
        ConfirmarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarCitaActionPerformed(evt);
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

        CancelarCita1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CancelarCita1.setForeground(new java.awt.Color(102, 102, 102));
        CancelarCita1.setText("Cancelar Cita");
        CancelarCita1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarCita1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("IVA Incluido");

        VisualizarCita.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VisualizarCita.setForeground(new java.awt.Color(102, 102, 102));
        VisualizarCita.setText("Visualizar Citas");
        VisualizarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarCitaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Por defecto usted no podra pagar mientras agenda, solamente los controles");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("ya que son gratuitos para hacer el pago debera dirigirse a pago de Citas hacer la cola y pagar");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Sala de espera");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DoctorFree1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(identificadorDeCita, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(doctorArango, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(doctorJuanCarlos, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(doctorJeison, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DoctorFree, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(mostradordeusuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(VisualizarCita, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(337, 337, 337)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DoctorFree2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(71, 71, 71)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(ConfirmarCita)
                                                .addGap(18, 18, 18)
                                                .addComponent(PagarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelarCita1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jLabel2)
                                                .addGap(7, 7, 7)
                                                .addComponent(mostradordeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(DoctorFree)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(doctorArango)
                                                    .addComponent(doctorJuanCarlos)
                                                    .addComponent(doctorJeison))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CancelarCita1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(VisualizarCita)
                                            .addComponent(DoctorFree1)
                                            .addComponent(DoctorFree2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(identificadorDeCita, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addComponent(costo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ConfirmarCita)
                                .addComponent(PagarBoton)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        PrimeraEntradaAutorizacion prim = 
        new PrimeraEntradaAutorizacion();
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

    private void TicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketActionPerformed

    }//GEN-LAST:event_TicketActionPerformed

    private void CostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostoActionPerformed
       
    }//GEN-LAST:event_CostoActionPerformed

    private void ConfirmarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarCitaActionPerformed
     boolean doctorSeleccionado = doctorArango.isSelected() ||
     doctorJeison.isSelected() || doctorJuanCarlos.isSelected();
    
     //Convertir el texto de identificador de String a int
    int identificador = Integer.parseInt(identificadorDeCita.getText());
    
    // Convertir el texto de Ticket a String
    String ticket = Ticket.getText();
    
    // Convertir el texto de Costo a entero
    int costo1 = Integer.parseInt(Costo.getText()); 
    boolean pagarSeleccionado=PagarBoton.isSelected();
    
    if (doctorSeleccionado) 
    {//Aplicacion de logica similar a la de especialidad y motivo la diferencia
        
          String especialidadSeleccionadaTexto = "";
          String motivoSeleccionadoTexto="";
          String doctorSeleccionado1 = "";
          
          //DEPENDIENDO DE LAS OPCIONES QUE SE ESCOJAN SE AGREGA EL TEXTO PARA GUARDAR AL RESPECTO
          if (boton1.isSelected()) especialidadSeleccionadaTexto = boton1.getText();
          else if (boton2.isSelected()) especialidadSeleccionadaTexto = boton2.getText();
          else if (boton3.isSelected()) especialidadSeleccionadaTexto = boton3.getText();
          else if (boton4.isSelected()) especialidadSeleccionadaTexto = boton4.getText();
          else if (boton5.isSelected()) especialidadSeleccionadaTexto = boton5.getText();

          // Verificamos el motivo seleccionado
          if (motivo1.isSelected()) motivoSeleccionadoTexto = motivo1.getText();
          else if (motivo2.isSelected()) motivoSeleccionadoTexto = motivo2.getText();
          else if (motivo3.isSelected()) motivoSeleccionadoTexto = motivo3.getText();
    
          if (doctorArango.isSelected()) doctorSeleccionado1= doctorArango.getText();
          else if (doctorJeison.isSelected()) doctorSeleccionado1 = doctorJeison.getText();
          else if (doctorJuanCarlos.isSelected()) doctorSeleccionado1= doctorJuanCarlos.getText();

    // Pasar los valores generados al constructor de 
    //confirmacionDelAgendamientoDeLaCita
    confirmacionDelAgendamientoDeLaCita confir = 
    new confirmacionDelAgendamientoDeLaCita(
       nombreUsuario, apellidoUsaurio, identificacion,
       especialidadSeleccionadaTexto,
       identificador, ticket, costo1,
       pagarSeleccionado, doctorSeleccionado1, motivoSeleccionadoTexto
    );

    this.dispose();
    confir.setVisible(true);
    confir.setLocationRelativeTo(null);
    confir.setResizable(false);
    }
    
    else
    {
       //No uso nada en consola ya que se tiene en cuenta que el usuario
       //usara el programa desde la interfaz y el inicio sera en un .exe
    }
    }//GEN-LAST:event_ConfirmarCitaActionPerformed
    //Generamos un identificador de forma aleatoria con el metodo random
    private int generarIdentificadorDeCita(){//perteneciendo a la clase Math 
        return (int)(Math.random()*50000)+1;//interna que se importo
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
    if (boton1.isSelected()) {
        identificacion.append("G"); // Ejemplo de código para medicina general
    } else if (boton2.isSelected()) {
        identificacion.append("P"); // Ejemplo de código para pediatría
    } else if (boton3.isSelected()) {
        identificacion.append("GI"); // Ejemplo de código para ginecología
    } else if (boton4.isSelected()) {
        identificacion.append("C"); // Ejemplo de código para cardiología
    } else if (boton5.isSelected()) {
        identificacion.append("D"); // Ejemplo de código para dermatología
    }

    if (motivo1.isSelected()) {
        identificacion.append("V"); // Ejemplo de código para valoración
    } else if (motivo2.isSelected()) {
        identificacion.append("A"); // Ejemplo de código para asesoramiento
    } else if (motivo3.isSelected()) {
        identificacion.append("C"); // Ejemplo de código para control
    }

    return identificacion.toString();
}
    /**
     * Obtenemos el numero de cita para la identificacion especifica, El # de
     * cita se basa en el contenido del archivo de citas
     * @return 
     */
    private String obtenerSiguienteNumeroCita() {
    //Obtenemos la identificacion de la cita para la cual se necesia
    String identificacion = obtenerIdentificacionEspecialidadMotivo();
    String siguienteNumeroCita = "";

    try {
        //Abrimos el archivo de citas para leer
        FileReader fr = new FileReader(
"src/main/java/com/asistentemedico/asistentedecitas/persistencia/citas.txt");
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
    //Tenemos el metodo generarCosto que extrae primero que opcion se escogio
    //en consecuencia se uso una forma no tan practica, una forma primitiva
    //pero muy efectiva
    private int generarCosto() {
    boolean especialidadSeleccionada = boton1.isSelected() ||
    boton2.isSelected() || boton3.isSelected() ||
    boton4.isSelected() || boton5.isSelected();
    
    boolean motivoSeleccionado=motivo1.isSelected() || motivo2.isSelected()
    || motivo3.isSelected();

    //HACEMOS UNA MARCANCION DE LOS DATOS SELECCIONADOS CON UNA METODOLOGIA NO TAN
    //PRACTICA PERO SI GARANTIZA EL CORRECTO FUNCIONAMIENTO SIN ERRORES 
    if (especialidadSeleccionada && motivoSeleccionado) 
    {
        String especialidad = null;
        String motivo = null;
        
        if (boton1.isSelected() && motivo1.isSelected()) 
        {
            especialidad = boton1.getText();
            motivo = motivo1.getText();
        } 
        else if(boton1.isSelected() && motivo2.isSelected())
        {
            especialidad = boton1.getText();
            motivo = motivo2.getText();
        }
        else if(boton1.isSelected() && motivo3.isSelected())
        {
            especialidad = boton1.getText();
            motivo = motivo3.getText();
        }
 
        else if (boton2.isSelected() && motivo1.isSelected()) 
        {
            especialidad = boton2.getText();
            motivo = motivo1.getText();
        } 
        else if (boton2.isSelected() && motivo2.isSelected()) 
        {
            especialidad = boton2.getText();
            motivo = motivo2.getText();
        } 
        else if (boton2.isSelected() && motivo3.isSelected()) 
        {
            especialidad = boton2.getText();
            motivo = motivo3.getText();
        } 
        
        else if (boton3.isSelected()&& motivo1.isSelected()) 
        {
            especialidad = boton3.getText();
            motivo=motivo1.getText();
        }
        
        else if (boton3.isSelected()&& motivo2.isSelected()) 
        {
            especialidad = boton3.getText();
            motivo=motivo2.getText();
        }
        
        else if (boton3.isSelected()&& motivo3.isSelected()) 
        {
            especialidad = boton3.getText();
            motivo=motivo3.getText();
        }

        else if (boton4.isSelected() && motivo1.isSelected()) 
        {
            especialidad = boton4.getText();
            motivo=motivo1.getText();
        }
        
        else if (boton4.isSelected() && motivo2.isSelected()) 
        {
            especialidad = boton4.getText();
            motivo=motivo2.getText();
        }
        
         else if (boton4.isSelected() && motivo3.isSelected()) 
        {
            especialidad = boton4.getText();
            motivo=motivo3.getText();
        }

        else if (boton5.isSelected() && motivo1.isSelected())
        {
            especialidad = boton5.getText();
            motivo=motivo1.getText();
        }
        
         else if (boton5.isSelected() && motivo2.isSelected())
        {
            especialidad = boton5.getText();
            motivo=motivo2.getText();
        }
        
        else if (boton5.isSelected() && motivo3.isSelected())
        {
            especialidad = boton5.getText();
            motivo=motivo3.getText();
        }
        //Se obtiene el texto para en consecuencia despues evaluar el texto
        //y retornar un precio
        
        //EVALUAMOS EL PRECIO 
        if (especialidad != null && motivo != null &&
                especialidad.equals("Médicina General") && 
                motivo.equals("Valoración")) 
        {
            return 100000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Médicina General") && 
                motivo.equals("Asesoramiento"))
        {
            return 100000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Médicina General") && 
                motivo.equals("Control"))
        {
            return 0;
        }
        
        if (especialidad != null && motivo != null &&
            especialidad.equals("Pedíatria") && 
            motivo.equals("Valoración")) 
        {
            return 150000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Pedíatria") && 
                motivo.equals("Asesoramiento"))
        {
            return 150000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Pedíatria") && 
                motivo.equals("Control"))
        {
            return 0;
        }
       
        if (especialidad != null && motivo != null &&
            especialidad.equals("Ginecología") && 
            motivo.equals("Valoración")) 
        {
            return 150000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Ginecología") && 
                motivo.equals("Asesoramiento"))
        {
            return 150000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Ginecología") && 
                motivo.equals("Control"))
        {
            return 0;
        }
        
        if (especialidad != null && motivo != null &&
        especialidad.equals("Cardiología") && 
        motivo.equals("Valoración")) 
        {
            return 150000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Cardiología") && 
                motivo.equals("Asesoramiento"))
        {
            return 150000;
        }
       
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Cardiología") && 
                motivo.equals("Control"))
        {
            return 0;
        }
       
        if (especialidad != null && motivo != null &&
        especialidad.equals("Dermátologia") && 
        motivo.equals("Valoración")) 
        {
            return 150000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Dermátologia") && 
                motivo.equals("Asesoramiento"))
        {
            return 150000;
        }
        
        else if(especialidad != null && motivo != null &&
                especialidad.equals("Dermátologia") && 
                motivo.equals("Control"))
        {
            return 0;
        }
    }
    // Si no se selecciona ninguna especialidad, se devuelve -1 como señal de error
    return -1;
}
            
    //NO RETORNA NADA SOLAMENTE HACE UNA ACCION DE MARCAR LO ESCOGIDO
    private void marcarBotonesporespecialidad(String especialidadMotivoSeleccionados){
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
    //DEPENDIENDO DE LO ESCOGIDO SE MARCARA EL BOTON DE PAGO
    //YA QUE SI ES CONTROL POR DEFECTO NO SE DEBE PAGAR ENTONCES
    //INTERNAMENTE SE DETECTA COMO PAGO
    private void marcarBotonespormotivo(String motivoSeleccionado){
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

    private void PagarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagarBotonActionPerformed
        
    }//GEN-LAST:event_PagarBotonActionPerformed

    private void CancelarCita1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarCita1ActionPerformed
        cancelacionDeCitas cancel=new cancelacionDeCitas(nombreUsuario
        ,apellidoUsaurio, identificacion);
        cancel.setVisible(true);
        cancel.setLocationRelativeTo(null);
        cancel.setResizable(false);
    }//GEN-LAST:event_CancelarCita1ActionPerformed

    private void VisualizarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarCitaActionPerformed
        this.dispose();
        visualizarCitas view=new visualizarCitas(nombreUsuario, apellidoUsaurio,
        identificacion);
        view.setVisible(true);
        view.setLocationRelativeTo(null);
        view.setResizable(false);
    }//GEN-LAST:event_VisualizarCitaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        InicioDeSesion inic= new InicioDeSesion();
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        EntradadePasarASalaDeEspera inic =
        new EntradadePasarASalaDeEspera(nombreUsuario, apellidoUsaurio,
            identificacion);
        inic.setVisible(true);
        inic.setLocationRelativeTo(null);
        inic.setResizable(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void volverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBotonActionPerformed
        InicioDeSesionExitoso inix= new InicioDeSesionExitoso
        (nombreUsuario, apellidoUsaurio, identificacion);
        this.dispose();
        inix.setVisible(true);
        inix.setLocationRelativeTo(null);
        inix.setResizable(false);
    }//GEN-LAST:event_volverBotonActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JButton CancelarCita1;
    private javax.swing.JButton ConfirmarCita;
    private javax.swing.JTextField Costo;
    private javax.swing.JLabel DoctorFree;
    private javax.swing.JLabel DoctorFree1;
    private javax.swing.JLabel DoctorFree2;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JRadioButton PagarBoton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel sobreNosotros2;
    private javax.swing.JLabel sobreNosotros3;
    private javax.swing.JButton volverBoton;
    // End of variables declaration//GEN-END:variables
}
