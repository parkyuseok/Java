package test.main;

public class MainClass01 {
		public static void main(String[] args) {

			// 10번 반복되는 블럭 구성하기
			for(int i=0; i<10; i++) {
				// 반복되는 동안에 i는 0부터 1씩 증가하면서 9까지 변한다.
				System.out.println("i:"+i);
				System.out.println("안녕하세요");
			}			
			// int result2=i; for문에서 쓰이는 변수 i는 반복문이 도는 동안에서만 사용할 수 있다.
			// for문이 종료되면 변수 i는 사라진다.
		}
}
