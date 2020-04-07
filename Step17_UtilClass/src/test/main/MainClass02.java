package test.main;

import java.util.ArrayList;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * 기본 data type은 Generic class로 지정할수 없다.
		 * 따라서 기본 데이터 type을 Generic 으로 지정을 하려면
		 * 기본 data type의 객체형을 사용해야 한다.
		 */
		ArrayList<Integer> nums=new ArrayList<>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		// 반복문 돌면서
		for(int i=0; i<nums.size(); i++) { // 고정 배열이면 nums.length이지만 가변 배열이므로 length가 아니다!!
			// i번째 방에 저장된 값 참조해서
			Integer tmp=nums.get(i); // Integer 대신 int를 써도 무방하다.
									 // 고정배열이면 nums[i]로 적는다.
			// 사용하기
			System.out.println(tmp);
		}
		System.out.println("확장 for 문을 활용하면");
		for(Integer tmp:nums) {
			System.out.println(tmp);
		}
	}
}
