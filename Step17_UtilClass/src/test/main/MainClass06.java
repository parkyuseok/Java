package test.main;

import java.util.HashMap;

import test.mypac.Pen;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 *  1. Pen 객체를 담을수 있는 HashMap 객체를 생성해서
		 *     참조값을 pens 라는 지역 변수에 담아 보세요.
		 */
		HashMap<String, Pen> pens=new HashMap<>();
		/*
		 *  2. pens 객체에 Pen 객체를 3개 생성해서 담아 보세요.
		 *  단, 담을때 key 값은 "red_pen", "green_pen", "blue_pen"
		 *  으로 담아 보세요.
		 */
		pens.put("red_pen", new Pen("red"));
		pens.put("green_pen", new Pen("green"));
		pens.put("blue_pen", new Pen("blue"));
		
		Pen p1=new Pen("yellow");
		pens.put("yellow_pen",p1);
		
		// 3. pens 에 들어 있는 Pen 객체의 참조값 불러오기
		Pen pen1=pens.get("red_pen");
		Pen pen2=pens.get("green_pen");
		Pen pen3=pens.get("blue_pen");
		Pen pen4=pens.get("yellow_pen");
		
		// 4. 테스트로 Pen 객체의 메소드 호출해보세요
		pen1.write();
		pen2.write();
		pen3.write();
		pen4.write();
		
		// pens 를 이용해서 직접 Pen 객체를 참조해서 메소드 호출하기
		pens.get("red_pen").write();
		pens.get("green_pen").write();
		pens.get("blue_pen").write();
		pens.get("yellow_pen").write();
	}
}
