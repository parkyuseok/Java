package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainClass11 {
	public static void main(String[] args) {
		// 로또 번호 6개 얻어내기
		
		Random ran=new Random();
		List<Integer> nums=new ArrayList<>();
		for(int i=0; i<6; i++) {
			// 1~45 사이의 랜덤한 정수 얻어내기
			int ranNum=ran.nextInt(45)+1;
			// 배열에 이미 존재 하는지 확인하기
			if(nums.contains(ranNum)) {
				i--; // 제어 변수값 되돌리기
			}else{ // 배열에 없는 수이면 배열에 추가하기
				nums.add(ranNum);
			}
		}
		
		// Collections 클래스의 static 메소드를 이용해서 정렬하기
		Collections.sort(nums);
		// 역순으로 뒤집기
		Collections.reverse(nums);
		
		for(int tmp:nums) {
			System.out.println(tmp);
		}
	}
}
