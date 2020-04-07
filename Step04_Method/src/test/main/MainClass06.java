package test.main;

//다른 package 에 있는 클래스를 사용하려면 import 를 해야한다.
import test.mypac.YourUtill;

public class MainClass06 {
	// run 했을때 실행순서가 시작되는 특별한 main() 메소드
	public static void main(String[] args) {
		/*
		 * 프로그래밍의 목적이
		 * 1. 파일을 업로드 하고
		 * 2. 파일을 다운로드 하는것이 목적이라면 ?
		 */
		YourUtill.fileUp();
		YourUtill.fileDown();
	}
}
