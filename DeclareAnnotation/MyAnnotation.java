package DeclareAnnotation;

import java.lang.annotation.*;

@Inherited 	// 해당 어노테이션을 선언하면 부모클래스에서 어노테이션을 상속 가능
@Documented	// 문서에도 어노테이션 정보가 표현
@Retention(RetentionPolicy.RUNTIME)	// 어노테이션의 범위를 설정
/*
 * 컴파일 이후에도 JVM에 의해서 참조가 가능하다.
 * @Retention(RetentionPolicy.CLASS)  >> 컴파일러가 클래스를 참조할 때까지 유효
 * @Retention(RetentionPolicy.SOURCE) >> 어노테이션 정보는 컴파일 이후 없어진다.
 * */

// 어노테이션이 적용될 위치를 결정
@Target({
	ElementType.PACKAGE,		// 패키지 선언시
	ElementType.TYPE,			// 타입 선언시
	ElementType.CONSTRUCTOR,	// 생성자 선언시
	ElementType.FIELD,			// 멤버 변수 선언시
	ElementType.METHOD,			// 매소드 선언시
	ElementType.ANNOTATION_TYPE,// 어노테이션 타입 선언시
	ElementType.LOCAL_VARIABLE,	// 지역 변수 선언시
	ElementType.PARAMETER,		// 매개 변수 선언시
	ElementType.TYPE_PARAMETER,	// 매개 변수 타입 선언시
	ElementType.TYPE_USE		// 타입 사용시
})

public @interface MyAnnotation {
	// enum 타입을 선언할 수 있다.
	public enum Quality{BAD, GOOD, VERYGOOD}
	
	// String은 기본 자료형은 아니지만 사용이 가능하다.
	String value();
	
	// 배열 형태로도 사용할 수 있다.
	int[]values();
	
	// enum 형태로 사용할 수 있다.
	Quality quality() default Quality.GOOD;
}
