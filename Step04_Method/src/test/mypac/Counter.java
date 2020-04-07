package test.mypac;

public class Counter {
	
	// int type 을 저장할 field 정의하기( 보통 위에 저장함 )
	public static int count=0; // public static field
	
	public static void addCount() {
		// 이 메소드가 몇번 호출되었는지 자체적으로  저장을 하고 싶다면?
		//	int count=0;
		//	count++;
		count++;
	}
}
