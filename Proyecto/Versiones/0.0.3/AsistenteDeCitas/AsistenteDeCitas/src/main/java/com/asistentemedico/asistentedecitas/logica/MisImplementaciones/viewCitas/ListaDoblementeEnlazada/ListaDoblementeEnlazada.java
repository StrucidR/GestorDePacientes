package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada;

public interface ListaDoblementeEnlazada <T>{
    public void agregarAlFinal(T valor);
    public void agregarAlInicio(T valor);
    public boolean estaVacia();
    public T eliminarDelInicio();
    public T eliminarDelFinal();
}
