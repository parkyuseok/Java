package test.main5;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class ServerMain {
	//클라이언트를 응대 하는 스레드 객체의 참조값을 담을 ArrayList
	static List<ServerThread> threadList=new ArrayList<>();
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			//5000번 port 의 연결 요청을 기다린다.
			serverSocket=new ServerSocket(5100);
			System.out.println("클라이언트의 연결 요청을 대기중 입니다.");
			while(true) {
				//5000 번 port의 연결 요청을 기다린다.
				Socket socket=serverSocket.accept();	//바로 리턴되지 않고 접속할 때 까지 블로킹 되있다. 클라이언트가 접속 요청을 해왔을 때 socket 객체(new Socket)가 리턴된다.	//socket 객체는 다수의 클라이언트를 기다리는 서버소켓역할을 하겠다. 방금 접속한 클라이언트와 그 소켓으로 입출력을 한다.(문자열, 파일, 등등)
				//새로운 스레드를 만들어서 시작시킨다.
				ServerThread t=new ServerThread(socket);
				t.start(); 		//=> 접속해오면 새로운 socket을 만들고 쓰레드 시작 대기.
				//스레드를 ArrayList 에 누적시키기
				threadList.add(t);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket!=null)serverSocket.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ServerMain main() 메소드가 종료됩니다.");
	}//main
	//inner 클래스로 스레드를 생성할 클래스 설계하기
	static class ServerThread extends Thread{
		//필드
		private Socket socket;
		private BufferedWriter bw;
		//생성자
		public ServerThread(Socket socket) {
			//생성자의 인자로 전달된 클라이언트와 연결된 Socket 객체의 참조값을 필드에 저장한다.
			this.socket=socket;
		}
		@Override
		public void run() {
			//클라이언트를 응대하기
			try {
				//클라이언트로부터 입력받을 객체의 참조값 얻어오기
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));	//필드에 참조값 넣어두기
				while(true) {
					//반복문 돌면서 전송된 문자열이 있으면 읽어온다.
					String msg=br.readLine(); 	//혹시 클라이언트가 접속이 끊기면 null이 리턴될 것이다.
					System.out.println(msg);
					if(msg==null) {	//접속이 종료되면
						System.out.println("클라이언트의 접속이 종료됩니다.");
						break;
					}
					//반복문 돌면서 모든 스레드의
					for(ServerThread tmp:threadList) {	//threadList에 있는 스레드들의 참조값을 하나씩 얻어와서 broadcast()메소드를 호출한다.
						//broadcast() 메소드를 호출하면서 문자열 전달
						tmp.broadcast(msg);
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}//try
			//접속 종료된 스레드 제거하기
			threadList.remove(this);	//Exception이 발생한 바로 그 참조값.
			//클라이언트가 접속 종료를 하면 반복문을 도는 과정중에 readLine()에서 읽어올 값이 없으니 Exception이 발생한다. 그러면 try-catch문에서 빠져나오게 되는데 이때 그 쓰레드를 제거를 해주어야 함.
			//만약 쓰레드를 제거하지 않고 두면 사용하지도 않는 스레드가 남아있게 되는데 이 스레드는 broadcast하는 과정에서 있지도 않은 값을 출력해주려 하다보니 Exception이 발생한다. 그러면 또 try-catch문에서 빠져나온다.
		}//run()
		//전송된 문자열을 중개하는 메소드
		public void broadcast(String msg) throws IOException {	//메소드를 호출하는 쪽에서는 Exception을 잡을 준비가 되어있기 때문에 throws를 해도 된다.
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
	}//class ServerThread
}