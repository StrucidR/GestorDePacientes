package com.asistentemedico.asistentedecitas.logica.Cita;

public class SalaDePago {
    
    private String nombre;
    private String apellido;
    private String identificacion;
    private String ticket;

    public SalaDePago(String nombre, String apellido, String identificacion, String ticket) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.ticket = ticket;
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

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return  nombre + ", " + apellido + ", " + identificacion + ", " + ticket ;
    }
    
}
