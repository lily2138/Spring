package chatting.step2.client;
/*
 * 키보드로 입력받은 데이타를 읽어서
 * 서버로 보낸다
 * ---------------------------------------------
 * 다시 서버가 보낸 메세지를 받아서 
 * 클라이언트 자신의 콘솔창에 출력한다.
 * ::
 * 입력 2
 * 출력 2 ...socket
 * ::
 * Client측 로직
 * 1. 소켓생성
 * 2. 스트림...
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChattClient {
	Socket s;
	BufferedReader br, br1; //입력두개필요하다. 서버가 보낸것도 받아야하기 때문에
	PrintWriter pw;
	
	
	public void go() {
		try {
			s = new Socket("192.168.0.33",60000);
			System.out.println("Client Socket Credating..... ^^");
			
			br = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(),true); //true는 auto flush--->이거 안해주면 문자열이기 때문에 안간다
			br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			System.out.println("Client stream Creating......^^");
			
			while(true) {
				String line = br.readLine(); //키보드로 입력받은 데이터 읽어서...
				pw.println(line); //서버로 간다.
				
				///////////////////////////////////////////////////////////////
				String serverMsg = br1.readLine();
				System.out.println("서버가 보낸 메세지"+ serverMsg);
			}
			
		}catch(Exception e) {
			System.out.println("서버와의 연결에서 실패했습니다....");
		}
	}	
	public static void main(String[] args) {
		ChattClient cc = new ChattClient();
		cc.go();

	}

}
