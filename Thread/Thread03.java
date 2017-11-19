package JavaThread;

import java.util.ArrayList;

/*
 * Runnable Interface 사용방식.
 * 기존의 방식은 Thread 를 상속(extends)하여 run() 메소드를 실행시키는 방식이었다.
 * */

public class Thread03 implements Runnable{
	int seq;
	
	public Thread03(int seq){
		this.seq = seq;
	}
	
	public static void main(String[]args){
		System.out.println(" --- Main Thread Start");
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for(int i = 0; i < 10; i++){
			
			// ------------------------------------------------------
			// 스레드 객체 생성하면서, Runnable 인터페이스 구현 객체를 인자로 받는다.
			
			Thread t = new Thread(new Thread03(i+1));
			t.start();
			threads.add(t);
		}
		
		for(int i = 0; i < threads.size(); i++){
			Thread t = threads.get(i);
			try{
				t.join();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println(" --- Main Thread Out");
	}
	
	@ Override // [인터페이스 오버라이드]
	public void run(){
		System.out.printf("%2d %s\n", this.seq, "Thread Start");
		
		try{
			Thread.sleep(200);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.printf("%2d %s\n", this.seq, "Thread End");
	}
}
