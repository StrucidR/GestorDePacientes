package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola;

public interface ListaCola <T>{
    
    void enqueue(T elemento);
    T dequeue();
    T peek();
    boolean estaVacia();
    T dequeue(T clienteAEliminar);//Otro metodo agregado para cumplir con los requerimientos de A
}
