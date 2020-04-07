package test.mypac;
/*
 * [ interface ]
 * 
 * - 생성자가 없다. ( 단독 객체 생성 불가 )
 * - 구현된 메소드는 가질수 없다. ( 추상 메소드만 가질수 있다 )
 * - 필드는 static final 필드만 가질수 있다.( 값을 변경할수 없는 "static" 필드만 가질수 있다 )
 * - data type의 역활을 할수 있다.
 * - 인터페이스 type 의 참조값이 필요하다면 해당 인터페이스를 implements 한
 *   클래스를 이용해서 객체를 생성해서 얻어낸다.
 * - 인터페이스는 다중 implements 가 가능하다. ( 클래스는 단일 extends 만 가능하다 )
 */
public interface Remocon {
	// static final 상수
	public String COLOR="#000000";
	// 추상 메소드
	public abstract void up();
	public void down();
}
