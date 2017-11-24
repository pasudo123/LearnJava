package JavaThread;

class ProcessingThread_Safe implements Runnable{
	private int count;
	// dummy Object Variable for synchronization
	private Object mutex = new Object();
	
	@Override 
	public void run(){
		for(int i = 1; i < 5; i++){
			processSomething(i);
			
			synchronized(mutex){
				count++;
			}
		}
	}
	
	public void processSomething(int i){
		// processing some job
		try{
			Thread.sleep(100);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public int getCount(){
		return this.count;
	}
}


public class Thread08_ThreadSafety {
	public static void main(String[]args){
		ProcessingThread_Safe pt = new ProcessingThread_Safe();
		Thread t1 = new Thread(pt, "t1");
		Thread t2 = new Thread(pt, "t2");
		
		t1.start();
		t2.start();
		
		// t1, t2 의 스레드 실행이 끝나고 이후 로직을 실행한다.
		try{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e){}
		
		System.out.println("Processing Count = " + pt.getCount());
	}
}
