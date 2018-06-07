
/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 * 
 * (1) Pass By Value
 * - 메소드의 파라미터는 다른 변수의 값에 의해 복사되며, 복사된 객체가 전달된다.
 * 
 * (2) Pass By Reference 
 * - 실제 매개변수의 Alias or Reference 가 전달된다.
 * 
 * => 자바는 항상 Pass By Value 이며, Pass By Reference 가 아니다.
 * 
 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/

/**ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 * 
 * 	[ 간단한 예제 ]
 * 	Balloon 클래스
 * 
 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ**/
class Balloon{
	private String color;
	
	public Balloon(){}
	
	public Balloon(String c){
		this.color = c;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
}


class Main {
	public static void main(String[] args) {
		Balloon red = new Balloon("Red");
		Balloon blue = new Balloon("Blue");
		
		System.out.println("swap() 이전 ㅡㅡㅡㅡ");
		System.out.println("red color = " + red.getColor());
		System.out.println("blue color = " + blue.getColor());
		
		/** SWAP() **/
		swap(red, blue);
		
		System.out.println("\nswap() 이후 ㅡㅡㅡㅡ");
		System.out.println("red color = " + red.getColor());
		System.out.println("blue color = " + blue.getColor());
		
		System.out.println("\nfoo() 이전 ㅡㅡㅡㅡ");
		System.out.println("blue color = " + blue.getColor());
		
		/** FOO() **/
		foo(blue);
		
		System.out.println("\nfoo() 이후 ㅡㅡㅡㅡ");
		System.out.println("blue color = " + blue.getColor());
	}
	
	private static void foo(Balloon balloon){
		balloon.setColor("Yellow");
		balloon = new Balloon("Green");
		balloon.setColor("Blue");
	}
	
	// o1 <ㅡ> o2
	public static void swap(Object o1, Object o2){
		Object temp = o1;
		o1 = o2;
		o2 = temp;
	} // 메소드 종료
}