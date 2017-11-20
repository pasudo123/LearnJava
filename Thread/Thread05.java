package JavaThread;

/*
 * reference : http://blog.eomdev.com/java/2016/04/06/Multi-Thread.html
 * 
 * 싱글스레드에서는 하나의 프로세스 내에 하나의 단일 스레드만 있기 때문에 
 * 실행 영역에 대한 동기, 비동기 처리를 해줄 필요가 없다.
 * 
 * 하지만
 * 
 * 멀티스레드에서는 하나의 프로세스 내에 여러개의 스레드가 존재하기 때문에 해당 실행 영역에서 다수의 스레드가 자원을 공유한다.
 * 따라서 이러한 자원의 공유는 서로의 작업에 영향을 끼치게 되므로 동기화 처리가 필요하다.
 * 
 * -- Java : difference Synchronized & join()
 * https://stackoverflow.com/questions/19832605/difference-in-output-from-use-of-synchronized-keyword-and-join
 * */
class Calculator{
	private int memory;
	
	public int getMemory(){
		return this.memory;
	}
	
	// public synchronized void setMemory(int paramMemory) 
	// synchronized 의 여부에 따라서 동기 비동기 처리를 할 수 있다.
	// synchronized : 해당 메소드에 'LOCK' 을 거는 행위.
	public void setMemory(int paramMemory){
		this.memory = paramMemory;
		try{
			System.out.println("sleep_before : " + this.getMemory());
			Thread.sleep(2000);
			System.out.println("sleep_after  : " + this.getMemory());
		}
		catch(InterruptedException e){
			// java.lang.Object 메소드, wait(), sleep(), join()
			// 해당하는 메소드에 InterruptedException 예외가 붙는다.
			System.out.println(Thread.currentThread().getName() + " : " + this.memory);
		}
	}
}

class User1 extends Thread{
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator){
        this.setName("CalculatorUser - 1");	// Thread setName()
        this.calculator = calculator;		// 멤버변수 이름 설정
    }
	
	public void run(){
		this.calculator.setMemory(100);		// 공유 객체에 100 저장
	}
}

class User2 extends Thread{
	private Calculator calculator;
	
	public void setCalculator(Calculator calculator){
        this.setName("CalculatorUser - 2");	// Thread setName()
        this.calculator = calculator;		// 멤버변수 이름 설정
    }
	
	public void run(){
		this.calculator.setMemory(500);		// 공유 객체에 500 저장
	}
}

public class Thread05 {
	public static void main(String[]args){
		Calculator calculator = new Calculator();   // 공유하게 되는 객체

		// -- user1
        User1 user1 = new User1();
        user1.setCalculator(calculator);
        user1.start();
        
        // -- user2 
        User2 user2 = new User2();
        user2.setCalculator(calculator);
        user2.start();
	}
}
