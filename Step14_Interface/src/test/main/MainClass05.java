package test.main;

import test.mypac.Calculator;

public class MainClass05 {
	public static void main(String[] args) {
		Calculator add=(a, b)->{return a+b;};
		Calculator sub=(a, b)->a-b; // return 값 바로 적은 것 위와 동일한 식
		Calculator multi=(a, b)->a*b;
		
		double result1=add.execute(10, 20); // 30
		double result2=sub.execute(100, 90); // 10		
		double result3=multi.execute(10, 10); // 100		
	}
}
