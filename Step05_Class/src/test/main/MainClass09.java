package test.main;

import java.util.Random;

import test.mypac.GuraUtil;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 1~45 사이의 랜덤한 정수를 5번 얻너내서 콘솔창에 출력하기
		 */
		// 반복문을 활용한다면...
		for(int i=0; i<5; i++) {
			int tmp=GuraUtil.ran.nextInt(45)+1;
			GuraUtil.out.println(tmp);
		}
	}
}
