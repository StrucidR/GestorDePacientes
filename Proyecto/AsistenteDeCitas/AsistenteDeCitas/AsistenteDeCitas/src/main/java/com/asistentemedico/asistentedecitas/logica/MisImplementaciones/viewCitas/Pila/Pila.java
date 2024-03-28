package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Pila;

public class Pila <T> implements ListaPila<T>{


	private Nodo<T> cabeza;//En teoria los valores agregados siempre
	//estaran por encima de la cabeza, la cabeza apuntara al elemento mas
	//recientemente agregado 
	
	public Pila() {//Constructor 
		this.cabeza=null;//En nulo ya que no hay constancia de datos
	}
	
	@Override//Agrega un elemento
    public void push(T elemento) {
        if (cabeza == null) {
            cabeza = new Nodo<>(elemento);
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(elemento);
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        }
    }
        public void insertarEnPosicion(T elemento, int posicion) {
        if (posicion == 0) {
            push(elemento); // Insertar al principio de la pila
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(elemento);
            Nodo<T> temp = cabeza;
            int contador = 1;
            while (contador < posicion && temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
                contador++;
            }
            nuevoNodo.setSiguiente(temp.getSiguiente());
            temp.setSiguiente(nuevoNodo);
        }
    }
    

	@Override//elimina y devuelve el elemento en la parte de arriba de la pila
	public T pop() {
		if(estaVacia()) 
		{
			throw new IndexOutOfBoundsException("POP ERROR");
		}
		T valor = cabeza.getValor();//Obtenemos el valor de la cabeza en valor y luego
		//se obtiene como el siguiente y pasa hacer la cabeza
		cabeza=cabeza.getSiguiente();
		
		return valor;
	}

	@Override//devuelve el elemento sin eliminarlo
	public T peek() {
		if(estaVacia())
		{
			throw new IndexOutOfBoundsException("PILA WITH ELEMENTS 0");
		}
		//se obtiene el valor de cabeza
		return cabeza.getValor();
	}

	@Override
	public boolean estaVacia() {
	    if (cabeza == null) 
	    {
	        return true;
	    }
	    else 
	    {
	        return false;
	        //Verificamos si esta vacio
	    }
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> temp = cabeza;
        while (temp != null) {
            sb.append(temp.getValor()).append("");
            temp = temp.getSiguiente();
        }
        sb.append(" ");//to String
        return sb.toString();
    }
	
	private static class Nodo<T>{
		private T valor;
		private Nodo<T> siguiente;
		
		public Nodo(T valor) {
			this(valor, null);
		}
		
        public Nodo(T valor, Nodo<T> siguiente) {
            this.valor = valor;
            this.siguiente = siguiente;
        }
        
        public T getValor() {
            return valor;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }
        
	}

	@Override
	public void remove() {
	    if (!estaVacia()) {
	    	cabeza=cabeza.getSiguiente();
	    } 
	}
}
