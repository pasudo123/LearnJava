package JavaThread;

// Message : 스레드가 작동하고 wait 및 notify 메소드를 호출하는 클래스
class Message{
	private  String msg;
	
	public Message(String str){
		this.msg = str;
	}
	
	public String getMsg(){
		return this.msg;
	}
	
	public void setMsg(String str){
		this.msg = str;
	}
}

// Waiter : 다른 스레드가 알림 메소드를 호출하여, 완료할때까지 대기하는 클래스
// Waiter 스레드는 synchronized 블록을 사용하여 Message 객체의 모니터를 소유.
class Waiter implements Runnable{
	private Message msg;
	
	public Waiter(Message m){
		this.msg = m;
	}
	
	@Override 
	public void run(){
		String name = Thread.currentThread().getName();
		
		// 객체에 대한 동기화 객체 형성
		// 멀티스레드에 대한 동기화 처리
		synchronized(msg){
			try{
				System.out.println(name + " Waiting to get notified at time : " + System.currentTimeMillis());
				msg.wait();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(name + " Waiter thread got notified at time : " + System.currentTimeMillis());
			System.out.println(name + " processed : " + msg.getMsg());
		}
	}
}

// Message 객체를 처리하고, Message 객체를 기다리기는 스레드를 깨우기 위해
// notify 메소드를 호출하는 클래스.
class Notifier implements Runnable{
	private Message msg;
	
	public Notifier(Message msg){
		this.msg = msg;
	}
	
	@Override
	public void run(){
		String name = Thread.currentThread().getName();
		System.out.println(name + " Started");
		
		try{
			Thread.sleep(1000);
			
			synchronized(msg){
				msg.setMsg(name + " Notifier Work Done");
				// notify를 하는 경우, wait() 집합에 여러 쓰레드가 있는 경우 
				// 무엇이 선택할지는 정해져 있지 않다.!! 락을 가지고 있는 쓰레드만이 notify()를 호출할수 있다.
//				msg.notify();

				// 대기중인 스레드를 모두 깨운다.
				msg.notifyAll();
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

public class Thread07 {
	public static void main(String[]args){
		Message msg = new Message("Process it");
		
		Waiter firWaiter = new Waiter(msg);
		Thread firThread = new Thread(firWaiter, "firWaiter");
		firThread.start();
		
		Waiter secWaiter = new Waiter(msg);
		Thread secThread = new Thread(secWaiter, "secWaiter");
		secThread.start();
		
		
		Notifier notifier = new Notifier(msg);
		Thread noti = new Thread(notifier, "notifier");
		noti.start();
		
//		try{
//			noti.join();
//			firThread.join();
//			secThread.join();
//		}
//		catch(Exception e){}
		
		System.out.println("All the Threads are started");
	}
}


/*
 *
 * - wait() & notify() & notifyAll() 
 * 위의 세 메소드는 모두 락을 가지고 있는 쓰레드만이 호출할 수 있다.
 * 락을 가지고 있지 않은 쓰레드가 호출하게 된다면 java.lang.IllegalMonitorStateException 이 발생
 * 
 * 위의 세 메소드는 Thread 클래스에 대한 메소드가 아니다.
 * 인스턴스의 wait() 집합에 대한 조작이다.
 * wait() 집합은 모든 인스턴스가 가지고 있으므로 wait, notify, notifyAll 은 
 * Object 클래스의 메소드인 것이다.
 * (오브젝트 클래스는 최상위 클래스이기 때문에 Thread 클래스의 슈퍼클래스 메소드이다.)
 * 
 * reference : 
 * (1) http://so-blog.net/2015/01/13/thread/
 * (2) https://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example?utm_source=website&utm_medium=sidebar&utm_campaign=Core-Java-Sidebar-Widget
 * 
 * */
