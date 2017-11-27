package JavaBasic;

/*
 * interface
 * (1) 인터페이스는 메소드를 구현할 수 없다. 선언만 가능 (추상클래스는 일반메소드는 구현가능하다.)
 * (2) 인터페이스는 생성자를 가질 수 없기 때문에 생성할 수 없다.
 * (3) 기본적으로 인터페이스는 접근지정자가 public , static , final 이므로 접근지정자를 지정할 필요가 없다.
 * (4) 인터페이스를 구현하는 클래스는 인터페이스 내 모든 메소드를 구현하여야 한다.
 * (5) 인터페이스를 구현하는 클래스가 추상클래스이면 인터페이스 내 모든 메소드를 구현하지 않아도 된다.
 * */

// 인터페이스
interface Shape{
	// 인터페이스는 기본적으로
	// 접근지정자가 public , static , final 이다.
	// 이에 따라서 컴파일러가 따로 이의를 제공하지 않는다.
	public String LABLE = "Shape";
	
	void draw();
	double getArea();
}

// (5) 의 내용
abstract class ShapeAbs implements Shape{
	@Override 
	public double getArea(){
		return 0;
	}
}

// Shape 인터페이스를 구현하는 Rectangle 클래스
class Rectangle implements Shape{
	private double width;
	private double height;
	
	public Rectangle(double w, double h){
		this.width = w;
		this.height = h;
	}
	
	@Override
	public void draw(){
		System.out.println("Drawing Rectangle");
	}
	
	@Override
	public double getArea(){
		return this.height * this.width;
	}
}

// Shape 인터페이스를 구현하는 Circle 클래스
class Circle implements Shape{
	private double radius;
	
	public Circle(double r){
		this.radius = r;
	}
	
	@Override
	public void draw(){
		System.out.println("Drawing Circle");
	}
	
	@Override
	public double getArea(){
		return Math.PI*this.radius*this.radius;
	}
	
	public double getRadius(){
		return this.radius;
	}
}

public class InterfaceEx {
	public static void main(String[]args){
		// 인터페이스 프로그래밍
		Shape shape = new Circle(10);
		shape.draw(); 
		// Drawing Circle
		
		System.out.println("Area = " + shape.getArea());
		// Area = 314.1592653589793
		
		// Switching 
		shape = new Rectangle(10, 10);
		
		shape.draw();
		// Drawing Rectangle
		
		System.out.println("Area = " + shape.getArea());
		// Area = 100.0
		
		/* Interface 이점
		 * 인터페이스를 구현하는 클래스는 사용 중인 메소드를 제거할 수 없다.
		 * 인터페이스는 계층적 구조의 코드에서 스타팅 포인드로써 지정하기 좋다.
		 * 자바 클래스는 여러 인터페이스를 구현할 수 있으므로 슈퍼클래스로 인터페이스를 사용하는 것이 좋음
		 * 
		 * Interface 단점
		 * 해당 인터페이스의 모든 메소드를 재정의한다면 모든 구현 클래스들에 대해서 유지보수의 어려움이 존재
		 * 기본 인터페이스를 확장하는 또 다른 인터페이스들이 필요
		 * */
		
		// reference 
		// https://www.journaldev.com/1601/interface-in-java?utm_source=website&utm_medium=sidebar&utm_campaign=Core-Java-Sidebar-Widget#java-interface-implementation-example
	}
}
