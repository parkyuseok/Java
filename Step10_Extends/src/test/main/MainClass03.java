package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass03 {
	public static void main(String[] args) {
		// p1 에는 SmartPhone 객체의 참조값이 들어 있다.
		SmartPhone p1=new SmartPhone();
		
		SmartPhone p2=p1;
		HandPhone p3=p1;
		Phone p4=p1;
		Object p5=p1;
		
		//Phone p6=p5; X
		/*
		 * Object type 을 Casting 연산자(Phone)을 이용해서
		 * Phone type 으로 강제 형 변환 한다음
		 * Phone type 변수에 담을수있다.
		 */
		Phone p6=(Phone)p5;
		p6.call();
		// HandPhone type 으로 Casting
		HandPhone p7=(HandPhone)p5;
		// SmartPhone type 으로 Casting
		SmartPhone p8=(SmartPhone)p5;
	}
}
