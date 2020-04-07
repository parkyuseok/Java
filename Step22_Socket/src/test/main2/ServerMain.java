package test.main2;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerMain {
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		Socket socket=null; // 직접 값을 지정하지 않고 accept라는 메소드가 리턴되면 그 값을 받아서 쓴다.
		try {
			//5000번 port 를 사용할 준비를 한다.
			serverSocket=new ServerSocket(5000);
			System.out.println("클라이언트의 연결 요청을 대기중 입니다.");
			while(true) { // 서버는 무한루프 도는중.
				//5000 번 port의 연결 요청을 기다린다.
				socket=serverSocket.accept();	//접속할 때 까지 (바로 리턴되지 않고)블로킹 되있다. 클라이언트가 접속 요청을 해왔을 때 리턴된다.	//socket 객체는 다수의 클라이언트를 기다리는 서버소켓역할을 하겠다. 방금 접속한 클라이언트와 그 소켓으로 입출력을 한다.(문자열, 파일, 등등)
				//접속된 클라이언트의 ip 주소 얻어오기
				String ip=socket.getInetAddress().getHostAddress();
				System.out.println("접속된 클라이언트의 ip: "+ip);
				// 접속한 클라이언트로 부터 입력 받을 객체의 참조값 얻어오기
				InputStream is=socket.getInputStream();
				InputStreamReader isr=new InputStreamReader(is);
				BufferedReader br=new BufferedReader(isr);
				// 클라이언트가 전송한 문자열을 한줄 입력받기(개행기호 기준)
				String msg=br.readLine();
				System.out.println(msg);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket!=null)serverSocket.close();
				if(socket!=null)socket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ServerMain() 클래스를 종료합니다.");
	}
}