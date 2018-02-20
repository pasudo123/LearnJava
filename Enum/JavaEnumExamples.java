package Enum;

import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map.Entry;
import java.util.Set;

public class JavaEnumExamples {
	public static void main(String[]args) throws IOException{
//		usingEnumMethods();
//		
//		usingEnumValueOf();
//		
//		usingEnumValues();
//		
//		usingEnumInSwitch(ThreadStatesEnum.START);
//		usingEnumInSwitch(ThreadStatesEnum.DEAD);
//		
//		usingEnumSet();
//		
//		usingEnumMap();
	}

	
	private static void usingEnumMap(){
		/**
		 * 
		 * EnumMap 에서는 null 을 Key 로써 사용하지 못하며, 동기화되지 않는다.
		 * 
		 * **/
		
		
		EnumMap<ThreadStatesEnum, String> enumMap = new EnumMap<ThreadStatesEnum, String>(ThreadStatesEnum.class);
		enumMap.put(ThreadStatesEnum.START, "Thread is started");
		enumMap.put(ThreadStatesEnum.RUNNING, "Thread is running");
		enumMap.put(ThreadStatesEnum.WAITING, "Thread is waiting");
		enumMap.put(ThreadStatesEnum.DEAD, "Thread is dead");
		
		Set<ThreadStatesEnum> keySet = enumMap.keySet();
		
		for(ThreadStatesEnum key : keySet){
			System.out.println("key = " + key.toString());
		}
		
		// Key, Value 쌍으로 들어오는 값들
		for(Entry<ThreadStatesEnum, String> entrySet : enumMap.entrySet()){
			System.out.println(entrySet.getKey());
			System.out.println(entrySet.getValue());
			System.out.println("==================");
		}
	}
	
	
	private static void usingEnumSet(){
		/**
		 * 
		 * EnumSet 은 동기화되지 않으며 null 요소는 허용되지 않는다.
		 * 또한 Copy(Collection<E> c) or complementOf(EnumSet<E> s) 
		 * 와 같은 유용한 메소드를 제공한다.
		 * 
		 * **/
		
		EnumSet<ThreadStatesEnum> enumSet = EnumSet.allOf(ThreadStatesEnum.class);
		
		for(ThreadStatesEnum testEnum : enumSet){
			System.out.println("Using EnumSet, Priority = " + testEnum.getPriority());
		}
	}
	
	
	private static void usingEnumInSwitch(ThreadStatesEnum th) {
		/**
		 * 
		 * 스위치 케이스에서 enum 상수를 사용하기.
		 * 
		 * **/
		
		switch (th) {
		case START:
			System.out.println("START thread");
			break;
		case WAITING:
			System.out.println("WAITING thread");
			break;
		case RUNNING:
			System.out.println("RUNNING thread");
			break;
		case DEAD:
			System.out.println("DEAD thread");
		}
	}
	
	
	private static void usingEnumValues(){
		/**
		 * 
		 * (1) values() 메소드는 enum 에 포함된 모든 값을 가져온다.
		 * (2) 해당 메소드는 자바 컴파일러에 의해 자동으로 생성된다.
		 * 	   +) java.util.Enum 클래스에는 values() 구현이 없다.
		 * 
		 * **/
		
		ThreadStatesEnum[] thArray = ThreadStatesEnum.values();
		
		for(ThreadStatesEnum th : thArray){
			System.out.println(th.name());	// enum 상수 필드
			System.out.println(th.toString() + " :: Priority = " + th.getPriority());
			System.out.println();
		}
	}
	
	
	private static void usingEnumValueOf(){
		/**
		 * 
		 * (1) Enum.valueOf() 메소드를 이용하면, String 으로부터 enum 객체를 생성이 가능하다.
		 * (2) Enum.valueOf(enumType, String) 으로 해당 String 열거형이 없는 경우 런타임 에러 발생
		 * 
		 * **/
		
		ThreadStatesEnum th = Enum.valueOf(ThreadStatesEnum.class, "START");
		System.out.println("th Priority = " + th.getPriority());
	}
	
	
	private static void usingEnumMethods() throws IOException{
		/**
		 * 
		 * (1) 어떻게 enum 객체를 생성하는지
		 * (2) enum 객체에 대한 메소드를 이용하는 방법
		 * (3) setPriority 를 활용해 enum 변수를 변경하는 방법
		 * 
		 * **/
		
		ThreadStatesEnum thc = null;
		
		thc = ThreadStatesEnum.DEAD;
		System.out.println("Priority is : " + thc.getPriority());
		
		thc = ThreadStatesEnum.DEAD;
		System.out.println("Using overriden method. : " + thc.toString());
		
		thc = ThreadStatesEnum.START;
		System.out.println("Using overriden method. : " + thc.toString());
		
		thc.setPriority(10);
		System.out.println("Enum Constant variable changed priority value : "+thc.getPriority());
	
		thc.close();
	}
}
