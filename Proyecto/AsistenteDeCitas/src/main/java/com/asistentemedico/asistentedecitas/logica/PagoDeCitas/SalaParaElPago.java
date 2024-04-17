package com.asistentemedico.asistentedecitas.logica.PagoDeCitas;

public class SalaParaElPago {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacionUsuario;
    private String ticketCita;

    public SalaParaElPago(String nombreUsuario, String apellidoUsuario, String identificacionUsuario, String ticketCita) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.identificacionUsuario = identificacionUsuario;
        this.ticketCita = ticketCita;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public String getTicketCita() {
        return ticketCita;
    }

    public void setTicketCita(String ticketCita) {
        this.ticketCita = ticketCita;
    }

    @Override
    public String toString() {
        return  nombreUsuario + ", " + apellidoUsuario + ", " + identificacionUsuario + ", " + ticketCita ;
    }
    
}
