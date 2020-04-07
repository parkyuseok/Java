package test.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass14 {
	public static void main(String[] args) {
		// 객체의 참조값을 담을 변수 선언
		FileInputStream fis=null; // 파일에서 byte 알갱이를 1개씩 읽어 들어는 것 
		FileOutputStream fos=null; 
		try {
			// 파일로 부터 읽어들일 객체의 참조값
			fis=new FileInputStream("c:/myFolder/kim1.png");
			// 파일에 출력할 객체의 참조값
			fos=new FileOutputStream("c:/myFolder/kim11.png");
			while(true) {
				// 1 byte를 읽어들이고
				int data=fis.read(); // data 변수에는 0~255의 바이트 숫자가 들어있다.
				if(data==-1)break; // 다 읽었으면 반복문 탈출
				// 읽어들인 1 byte 출력하기
				fos.write(data);
				fos.flush();
			}
			System.out.println("파일을 복사 했습니다.");
		} catch (Exception e) { // Exception은 모든 Exception을 받을수 있다.
			e.printStackTrace();
		// close를 하지 않으면 만들어지지 않는다.
		// 이셉션이 발생할 수 있으므로 finally 절에 적어준다.
		}finally{ // Exception 발생과 상관 없이 실행이 보장되는 블럭, 무언가 마무리 작업은 여기서 하면 된다.
			try {
				if(fis!=null)fis.close(); // 위에서 경로를 잘못 적어서 이셉션이 발생한 경우 fis에는 null값이 들어가므로 꼬인다.
				if(fos!=null)fos.close(); // 따라서 if절로 체크해주어야 한다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // try
	} // main 
} // class
