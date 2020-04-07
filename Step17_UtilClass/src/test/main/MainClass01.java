package test.main;

import java.util.ArrayList;

public class MainClass01 {
	public static void main(String[] args) {
		// String type 을 담을수 있는 가변 배열객체 생성해서 참조값을 변수에 담기
		ArrayList<String> names=new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");	// javascript의 names.push 와 같다.	
		
		// 배열의 방의 크기 참조
		int size=names.size();
		
		// 0번방에 저장된 참조값 얻어오기
		String name0=names.get(0);
		System.out.println(name0);
		// 1번방에 없애기(삭제하기) 2번방의 인덱스가 1번방으로 당겨진다.
		names.remove(1);
		
		// 모든 방 없애기(삭제하기)
		names.clear();
	}
}
