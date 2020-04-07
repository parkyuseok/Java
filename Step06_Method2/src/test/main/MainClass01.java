package test.main;

import test.mypac.MyUtill;
import test.mypac.Pen;

public class MainClass01 {
	public static void main(String[] args) {
		// 날씨가 궁금 하다면?
		// static 메소드는 클래스명으로 호출하고
		MyUtill.showWeater();
		// non-static 메소드는 참조값으로 호출한다.
		new MyUtill().printWeater();
		// 메소드를 호출하고 나서 리턴된 값을 변수에 담기
		String result = new MyUtill().getWeather();
		System.out.println(result);
		
		Pen p=new MyUtill().getPen();
		p.write();
		
		new MyUtill().getPen().write();
	}
}
