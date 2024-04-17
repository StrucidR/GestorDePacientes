package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Pila;

public interface ListaPila<T> {
  void push(T element);
  T pop();
  T peek();
  boolean estaVacia();
  void remove();//Metodo agregado para cumpli con los requerimientos del B
}
