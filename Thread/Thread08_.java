package JavaThread;


class ProcessingThread implements Runnable{
	private int count;
	
	@Override 
	public void run(){
		for(int i = 1; i < 5; i++){
			processSomething(i);
			count++;
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

public class Thread08_ {
	public static void main(String[]args){
		// 다중 스레드가 공유되는 자원을 업데이트하는 간단한 프로그램
		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		Thread t2 = new Thread(pt, "t2");
		
		t1.start();
		t2.start();
		
		// t1, t2 의 스레드 실행이 끝나고 이후 로직을 실행한다.
		try{
			t1.join();
			t2.join();
		}
		catch(InterruptedException e){
			// reference 
			// http://so-blog.net/2015/01/17/interrupted_exception/
		}
		
		System.out.println("Processing Count = " + pt.getCount());
		
		/****
		결과값을 보면 사실상 두개의 스레드가 실행되고 이후에 count 값이 8이 출력될 것 같지만,
	 	사실상 값은 6 ~ 8 사이의 값이 도출된다.
		
	 	무엇이 문제인가 ?
	 	
	 	데이터 손상을 야기하기 때문이다.
	 	
	 	어떻게 해결하는가 ? >> Thread Safefy Code
		****/ 
	}
}