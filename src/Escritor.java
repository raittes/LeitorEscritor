
public class Escritor extends Thread{

	private Buffer buffer;
	public Escritor(Buffer buffer){
		this.buffer = buffer;
	}
	
	public void escrever(){
		buffer.escrever();
	}
	
	public void run() {
			this.escrever();
			System.out.println("Thread: "+this.getId()+" escreveu");
			this.notifyAll();
			
	}
}
