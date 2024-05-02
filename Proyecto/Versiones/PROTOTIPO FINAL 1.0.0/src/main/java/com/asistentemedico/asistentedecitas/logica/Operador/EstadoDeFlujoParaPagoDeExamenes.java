package com.asistentemedico.asistentedecitas.logica.Operador;

public class EstadoDeFlujoParaPagoDeExamenes {
    
    private String nombre;
    private String apellido;
    private String identificacion;
    private String estadoDeFlujo;

    public EstadoDeFlujoParaPagoDeExamenes(String nombre, String apellido, String identificacion, String estadoDeFlujo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.estadoDeFlujo = estadoDeFlujo;
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

    public String getEstadoDeFlujo() {
        return estadoDeFlujo;
    }

    public void setEstadoDeFlujo(String estadoDeFlujo) {
        this.estadoDeFlujo = estadoDeFlujo;
    }
    
    @Override
    public String toString() {
        return  nombre + ", " + apellido + ", " + identificacion + ", " + estadoDeFlujo;
    }
    
}
