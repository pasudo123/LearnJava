package JavaThread;

// String 형태의 ThreadLocal 변수
class StringThreadLocal{
	// Generic ThreadLocal
	private ThreadLocal<String> myThreadLocal = new ThreadLocal<String>();
	
	public StringThreadLocal(){}
	
	// 스레드 로컬 저장 값 설정
	public void setThreadLocal(String valueStr){
		this.myThreadLocal.set(valueStr);
	}
	
	public String getThreadLocal(){
		String valueStr = (String) this.myThreadLocal.get();
		
		return valueStr;
	}
	
	public void run(){
		
	}
}

// Integer 형태의 ThreadLocal 변수
class IntegerThreadLocal implements Runnable{
	/*
	 * ThreadLocal 변수를 주석 여부에 따라서 
	 * 동일한 스레드지만 스레드에 따라서 읽고 쓸 수 있는 변수를 만들 수 있다.
	 * 
	 * 두 개의 스레드가 동일한 코드를 실행하지만, 사실상 두 스레드는 서로의
	 * ThreadLocal 변수를 볼 수 없다.*/
	
	private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
//	private double staticVariable = 0;	// 테스트용 값
	
	public void run(){
		// 100D 는 double 리터럴을 의미
		threadLocal.set((int) (Math.random() * 100D));
//		staticVariable = Math.random() * 100D;
		
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){}
		
		System.out.println(threadLocal.get());
//		System.out.println((int)staticVariable);
	}
}

public class Thread10{
	public static void main(String[]args) throws InterruptedException{
		IntegerThreadLocal sharedRunnableInstance = new IntegerThreadLocal();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
	}
}
