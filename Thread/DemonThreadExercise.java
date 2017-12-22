package JavaThread;

class AutoSaveThread extends Thread{
	public void save(){
		System.out.println("자동 저장");
	}
	
	@Override
	public void run(){
		while(true){
			try{
				Thread.sleep(1000);
			}
			catch(Exception e){
				System.out.println("데몬 스레드 run() break");
				break;
			}
			
			save();
		}
	}
}

public class DemonThreadExercise {
	public static void main(String[]args){
		AutoSaveThread asThread = new AutoSaveThread();
		asThread.setDaemon(true);	// 데몬스레드 설정.
		asThread.start();
		
		/*
		 * 메인 스레드가 Thread.sleep(5000) 으로 잠자고 있는 상태에서,
		 * 데몬 스레드는 계속 실행 중에 있다. 하지만, 메인 스레드 종료가 되면
		 * 더불어서 데몬 스레드도 강제적으로 같이 종료된다.
		 * */
		try{
			Thread.sleep(5000);
		}
		catch(Exception e){}
		
		System.out.println("메인 스레드 종료");
	}
}
