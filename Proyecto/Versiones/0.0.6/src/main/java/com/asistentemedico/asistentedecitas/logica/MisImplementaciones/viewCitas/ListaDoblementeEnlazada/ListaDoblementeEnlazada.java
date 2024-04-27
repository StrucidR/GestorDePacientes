package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada;

import java.util.Iterator;

public interface ListaDoblementeEnlazada <T>{
    public void agregarAlFinal(T valor);
    public void agregarAlInicio(T valor);
    public boolean estaVacia();
    public T eliminarDelInicio();
    public T eliminarDelFinal();
    public Iterator<T> iterator();
}
