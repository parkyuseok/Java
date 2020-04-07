package test.main3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {
	public static void main(String[] args) {
		System.out.print("서버에 전송할 문자열:");
		Scanner scan=new Scanner(System.in);
		String msg=scan.nextLine();
		
		Socket socket=null;
		try {
			// new Socket(접속할 ip 주소, port 번호)
			/*
			 *  나의 아이피 주소는
			 *  127.0.0.1 또는 localhost
			 *  혹은 ipconfig를 통해서 얻어낸 아이피 주소를 사용하면 된다.
			 */
			socket=new Socket("127.0.0.1", 5000);
			System.out.println("Socket 연결 성공");
			// 서버에 출력할 수 있는 객체의 참조값 얻어오기
			OutputStream os=socket.getOutputStream();
			OutputStreamWriter osw=new OutputStreamWriter(os);
			BufferedWriter bw=new BufferedWriter(osw);
			bw.write(msg); // 문자열을 서버에 출력하기
			bw.newLine(); // 개행기호 출력 (서버에서 줄 단위로 읽어낼 수 있다.)
			bw.flush(); // 밀어내기 (실제 데이터는 flush 해야 간다.)
			// 서버로 부터 입력받을 객체
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String fromServer=br.readLine(); // 줄단위로 인식한다. 따라서 개행기호가 있어야한다.
			// 출력하기
			System.out.println("fromServer:"+fromServer);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket!=null)socket.close();
			}catch(Exception e) {}
		}
		System.out.println("ClientMain main() 메소드가 종료 됩니다.");
	}
}
