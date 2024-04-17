package com.asistentemedico.asistentedecitas.logica;

public class Usuario {
    
    private String nombre;
    private String apellido;
    private String identificacion;
    private String edad;
    private String telefono;
    private String contrasenia;

    public Usuario(String nombre, String apellido, String identificacion, String edad, String telefono, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.edad = edad;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return nombre + ", " + apellido + ", " + identificacion + ", " + edad + ", " + telefono + ", " + contrasenia ;
    }
    
}
