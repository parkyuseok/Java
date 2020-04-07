package test.main;
/*
 *  [ 연산자 ]
 *  
 *  1. 산술연산자
 *  
 *  종류 : +, -, *, /, %
 */
public class MainClass01 {
	public static void main(String[] args) {
		int num1=5;
		int num2=2;
		// + 연산자를 이용해서 두수의 합을 구하기
		int sum = 10 + 1;
		int sum2 = num1 + num2;
		int sum3 = 10 + num2;
		
		// 정수 / 정수 로 나누면 결과도 정수이다.
		// 결과적으로 5를 3으로 나눈 몫을 얻어낸다.
		int result1 = 5 / 3; //1
		int result2 = num1 / num2; //2	
		// 나누었을때 정확한 실수값을 얻어내고 싶으면 둘중 하나는 실수여야 한다.
		double result3 = 5 / 3.0; // 정수.0 = 정수d 와 같다.
		// int type과 double type을 연산하면 결과는 double type 이다.
		// 넓은 범위와 좁은 범위를 연산하면 넓은 범위의 Data type이 나온다.
		double result4 = num1 / (double)num2;
		
		// num1 을 num2 로 나눈 나머지 값을 얻어낸다.
		int result5 = num1 % num2;
	}
}













