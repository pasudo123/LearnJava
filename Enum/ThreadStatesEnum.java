package Enum;

import java.io.Closeable;
import java.io.IOException;

// enum 타입으로 할 수 있는 모든 것들

public enum ThreadStatesEnum implements Closeable{
	START(1){
		@Override
		public String toString(){
			return "START implements. Priority = " + getPriority();
		}
		
		@Override
		public String getDetail(){
			return "START";
		}
	},
	
	RUNNING(2){
		@Override
		public String getDetail(){
			return "RUNNING";
		}
	},
	
	WAITING(3){
		@Override
		public String getDetail(){
			return "WAITING";
		}
	},
	
	DEAD(4){
		@Override
		public String getDetail(){
			return "DEAD";
		}
	};
	
	// Enum 타입 내부의 기본형 필드
	private int priority;
	
	// Enum 타입 내부의 추상메소드
	public abstract String getDetail();
	
	// Enum 타입의 생성자는 항상 접근지정자가 private
	private ThreadStatesEnum(int i){
		priority = i;
	}
	
	// Enum 은 메소드를 가질 수 있다.
	public int getPriority(){
		return this.priority;
	}
	
	public void setPriority(int p){
		this.priority = p;
	}
	
	// Enum 은 메소드 오버라이딩이 가능하다.
	@Override
	public String toString(){
		return "Default ThreadStatesConstructors implementation. Priority = " + getPriority();
	}
	
	@Override
	public void close() throws IOException{
		System.out.println("Close of Enum");
	}
}

/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 * 
 * [ Enum Type 정리 ]
 * 
 * (1)  enum 은 인터페이스를 구현할 수 있다.
 * (2)  enum 생성자의 접근지정자는 항상 private 이다. 
 * 	    **모든 enum 필드는 생성자에 따라서 디폴트 혹은 파라미터 있는 생성자를 만들 수 있다.
 * (3)  new 연산자를 사용해서 enum의 인스턴스를 만들 수 없다.
 * (4)  enum 에서 추상 메소드를 선언할 수 있으며, **모든 enum 필드는 추상 메소드를 구현하여야 한다.
 * (5)  enum 상수는 네임스페이스가 가능하다. 위의 예시에서 ThreadStatesEnum.START  가 가능하는 의미.
 * (6)  enum 필드를 새롭게 추가할 수 있다.
 * (7)  enum 상수는 대문자와 언더바로 작성한다.
 * (8)  enum 상수는 기본이 static final 이다.
 * (9)  enum 필드는 언제든 변경이 가능하다. 위의 예어서 priority 가 대표적인 예이다.
 * (10) enum 상수는 static final 이기 때문에 "==" or equals() 메소드를 사용하여 안전하게 비교할 수 있다.
 * 
 *ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
