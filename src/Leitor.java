
public class Leitor extends Thread{
	
	Buffer buffer;
	public Leitor(Buffer buffer){
		this.buffer = buffer;
	}
	
	public int ler(){
		return buffer.ler();
		
		
	}
	
	public void run(){
		int resultado = this.ler();
		while(resultado==0){
			try {
				System.out.println("Thread: "+this.getId()+" Parou");
				this.wait();				
			} catch (InterruptedException e) {
				resultado =1;
				e.printStackTrace();
			}
			resultado =  this.ler();
		}
		buffer.set(0);	
		System.out.println("Thread: "+this.getId()+" valor: "+resultado);
	}

}
