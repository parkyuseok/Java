package test.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MethodDemo7 {
	public static String numbering(int init, int limit) {
		int i =init;
		// 만들어지는 숫자를 output이라는 변수에 담기 위해
		// 변수에 빈 값을 주었다.
		String output="";
		while(i<limit) {
			// 숫자를 화면에 출력하는 대신 변수 output에 담았다.
			// output = output+i 
			output += 

			i++;
		}
		// 중요!! output에 담긴 문자열을 메소드 외부로 반화하려면
		// 아래와 같이 return 키워드 뒤에 반환하려는 값을 배치하면 된다.
		return output;
	}
	
	public static void main(String[] args) {
		// numbering 메소드에서 리턴한 값이 result 변수에 담긴다.
		String result = MethodDemo7.numbering(1,5);
		// result 변수의 값을 화면에 출력한다.
		System.out.println(result);
		try {
			// 다음 행은 out.txt라는 파일에
			// numbering 메소드가 반환한 값을 저장합니다.
			BufferedWriter out=new BufferedWriter(new FileWriter("out.txt"));
			out.write(result);
			out.close(); // out.txt라는 파일이 만들어 지고, 파일 안에 1234라는 값이 기록돼 있음.
		}catch(IOException e) {}
	}
}
