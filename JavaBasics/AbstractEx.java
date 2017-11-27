package JavaBasic;

/*
 * abstract class
 * (1) 추상메소드를 하나라도 포함하고 있는 클래스
 * (2) 추상메소드는 선언만 할 수 있다. (추상메소드는 몸체가 없다.)
 * (3) 일반메소드는 구현이 가능하다.
 * (4) 추상클래스와 추상메소드를 만들기 위해 사용
 * (5) 추상클래스는 인스턴스화 하지 못한다.
 * (6) 하위 클래스에서 추상메소드를 구현 및 확장하며 재정의하기 위해 사용한다.
 * (7) 추상클래스는 다중상속을 지원하지 않는다.
 * (8) 추상클래스를 상속받는 클래스는 반드시 abstract method 를 재정의하여야 한다.
 * */

abstract class Person{
	private String name;
	private String gender;
	
	public Person(String nm, String gen){
		this.name = nm;
		this.gender = gen;
	}
	
	// abstract method
	public abstract void work();
	
	@Override
	public String toString(){
		return "Name = " + this.name + " :: Gender = " + this.gender;
	}
	
	// 이름 변경
	public void chanageName(String newName){
		this.name = newName;
	}
}

// Employee 클래스는 Person 클래스의 멤버변수와 메소드를 상속받는다.
class Employee extends Person{
	private int empId;
	
	public Employee(String nm, String gen, int id){
		// 슈퍼클래스 생성자 
		super(nm, gen);
		this.empId = id;
	}
	
	// 추상메소드를 무조건 재정의
	@Override
	public void work(){
		if(empId == 0){
			System.out.println("Not Working");
		}
		else{
			System.out.println("Working as employee !!");
		}
	}
	
	@Override
	public String toString(){
		return super.toString();
	}
}

public class AbstractEx {
	public static void main(String[]args){
		Person student = new Employee("Dove", "Female", 0);
		Person employee = new Employee("Pankaj", "Male", 123);
		
		student.work();
		employee.work();
		
		// Using Method implements in abstract class - inheritance (상속)
		employee.chanageName("Pankaj Kumar");
		
		System.out.println(student.toString());
		System.out.println(employee.toString());
	}
}
