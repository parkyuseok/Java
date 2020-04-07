package test.main;

public class MainClass01 {
	public static void main(String[] args) { // MainThread
		System.out.println("main 메소드가 시작 되었습니다.");
		// 새로운 스레드 시작 시키기
		new CounterThread().start(); // main 스레드와 상관 없이 start 메소드를 호출하는 즉시 시작된다. // run메소드 호출하면 x
		draw();
		System.out.println("main 메소드가 종료 됩니다.");
	}
	public static void draw() {
		System.out.println("5초 동안 그림을 그려요");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	 *  - 새로운 작업단위(Thread) 만들기
	 *  1. Thread 클래스를 상속받은 클래스를 정의 한다.
	 *  2. run() 메소드를 오버라이드 한다.
	 *  3. 만든 클래스를 이용해서 객체를 생성하고 start() 메소드를 호출하면
	 *     생성된 객체의 run() 메소드에서 새로운 작업단위가 시작된다.
	 */
	static class CounterThread extends Thread{ 
		@Override
		public void run() {
			System.out.println("새로운 스레드가 시작됨");
			int count=0;
			while(true) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				count++;
				System.out.println(count);
				if(count==10)break;
			}
			System.out.println("새로운 스레드가 종료됨");
		}
	}
}
