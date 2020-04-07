package test.main;

import test.mypac.Car;

public class MainClass01 {
	public static void main(String[] args) {
		// Car type 객체의 drive() 메소드 호출하기
		new Car().drive(); // 실행 했을때 heap 영역에 객체가 만들어진다.
		// Car type 객체의 필드에 값 대입하기
		new Car().brand="Tesla"; // String type만 들어갈수 있다.
		// Car type 객체의 필드에 저장된 값 읽어오기
		String a = new Car().brand;
	}
}
