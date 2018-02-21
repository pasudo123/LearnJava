package JavaBasic;

/*
 * Java Interface Static Method
 * */

// 올바르게 구현되어있는 클래스
interface MyData{
	default void print(String str){
		if(!isNull(str)){
			System.out.println("MyData Print :: " + str);
		}
	}
	
	static boolean isNull(String str){
		System.out.println("Interface Null Check");
		
		// str 이 null ?
		// str 이 공백    ?
		return str == null? true:"".equals(str)? true:false;
	}
}

// 올바르게 구현되지 못한 클래스
class MyDatalmpl implements MyData{
	// 해당 클래스 MyDataImpl 는 isNull() 메소드를 구현하는데 있어서,
	// static method isNull() 을 오버라이딩 하지 못한다.
	// @Override 애노테이션 처리를 하면 컴파일 에러가 발생한다.
	
	// 인터페이스 static method 는 유틸리티 메소드를 제공하는데,
	// 널 점검이나 콜렉션 정렬등을 제공하는데 적합하다.
	// 결과적으로 static method 를 오버라이딩 하지 못하게 하여 보안을 하는데 유리하다.
	
	public boolean isNull(String str){
		System.out.println("lmpl Null Check");
		
		return str == null? true:false;
	}
}

public class Java8InterfaceChanges02 {
	public static void main(String[]args){
		MyDatalmpl obj = new MyDatalmpl();
		obj.print("");
		obj.isNull("abc");
		
		System.out.println(obj.isNull("abc"));
	}
}
