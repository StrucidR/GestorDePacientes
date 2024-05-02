package com.asistentemedico.asistentedecitas.logica.Examen;

public class Examen {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacionDeExamen;
    private String ticketDeExamen;
    private String costo;
    private String tipoExamen;
    private String descripcion;
    private String estadoDePago;
    private String asistencia;
    private String identificacionUsuario;

    public Examen(String nombreUsuario, String apellidoUsuario, String identificacionDeExamen, String ticketDeExamen, String costo, String tipoExamen, String descripcion, String estadoDePago, String asistencia,
            String identificacionUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.identificacionDeExamen = identificacionDeExamen;
        this.ticketDeExamen = ticketDeExamen;
        this.costo = costo;
        this.tipoExamen = tipoExamen;
        this.descripcion = descripcion;
        this.estadoDePago = estadoDePago;
        this.asistencia = asistencia;
        this.identificacionUsuario=identificacionUsuario;
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

    public String getTicketDeExamen() {
        return ticketDeExamen;
    }

    public void setTicketDeExamen(String ticketDeExamen) {
        this.ticketDeExamen = ticketDeExamen;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoDePago() {
        return estadoDePago;
    }

    public void setEstadoDePago(String estadoDePago) {
        this.estadoDePago = estadoDePago;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    
    
    @Override
    public String toString() {
        return nombreUsuario + ", " + apellidoUsuario + ", " + identificacionDeExamen + ", " + ticketDeExamen + ", " + costo + ", " + tipoExamen + ", " + descripcion + ", " + estadoDePago + ", " + asistencia + ", " + identificacionUsuario;
    }
    
}
