package JavaProgmr;

import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class ArrayListVector {
	public static <T> void main(String[]args){
		/*
		 * ArrayList 와 Vector 모두 List Interface 를 구현.
		 * 둘 다 자료구조로 일반적인 배열을 이용하며 동적으로 크기 조정이 가능하다.
		 * 
		 * ArrayList & Vector 의 차이점을 살펴보자
		 * (1) 동기화 여부
		 * Vector 는 한 번에 하나의 쓰레드만 액세스한다.
		 * ArrayList 는 동시에 여러 쓰레드가 ArrayList 에 작업할 수 있다. (다중 스레드 작업 가능)
		 * 멀티스레드 환경에서 ArrayList 를 작업하려는 경우 코드블럭을 동기화 시켜주어야 한다.
		 * 
		 * (2) 퍼모먼스, 성능 측면
		 * Vector 는 동기화되기 때문에 상대적으로 느리고 ArrayList 가 더 빠르다.
		 * 
		 * (3) 데이터 증가
		 * Vector 는 해당 용량이 다 차면 현재의 용량에서 2배(double) 용량을 증가시킨다.
		 * ArrayList 는 해당 용량이 다 차면 현재 용량의 절반(half) 만 증가시킨다.
		 * 
		 * (4) 데이터 읽기
		 * Vector 는 Enumeration 과 Iterator 를 제공한다.
		 * ArrayList 는 Iterator 만 제공한다.
		 *  */
		
		ArrayList<String> arrList = new ArrayList<String>();
		Vector<String> vector = new Vector<String>();
		
		System.out.print("ArrayList Capacity :: ");
		try{
		System.out.println(findCapacity(arrList));
		}catch(Exception e){}
		
		// 가진 용량만큼 값을 삽입.
		for(int i = 0; i < 10; i++)
			arrList.add(String.valueOf(i));
		
		// 사이즈 확인
		System.out.print("ArrayList Size :: ");
		System.out.println(arrList.size());
		
		// 용량을 초과시킴.
		arrList.add("10");
		
		// 현재 가진 용량의 절반만 늘어났음을 확인할 수 있다.
		System.out.print("ArrayList Capacity :: ");
		try{
		System.out.println(findCapacity(arrList));
		}catch(Exception e){}
	}

	// ArrayList 에는 커패서티 메소드가 없어서 리플렉션으로 따로 구현해서 확인.
	// reference : http://javaonlineguide.net/2015/08/find-capacity-of-an-arraylist-in-java-size-vs-capacity-in-java-list-example.html
	public static int findCapacity(List<String> list) throws Exception{
		Field field = ArrayList.class.getDeclaredField("elementData");
		field.setAccessible(true);
		
		return ((Object[])field.get(list)).length;
	}
}
