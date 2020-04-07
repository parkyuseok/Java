package test.main;

import java.util.Random;

public class MainClass03 {
	public static void main(String[] args) {
		Random ran=new Random();
		int ranNum=ran.nextInt(6)+5;
		System.out.println(ranNum);
	}
}
