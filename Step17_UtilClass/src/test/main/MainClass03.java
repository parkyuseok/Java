package test.main;

import java.util.ArrayList;

import test.mypac.Pen;

public class MainClass03 {
	public static void main(String[] args) {
		// 1. Pen type을 담을수 있는 가변배열 객체를 생성해서 참조값을 pens
		// 라는 지역 변수에 담기
		ArrayList<Pen> pens=new ArrayList<>();
		// 2. pens 배열에 Pen 객체를 각각 3개 생성해서 순서대로 담아 보세요.
		pens.add(new Pen("Red"));
		pens.add(new Pen("Orange"));
		pens.add(new Pen("Yellow"));
		// 3. 반복문을 이용해서 pens 배열에 저장된 Pen 객체의 참조값을 이용해서
		//    참조해서 .write() 메소드를 호출해 보세요.
		for(int i=0; i<pens.size(); i++) { // pens.size(); check!
			Pen tmp=pens.get(i);
			tmp.write();
		}
		for(Pen tmp:pens) {
			tmp.write();
		}
	}
}
