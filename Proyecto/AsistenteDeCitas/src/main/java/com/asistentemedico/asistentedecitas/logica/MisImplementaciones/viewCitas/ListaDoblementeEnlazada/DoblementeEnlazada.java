package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.ListaDoblementeEnlazada;

public class DoblementeEnlazada <T> implements ListaDoblementeEnlazada<T>{
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;

    public DoblementeEnlazada() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    @Override
    public void agregarAlInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor, cabeza, null);
        if (cabeza != null) {
            cabeza.anterior = nuevoNodo;
        }
        cabeza = nuevoNodo;
        if (cola == null) {
            cola = nuevoNodo;
        }
        tamano++;
    }

    @Override
    public void agregarAlFinal(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor, null, cola);
        if (cola != null) {
            cola.siguiente = nuevoNodo;
        }
        cola = nuevoNodo;
        if (cabeza == null) {
            cabeza = nuevoNodo;
        }
        tamano++;
    }
    
    @Override
     public T eliminarDelInicio() {
	if(estaVacia()) {
            throw new UnsupportedOperationException("La lista esta vacia"); 
    	}else if(tamano==1) {//Si solo tiene un elemento, tamano y cola son el mismo valor y ahora seran nulos tras eliminarlos
    		T valor =  cabeza.getValor();
    		 cabeza = null;
    		 cola = null;
    		 tamano = 0;//La lista queda vacia
    		return valor;
    	}
    		T eliminado = cabeza.getValor();
		 	Nodo<T> nodoActual = cabeza.getSiguiente(); // Mantenemos una referencia al nodo anterior
		 	nodoActual.setAnterior(null); // establecemos como null la referencia anterior a nodoActual, osea la cabeza que vamos a eliminar
		 	cabeza= nodoActual;	// cabeza ahora es nodoActual
		 	tamano--; //disminuye el tamano
    	
		 return eliminado;
	}
     
     @Override
     public T eliminarDelFinal() {
    if (estaVacia()) {
        throw new UnsupportedOperationException("La lista está vacía");
    } else if (tamano == 1) {
        T valor = cola.getValor();
        cabeza = null;
        cola = null;
        tamano = 0;
        return valor;
    }

    T eliminado = cola.getValor();
    Nodo<T> nodoActual = cola.getAnterior();
    nodoActual.setSiguiente(null);
    cola = nodoActual;
    tamano--;

    return eliminado;
    }
        
    @Override
	public boolean estaVacia() {//Metodo que sirve para saber si nuestra lista
		//esta vacia o no esperando de retorno un boolean que sea true si esta vacia
		//y false si no
		if(tamano== 0 ) {//primera condicion me dice si el tamanio es 0 entonces quiere 
			//decir que no contiene elementos entonces me retornara un true , de que esta 
			//vacia
			System.out.println("Vacia");
			return true;
		}else {//Si no cumple con la anterior condicion simplemente retorna el false
			//de que si esta o contiene la lista al menos con un elemento retornara false
			//de que no esta vacio
			System.out.println("Elementos");
			return false;
		}
	}
    
    public Nodo<T> getCabeza() {
        return cabeza;
    }
    	public static class Nodo<T>{ //Define la clase estatica interna que es un nodo que es generico en este caso T referente a que puede contener cualquier tipo de objeto, un integer,String etc
		T valor;//se declara la variable con nombre de valor de tipo generico para almacenar el valor del nodo que se obtendra u que pertenece a ese nodo que deseamos trabajar
		Nodo<T> siguiente;//Se declara la variable del siguiente con tipo Nodo que apunta al siguiente nodo en la lista la misma funcionalidad tiene anterior pero apunta al anterior nodo de la lista
		Nodo<T> anterior;
		public Nodo(T valor) {
			this(valor, null, null);//Este constructor inicializa el nodo con un valor dado y sin algo en el siguiente u anterior garantizando que cuando implementemos el programa iniciando este completamente vacia la lista
			//de nodos
		}
		public Nodo(T valor, Nodo<T> siguiente, Nodo<T> anterior) {//Este constructor sin embargo inicializa el nodo con valor dado y el nodo siguiente y anterior
			this.valor = valor;//donde sirve para asignar un valor pasando como argumento al campo en este caso valor de la instancia actual del nodo y el this referido a la instancia actual de esta clase, se usa para distinguir
			this.siguiente = siguiente;//entre el parametro es decir el valor del constructor y el campo del valor de la clase y asi con la misma funcionalidad o implementacion funcionan this.siguiente=siguiente y this.anterior=anterior
			this.anterior = anterior;
		}
		public T getValor() {//Obtiene el valor de ese generico con el que estemos trabajando
			return valor;//y lo devuelve, no existe un set valor porque no podemos establecer un valor en un nuevo nodo. bueno se puede pero es mejor usar un remplazo de valor de variable facilitando u optimizando el sistema o codigo
		}
		public Nodo<T> getSiguiente() {//Obtiene el siguiente nodo
			return siguiente;//y retornar el siguiente nodo obteniendolo
		}
		public void setSiguiente(Nodo<T> siguiente) {//Establece el siguiente nodo 
			this.siguiente = siguiente;//y retorna su valor con el this.siguiente = siguiente haciendo referencia al siguiente nodo de la lista de esta clase 
		}
		public Nodo<T> getAnterior() {//Misma funcionalidad o implementacion en esta parte del codigo que en el getSiguiente la unica diferencia es que es con el anterior nodo
			return anterior;//anterior al nodo actual donde nos encontremos
		}
		public void setAnterior(Nodo<T> anterior) {//Misma funcionalidad o implementacion que el set siguiente estableciendo su valor pero en este caso en el anterior nodo del actual
			this.anterior = anterior;
		}
                
                
	}
        
        
}
