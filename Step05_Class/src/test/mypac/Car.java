package test.mypac;
/*
 * [ 클래스의 용도 ]
 * 1. static 필드나 메소드를 감싸는 역활
 * 2. 객체의 설계도 역활
 * 3. data Type 역활
 */
public class Car {
	// 제조사
	public String brand=null; // field는 선언만 해도 null이 자동으로 들어간다.
	
	// 달리는 기능
	public void drive() {
		System.out.println("달려요~");
	}
	public void showBrand() {
		System.out.println("제조사:"+this.brand);
	}
}
