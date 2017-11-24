package JavaThread;

import java.util.Arrays;

class HashMapProcessor implements Runnable{
	private String[] strArr = null;
	
	public HashMapProcessor(String[] m){
		this.strArr = m;
	}
	
	public String[] getMap(){
		return this.strArr;
	}
	
	@Override
	public void run(){
		// System.out.println(Thread.currentThread().getName());
		processArr(Thread.currentThread().getName());
	}
	
	public void processArr(String name){
		for(int i = 0; i < strArr.length; i++){
			// process data & thread name Append
			processSomething(i);
			addThreadName(i, name);
		}
	}
	
	private void addThreadName(int i, String name){
		strArr[i] = strArr[i] + ":" + name;
	}
	
	private void processSomething(int index) {
		// processing some job
		try {
			Thread.sleep(index * 100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Thread09_{
	public static void main(String[]args) throws InterruptedException{
		String [] arr = {"1", "2", "3", "4", "5", "6"};
		HashMapProcessor hmp = new HashMapProcessor(arr);
		
		Thread t1 = new Thread(hmp, "t1");
		Thread t2 = new Thread(hmp, "t2");
		Thread t3 = new Thread(hmp, "t3");
		
		long startTime = System.nanoTime();
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Time Taken > " + (long)(System.nanoTime() - startTime));
		System.out.println(Arrays.asList(hmp.getMap()));
	}
}
