package test.main4;
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

import org.json.JSONObject;
public class ServerMain {
	// 클라이언트를 응대 하는 스레드 객체의 참조값을 담을 ArrayList
	static List<ServerThread> threadList=new ArrayList<>(); // static field 안에서 non static 못 쓰므로 static을 써준다.
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket=null;
		try {
			// 5000번 port 를 사용할 준비를 한다.
			serverSocket=new ServerSocket(5500); // 5000번 포트에서 client를 기다리겠다.(accept 메소드를 호출 했을 때 부터)
			System.out.println("클라이언트의 연결 요청을 대기중 입니다.");
			while(true) { // 서버는 무한루프 도는중.
				// 5000 번 port의 연결 요청을 기다린다. client의 접속을 기다린다.
				Socket socket=serverSocket.accept(); //접속할 때 까지 (바로 리턴되지 않고)블로킹 되있다. 클라이언트가 접속 요청을 해왔을 때 리턴된다. //socket 객체는 다수의 클라이언트를 기다리는 서버소켓역할을 하겠다. 방금 접속한 클라이언트와 그 소켓으로 입출력을 한다.(문자열, 파일, 등등)
				// 새로운 스레드를 만들어서 시작 시킨다. 1대1로 처리해야 하므로 스레드 객체를 생성하고 socket 변수를 전달해준다.
				ServerThread t=new ServerThread(socket);
				t.start();
				// 스레드를 ArrayList에 누적 시키기
				threadList.add(t); // 지역변수는 반복문 돌 때마다 사라지므로 static인 threadList field에 담아 놓는다.
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
		System.out.println("ServerMain() 클래스를 종료합니다.");
	}//main()
	
	// inner 클래스로 스레드를 생성할 클래스 설계하기
	static class ServerThread extends Thread{ // 혹은 implements Runnable
		// 필드
		private Socket socket; // static final을 제공하지 않는 field를 제외하고는 보통 private를 사용한다.
		private BufferedWriter bw; // 메소드들에서 사용되는 부품들(field)가 변경되면 메소드가 호출 될시 문제가 생길 수 있으므로
		private String chatName;
		// 생성자
		public ServerThread(Socket socket) {
			// 생성자의 인자로 전달된 클라이언트와 연결된 Socket 객체의 참조값을 필드에 저장한다.
			this.socket=socket;
			// 생성자를 만들지 않을거면 setSocket 메소드를 만들어야 한다.(접근 메소드)
		}
		// 대화명을 리턴해주는 메소드
		public String getChatName() {
			return chatName;
		}
		@Override
		public void run() { // new ServerThread(socket).start(); 여기로 실행순서가 온다. new 할 때마다 새로운 작업단위 시작.
			// 클라이언트를 응대 하기
			try {
				// 클라이언트로 부터 입력받을 객체의 참조값 얻어오기.
				BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				this.bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				while(true) { // Server Thread가 하는 작업
					// 반복문 돌면서 전송된 문자열이 있으면 읽어온다.
					String json=br.readLine(); // 문자열이 올 때까지 대기하고 있다가 문자열이 오면 실행순서가 아래로 내려간다. // client가 나가게 되면 Exception이 발생해서 catch부분으로 가서 remove한다.
					System.out.println(json);
					// 클라이언트가 전송한 json 문자열을 이용해서 객체 생성
					JSONObject jsonObj=new JSONObject(json); // 원하는 정보를 쉽게 빼낼려고 JSONObject 객체 생성.
					String type=jsonObj.getString("type");
					if(type.equals("enter")) {
						// 대화명을 스레드의 필드에 저장하기
						String chatName=jsonObj.getString("chatName");
						this.chatName=chatName;
						// 대화면 중개 하기
						broadcastChatName();
					}
					//누군가가 메세지를 보내면 다른 client에 전송해 준다.
					for(ServerThread tmp:threadList) { // ServerThread 배열 type의 threadList field(배열의 참조값)에 담긴 값이 반복문이 동작할 때마다 tmp 변수에 담아준다.
						tmp.broadcast(json); // 반복문이 동작하면서 모든 스레드의 broadcast 메소드에 문자열을 전달하면서 호출한다.
					}
				}//while
			}catch(Exception e) { // 모든 Exception 처리
				e.printStackTrace();
			} // try
			// 접속 종료된 스레드 제거하기 //remove 참조값에 인한 삭제 ( 인덱스로 인한 삭제도 할수 있음 )
			threadList.remove(this); // 쓸수 없는 참조값이 남아있어서 for-each 문에서 문제가 발생해서 broadcast를 호출 할 때 이셉션이 발생한다.
			
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("type", "leave");
			jsonObj.put("chatName", chatName);
			
			try {
				for(ServerThread tmp:threadList) {
					tmp.broadcast(jsonObj.toString());
				}
				broadcastChatName();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}//run()
		
		// 전송된 문자열을 중계 하는 메소드 // 누군가가 메세지를 보내면 다른 client에 전송해 준다.
		public void broadcast(String msg) throws IOException { // 호출하는 쪽에서 Exception을 처리 할수 있으므로 쓰로우 한다.
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}//broadcast(String msg)
		
		// 채팅방 참여자 목록을 중개하는 메소드
		public void broadcastChatName() throws IOException {
			List<String> names=new ArrayList<>();
			for(ServerThread tmp:threadList) {
				names.add(tmp.getChatName());
			}
			//json 문자열로 구성하고
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("type", "update");
			jsonObj.put("names", names);
			// 모든 클라이언트에게 중개하기
			for(ServerThread tmp:threadList) {
				tmp.broadcast(jsonObj.toString());
			}
		}//broadcastChatName
	}//class ServerThread
}