package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	static Weapon w1=new Weapon() {	
		@Override
		public void attack() {
			System.out.println("제일 먼저 본 사람을 혼내준다.");
		}
	};
	public static void main(String[] args) {
		// useWeapon 메소드를 호출해 보세요.
		MainClass05.useWeapon(w1);
		
		MainClass05.useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("고백해서 혼내준다.");				
			}
		});
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
