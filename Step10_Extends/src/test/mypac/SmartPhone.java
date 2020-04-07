package test.mypac;

public class SmartPhone extends HandPhone{
	
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	// 부모 클래스(HandPhone) 클래스에 정의된 메소드 오버라이드 하기
	@Override
	public void takePicture() {
		// super.takePicture(); 부모 메소드 호출할 때 
		//( 재정의를 하되 부모 메소드를 호출을 해야 동작을 하는 경우가 있다. )
		System.out.println("1000만 화소의 사진을 찍어요");
	}
}
