package test.main;
// import 까먹지 말기!!!
import java.util.Random;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * 1~45 사이의 랜덤한 정수를 5번 얻너내서 콘솔창에 출력하기
		 */
		
		Random ran=new Random();
		// 반복문을 활용한다면...
		for(int i=0; i<5; i++) {
			int result=ran.nextInt(45)+1;
			System.out.println(result);
		}
//		int result1=ran.nextInt(45)+1;
//		System.out.println(result1);
//		int result2=ran.nextInt(45)+1;
//		System.out.println(result2);
//		int result3=ran.nextInt(45)+1;
//		System.out.println(result3);
//		int result4=ran.nextInt(45)+1;
//		System.out.println(result4);
//		int result5=ran.nextInt(45)+1;
//		System.out.println(result5);		
	}
}
