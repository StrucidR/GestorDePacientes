package com.asistentemedico.asistentedecitas.logica.Cita;

public class Cita {
    
    private String nombre;
    private String apellido;
    private String identificacion;
    private String identificador;
    private String ticket;
    private String costo;
    private String doctor;
    private String estado;
    private String especialidad;
    private String asistencia;
    private String motivo;

    public Cita(String nombre, String apellido, String identificacion, 
    String identificador, String ticket, String costo, String doctor, 
    String estado, String especialidad, String asistencia, String motivo) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.identificador = identificador;
        this.ticket = ticket;
        this.costo = costo;
        this.doctor = doctor;
        this.estado = estado;
        this.especialidad = especialidad;
        this.asistencia = asistencia;
        this.motivo = motivo;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return  nombre + ", " + apellido + ", " + identificacion + ", " + identificador + ", " + ticket + ", " + costo + ", " + doctor + ", " + estado + ", " + especialidad + ", " + asistencia + ", " + motivo ;
    }
}
