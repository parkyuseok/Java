package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		MainClass04.showSum(1, 2);
		int a=3;
		int b=4;
		MainClass04.showSum(a, b);
		MainClass04.showOperator(10, 20);
	}
	//인자로 전달된 두개의 정수를 더해서 결과값을 콘솔창에 출력하는 static 메소드
	public static void showSum(int num1, int num2) {
		int sum=num1+num2;
		System.out.println("전달된 두수의 합:"+sum);
	}
	public static void showOperator(int num3, int num4) {
		int Operator=num3*num4;
		System.out.println("전달된 두수의 곱:"+Operator);
	}
}
