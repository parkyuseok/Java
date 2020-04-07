package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 *  영어 사전
		 *  
		 *  apple : 사과
		 *  ball  : 공
		 *  money : 돈
		 *  game  : 놀이
		 *  book  : 책
		 */
		Map<String, String> dic=new HashMap<>();
		dic.put("apple", "사과");
		dic.put("ball", "공");
		dic.put("money", "돈");
		dic.put("game", "놀이");
		dic.put("book", "책");
		/*
		 *  키보드로 부터 입력 받을수 있는 Scanner 객체 생성하기
		 *  System.in 은 키보드와 연결된 InputStream 객체 이다.
		 */  
		Scanner scan=new Scanner(System.in);
		
		while(true) {
		
		System.out.print("찾을 단어 입력(종료는 Q 입력):");
		// 문자열 한줄 입력 받기
		String word=scan.nextLine();
		
		// 단어 찾기
		String mean=dic.get(word);
		
		System.out.println(word+" 의 뜻은 "+mean+" 입니다.");
		if(word.equals("q"))
			break;
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
