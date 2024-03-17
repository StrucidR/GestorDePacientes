package com.asistentemedico.asistentedecitas.logica.MisImplementaciones.viewCitas;

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
		{//En la cola se debe conocer el primer elemento e ultimo por esa razon el uso de cola
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

	//Eliminamos por elemento algo asi como por indice
	public T dequeue(T clienteAEliminar) {
		if (estaVacia()) {
			throw new IndexOutOfBoundsException("La cola está vacía");
		}


		if (cabeza.getValor().equals(clienteAEliminar)) {
			return dequeue();
		}


		Nodo<T> guia = cabeza;
		while (guia.getSiguiente() != null && !guia.getSiguiente().getValor().equals(clienteAEliminar)) {
			guia = guia.getSiguiente();
		}
		//condición en el bucle while se detiene cuando el siguiente nodo no es nulo 
		//(lo que significa que hay más nodos en la cola) y el valor del siguiente nodo no es igual al cliente

		if (guia.getSiguiente() != null) {
			if (guia.getSiguiente() == cola) {
				cola = guia;
			}
			T valor = guia.getSiguiente().getValor();
			guia.setSiguiente(guia.getSiguiente().getSiguiente());//actualizamos referencias algo asi como eliminar en doblemente enlazada
			return valor;
		} else {
			throw new IndexOutOfBoundsException("El cliente especificado no está en la cola");
		}
	}

}
