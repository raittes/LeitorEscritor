import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class ExecutorService2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long tempo = (long) (1000);
		ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
		ExecutorService service = Executors.newFixedThreadPool(4);
		Buffer buffer = new  Buffer();
		for(int i = 0; i<120;i++){
			exec.scheduleAtFixedRate(new Escritor(buffer), 0,tempo, TimeUnit.MILLISECONDS);
			service.execute(new Leitor(buffer));			
		}
		
	}

	
}
