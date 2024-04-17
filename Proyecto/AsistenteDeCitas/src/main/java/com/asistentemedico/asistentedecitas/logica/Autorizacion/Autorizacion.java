package com.asistentemedico.asistentedecitas.logica.Autorizacion;

public class Autorizacion {
    
    private String nombre;
    private String apellido;
    private String identificacion;
    private String identificadordelacita;
    private String ticketdelacita;
    private String precio;
    private String tipoExamen;
    private String identificadordeautorizacion;
    private String descripcion;
    private String Estado;
    private String ticketDeAutorizacion;

    public Autorizacion(String nombre, String apellido, String identificacion, String identificadordelacita, String ticketdelacita, String precio, String tipoExamen, String identificadordeautorizacion, String descripcion, String Estado, String ticketDeAutorizacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.identificadordelacita = identificadordelacita;
        this.ticketdelacita = ticketdelacita;
        this.precio = precio;
        this.tipoExamen = tipoExamen;
        this.identificadordeautorizacion = identificadordeautorizacion;
        this.descripcion = descripcion;
        this.Estado = Estado;
        this.ticketDeAutorizacion = ticketDeAutorizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificadordelacita() {
        return identificadordelacita;
    }

    public void setIdentificadordelacita(String identificadordelacita) {
        this.identificadordelacita = identificadordelacita;
    }

    public String getTicketdelacita() {
        return ticketdelacita;
    }

    public void setTicketdelacita(String ticketdelacita) {
        this.ticketdelacita = ticketdelacita;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
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

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getTicketDeAutorizacion() {
        return ticketDeAutorizacion;
    }

    public void setTicketDeAutorizacion(String ticketDeAutorizacion) {
        this.ticketDeAutorizacion = ticketDeAutorizacion;
    }
    
    @Override
    public String toString() {
        return  nombre + ", " + apellido + ", " + identificacion + ", " + identificadordelacita + ", " + ticketdelacita + ", " + precio + ", " + tipoExamen + ", " + identificadordeautorizacion + ", " + descripcion + ", " + Estado + ", " + ticketDeAutorizacion ;
    }

}
