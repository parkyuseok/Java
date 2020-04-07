package test.mypac;
/*
 * extends 클래스명을 작성하지 않으면 자동으로 extends Object 된다.
 * 즉 자동으로 Object 클래스를 상속받게 되는 것이다.
 */
public class Phone extends Object{
	// 전화 하는 기능
	public void call() {
		System.out.println("전화를 걸어요");
	}
}
