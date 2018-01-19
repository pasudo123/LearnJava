package DeclareAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 멤버 변수에 선언시 해당 멤버 변수 타입이 String이라면,
 * 어노테이션에 정의된 값을 멤버변수에 주입한다.
 * */

@Target(ElementType.FIELD)	// 멤버 변수 선언시
@Retention(RetentionPolicy.RUNTIME)
public @interface StringInjector {
	String value() default "This is StringInjector";
}
