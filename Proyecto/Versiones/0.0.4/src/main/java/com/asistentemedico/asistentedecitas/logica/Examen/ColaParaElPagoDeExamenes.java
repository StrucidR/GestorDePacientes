package com.asistentemedico.asistentedecitas.logica.Examen;

public class ColaParaElPagoDeExamenes {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacionDeExamen;
    private String ticketExamen;

    public ColaParaElPagoDeExamenes(String nombreUsuario, String apellidoUsuario, String identificacionDeExamen, String ticketExamen) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.identificacionDeExamen = identificacionDeExamen;
        this.ticketExamen = ticketExamen;
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

    public String getIdentificacionDeExamen() {
        return identificacionDeExamen;
    }

    public void setIdentificacionDeExamen(String identificacionDeExamen) {
        this.identificacionDeExamen = identificacionDeExamen;
    }

    public String getTicketExamen() {
        return ticketExamen;
    }

    public void setTicketExamen(String ticketExamen) {
        this.ticketExamen = ticketExamen;
    }

    @Override
    public String toString() {
        return nombreUsuario + ", " + apellidoUsuario + ", " + identificacionDeExamen + ", " + ticketExamen;
    }
    
}
