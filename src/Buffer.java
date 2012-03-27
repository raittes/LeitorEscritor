class Buffer {

	private int valor;
	
	public Buffer() {
	}

	public synchronized void escrever() {
		valor++;
	}

	public synchronized int ler() {
		return valor;
	}
	public synchronized void set(int value){
		valor = value;
	}
}