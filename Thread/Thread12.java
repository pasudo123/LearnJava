package JavaThread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

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
		System.out.println();
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

class RejectExecutionHandler implements RejectedExecutionHandler{
	/*
	 * 
	 * 스레드 풀내 지정된 작업큐에 들어가지 않은 작업 대기 상태임에도 
	 * RejectedExecutionHandler 인터페이스 구현을 통해서 작업을 처리할 수 있다.
	 * 
	 * */
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor){
		System.out.println(r.toString() + " is rejected --------- ");
	}

}

class MyMonitorThread implements Runnable{
	private ThreadPoolExecutor executor;
	private int seconds;
	private boolean run = true;
	
	public MyMonitorThread(ThreadPoolExecutor executor, int delay){
		this.executor = executor;
		this.seconds = delay;
	}
	
	public void shutdown(){
		this.run = false;
	}
	
	@Override
	public void run(){
		while(run){
			int poolSize = this.executor.getPoolSize();
			int coreSize = this.executor.getCorePoolSize();
			int activeCnt = this.executor.getActiveCount();
			long completeTaskCnt = this.executor.getCompletedTaskCount();
			long taskCount = this.executor.getTaskCount();
			boolean isShutDown = this.executor.isShutdown();
			boolean isTerminated = this.executor.isTerminated();
			
			System.out.println(String.format("[monitor] [%d/%d]", poolSize, coreSize));
			System.out.println(String.format("Active : %d , Completed : %d , Task : %d", activeCnt, completeTaskCnt, taskCount));
			System.out.println(String.format("isShutdown : %s , isTerminated : %s", isShutDown, isTerminated));
			System.out.println();
			
			try{
				Thread.sleep(seconds * 1000);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
public class Thread12 {
	public static void main(String[]args) throws InterruptedException{
		// RejectedExecutionHandler implementation
		RejectExecutionHandler rejectionHandler = new RejectExecutionHandler();
		
		// Get the ThreadFactory implementation to use
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		
		// Creating the ThreadPoolExecutor
		// 초기 스레드풀 사이즈 = 2, 
		// 최대 스레드풀 사이즈 = 4 
		ThreadPoolExecutor executorPool = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2), threadFactory, rejectionHandler);
		
		// Start the monitoring Thread
		MyMonitorThread monitor = new MyMonitorThread(executorPool, 3);
		Thread monitorThread = new Thread(monitor);
		monitorThread.start();
		
		// submit work to the Thread pool
		for(int i = 0; i < 10; i++){
			executorPool.execute(new WorkerThread("cmd " + i));
		}
		
		Thread.sleep(30000);
		
		// shutdown the pool
		executorPool.shutdown();
		
		// shutdown the monitor thread
		Thread.sleep(5000);
		
		monitor.shutdown();
	}
}
