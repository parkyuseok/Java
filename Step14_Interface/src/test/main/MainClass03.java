package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	public static void main(String[] args) {
		Remocon r1=new Remocon() { // implements Remocon 된 익명 클래스
			
			@Override
			public void up() {
				System.out.println("아무거나 올려");
			}
			
			@Override
			public void down() {
				System.out.println("몰라 아무거나 내려");
			}
		};
		// useRemocon() 메소드 호출하면서 Remocon type 참조값 전달하기
		useRemocon(r1);
		useRemocon(new Remocon() {
			
			@Override
			public void up() {
				System.out.println("바로 올려");
			}
			
			@Override
			public void down() {
				System.out.println("바로 내려");
			}
		});
	}
	public static void useRemocon(Remocon r){
		r.up();
		r.down();
	}
}
