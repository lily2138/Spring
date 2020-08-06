package chatting.step1.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 클라이언트가 보낸 메세지를 받아서
 * 자신의 콘솔창에 받은 메세지를 출력
 * ::
 * 서버측 로직
 * 1. ServerSocket 생성(port 6000)
 * 2. 클라이언트가 서버에 접속하면 accept로 받아서
 * 	  Socket을 하나 리턴.
 * 3. 소켓으로부터 스트림 리턴
 * 
 */
public class ChattServer {
	ServerSocket server;
	Socket s;
	BufferedReader br;
	
	public void go() {
		try {
			server = new ServerSocket(60000);
			System.out.println("Server Ready......");
			
			s=server.accept();
			System.out.println("Client Socket...Returning...");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//getInputStream()과 system.in에 다른점
			//System.in은 키보드 안에 있는것을 읽어들이는 것이다
			//getInputStream()은 외부데이터로 받아들여서 읽는것이다.
			
			
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println("Client가 보낸 메세지"+line);
			}
			br.close();
		}catch(Exception e) {
			System.out.println("Client와의 연결이 끊어졌습니다...");
		}
	}
	
	public static void main(String[] args) {
		ChattServer cs = new ChattServer();
		cs.go();

	}

}








