package Enum;

public class Usage {
	private static void benefitsOfEnumOverConstants(){
		
		// Enum values are fixed
		simpleEnumExample(ThreadStates.START);
		simpleEnumExample(ThreadStates.WAITING);
		simpleEnumExample(ThreadStates.RUNNING);
		simpleEnumExample(ThreadStates.DEAD);
		simpleEnumExample(null);
		
		simpleConstantsExample(1);
		simpleConstantsExample(2);
		simpleConstantsExample(3);
		simpleConstantsExample(4);
		
		simpleConstantsExample(5);
		
		/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 
		 * -- simpleConstantExample() 메소드를 살펴보게 되면, 
		 * 어떠한 int형 변수 값을 넘길 수 있기 때문에 타입에 대해 불안정하다.
		 * 
		 * 
		 * -- simpleEnumExample() 메소드를 사용하게 되면 런타임 에러를 발생시키지 않느다.
		 * 대신에 컴파일 시간에 구문분석에 대한 오류를 통해서 문제점을 바로잡을 수 있다.
		 * enum 타입은 해당하는 타입만 파라미터로 받기 때문에 타입에 안정적임을 볼 수 있다.
		 * 
		 *ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
	}
	
	private static void simpleEnumExample(ThreadStates th){
		if(th == ThreadStates.START)
			System.out.println("Thread started");
		
		if(th == ThreadStates.WAITING)
			System.out.println("Thread is waiting");
		
		if(th == ThreadStates.RUNNING)
			System.out.println("Thread is running");
		
		else
			System.out.println("Thread is Dead");
	}
	
	private static void simpleConstantsExample(int i){
		if(i == ThreadStatesConstant.START)
			System.out.println("Thread Started");
		
		else if(i == ThreadStatesConstant.WAITING)
			System.out.println("Thread is Waiting");
		
		else if(i == ThreadStatesConstant.RUNNING)
			System.out.println("Thread is Running");
		
		else
			System.out.println("Thread is Dead");
	}
}
