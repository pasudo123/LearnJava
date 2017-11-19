package JavaThread;

/*
 * 멀티스레드는 동시성 혹은 병렬성으로 실행된다.
 * (1) 동시성 (Concurrency)
 * - 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가면서 실행하는 성질.
 * 
 * (2) 병렬성 (Parallelism)
 * - 멀티 작업을 위해 개별 스레드를 동시에 실행하는 성질 
 * 
 * 동시성 작업을 하는 경우, 자바 스레드 스케쥴링 기법을 사용
 * -- 우선순위 방식과 순환할당 방식을 이용한다.
 * 
 * 
 * ++++
 * 우선순위 방식은 프로그래머가 직접 제어가 가능한데, 
 * 기억하고 있어야할 사항은 스레드 스케줄링 우선순위 방식은
 * 스레드 우선순위에 무조건적으로 의존하지는 않는다고 한다.
 * ++++
 * 
 * ++++ 
 * 순환할당 방식은 라운드 로빈이라고 불리운다.
 * 시간 할당량을 정하여 하나의 스레드를 정해진 시간만큼 실행하고
 * 이후에 다른 스레드를 실행하는 기법이다. 
 * 자바의 JVM 에 의해서만 이루어지기 때문에 프로그래머가 따로 제어하지 못한다.
 * https://stackoverflow.com/questions/12038592/java-thread-priority-has-no-effect
 * */

// code reference : https://kodejava.org/how-do-i-set-the-priority-of-a-thread/
class ThreadPriority extends Thread {
	private String threadName;

	ThreadPriority(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		System.out.println("Running [" + threadName + "]");
		for (int i = 1; i <= 10; i++) {
			System.out.println("[" + threadName + "] => " + i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Thread04 {
	public static void main(String[] args) {
		/*
		 * java.lang.Thread's Method public static Thread currentThread();
		 * currentThread() : 현재 실행중인 메소드 리턴.
		 */
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());

		ThreadPriority thread1 = new ThreadPriority("1st");
		ThreadPriority thread2 = new ThreadPriority("2nd");
		ThreadPriority thread3 = new ThreadPriority("3rd");
		ThreadPriority thread4 = new ThreadPriority("4th");
		ThreadPriority thread5 = new ThreadPriority("5th");

		// set thread1 to minimum priority = 1
		thread1.setPriority(Thread.MIN_PRIORITY);

		// set thread2 to priority 2
		thread2.setPriority(2);

		// set thread3 to normal priority = 5
		thread3.setPriority(Thread.NORM_PRIORITY);

		// set thread4 to priority 8
		thread4.setPriority(8);

		// set thread5 to maximum priority = 10
		thread5.setPriority(Thread.MAX_PRIORITY);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
