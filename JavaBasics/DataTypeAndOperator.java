package JavaBasic;

import java.util.*;
import java.io.*;

class Person{
	String name;
	int age;
	char gender;
	
	Person(){}
}

public class DataTypeAndOperator {
	public static void main(String[]args){
		
		/*
		 * 자바는 선언형 프로그래밍 언이이다. 선언을 해야만 사용이 가능하기 때문이다.
		 *
		 * 자바에는 기본형(primitive type)과 참조형(reference type) 존재
		 * - 기본타입 >> 논리형, 문자형, 정수형, 실수형이 존재
		 * - 참조타입 >> 객체의 주소를 저장, null 혹은 객체의 주소
		 * 
		 * 여기서 메모리 구조도 같이 살펴볼 필요성이 있다.
		 * 
		 * --- Stack Area ---
		 * (1) Stack 영역은 변수값을 저장한다. 
		 * (2) 기본타입인 정수형 변수, 실수형 변수, 논리형 변수를 실제값으로 저장한다.
		 * (3) 참조형 변수(reference variable) 또한 객체의 주소를 할당하지 않은 상태에서는 스택 메모리에 저장된다.
		 * (4) 메모리 할당 시 컴파일 할 때 이미 계산이 이루어진다.
		 * (5) 메소드 작업이 종료되면 할당되었던 메모리 공간은 반환되서 비워진다. (스택 메모리는 일시적이다.)
		 * 
		 * 
		 * --- Heap Area ---
		 * (1) Heap 영역은 객체와 배열이 생성되는 공간이고, 참조타입(배열, 열거, 클래스, 인터페이스) 
		 * 힙영역에 주소형식으로 저장한다.
		 * (2) 크기가 정해져 있지 않다. 따라서 변경이 가능
		 * (3) 메모리 할당 시 프로그램을 실행할 때 메모리를 빌려 동적으로 할당
		 * (4) 참조하는 변수가 없다면 자동으로 힙 영역에서 제거된다. (GC 작용)
		 * */
		
		/*
		 * (1) boolean
		 * - Size : 8bits (= 1Byte)
		 * - Range : NA (Not Available)
		 * - Default Value : false
		 * - 자바가 데이터를 다루는 최소 범위가 1Byte 이기 때문에 낭비지만 1Byte 사용
		 * 
		 * 
		 * (2) char
		 * - Size : 16bits (= 2Byte)
		 * - Range : Unicode Characters
		 * - Default Value : '\u0000' or 0
		 * - 자바의 경우 유니코드를 사용하는 동양의 글자 경우 2Byte 가 필요, char 경우 2Byte 사용
		 * 
		 * 
		 * (3) byte
		 * - Size : 8bits (= 1Byte)
		 * - Range : [ -128 to 127 ] or [ -2^7 to 2^7-1 ]
		 * - Default Value : 0
		 * 
		 * 
		 * (4) short
		 * - Size : 16bits (= 2Byte)
		 * - Range : [ -2^15 to 2^15-1 ]
		 * - Default Value : 0
		 * 
		 * 
		 * (5) int 
		 * - Size : 32bits (= 4Byte)
		 * - Range : [ -2^31 to 2^31-1 ]
		 * - Default Value : 0
		 * 
		 * 
		 * (6) long
		 * - Size : 64bits (= 8Byte)
		 * - Range : [ -2^63 to 2^63-1 ]
		 * - Default Value : 0
		 * 
		 * 
		 * (7) float
		 * - Size : 32bits (= 4Byte)
		 * 
		 * 
		 * (8) double
		 * - Size : 64bits (= 8Byte)
		 * 
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 *
		 * 명시적 데이터 값 (리터럴)
		 * 자바에서는 명시적으로 사용하는 리터럴 값을 사용한다.
		 *
		 * 자바의 정수 리터럴은 기본이 int 형이다.
		 * 따라서 long 타입의 정수를 리터럴로 표현하기 위해서는 숫자 끝에 L(l)을 붙인다.
		 *
		 * 반면에,
		 * 자바의 실수 리터럴은 기본이 double 형이다.
		 *  float 타입의 실수를 리터럴로 표현하기 위해서 숫자 끝에 F(f)를 붙인다.
		 *
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 *
		 * Range 범위의 값이 바이트 크기보다 1이 작은 이유는, 숫자를 표현하는 데이터타입에 있어서 
		 * 맨 앞의 비트를 부호로 나타내는 비트로 사용하기 때문이다. 범위안에는 중간에 0이 존재한다. 
		 *
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 *
		 * JVM 의 피연산자 스택이 피연사자를 4Byte 단위로 저장하기 때문에
		 * int 보다 작은 자료형의 값을 계산하는 경우 int 형으로 캐스팅되어 연산이 수행
		 * 
		 * 정수형 데이터를 사용하게 되면 JVM에서 기본적으로 int형 데이터타입의 데이터로 인식을 해준다.
		 *
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 
		 * */
		
		/** ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ **/
		Byte byteMinValue = Byte.MIN_VALUE;
		Byte byteMaxValue = Byte.MAX_VALUE;
		
		Short shortMinValue = Short.MIN_VALUE;
		Short shortMaxValue = Short.MAX_VALUE;
		
		Integer intMinValue = Integer.MIN_VALUE;
		Integer intMaxValue = Integer.MAX_VALUE;
		
		Long longMinValue = Long.MIN_VALUE;
		Long longMaxValue = Long.MAX_VALUE;
		
		Float floatMinValue = Float.MIN_VALUE;
		Float floatMaxValue = Float.MAX_VALUE;
		
		Double doubleMinValue = Double.MIN_VALUE;
		Double doubleMaxValue = Double.MAX_VALUE;
		
		Boolean booleanFalse = Boolean.FALSE;
		Boolean booleanTrue = Boolean.TRUE;
		
		/**
		 * Byte.MIN_VALUE : -128
		 * Byte.MAX_VALUE : 127
		 * 
		 * Short.MIN_VALUE : -32768
		 * Short.MAX_VALUE : 32767
		 * 
		 * Integer.MIN_VALUE : -2147483648
		 * Integer.MAX_VALUE : 2147483647
		 * 
		 * Long.MIN_VALUE : -9223372036854775808
		 * Long.MAX_VALUE : 9223372036854775807
		 * 
		 * Float.MIN_VALUE : 1.4E-45
		 * Float.MAX_VALUE : 3.4028235E38
		 * 
		 * Double.MIN_VALUE : 4.9E-324
		 * Double.MAX_VALUE : 1.7976931348623157E308
		 * 
		 * Boolean.FALSE : false
		 * Boolean.TRUE : true
		 **/
	}
}
