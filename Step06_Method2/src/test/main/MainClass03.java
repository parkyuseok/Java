package test.main;

import test.mypac.MyUtill;
import test.mypac.Pen;

public class MainClass03 {
	public static void main(String[] args) {
		// MyUtill 클래스에 정의된 showNum() 메소드를 호출해 보세요
		new MyUtill().showNum(10);
		// MyUtill 클래스에 정의된 showInfo() 메소드를 호출해 보세요
		new MyUtill().showInfo(10, "박유석");
		// MyUtill 클래스에 정의된 usePen() 메소드를 호출해 보세요
		new MyUtill().usePen(new Pen());
	}
}
