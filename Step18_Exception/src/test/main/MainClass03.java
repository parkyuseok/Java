package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * 1~10 까지 출력을 하고 싶다.
		 * 단, 1초에 1번씩
		 */
		for(int i=0; i<10; i++) {
			System.out.println(i+1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
