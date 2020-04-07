package test.main;

import java.util.Scanner;

import test.mypac.GuraException;

public class MainClass04 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
		System.out.println("클럽입니다.");
		System.out.print("이름을 입력 하세요:");
		String name=scan.nextLine();
		if(name.equals("김구라")) {
			throw new GuraException("김구라 출입금지!"); // 예외 객체를 생성해서 던진다.
		}
		System.out.println(name+"님 클럽에서 신나게 놀아요");
		}catch(GuraException ge){
			System.out.println("김구라 출입금지!");
			ge.printStackTrace();
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
