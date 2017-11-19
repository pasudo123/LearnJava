package JavaThread;

import java.util.*;

public class Thread02 extends Thread{
	int seq;
	
	public static void main(String[]args){
		System.out.println(" === Main Thread Start");
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for(int i = 0; i < 10; i++){
			Thread02 t = new Thread02();
			t.setSeq(i+1);
			t.start();
			threads.add(t);
		}// for
		
		for(int i = 0; i < threads.size(); i++){
			Thread t = threads.get(i);
			
			/*
			 * 스레드가 종료되고, 그 다음 로직을 수행해야할 때 
			 * 필요한 메소드 : .join() 
			 * */
			
			try{
				// 't' Thread 가 실행되고 종료할 때까지 기다림.
				t.join();
			}
			catch(Exception e){
				System.out.println("Error : " + e);
			}
		}// for
		
		System.out.println(" === Main Thread End");
	}
	
	// 번호 부여.
	public void setSeq(int n){
		this.seq = n;
	}
	
	public void run(){
		System.out.printf("%2d %s\n", seq, "Thread Start");
		System.out.printf("%2d %s\n", seq, "Thread End");
	}
}