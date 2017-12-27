package JavaProgmr;

import java.util.stream.Stream;

import javax.print.attribute.standard.NumberUpSupported;

import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class StreamAPIExample {
	public static void main(String[]args){
		
//		createJavaStream();
//		JavaStreamToCollection();
//		JavaStreamToArray();
		
		
		// [ Java Stream Intermediate Operations ] 
//		UseFilterIntermediateOperations();
//		UseMapIntermediateOperations();
//		UseSortedIntermediateOperations();
//		UseFlatMapIntermediateOperations();
		
		
		// [ Java Stream Terminal Operations ]
//		UseReduceTerminalOperations();
//		UseForEachTerminalOperations();
//		UseMatchTerminalOperations();
//		UseFindFirstTerminalOperations();
		
		
		// [ *** Java 8 Stream API Limitation *** ]
//		limitation();
		
		
		// [ *** Java Stream API Doc *** ]
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
	}

	
	// JavaStream 을 생성하기 위한 내용을 포함하고 있는 메소드
	public static void createJavaStream(){
		// -- Stream.of() 메소드를 이용하여, 유사한 타입의 데이터 스트림을 만들 수 있다.
		Stream<Integer>streamByInteger = Stream.of(1, 2, 3, 4);
		Stream<String>streamByString = Stream.of("1", "2", "3", "4");
		
		
		// -- 객체 배열을 가진 Stream.of() 메소드를 사용하여 스트림을 반환.
		// -- JDK1.5 이상에서 지원하는 auto-boxing 기능을 지원하지 않기에 명시적으로 형을 선언해준다.
		Stream<Integer>streamByIntegerArr = Stream.of(new Integer[]{1, 2, 3, 4});
		
		// Complie time Error : Type mismatch
		// Stream<Integer> stream = Stream.of(new int[] {1, 2, 3, 4});
		
		
		// -- Collection stream() 메소드를 통해서, 순차 스트림과 병렬 스트림을 만들 수 있다.
		List<Integer> exList = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++)
			exList.add((i+1));

		// (1) Sequential Stream : 순차 스트림
		Stream<Integer> sequentialStream = exList.stream();
		// (2) Parallel Stream : 병렬 스트림
		Stream<Integer> parallelStream = exList.parallelStream();
		
		
		// -- Stream 을 만들기 위해서, Stream.generate() 와 Stream.iterate() 메소드를 이용한다.
		Stream<String>stream1 = Stream.generate(()->{return "abc";});
		Stream<String>stream2 = Stream.iterate("abc", (i) -> i);
		
		
		// -- Arrays.stream() 과 String.chars() 메소드를 이용해서 Stream 을 만든다.
		LongStream lStream = Arrays.stream(new long[]{1, 2, 3, 4});
		IntStream iStream = "abc".chars();
	}
	
	
	// Converting Java Stream to Collection
	public static void JavaStreamToCollection(){
		
		// [ List 혹은 Map 혹은 Set 을 Stream 으로 얻어오기 위해서 collect() 메소드를 이용 ]
		
		// 1. List
		// Stream new Create
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println(intList); 
		// >> [1, 2, 3, 4]
		
		
		// 2. Map
		// Stream is Closed, 따라서 새롭게 생성해야 한다.
		intStream = Stream.of(1, 2, 3, 4);
		Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i->i, i->i+10));
		System.out.println(intMap);
		// >> {1=11, 2=12, 3=13, 4=14}
		
		
		// 3. Set
		// Stream is re Closed, 다시 닫혔기 때문에 새롭게 생성 (중복을 허용하지 않음)
		intStream = Stream.of(1, 2, 3, 4);
		Set<Integer> intSet = intStream.collect(Collectors.toSet());
		System.out.println(intSet);
		// >> [1, 2, 3, 4]
	}
	
	
	// Converting Java Stream to Array
	public static void JavaStreamToArray(){
		
		// -- [ To Create an Array from the Stream, Use stream toArray() 메소드 이용 ]
		
		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		Integer[]intArray = intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray));
		// >> [1, 2, 3, 4]
	}
	
	
	// Java Stream 중간 작업하기. (Intermediate Operations)
	// Stream filter() : filter 메소드를 사용하여, 
	// 조건에 대한 스트림 요소를 테스트하고 필터링된 목록을 생성가능.
	public static void UseFilterIntermediateOperations(){
		List<Integer> myList = new ArrayList<Integer>();
		
		for(int i = 0; i < 100; i++)
			myList.add(i);
		
		// 순차 스트림 형성
		Stream<Integer> sequentialStream = myList.stream();
		
		// filter 기능 : numbers greater than 90
		Stream<Integer> highNums = sequentialStream.filter(p->p > 90); 
		System.out.print("High Nums greater than 90 = ");
		highNums.forEach(p -> System.out.print(p + " "));
		// >> High Nums greater than 90 = 91 92 93 94 95 96 97 98 99 
	}
	
	
	// Java Stream 중간 작업하기. (Intermediate Operations)
	// Stream map() : map() 메소드를 사용하여 스트림에 적용할 수 있다.
	public static void UseMapIntermediateOperations(){
		Stream<String> names = Stream.of("aBc", "d", "ef");
		
		// map 기능을 이용해서, 람다를 구성하고, 구성된 스트림을 Collection, List 로 반환.
		System.out.println(names.map(s->{return s.toUpperCase();}).collect(Collectors.toList()));
		// >> [ABC, D, EF]
	}
	
	
	// Java Stream 중간 작업하기. (Intermediate Operations)
	// Stream sorted() : sorted() 메소드를 사용하여 Comparator 인수를 전달하여,
	// 스트림 요소를 특정 기준에 맞게 정렬
	public static void UseSortedIntermediateOperations(){
		Stream<String> names = Stream.of("aBc", "d", "ef", "123456");
		List<String> reverseSorted = names.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(reverseSorted);
		// >> [ef, d, aBc, 123456]
		
		
		names = Stream.of("aBc", "d", "ef", "123456");
		List<String> naturalSorted = names.sorted().collect(Collectors.toList());
		System.out.println(naturalSorted);
		// >> [123456, aBc, d, ef]
	}
	
	
	// Java Stream 중간 작업하기. (Intermediate Operations)
	// Stream flatMap() : flatMap() 메소드를 사용하여 list 의 스트림에서 스트림을 생성 가능
	public static void UseFlatMapIntermediateOperations(){
		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("PARK"), Arrays.asList("KIM", "JEON"), Arrays.asList("LEE"));
		
		// flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(strList ->strList.stream());;
		flatStream.forEach(System.out::println);
		// PARK
		// KIM
		// JEON
		// LEE
		
		// Java8 내부 반복 관련 반박 글 : http://gafter.blogspot.kr/2007/07/internal-versus-external-iterators.html
	}
	
	
	// Java Stream 터미널 작업. (Terminal Operations)
	public static void UseReduceTerminalOperations(){
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
		
		// reduce() 메소드를 사용, 연관 누적 함수를 이용해 스트림 요소의 감소를 수행하고 Optional 을 반환한다.
		Optional<Integer> intOptional = numbers.reduce((i, j) -> {return i*j;});
		if(intOptional.isPresent())
			System.out.println("Multiplication = " + intOptional.get());
			// >> 120
	}
	
	
	// Java Stream 터미널 작업. (Terminal Operations)
	public static void UseCountTerminalOperations(){
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
		
		// count() 메소드를 사용, 스트림 항목의 수를 계산할 수 있다.
		System.out.println("Number of elements in Stream = " + numbers.count());
		// >> 5
	}
	
	
	// Java Stream 터미널 작업. (Terminal Operations)
	public static void UseForEachTerminalOperations(){
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
		
		// forEach() 메소드를 사용, 스트림을 반복할 때 사용
		// forEach() 는 Iterator 대신에 사용할 수 있으며 스트림의 모든 요소를 출력할 수 있다.
		numbers.forEach(i->System.out.print(i + ", "));
		// >> 1, 2, 3, 4, 5,
	}
	
	
	// Java Stream 터미널 작업. (Terminal Operations)
	public static void UseMatchTerminalOperations(){
		// anyMatch(), allMatch(), noneMatch() 메소드를 이용해 Stream 요소 일치여부를 확인 가능.
		
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains 4 ? : " + numbers1.anyMatch(i -> i == 4));
		// Stream contains 4 ? : true
		
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream contains all elements less than 10 ? : " + numbers2.allMatch(i -> i < 10));
		// Stream contains all elements less than 10 ? : true
		
		Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5);
		System.out.println("Stream doesn't contain 10 ? : " + numbers3.noneMatch(i -> i == 10));
		// Stream doesn't contain 10 ? : true
	}
	
	
	// Java Stream 터미널 작업. (Terminal Operations)
	public static void UseFindFirstTerminalOperations(){
		// findFirst() 메소드를 통해서 첫번째 문자 'J' 를 가지고 있는 문자열을 찾는다.
		
		Stream<String> names = Stream.of("KIM", "JEON", "PARK", "LEE");
		Optional<String> firstNameWithJ = names.filter(i -> i.startsWith("J")).findFirst();
		
		if(firstNameWithJ.isPresent())
			System.out.println("First Name Starting With J = " + firstNameWithJ.get());
			// First Name Starting With J = JEON	
	}
	
	
	// Java 8 StreamAPI Limitation
	public static void limitation(){
		// 병렬 스트림을 사용하고 람다 표현식이  stateful (상태유지) 인 경우, 
		// 무작위적인 응답이 발생할 수 있다.
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
		List<Integer> result = new ArrayList<Integer>();
		Stream<Integer> stream = list.parallelStream();	// 병렬 스트림
//		Stream<Integer> stream = list.stream();	// 순차 스트림
		
		stream.map(s->{
			synchronized(result){
				if(result.size() < 10){
					result.add(s);
				}
			}
			return s;
		}).forEach(e -> {});
		
		// 순차스트림의 경우, 1 ~ 10 출력 (일정하다)
		// 병렬스트림의 경우, 무작위적 출력 (병렬처리를 위해 정의된 순서가 없기 떄문이다.)
		System.out.println(result);
		
		// 스트림은 한번 이용되고 나면, 이후에 다시 생성해주어야 한다.
		// 
	}
}
