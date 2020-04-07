package test.main;

import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass04 {
	public static void main(String[] args) {
		// Phone 객체를 생성해서 Phone type 변수에 담기
		Phone p1=new Phone();
		// class cast Exception이 발생한다. (Casting이 만능은 아니다.)
		SmartPhone p2=(SmartPhone)p1;
		p2.doInternet();
	}
}
