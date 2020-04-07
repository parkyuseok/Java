package test.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass10 {
	public static void main(String[] args) {
		// 이미 만들어진 memo.txt 파일에 Access 할수 잇는 객체 생성
		File f1=new File("c:/myFolder/memo.txt");
		String str;
		try {
			// FileWriter fw=new FileWriter(f1, true); true로 바꿔놔야 append 모드가 작동됨.
			FileWriter fw=new FileWriter(f1, true); // File 객체에는 문자열을 기록하는 기능이 없으므로 FileWriter 객체를 생성한다.
//			fw.write("하나"); // 기존의 내용에 오버라이드 된다.
//			fw.write("\r\n"); // 개행기호
//			fw.write("둘");
//			fw.write("\r\n"); // 개행기호
//			fw.write("셋");
//			fw.write("\r\n"); // 개행기호
//			fw.write("튀어!");
			fw.append("\r\n");
			fw.append("하나");
			fw.append("\r\n");
			fw.append("둘");
			fw.append("\r\n");
			fw.append("셋");
			fw.append("\r\n");
			fw.append("튀어!");
			fw.flush();
			fw.close(); // 수정중인 상태(눈에는 안보임)에서 날라갈수 있으므로 닫아줘야 한다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main 메소드가 리턴됩니다.");
	}
}
