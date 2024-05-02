package com.asistentemedico.asistentedecitas.logica.Autorizacion;

public class SalaDeAutorizaciones {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String identificacion;
    private String identificadordecita;
    private String ticketdecita;
    private String costo;
    private String tipoExamen;
    private String identificadordeautorizacion;
    private String descripcion;
    private String estadodeautorizacion;

    public SalaDeAutorizaciones(String nombreUsuario, String apellidoUsuario, String identificacion, String identificadordecita, String ticketdecita, String costo, String tipoExamen, String identificadordeautorizacion, String descripcion, String estadodeautorizacion) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.identificacion = identificacion;
        this.identificadordecita = identificadordecita;
        this.ticketdecita = ticketdecita;
        this.costo = costo;
        this.tipoExamen = tipoExamen;
        this.identificadordeautorizacion = identificadordeautorizacion;
        this.descripcion = descripcion;
        this.estadodeautorizacion = estadodeautorizacion;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificadordecita() {
        return identificadordecita;
    }

    public void setIdentificadordecita(String identificadordecita) {
        this.identificadordecita = identificadordecita;
    }

    public String getTicketdecita() {
        return ticketdecita;
    }

    public void setTicketdecita(String ticketdecita) {
        this.ticketdecita = ticketdecita;
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

    public String getIdentificadordeautorizacion() {
        return identificadordeautorizacion;
    }

    public void setIdentificadordeautorizacion(String identificadordeautorizacion) {
        this.identificadordeautorizacion = identificadordeautorizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadodeautorizacion() {
        return estadodeautorizacion;
    }

    public void setEstadodeautorizacion(String estadodeautorizacion) {
        this.estadodeautorizacion = estadodeautorizacion;
    }

    @Override
    public String toString() {
        return  nombreUsuario + ", " + apellidoUsuario + ", " + identificacion + ", " + identificadordecita + ", " + ticketdecita + ", " + costo + ", " + tipoExamen + ", " + identificadordeautorizacion + ", " + descripcion + ", " + estadodeautorizacion ;
    }
    
}
