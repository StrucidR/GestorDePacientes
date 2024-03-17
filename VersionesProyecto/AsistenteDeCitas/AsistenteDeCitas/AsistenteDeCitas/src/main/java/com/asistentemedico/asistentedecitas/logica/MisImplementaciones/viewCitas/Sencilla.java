package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas;

public class Sencilla<T> implements ListaSencilla<T>{
    private Nodo<T> cabeza;

    private static class Nodo<T>{
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    @Override
    public void agregar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    @Override
    public void buscar(Proceso<T> proceso) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            proceso.ejecutar(actual.dato);
            actual = actual.siguiente;
        }
    }

    public interface Proceso<T> {
        void ejecutar(T elemento);
    }
    
    @Override
    public void limpiar() {
        cabeza = null;
    }
}
