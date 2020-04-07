package test.main;

import test.mypac.Weapon;

public class MainClass03 {
	// Weapon 추상 클래스를 상속 받은 inner class
	class AWeapon extends Weapon{
		@Override
		public void attack() {
			System.out.println("A 형태로 공격을 해요!");
		}
	}
	public static void main(String[] args) {
		// Weapon 추상 클래스를 상속받은 Local Inner Class
		// non static inner class 를 이용해서 객체 생성
		Weapon w1=new MainClass03().new AWeapon();
		w1.prepare();
		w1.attack();
		
		class Bweapon extends Weapon{
			@Override
			public void attack() {
				System.out.println("B 형태로 공격해요");
			}
		}
		// local inner class 를 이용해서 객체 생성
		Weapon w2=new Bweapon();
		w2.prepare();
		w2.attack();
	}
}
