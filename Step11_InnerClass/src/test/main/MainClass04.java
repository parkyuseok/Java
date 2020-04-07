package test.main;

import test.mypac.Academy;

public class MainClass04 {
	public static void main(String[] args) {
		new Academy().teaching();
		/*
		 * 1. Academy 클래스의 teaching() 메소드를 재정의 하고 싶다.
		 * 2. teaching() 메소드 하나 때문에 파일을 새로 만들기는 싫다.
		 * 3. 내부 클래스로 만들기도 싫다.
		 * 4. Local 내부 클래스로 만들고 싶은데 새로운 type 을 만들어 내기도 싫다.
		 */
//2.	MyAcademy ma=new MyAcademy();
//		ma.teaching();
//	}
//	public static class MyAcademy extends Academy{
//		@Override
//		public void teaching() {
//			System.out.println("스파르타 식으로 학생들을 가르쳐요.");
//		}
	
//3.	class MyAcademy extends Academy{
//			@Override
//			public void teaching() {
//				System.out.println("스파르타 식으로 공부를 가르쳐요");
//			}
//		}
//		MyAcademy ma=new MyAcademy();
//		ma.teaching();
		Academy ac=new Academy() {
			@Override
			public void teaching() {
				System.out.println("스파르타 식으로 공부를 가르쳐요");
			}
		};
		ac.teaching();
	}
}
