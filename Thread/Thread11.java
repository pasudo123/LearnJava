package JavaThread;

// 스레드 풀을 이용하기 위한 클래스 import
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{
	private String command;
	
	public WorkerThread(String s){
		this.command = s;
	}
	
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}
	
	private void processCommand(){
		// 해당되는 작업 수행.
		try{
			System.out.println(Thread.currentThread().getName() + " Work");
			Thread.sleep(5000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	@Override 
	public String toString(){
		return this.command;
	}
}

public class Thread11 {
	public static void main(String[]args){
		/*
		 * java.util.concurrent.Executors 는 
		 * java.util.concurrent.Executor 인터페이스의 구현을 제공
		 * java 에 스레드 풀을 생성한다.*/
		
		// creating fixed size thread pool of 5 worker threads
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		// 10개의 작업 시행
		// 스레드 풀로 설정한 5개의 작업을 시행한다.
		// 우선적으로 끝난 작업은 바로 이후의 작업을 시행한다.
		for(int i = 0; i < 10; i++){
			Runnable worker = new WorkerThread(String.valueOf(i));
			executor.execute(worker);
		}
		
		// 현재 남아있는 작업 완료 후 스레드 풀 종료
		executor.shutdown();	
		
		// 현재 남아있는 작업이 있으면 계속 while
		// Thread.sleep() 과 연관있다.
		while(!executor.isTerminated()){}
		
		System.out.println("Finished All Threads");
	}
}
