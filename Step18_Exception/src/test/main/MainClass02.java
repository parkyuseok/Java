package test.main;
/*
 * Exception 의 종류
 * 
 * 1. 실행시에 발생하는 Exception
 * - RuntimeException 을 상속 받은 예외 type 이다.
 * - try~catch 블럭을 작성해도 되고 안해도 된다.
 * 
 * 2. 컴파일시에 발생하는 Exception
 * - RuntimeException 을 상속 받지 않는 예외 type 이다.
 * - 반드시 try~catch 블럭을 작성해야 하거나 throw를 해야한다.(의무)
 */
public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		// 반드시 처리를 해야만 하는 Exception이 있다.
		// Exception을 처리하지 않으면 중대한 오류가 발생할수 있으므로 컴파일에서 잡아준다.
		try {
			Thread.sleep(1000*10);  // 실행의 흐름을 1초 동안 잡아 놓는다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 메소드가 종료 되었습니다.");
		
	}
}
