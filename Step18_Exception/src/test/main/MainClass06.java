package test.main;

import java.io.InterruptedIOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import test.mypac.Heater;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 *  날씨가 춥다. 어떻게 해야 할까?
		 *  난방을 해야지~~
		 */
		Heater heater=null; // 변수를 밖에서 만들어주고
		try {
			heater=new Heater(); // 내부에서 참조값을 넣어준다.
			// Heater heater=new Heater(); 지역변수 이므로 try{안에서만 쓸수 있음}
			heater.heat(); // 난방을 따닷하게 하고 일을 시작해요.
			
			Scanner scan=new Scanner(System.in);
			System.out.println("정수 입력:");
			int num=scan.nextInt();
			System.out.println("입력한 정수:"+num);
			
			heater.off(); // 작업을 다했으면 히터를 꺼요
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (InputMismatchException ime) {
			ime.printStackTrace();
		}finally { // Exception 발생과 상관 없이 실행이 보장되는 블럭
			// 무언가 마무리 작업은 여기서 하면 된다.
			heater.off();
		}
	}
}
