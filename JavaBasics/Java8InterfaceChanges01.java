package JavaBasic;

/*
 * Java8 이전에는 인터페이스가 메소드 선언만 할 수 있었다.
 * 하지만 Java8 이후부터 인터페이스는 선언 및 구현까지도 가능하다.
 * Java8 에서 인터페이스는 default Method 와 static Method 를 가질 수 있다.
 * 
 * 이전에 존재하는 인터페이스와 추상클래스의 차이점을 줄여줄 수 있다.
 * 인터페이스에 기본 메소드를 도입하게 된 주요 계기는 Collection API 를 개선하여 람다표현식을 지원하기 위함이다.
 * 
 * 자바 인터페이스의 디폴트 메소드를 Defender 메소드 혹은 Virtual Extension Methods 라고도 한다.
 * */

interface Interface1{
	void method1(String str);
	
	// 디폴트 메소드를 이용하기 위해선 default 키워드를 이용해주어야 한다.
	// 디폴트 메소드를 이용했기 때문에 Interface1 구현하는 클래스는 디폴트 메소드를 구현하지 않아도 상관없다.
	default void log(String str){
		System.out.println("Interface1 logging :: " + str);
	}
}

class SubClass1 implements Interface1{
	// SubClass1 은 Interface1 의 디폴트 메소드를 구현하지 않아도 상관 없다.
	// 이러한 이점은 인터페이스를 확장하고 다른 메소드를 추가하는 이점을 누릴 수 있다.
	
	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub
		
	}
}

interface Interface2{
	void method2();
	
	default void log(String str){
		System.out.println("Interface2 logging :: " + str);
	}
}

class RealizeClass implements Interface1, Interface2{

	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void method2() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void log(String str){
		// [ 문제  ]
		// public void log(String str) 메소드를 제거하면 컴파일 에러가 나온다.
		
		// [ 이유  ]
		// 자바는 다중상속을 허용하지 않는다. 이러한 문제를  Diamond Problem 이라고 뜻한다.
		// 왜냐하면 상속받는 클래스가 부모클래스의 어느 슈퍼클래스에 대한 메소드를 사용할지 문제가 생기기 때문
		//
		// Interface 에도 동일하게 문제가 생길 수 있음.
		//
		// Interface1 & Interface2 양쪽에 동일한 디폴트 메소드가 존재하기 때문에
		// log() 메소드를 오버라이딩 해주어야 한다.
	}
}

public class Java8InterfaceChanges01 {
	public static void main(String[]args){
		
	}
}
