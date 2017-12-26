package JavaProgmr;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class StreamAPIExplain {
	public static void main(String[]args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(20);
		list.add(33);
		list.add(1);
		list.add(66);
		
		// 일반적인 Iterator Java API 이용
		System.out.println(sumIterator(list));
		
		// Internal StreamAPI 이용
		System.out.println(sumStream(list));
		
		/* reference : 
		 * https://www.journaldev.com/2774/java-8-stream?utm_source=website&utm_medium=sidebar&utm_campaign=Core-Java-Sidebar-Widget#stream-overview
		 * 
		 * [ Java 8 Stream API 핵심 개념 ]
		 * 
		 * (1) Collection & Java Stream
		 * - 컬렉션은 값을 보유하는 메모리 구조
		 * - 컬렉션을 사용하기 이전에 모든 값이 채워져 있어야 한다.
		 * - 반면 Java Stream 은 요청 시 계산되는 데이터 구조
		 * 
		 * - Java Stream 은 데이터를 저장하지 않는다.
		 * - 해당 소스 데이터 구조 (Collection 혹은 Array) 에서 작동하며,
		 * - 특정한 작업을 수행하거나 사용할 수 있도록 파이프라인된 데이터를 생성한다.
		 * 
		 * - 해당 리스트에서 스트림을 생성하고, 조건에 따라 필터링이 가능하다.
		 * 
		 * - Java Stream 은 함수형 인터페이스를 사용하므로 람다식을 사용하는 함수형 프로그래밍에 적합
		 * 
		 * - Java 8 Stream 내부 반복 원칙은 스트릠 작업에서 지연 검색을 달성하는 것을 도와준다.
		 * - 더 높은 성능 및 최적화 범위가 허용된다. 그리고 재사용이 불가하다.
		 * 
		 * - 모든 Java Stream API 인터페이스 및 클래스는 java.util.Stream 패키지에 있다.
		 * - int, double 과 같은 원시형 데이터는 오토 박싱에 많은 시간이 소모될 수 있으므로
		 * - 원시형 데이터에 대한 특정 클래스가 존재한다. (IntStream & LongStream & DoubleStream)
		 * 
		 * (2) Functional Interfaces in Java 8 Stream (기능 인터페이스 일부)
		 * (2-1) Function and BiFunction
		 * - Function<T, R>
		 * - T 가 입력 유형, R 이 결과 유형
		 * 
		 * (2-2) Predicate and BiPredicate
		 * - 스트림 요소를 테스트 
		 * 
		 * (2-3) Consumer and BiConsumer
		 * - 단일 입력 변수를 허용하고, 결과를 리턴하지 않는 연산
		 * 
		 * (2-4) Supplier
		 * - 스트림에서 새 값을 생성할 수 있는 연산을 나타낸다.
		 * 
		 * 자세한 내용은 reference 에 ...
		 * */
	}
	
	// 정수의 합을 알기 위해서, Iterator 함수를 이용해야 한다.
	// 간단한 작업을 수행하는데 많은 코드를 필요로 한다.
	private static int sumIterator(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num > 10) {
				sum += num;
			}
		}
		return sum;
		
		/*
		 * parameter 로 받아오는 list 에서, 10보다 큰 정수의 합을 구하고 리턴한다.
		 * 위의 코드는 세가지 문제점이  존재한다.
		 * 
		 * (1) 정수의 합을 알기 이전에, Iterataion API 를 구현해야 한다. 
		 * - 이것은 클라이언트 프로그램이 리스트를 반복하는 알고리즘을 처리하기 때문에, 
		 * - external iteration(외부 이터레이션) 이라고 부른다.
		 * 
		 * (2) 위의 코드는 순차적인 진행이며, 병렬적(parallel)으로 수행하기에는 어렵다.
		 * 
		 * (3) 간단한 연산을 수행하기 위해, 많은 코드를 필요로 하고 있다.
		 * 
		 * */
		
		// --> 결과적으로 위의 단점을 극복하고자 StreamAPI 를 이용
		// --> StreamAPI 를 이용하여, Internal iteration 을 구현 (반복을 제어)
	}
	
	// sumIterator() 가 가진 단점을 극복, 내부 스트림 API 를 이용
	// 순차 및 병렬 실행, 주어진 기준에 따른 필터링, 매핑 등 여러가지 기능 제공
	private static int sumStream(List<Integer> list){
		return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
	}
}
