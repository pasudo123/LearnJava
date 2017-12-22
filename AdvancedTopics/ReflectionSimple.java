package GeeksforGeeks;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Sample Class
class Student{
	private String name;
	private int roll_No;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getRoll_no(){
		return roll_No;
	}
	
	public void setRoll_no(int roll_no){
		this.roll_No = roll_no;
	}
}

public class Main {
	public static void main(String[]args){
		Student s = new Student();
		
		// 생성된 클래스 객체를 JVM 을 통해 반환
		Class c = s.getClass();
		
		System.out.println(c.getName());
		// >> GeeksforGeeks.Student
		
		
		// 클래스 내의 선언된 메소드를 배열 형태로 모두 반환
		Method m[] = c.getDeclaredMethods();
		for(Method method : m)
			System.out.println(method.getName());
		// >> getName
		// >> setName
		// >> getRoll_no
		// >> setRoll_no
		
		
		// 클래스 내의 선언된 필드를 배열 형태로 모두 반환
		Field f[] = c.getDeclaredFields();
		for(Field field : f)
			System.out.println(field.getName());
		// >> name
		// >> roll_No
		
		
		// 로드한 모든 .class 파일에 대해서 클래스 하나의 Object 만 생성.
		Student s2 = new Student();
		Class c2 = s2.getClass();
		System.out.println(c == c2);
		// >> true
	}
}
