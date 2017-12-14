package JavaProgmr;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

class Student{
	String name = "";
	int age = 0;
	int sex = 0; // 0 : 남, 1 : 여
	
	public Student(){}
	
	public Student(String name, int age, int sex){
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public void Tell(){
		System.out.println("Student Tell");
	}
	
	public void eat(){
		System.out.println("Student Eat");
	}
}

public class Reflection {
	public static void main(String[]args){
		Reflection ref = new Reflection();
		
		ref.basicReflection();
//		ref.applyReflection();
		
		/*
		 * 컴파일 시간이 아닌 런타임 시간에 다른 클래스에 대해서 동적으로 접근하고자 하는 경우
		 * 클래스와 멤버필드, 생성자, 메소드 등에 관한 정보를 얻을 때 사용한다.
		 * 
		 * 리플렉션은 외부에 공개되지 않은 private 멤버도 조작이 가능하니 주의해야 한다.
		 * private 멤버는 Field.setAccessible() 메소드를 true 로 지정하면 접근 가능하다.
		 * */
	}
	
	public void applyReflection(){
		try{
			// 에러 뜸
			Class c = Class.forName("Student");
			
			// 해당 클래스 이름
			System.out.println(c.getName());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void basicReflection(){
		try{
			// Vector 클래스
			Class c = Class.forName("java.util.Vector");
			
			// 선언된 메소드 목록 가져오기.
			Method[] methodList = c.getDeclaredMethods();
			
			// java.util.Vector 클래스가 가진 모든 메소드를 출력
			for(int idx = 0; idx < methodList.length; idx++){
				System.out.println(methodList[idx]);
			}
			
			System.out.println("==================================");
			
			// writeObject() 메소드
			Method method = methodList[27];
			
			// writeObject() 메소드의 
			// (1) 클래스 이름
			// (2) 메소드 이름
			// (3) 리턴 타입
			System.out.println("Class Name : " + method.getDeclaringClass());
			System.out.println("Method Name : " + method.getName());
			System.out.println("Return Type : " + method.getReturnType());

			System.out.println("==================================");
			
			// 매개변수들의 타입 변환
			Class[]paramTypes = method.getParameterTypes();
			for(int idx = 0; idx < paramTypes.length; idx++)
				System.out.println("Param Type : " + (idx + 1) + " : " + paramTypes[idx]);
			
			System.out.println("==================================");
			
			// 예외 타입 반환
			Class[]ExceptionTypes = method.getExceptionTypes();
			for(int idx = 0; idx < ExceptionTypes.length; idx++)
			System.out.println("Exception Type : " + (idx + 1) + " : " + ExceptionTypes[idx]);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
