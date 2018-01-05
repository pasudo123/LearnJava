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
		 * 
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * Range 범위의 값이 바이트 크기보다 1이 작은 이유는, 숫자를 표현하는 데이터타입에 있어서 
		 * 맨 앞의 비트를 부호로 나타내는 비트로 사용하기 때문이다. 범위안에는 중간에 0이 존재한다. 
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * JVM 의 피연산자 스택이 피연사자를 4Byte 단위로 저장하기 때문에
		 * int 보다 작은 자료형의 값을 계산하는 경우 int 형으로 캐스팅되어 연산이 수행
		 * 
		 * 정수형 데이터를 사용하게 되면 JVM에서 기본적으로 int형 데이터타입의 데이터로 인식을 해준다.
		 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 * 
		 * */
	}
}
