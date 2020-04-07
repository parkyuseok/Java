package test.mypac;

public class MyUtil {
	public static void draw() {
		System.out.println("5초 동안 그림을 그려요");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("그림 그리기 완료");
	}
	public static void send() throws InterruptedException { // send에 발생하는 exception을 호출하는 쪽으로 미룸.
		System.out.println("5초 동안 전송을 해요");
		Thread.sleep(5000);
		System.out.println("전송 완료");
	}
}
