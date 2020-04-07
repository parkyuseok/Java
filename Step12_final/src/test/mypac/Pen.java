package test.mypac;
/*
 * 클래스를 정의 할때 final 예약어를 붙이면 해당 클래스를 상속받는
 * 자식 클래스를 정의할수 없는 마지막 클래스
 * 즉, 종단 클래스가 된다. 고자 클래스
 */
public final class Pen {
 public void write() {
	 System.out.println("필기를 해요!");
 }
}
