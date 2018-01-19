package DeclareAnnotation;

public class AnnotationDemo {
	public static void main(String[]args) throws IllegalAccessException, InstantiationException{
		
		// 컨텍스트 커네이너를 초기화한다.
		MyContextContainer demo = new MyContextContainer();
		
		// MyObject 객체를 하나 받아온다.
		MyObject obj = demo.get(MyObject.class);
		
		// print is "My name is JDM"
		// print is "This is StringInjector"
		// print is "null"
		System.out.println(obj.getName());
		System.out.println(obj.getDefaultValue());
		System.out.println(obj.getInvalidType());
	}
}
