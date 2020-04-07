package test.mypac;
/*
 * [ 메소드를 만들때 고려 해야 할 사항 ]
 * 
 * 1. 접근 지정자
 * 2. static or non static
 * 3. Method의 return type
 * 4. 메소드명
 * 5. 메소드에 전달 받는 인자의 갯수와 데이터 type
 */
public class MyUtill {
	// 날씨를 콘솔창에 출력하는 메소드
	public static void showWeater() {
		System.out.println("오늘은 첫눈이 와요!");
	}
	// 날시를 콘솔창에 출력하는 메소드
	public void printWeater() {
		System.out.println("오늘은 쌀쌀해요!");
	}
	// 날씨를 String type 으로 return하는 메소드
	public String getWeather() {
		// 날씨를 얻어오는 작업을 수행했다고 가정
		String msg="오늘은 흐려요";
		// 날씨 정보가 있는 String type 을 리턴해 주기
		return msg;
	}
	// Pen 객체를 리턴해주는 메소드
	public Pen getPen() {
		Pen p=new Pen();
		return p;
	}
	
	public MyUtill fire() {
		System.out.println("빵~");
		// this 는 메소드를 감싸고 있는 클래스로 생성된 객체의 참조값을 가리킨다.
		return this;
	}
	// 인자로 전달 받은 int type 을 콘솔에 출력하는 메소드
	public void showNum(int num) {
		System.out.println("num:"+num);
	}
	// int type 과 String type 을 전달 받는 메소드
	public void showInfo(int num, String name) {
		System.out.println("num:"+num+" name:"+name);
	}
	// Pen type 을 전달 받는 메소드
	public void usePen(Pen p) {
		p.write();
	}
}
