import java.util.concurrent.*;

public class ScheduleThread extends Thread {
	public void run() {
		try {
			Thread.sleep(2000);
			if (this.getName().equals("Thread-5")) {
				Thread.sleep(8000);
				System.out.println(" Thread-5");
			}

		} catch (InterruptedException ie) {

		}
	}

	public static void main(String args[]) {
		
		Buffer buffer = new  Buffer();
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(4);
		for (int i = 0; i < 120; i++) {
			long tempo = (long) (100);
			System.out.println("Escritor-" + i + " será executada em " + tempo
					+ "ms.");
			// Escalona a execução da thread
			exec.schedule(new Escritor(buffer), tempo, TimeUnit.MILLISECONDS);
		}
		for (int i = 0; i < 120; i++) {
			long tempo = (long) (100);
			System.out.println("Leitor-" + i + " será executada em " + tempo
					+ "ms.");
			// Escalona a execução da thread
			exec.schedule(new Leitor(buffer), tempo, TimeUnit.MILLISECONDS);
		}
		
		
		exec.shutdown();
	}
}