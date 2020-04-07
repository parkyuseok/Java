package test.auto;
/*
 * 접근 지정자에 대한 정리
 * 
 * class 접근 지정자 : public, default
 * 생성자, field, method, 접근 지정자 : public, protected, default, private
 * public => 어디서든 접근 가능
 * protected => 같은 클래스, 같은 객체, 같은 package,
 * 				다른 package 이지만 상속 관계면 접근 가능
 * default => 같은 클래스, 같은 객체, 같은 package
 * private => 같은 클래스, 같은 객체
 */

public class Car {
	// 필드
	// protected => "나랑 관계된 패키지, 클래스, 메서드는 접근하도록 설정" ,"외부 패키지도 허용!"
	protected Engine engine; // 필드는 메소드가 정상 동작하기 위한 부품들인 경우가 많음
	// 생성자
	public Car(Engine engine) {
		this.engine=engine;
	}
	// 메소드
	public void drive() {
		if(this.engine==null) {
			System.out.println("Engine 객체가 없어서 못달려요!");
		}else {
		System.out.println("달려요!");
		}
	}
}
