package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas.Cola;

public class Cola <T> implements ListaCola<T>{

	private Nodo<T> cabeza;
	private Nodo<T> cola;

	public Cola() {
		this.cabeza=null;
		this.cola=null;
	}

	@Override//Agregamos cliente
	public void enqueue(T elemento) {
		Nodo<T> nuevoNodo = new Nodo<>(elemento);
		if (estaVacia()) 
		{
			cabeza = nuevoNodo;
		} 
		else 
		{//En la cola se debe conocer el primer elemento e ultimo 
                //por esa razon el uso de cola
	        //establecemos en la cola el siguiente como nuevo Nodo
	        cola.setSiguiente(nuevoNodo);
		}
		cola = nuevoNodo;
	}

	@Override//Atendemos al cliente
	public T dequeue() {

		if (estaVacia()) 
		{
		throw new IndexOutOfBoundsException("DEQUEUE ERROR");
		}//generico y obtenemos su valor y asi la cabeza ya que el cliente sera atendido pues
		//el siguiente pasa a la cabeza cola FIRST IN FIRST OUT
		T valor = cabeza.getValor();
		cabeza = cabeza.getSiguiente();

		if (cabeza == null) 
		{//Actualizamos ya que podemos atender al ultimo y entonces no abra ninguno en cola
			cola = null;
		}
		return valor;
	}

	@Override
	public T peek() {
		if (estaVacia()) 
		{
		throw new IndexOutOfBoundsException("PEEK ERROR");
		}//obtenemos el valor en el primer en la lista
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
		}//Se puede hacer solo cabeza==null 
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Nodo<T> temp = cabeza;
		while (temp != null) {
			sb.append(temp.getValor()).append(" -> ");
			temp = temp.getSiguiente();
		}
		sb.append(" ");
		return sb.toString();
	}

	private static class Nodo<T> {
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


}
