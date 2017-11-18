package JavaThread;

/***
 * Thread 클래스를 extends 했기 때문에, start() 실행 시
 * run 메소드가 수행되는 것.
 * 
 * Thread 클래스는 start 실행 시 run 메소드가 수행되도록 내부적으로 구성.
 ***/
public class Thread01 extends Thread{
	int seq;
	
	public static void main(String[]args){
		System.out.println(" === Main Thread Start");
		
		for(int i = 0; i < 10; i++){
			Thread01 m = new Thread01();
			m.setSeq(i+1);
			m.start();
		}
		
		System.out.println(" === Main Thread End");
	}
	
	// 번호 부여.
	public void setSeq(int n){
		this.seq = n;
	}
	
	public void run(){
		System.out.printf("%2d %s\n", seq, "Thread Start");
		System.out.printf("%2d %s\n", seq, "Thread End");
		/*
		 * 순서대로 실행되고 있지 않음.
		 * 더 특별한 부분은 메인 스레드가 끝나는 시점은 매번 달라진다는 사실.
		 * */
	}
}