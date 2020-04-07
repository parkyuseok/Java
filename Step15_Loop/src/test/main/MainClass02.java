package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		String[] names= {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};
		for(int i=0; i<names.length; i++) {
			// i번째 String type 참조하기
			String tmp=names[i]; // 배열 안의 data type으로 선언한다.
			System.out.println(tmp);
		}
		System.out.println("확장 for 문을 활용하면...");
		// 확장 for 문 -> for 문이 돌때 변수 i를 활용할 필요가 없을 때
		for(String tmp:names) {
			System.out.println(tmp);
		}
	}
}
