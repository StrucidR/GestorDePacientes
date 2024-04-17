package com.asistentemedico.asistentedecitas.logica.Cita;

public class SalaDeCitas {
    
    String nombre;
    String apellido;
    String identificacion;
    String identificadordecita;
    String ticketDeCita;

    public SalaDeCitas(String nombre, String apellido, String identificacion, String identificadordecita, String ticketDeCita) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.identificadordecita = identificadordecita;
        this.ticketDeCita = ticketDeCita;
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

    public String getIdentificadordecita() {
        return identificadordecita;
    }

    public void setIdentificadordecita(String identificadordecita) {
        this.identificadordecita = identificadordecita;
    }

    public String getTicketDeCita() {
        return ticketDeCita;
    }

    public void setTicketDeCita(String ticketDeCita) {
        this.ticketDeCita = ticketDeCita;
    }

    @Override
    public String toString() {
        return  nombre + ", " + apellido + ", " + identificacion + ", " + identificadordecita + ", " + ticketDeCita ;
    }
    
}
