package test.main;

import test.mypac.Weapon;

public class MainClass04 {
	
	// Weapon type 의 static 필드
	static Weapon w2=new Weapon() {
		
		@Override
		public void attack() {
			System.out.println("static Weapon w2=new Weapon Ctrl+space를"
					+ "치면 자동으로 오버라이드 되요~");
		}
	};
	public static void main(String[] args) {
		/* 
		 * Weapon 추상 클래스 type 의 참조값을 익명의 Local inner class
		 * 를 이용해서 얻어내기
		 *
		 * class ? extends Weapon{
		 *     public void attack(){}
		 * }
		 * Weapon w1=new ?();
		 */
		Weapon w1=new Weapon() {
			@Override
			public void attack() {
				System.out.println("내 마음대로 공격해요");
			}
		};
		w1.prepare();
		w1.attack();
		MainClass04.w2.prepare();
		w2.attack();
	}
}
