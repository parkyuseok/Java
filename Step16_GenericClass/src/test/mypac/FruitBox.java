package test.mypac;

public class FruitBox<T> { // <T, T2> 이런식으로 두개도 지정해줄수 있다.
	// 필드의 data type을 Generic 클래스로 지정하기
	private T item;
	// 메소드에 전달 받는 data type을 Generic 클래스로 지정하기
	public void push(T item) {
		this.item=item;
	}
	// 메소드의 return type을 Generic 클래스로 지정하기
	public T pull() {
		return this.item;
	}
}
