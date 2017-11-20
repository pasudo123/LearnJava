package JavaThread;

class AnonyThread{
	public AnonyThread(){}
	
	public void setStart(){
		// setStart() 진입
		System.out.println(Thread.currentThread());
		
		Thread thread = new Thread(new Runnable(){
			public void run(){
				System.out.println("------");
				System.out.println("Running Thread : " + Thread.currentThread());
				for(int i = 0; i < 5; i++){
					System.out.println("run : " + i);
				}
				System.out.println("------");
			}
		});
		
		thread.start();
		try{
			// thread 로직이 끝날때까지 기다린다.
			thread.join();
		}
		catch(Exception e){}
		
		// setStart() 이탈
		System.out.println(Thread.currentThread());
	}
}

class LambdaThread{
	public LambdaThread(){}
	
	public void setStart(){
		// 람다식 스레드를 실행시킬 수 있다.
		// Java 8 에서 가능하다.
		Thread thread = new Thread(()->{
			System.out.println("------");
			System.out.println("Running Thread : " + Thread.currentThread());
			for(int i = 0; i < 5; i++){
				System.out.println("run : " + i);
				try{
					Thread.sleep(50);
				}
				catch(Exception e){}
			}
			System.out.println("------");
		});
		
		thread.start();
		try{
			thread.join();
		}
		catch(Exception e){}
	}
}

public class Thread012 {
	public static void main(String[]args){
		AnonyThread an_thread = new AnonyThread();
		an_thread.setStart();
		
		LambdaThread lm_thread = new LambdaThread();
		lm_thread.setStart();
	}
}
