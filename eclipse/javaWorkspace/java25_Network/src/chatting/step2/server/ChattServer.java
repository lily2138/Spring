package chatting.step2.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Ŭ���̾�Ʈ�� ���� �޼����� �޾Ƽ�
 * �ٽ� Ŭ���̾�Ʈ���� ���� �޼����� ������
 * ::
 * ������ ����
 * 1. ServerSocket ����(port 6000)
 * 2. Ŭ���̾�Ʈ�� ������ �����ϸ� accept�� �޾Ƽ�
 * 	  Socket�� �ϳ� ����.
 * 3. �������κ��� ��Ʈ�� ����
 * 
 */
public class ChattServer {
	ServerSocket server;
	Socket s;
	BufferedReader br;
	//�߰�
	PrintWriter pw;
	
	public void go() {
		try {
			server = new ServerSocket(60000);
			System.out.println("Server Ready......");
			
			s=server.accept();
			System.out.println(s.getInetAddress()+" ���� �����ϼ̽��ϴ�...");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//getInputStream()�� system.in�� �ٸ���
			//System.in�� Ű���� �ȿ� �ִ°��� �о���̴� ���̴�
			//getInputStream()�� �ܺε����ͷ� �޾Ƶ鿩�� �д°��̴�.
			
			pw = new PrintWriter(s.getOutputStream(),true);
			
			
			String line = null;
			while((line = br.readLine())!=null) {
				pw.println(line);
			}
			br.close();
		}catch(Exception e) {
			System.out.println("Client���� ������ ���������ϴ�...");
		}
	}
	
	public static void main(String[] args) {
		ChattServer cs = new ChattServer();
		cs.go();

	}

}







