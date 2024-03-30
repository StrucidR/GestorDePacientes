package com.asistentemedico.asistentedecitas.igu.autorizacion;

import com.asistentemedico.asistentedecitas.igu.pagodecitas.*;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import com.asistentemedico.asistentedecitas.persistencia.Autorizacion.GestorAutorizacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PasarASalaDeAutorizacion extends javax.swing.JFrame {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacion;
    private String identificadorDeCita;
    private String ticket;
    private String ticketDeAutorizacion;
    
    private Timer timer;
    private int tiempoRestante;
    
    public PasarASalaDeAutorizacion(String nombreUsuario, String apellidoUsuario, String identificacion,
            String identificadorDeCita, String ticket, 
            String especialidadMotivoSeleccionados, int costo, 
            String descripcionPrincipal, int identificadordeautorizacion,
            String ticketDeAutorizacion) {
        initComponents();
        
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsuario=apellidoUsuario;
        this.identificacion=identificacion;
        this.identificadorDeCita=identificadorDeCita;
        this.ticket=ticket;
        this.ticketDeAutorizacion=ticketDeAutorizacion;
        
        nombreEntrada.setText(nombreUsuario);
        nombreEntrada.setEditable(false);
        
        ApellidoEntrada.setText(apellidoUsuario);
        ApellidoEntrada.setEditable(false);
        
        IdentificacionEntrada.setText(identificacion);
        IdentificacionEntrada.setEditable(false);
        
        IdentificadorDeCitaEntrada.setText(identificadorDeCita);
        IdentificadorDeCitaEntrada.setEditable(false);
        
        ticketEntrada.setText(ticket);
        ticketEntrada.setEditable(false);
        
        precioEntrada.setText(String.valueOf(costo));
        precioEntrada.setEditable(false);
        
        descripcion.setText(descripcionPrincipal);
        descripcion.setEditable(false);
       
        identificadorEntrada.setText(String.valueOf(identificadordeautorizacion));
        identificadorEntrada.setEditable(false);
        
        ticketAutorizacionEntrada.setText(ticketDeAutorizacion);
        ticketAutorizacionEntrada.setEditable(false);
        
        marcarBotones(especialidadMotivoSeleccionados);
        disableComponents();
        
        pasarASala.setEnabled(false);
        tiempoRestante=60;
        iniciarTemporizador();
    }
        private void disableComponents(){
        examen1.setEnabled(false);
        examen2.setEnabled(false);
        examen3.setEnabled(false);
        examen4.setEnabled(false);
        examen5.setEnabled(false);
        examen6.setEnabled(false);
    }
        
        
        private void marcarBotones(String especialidadMotivoSeleccionados){
    String [] especialidadMotivo = especialidadMotivoSeleccionados.split
        (", ");
    
    for(String esp: especialidadMotivo){
        if(esp.equals(examen1.getText())) examen1.setSelected(true);
        if(esp.equals(examen2.getText())) examen2.setSelected(true);
        if(esp.equals(examen3.getText())) examen3.setSelected(true);
        if(esp.equals(examen4.getText())) examen4.setSelected(true);
        if(esp.equals(examen5.getText())) examen5.setSelected(true);
        if(esp.equals(examen6.getText())) examen6.setSelected(true);
        
    }
}
    private void iniciarTemporizador() {
          // Configurar el temporizador para que se actualice cada segundo
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoRestante--;
                if (tiempoRestante >= 0) {
                    actualizarEtiquetaTiempo();
                } else {
                    detenerTemporizador();
                }
            }
        });
        timer.start();
    }
          
    private void actualizarEtiquetaTiempo() {
        int minutos = tiempoRestante / 60;
        int segundos = tiempoRestante % 60;
        etiquetaTiempo.setText(String.format("%02d:%02d", 
                minutos, segundos));
        
        if(tiempoRestante==0){
            pasarASala.setEnabled(true);
            detenerTemporizador();
        }
    }

    private void detenerTemporizador() {
        timer.stop();
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
        Nombre = new javax.swing.JLabel();
        nombreEntrada = new javax.swing.JTextField();
        Apellido = new javax.swing.JLabel();
        ApellidoEntrada = new javax.swing.JTextField();
        Identificacion = new javax.swing.JLabel();
        IdentificacionEntrada = new javax.swing.JTextField();
        citaIdentificador = new javax.swing.JLabel();
        IdentificadorDeCitaEntrada = new javax.swing.JTextField();
        salir = new javax.swing.JButton();
        Ticket = new javax.swing.JLabel();
        ticketEntrada = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        examen1 = new javax.swing.JRadioButton();
        examen2 = new javax.swing.JRadioButton();
        examen3 = new javax.swing.JRadioButton();
        examen4 = new javax.swing.JRadioButton();
        examen5 = new javax.swing.JRadioButton();
        examen6 = new javax.swing.JRadioButton();
        Precio = new javax.swing.JLabel();
        precioEntrada = new javax.swing.JTextField();
        pasarASala = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        identificadorEntrada = new javax.swing.JTextField();
        etiquetaTiempo = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ticketAutorizacionEntrada = new javax.swing.JTextField();

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

        Nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Nombre.setForeground(new java.awt.Color(102, 102, 102));
        Nombre.setText("Nombre(S):");

        nombreEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nombreEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreEntradaActionPerformed(evt);
            }
        });

        Apellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Apellido.setForeground(new java.awt.Color(102, 102, 102));
        Apellido.setText("Apellido(S):");

        ApellidoEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ApellidoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApellidoEntradaActionPerformed(evt);
            }
        });

        Identificacion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Identificacion.setForeground(new java.awt.Color(102, 102, 102));
        Identificacion.setText("Identificación:");

        IdentificacionEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        IdentificacionEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdentificacionEntradaActionPerformed(evt);
            }
        });

        citaIdentificador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        citaIdentificador.setForeground(new java.awt.Color(102, 102, 102));
        citaIdentificador.setText("Identificador de la cita:");

        IdentificadorDeCitaEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        IdentificadorDeCitaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdentificadorDeCitaEntradaActionPerformed(evt);
            }
        });

        salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 102, 102));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        Ticket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ticket.setForeground(new java.awt.Color(102, 102, 102));
        Ticket.setText("Ticket:");

        ticketEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ticketEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketEntradaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Tipo de Examen a Autorizar");

        examen1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen1.setForeground(new java.awt.Color(0, 102, 102));
        examen1.setText("Sangíneo");
        examen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen1ActionPerformed(evt);
            }
        });

        examen2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen2.setForeground(new java.awt.Color(0, 102, 102));
        examen2.setText("Cenfálico");
        examen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen2ActionPerformed(evt);
            }
        });

        examen3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen3.setForeground(new java.awt.Color(0, 102, 102));
        examen3.setText("Cráneo");
        examen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen3ActionPerformed(evt);
            }
        });

        examen4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen4.setForeground(new java.awt.Color(0, 102, 102));
        examen4.setText("Radiográfia");
        examen4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen4ActionPerformed(evt);
            }
        });

        examen5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen5.setForeground(new java.awt.Color(0, 102, 102));
        examen5.setText("Orína");
        examen5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen5ActionPerformed(evt);
            }
        });

        examen6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        examen6.setForeground(new java.awt.Color(0, 102, 102));
        examen6.setText("Próstata");
        examen6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examen6ActionPerformed(evt);
            }
        });

        Precio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Precio.setForeground(new java.awt.Color(102, 102, 102));
        Precio.setText("PRECIO");

        precioEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioEntradaActionPerformed(evt);
            }
        });

        pasarASala.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pasarASala.setForeground(new java.awt.Color(0, 102, 102));
        pasarASala.setText("Pasar  a Sala");
        pasarASala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarASalaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Descripción del examen");

        descripcion.setColumns(20);
        descripcion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descripcion.setRows(5);
        jScrollPane1.setViewportView(descripcion);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Identificador de Autorización");

        identificadorEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        etiquetaTiempo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        etiquetaTiempo.setForeground(new java.awt.Color(0, 102, 102));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Por favor espere a que asignemos su solicitud de autorización a la sala para ser confirmada");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Si te sales se eliminara la solicitud ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Ticket de autorización");

        ticketAutorizacionEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(citaIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IdentificadorDeCitaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                        .addComponent(Identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IdentificacionEntrada)
                        .addComponent(ApellidoEntrada))
                    .addComponent(nombreEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pasarASala)))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(246, 246, 246)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ticketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                            .addComponent(examen3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(precioEntrada, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Precio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(identificadorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ticketAutorizacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nombre)
                            .addComponent(Ticket)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nombreEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ticketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Apellido)
                                    .addComponent(jLabel9))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ApellidoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examen1)
                                    .addComponent(examen2)
                                    .addComponent(examen3))
                                .addGap(18, 18, 18)
                                .addComponent(Identificacion))
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IdentificacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(examen4)
                                    .addComponent(examen5)
                                    .addComponent(examen6))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(citaIdentificador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Precio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdentificadorDeCitaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pasarASala, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(etiquetaTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(identificadorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ticketAutorizacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)))
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(61, 61, 61)
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
        GestorAutorizacion.eliminarAutorizacion(nombreUsuario, 
 apellidoUsuario, identificacion, identificadorDeCita, 
        ticket);
        this.dispose();
        Registro regis= new Registro();
        regis.setVisible(true);
        regis.setLocationRelativeTo(null);
        regis.setResizable(false);
    }//GEN-LAST:event_lobbybotonActionPerformed

    private void IniciarSesionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarSesionbotonActionPerformed
         GestorAutorizacion.eliminarAutorizacion(nombreUsuario, 
  apellidoUsuario, identificacion, identificadorDeCita, 
        ticket);
        this.dispose();
        InicioDeSesion princ=new InicioDeSesion();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_IniciarSesionbotonActionPerformed

    private void AutorizacionbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionbotonActionPerformed
        GestorAutorizacion.eliminarAutorizacion(nombreUsuario, 
 apellidoUsuario, identificacion, identificadorDeCita,
        ticket);
        this.dispose();
        Principal princ=new Principal();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_AutorizacionbotonActionPerformed

    private void PagoDeCitasbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasbotonActionPerformed
        GestorAutorizacion.eliminarAutorizacion(nombreUsuario, 
 apellidoUsuario, identificacion, identificadorDeCita, 
        ticket);
        this.dispose();
        pagodeCitasPrimeraEntrada princ=new pagodeCitasPrimeraEntrada();
        princ.setVisible(true);
        princ.setLocationRelativeTo(null);
        princ.setResizable(false);
    }//GEN-LAST:event_PagoDeCitasbotonActionPerformed

    private void PagoDeCitasboton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoDeCitasboton1ActionPerformed
        GestorAutorizacion.eliminarAutorizacion(nombreUsuario, 
        apellidoUsuario, identificacion, identificadorDeCita, 
        ticket);
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

    private void IdentificadorDeCitaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdentificadorDeCitaEntradaActionPerformed
         validarCampos();
    }//GEN-LAST:event_IdentificadorDeCitaEntradaActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        GestorAutorizacion.eliminarAutorizacion(nombreUsuario, 
 apellidoUsuario, identificacion, identificadorDeCita, 
        ticket);
        this.dispose();
        Principal sala = new Principal();
        sala.setVisible(true);
        sala.setLocationRelativeTo(null);
        sala.setResizable(false);
    }//GEN-LAST:event_salirActionPerformed

    private void ticketEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketEntradaActionPerformed
        validarCampos();
    }//GEN-LAST:event_ticketEntradaActionPerformed

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

    private void precioEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioEntradaActionPerformed

    }//GEN-LAST:event_precioEntradaActionPerformed

    private void pasarASalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarASalaActionPerformed
        String textPrecio = precioEntrada.getText();
        int precio = Integer.parseInt(textPrecio);
        
        String textIdentificadorAutorizacion = identificadorEntrada.getText();
        int identificadordeautorizacion = Integer.parseInt(textIdentificadorAutorizacion);
        
        String descripcion = generarDescripcion();
        
        StringBuilder tipoExamenBuilder = new StringBuilder();
        if (examen1.isSelected()) tipoExamenBuilder.append
        (examen1.getText()).append(", ");
        if (examen2.isSelected()) tipoExamenBuilder.append
        (examen2.getText()).append(", ");
        if (examen3.isSelected()) tipoExamenBuilder.append
        (examen3.getText()).append(", ");
        if (examen4.isSelected()) tipoExamenBuilder.append
        (examen4.getText()).append(", ");
        if (examen5.isSelected()) tipoExamenBuilder.append
        (examen5.getText()).append(", ");
        if (examen6.isSelected()) tipoExamenBuilder.append
        (examen6.getText()).append(", ");

         // Eliminar la coma adicional si hay al menos un examen seleccionado
        String tipoExamen = tipoExamenBuilder.length() > 0 ?
        tipoExamenBuilder.substring(0, tipoExamenBuilder.length() - 2) : "";
                
        GestorAutorizacion.guardarEnSalaDeEspera(
   nombreUsuario, apellidoUsuario, identificacion, 
  identificadorDeCita, ticket, precio,tipoExamen, 
        identificadordeautorizacion,descripcion);
        
        this.dispose();
        SalaDeEsperaDeAutorizaciones prim = new SalaDeEsperaDeAutorizaciones
        (identificadordeautorizacion);
        prim.setVisible(true);
        prim.setLocationRelativeTo(null);
        prim.setResizable(false);
    }//GEN-LAST:event_pasarASalaActionPerformed
    private void validarCampos() {
    // Verifica si los campos están completados correctamente
    boolean camposValidos = true;
    try {
        Integer.parseInt(IdentificacionEntrada.getText());
        Integer.parseInt(IdentificadorDeCitaEntrada.getText());
        Integer.parseInt(ticketEntrada.getText());
    } catch (NumberFormatException e) {
        // Si alguno de los campos no es un número, marca los campos como no válidos
        camposValidos = false;
    }

    // Habilita o deshabilita el botón según si los campos son válidos o no
    salir.setEnabled(camposValidos);
}

private boolean camposCompletos() {
    // Verifica si todos los campos están completados
    return !nombreEntrada.getText().isEmpty() &&
            !ApellidoEntrada.getText().isEmpty() && 
            !IdentificacionEntrada.getText().isEmpty() &&
            !IdentificadorDeCitaEntrada.getText().isEmpty();
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
                descripcion = "Un examen de sangre que evalúa diversos parámetros"
                        + "como células sanguíneas niveles de glucosa lípidos electrolitos"
                        + "y función de órganos como el hígado y los riñones entre otros";
                break;
            case "Cenfálico":
                descripcion = "Un examen que se enfoca en la región de la cabeza"
                        + "incluyendo el cerebro los nervios craneales y la"
                        + "circulación sanguínea en esta área Puede involucrar"
                        + "técnicas de imagen como la resonancia magnética o la"
                        + "tomografía computarizada";
                break;
            case "Cráneo":
                descripcion = "Un examen radiográfico que se centra específicamente en los"
                        + "huesos del cráneo para evaluar su estructura integridad"
                        + "y posibles lesiones como fracturas o anomalías óseas";
                break;
            case "Radiográfia":
                descripcion = "Un examen de imagen que utiliza rayos X para"
                        + "producir imágenes de estructuras internas del cuerpo"
                        + "como huesos órganos y tejidos blandos con el fin de"
                        + "diagnosticar diversas condiciones médicas";
                break;
            case "Orína":
                descripcion = "Un análisis de la composición y características"
                        + "de la orina que puede proporcionar información sobre"
                        + "la función renal ";
                break;
            case "Próstata":
                descripcion = "Un examen que evalúa la salud de la próstata"
                        + "especialmente en hombres a menudo realizado mediante"
                        + "un examen físico (toque rectal) y análisis de sangre"
                        + "para medir el antígeno prostático específico (PSA)"
                        + "que puede indicar problemas como la hiperplasia"
                        + "prostática benigna o el cáncer de próstata";
                break;
        }
    }

    return descripcion;
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apellido;
    private javax.swing.JTextField ApellidoEntrada;
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JLabel Identificacion;
    private javax.swing.JTextField IdentificacionEntrada;
    private javax.swing.JTextField IdentificadorDeCitaEntrada;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JLabel Precio;
    private javax.swing.JLabel Ticket;
    private javax.swing.JLabel citaIdentificador;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JLabel etiquetaTiempo;
    private javax.swing.JRadioButton examen1;
    private javax.swing.JRadioButton examen2;
    private javax.swing.JRadioButton examen3;
    private javax.swing.JRadioButton examen4;
    private javax.swing.JRadioButton examen5;
    private javax.swing.JRadioButton examen6;
    private javax.swing.JTextField identificadorEntrada;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lobbyboton;
    private javax.swing.JTextField nombreEntrada;
    private javax.swing.JButton pasarASala;
    private javax.swing.JTextField precioEntrada;
    private javax.swing.JButton salir;
    private javax.swing.JTextField ticketAutorizacionEntrada;
    private javax.swing.JTextField ticketEntrada;
    // End of variables declaration//GEN-END:variables
}
