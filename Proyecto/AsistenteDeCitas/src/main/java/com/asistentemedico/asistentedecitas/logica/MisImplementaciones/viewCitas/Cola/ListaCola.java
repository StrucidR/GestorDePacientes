package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola;

public interface ListaCola <T>{
    
    void enqueue(T elemento);
    T dequeue();
    T peek();
    boolean estaVacia();
    
}
