package test.main;

import test.maypac.Pen;

public class MainClass04 {
	public static void main(String[] args) {
		// 1. Pen 객체를 3개 생성해서 참조값을 pen1, pen2, pen3 라는 이름의
		// 지역 변수에 담아 보세요.
		Pen pen1=new Pen("red");
		Pen pen2=new Pen("blue");
		Pen pen3=new Pen("green");
		// 2. Pen 객체를 저장할수 있는 방 3개 짜리 빈 배열 객체를 생성해서
		// 참조값을 pens 라는 이름의 지역 변수에 담아 보세요.
		Pen[] pens= new Pen[3];
		// 3. 위에서 생성한 배열에 pen1, pen2, pen3 에 저장된 참조값을
		// 배열의 0번방, 1번방, 2번방에 순서대로 담아 보세요.
		pens[0]=pen1;
		pens[1]=pen2;
		pens[2]=pen3;
		// 4. pens 배열안에 들어있는 Pen 객체의 참조값을 이용해서 write() 메소드를
		// 호출해 보세요.
		pens[0].write();
		pens[1].write();
		pens[2].write();
		// 5. 4번에서 했던 작업을 for 문을 활용해서 해보세요.
		for(int i=0; i<pens.length; i++) {
			pens[i].write();
		}
	}
}
