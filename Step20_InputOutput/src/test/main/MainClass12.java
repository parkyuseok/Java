package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass12 {
 public static void main(String[] args) {
	File f1=new File("c:/myFolder/memo.txt");
	try {
		// 파일에서 문자열을 읽어들일 객체 생성
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);
		// 반복문 돌면서 한줄씩 읽어내기
		while(true) {
			// 개행기호 빼고 한줄의 문자열 읽어오기
			String line=br.readLine(); // 개행기호 기준으로 읽어오므로 개행기호는 빼고 읽어옴
			if(line==null)break; // 다 읽어 왔으면 반복문 탈출
			System.out.println(line); // println으로 해야 개행이 출력됨.
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}

