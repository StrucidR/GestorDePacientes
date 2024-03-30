package com.asistentemedico.asistentedecitas.igu.autorizacion;

import com.asistentemedico.asistentedecitas.igu.pagodecitas.*;
import com.asistentemedico.asistentedecitas.igu.InicioDeSesion.InicioDeSesion;
import com.asistentemedico.asistentedecitas.igu.Principal.Principal;
import com.asistentemedico.asistentedecitas.igu.Registro.Registro;
import com.asistentemedico.asistentedecitas.igu.examenes.EntradadeExamenes;
import javax.swing.JTextArea;

public class ustedYaCuentaConUnaAutorizacion extends javax.swing.JFrame {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacion;
    private String identificadorDeCita;
    private String ticket;
    private String precio;
    private String descripcion;
    private String identificadorDeAutorizacion;
    
    public static void insertFormattedText(JTextArea textArea, String text) {
        
        StringBuilder formattedText = new StringBuilder();
        String[] words = text.split("\\s+");
        int lineWidth = 55;
        int currentLineWidth = 0;

        for (String word : words) {
            if (currentLineWidth + word.length() > lineWidth) {
                formattedText.append("\n");
                currentLineWidth = 0;
            }
            formattedText.append(word).append(" ");
            currentLineWidth += word.length() + 3;
        }
        textArea.setText(formattedText.toString().trim());
    }
    
    public ustedYaCuentaConUnaAutorizacion(String nombreUsuario,
            String apellidoUsuario, String identificacion, String identificadorDeCita,
            String ticket, String especialidadMotivosSeleccionados, String precio,
            String descripcion, String identificadorDeAutorizacion) {
        
        initComponents();
        
        this.nombreUsuario=nombreUsuario;
        this.apellidoUsuario=apellidoUsuario;
        this.identificacion=identificacion;
        this.identificadorDeCita=identificadorDeCita;
        this.ticket=ticket;
        this.precio=precio;
        this.descripcion=descripcion;
        this.identificadorDeAutorizacion=identificadorDeAutorizacion;
        
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
        
        precioEntrada.setText(precio);
        precioEntrada.setEditable(false);
       
        insertFormattedText(descripcionEntrada, descripcion);
        descripcionEntrada.setEditable(false);
        
        identificadorDeAutorizacionEntrada.setText(identificadorDeAutorizacion);
        identificadorDeAutorizacionEntrada.setEditable(false);
        
        marcarBotones(especialidadMotivosSeleccionados);
        disableComponents();
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
        jLabel4 = new javax.swing.JLabel();
        nombreEntrada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ApellidoEntrada = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        IdentificacionEntrada = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        IdentificadorDeCitaEntrada = new javax.swing.JTextField();
        salir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ticketEntrada = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        examen1 = new javax.swing.JRadioButton();
        examen2 = new javax.swing.JRadioButton();
        examen3 = new javax.swing.JRadioButton();
        examen4 = new javax.swing.JRadioButton();
        examen5 = new javax.swing.JRadioButton();
        examen6 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        precioEntrada = new javax.swing.JTextField();
        AutorizacionYSeccionDeExamenes = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionEntrada = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        identificadorDeAutorizacionEntrada = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        salir1 = new javax.swing.JButton();

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

        IdentificadorDeCitaEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        IdentificadorDeCitaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdentificadorDeCitaEntradaActionPerformed(evt);
            }
        });

        salir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 102, 102));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Ticket:");

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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("PRECIO");

        precioEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        precioEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioEntradaActionPerformed(evt);
            }
        });

        AutorizacionYSeccionDeExamenes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AutorizacionYSeccionDeExamenes.setForeground(new java.awt.Color(0, 102, 102));
        AutorizacionYSeccionDeExamenes.setText("Pasar  a exámenes");
        AutorizacionYSeccionDeExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutorizacionYSeccionDeExamenesActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Descripción del examen");

        descripcionEntrada.setColumns(20);
        descripcionEntrada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descripcionEntrada.setRows(5);
        jScrollPane1.setViewportView(descripcionEntrada);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Identificador de Autorización");

        identificadorDeAutorizacionEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        identificadorDeAutorizacionEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                identificadorDeAutorizacionEntradaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Su orden ha sido autorizada");

        salir1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        salir1.setForeground(new java.awt.Color(0, 102, 102));
        salir1.setText("Volver");
        salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir1ActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(salir)
                        .addGap(26, 26, 26)
                        .addComponent(AutorizacionYSeccionDeExamenes)
                        .addGap(22, 22, 22)
                        .addComponent(salir1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdentificadorDeCitaEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdentificacionEntrada)
                            .addComponent(ApellidoEntrada))
                        .addComponent(nombreEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ticketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(246, 246, 246)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(examen1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examen4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(examen2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(examen5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(precioEntrada, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(examen6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(examen3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(identificadorDeAutorizacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ticketEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ApellidoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(examen1)
                            .addComponent(examen2)
                            .addComponent(examen3))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
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
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdentificadorDeCitaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(identificadorDeAutorizacionEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutorizacionYSeccionDeExamenes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salir1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117)
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

    private void IdentificadorDeCitaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdentificadorDeCitaEntradaActionPerformed
         validarCampos();
    }//GEN-LAST:event_IdentificadorDeCitaEntradaActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
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

    private void AutorizacionYSeccionDeExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorizacionYSeccionDeExamenesActionPerformed
       
    }//GEN-LAST:event_AutorizacionYSeccionDeExamenesActionPerformed

    private void identificadorDeAutorizacionEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_identificadorDeAutorizacionEntradaActionPerformed

    }//GEN-LAST:event_identificadorDeAutorizacionEntradaActionPerformed

    private void salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir1ActionPerformed
        this.dispose();
        PrimeraEntradaAutorizacion sala = new PrimeraEntradaAutorizacion();
        sala.setVisible(true);
        sala.setLocationRelativeTo(null);
        sala.setResizable(false);
    }//GEN-LAST:event_salir1ActionPerformed
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
    return !nombreEntrada.getText().isEmpty() && !ApellidoEntrada.getText().isEmpty() && !IdentificacionEntrada.getText().isEmpty() && !IdentificadorDeCitaEntrada.getText().isEmpty();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellidoEntrada;
    private javax.swing.JButton AutorizacionYSeccionDeExamenes;
    private javax.swing.JButton Autorizacionboton;
    private javax.swing.JTextField IdentificacionEntrada;
    private javax.swing.JTextField IdentificadorDeCitaEntrada;
    private javax.swing.JButton IniciarSesionboton;
    private javax.swing.JButton PagoDeCitasboton;
    private javax.swing.JButton PagoDeCitasboton1;
    private javax.swing.JTextArea descripcionEntrada;
    private javax.swing.JRadioButton examen1;
    private javax.swing.JRadioButton examen2;
    private javax.swing.JRadioButton examen3;
    private javax.swing.JRadioButton examen4;
    private javax.swing.JRadioButton examen5;
    private javax.swing.JRadioButton examen6;
    private javax.swing.JTextField identificadorDeAutorizacionEntrada;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lobbyboton;
    private javax.swing.JTextField nombreEntrada;
    private javax.swing.JTextField precioEntrada;
    private javax.swing.JButton salir;
    private javax.swing.JButton salir1;
    private javax.swing.JTextField ticketEntrada;
    // End of variables declaration//GEN-END:variables
}
