package JavaProgmr;

import java.util.stream.Stream;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamAPIExample {
	public static void main(String[]args){
		
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

		// (1) Sequential Stream
		Stream<Integer> sequentialStream = exList.stream();
		// (2) Parallel Stream
		Stream<Integer> parallelStream = exList.parallelStream();
		
		
		// -- Stream 을 만들기 위해서, Stream.generate() 와 Stream.iterate() 메소드를 이용한다.
		Stream<String>stream1 = Stream.generate(()->{return "abc";});
		Stream<String>stream2 = Stream.iterate("abc", (i) -> i);
		
		
		// -- Arrays.stream() 과 String.chars() 메소드를 이용해서 Stream 을 만든다.
		LongStream lStream = Arrays.stream(new long[]{1, 2, 3, 4});
		IntStream iStream = "abc".chars();
	}
	
	// Converting Java Stream to Collection or Array
	public static void JavaStreamToCollectionOrArray(){
		
	}
}
