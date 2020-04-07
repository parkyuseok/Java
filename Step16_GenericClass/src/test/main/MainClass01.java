package test.main;

import test.mypac.Apple;
import test.mypac.Banana;
import test.mypac.FruitBox;
import test.mypac.Orange;

public class MainClass01 {
	public static void main(String[] args) {
		// Generic 클래스를 Apple 로 해서 FruitBox 객체 생성해서 참조값 얻어내기
		FruitBox<Apple> box1=new FruitBox<Apple>();
		// push() 메소드 사용해 보기
		box1.push(new Apple());
		// pull() 메소드 사용해 보기
		Apple a=box1.pull();
		/*
		 * Generic 클래스를 Banana 로 지정해서 위와 동일한 코드를 작성해 보세요.
		 */
		FruitBox<Banana> box2=new FruitBox<Banana>();
		box2.push(new Banana());
		Banana b=box2.pull();
		
		// Generic 을 Orange 로 지정
		FruitBox<Orange> box3=new FruitBox<>(); // 생략가능하고 받을 때만 잘 받으면 된다.(가독성을 위해)
		box3.push(new Orange());
		Orange c=box3.pull();
	}
}
