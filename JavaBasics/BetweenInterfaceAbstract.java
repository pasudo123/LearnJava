package JavaBasic;

/* Difference between Abstract Class & Interface
 * (1) 추상클래스는 main() 를 포함할 수 있기 때문에, 실행이 가능하지만, 인터페이스는 그렇지 않다.
 * abstract class Main{
 * 	public static void main(String[]args){
 *  	//// 
 *  }
 * }
 * 
 * (2) 추상클래스는 extends 키워드를 이용하는 반면 인터페이스는 implements 를 이용한다.
 * 
 * (3) 추상클래스를 상속받는 자식클래스는 추상클래스가 가진 추상메소드를 오버라이딩해야 한다.
 * (3-1) 하지만 추상클래스를 상속받는 자식클래스가 추상클래스인 경우에는 부모클래스의 추상메소드를 오버라이딩하지 않아도 된다.
 * 
 * (4) 추상클래스는 일반 메소드를 구현할 수 있지만, 인터페이스는 하지 못한다.
 * (4-1) 하지만 자바8 에서 인터페이스도 메소드 구현이 가능하다.
 * 
 * (5) 추상클래스는 생성자를 가질 수 있지만, 인터페이스는 가지지 못한다.
 * 
 * (6) 추상클래스는 인스턴스화 하지 못한다는 점을 제외하면 일반 클래스와 동일한 특징을 지닌다.
 * (6-1) 인터페이스는 완전하게 다른 타입이다.
 * 
 * (7) 추상클래스는 접근지정자를 public, private(unused), protected, static(구현해야함) 을 이용할 수 있다.
 * (7-1) 인터페이스는 접근지정자를 public & abstract 밖에 이용하지 못한다.
 * (7-2) 인터페이스에 대한 내용이 자바 8에서 변경되었다.
 * */

public class BetweenInterfaceAbstract {
	public static void main(String[]args){
		
	}
}
