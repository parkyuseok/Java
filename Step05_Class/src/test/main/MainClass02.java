package test.main;
// package가 다르므로 import 해줘야 함
import test.mypac.Car;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * 달려야 한다면?
		 */
		Car c1=new Car();
		c1.drive();
		c1.brand="테슬라";
		c1.showBrand();
	}
}
