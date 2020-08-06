package chatting.gui.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;



public class ChattServer {
	ServerSocket server;
	Socket s;
	ArrayList<ChattThread> list;

	public ChattServer() {
		list = new ArrayList<>();
	}
	
	public void broadcast(String message) {
		for(ChattThread t : list) {
			t.sendMessage(message);
		}
	}
	
	public void go() {
		try {
			server=new ServerSocket(60000);
			System.out.println("Server Ready......");
			
			while(true) { 
				s=server.accept();
				ChattThread ct = new ChattThread(s,this);
				list.add(ct);
				ct.start(); //run으로 간다
			}
		}catch(Exception e) {
			
		}
	}
	
	public static void main(String[] args) {
		ChattServer cs = new ChattServer();
		cs.go();
	}
}
class ChattThread extends Thread{
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ChattServer chattServer;
	
	ChattThread(Socket s, ChattServer chattserver) {
		this.chattServer = chattserver;
		this.s = s;
		System.out.println(s.getInetAddress()+"님이 접속하셨습니다...");
		chattServer.broadcast(s.getInetAddress()+"님이 채팅방을 들어왔습니다....");
	}
	
	public void sendMessage(String str) {
		pw.println(str);
	}
	
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(),true);
			
			while(true) {
				String line = br.readLine();
				chattServer.broadcast(line);
				
			}
		}catch(IOException e) {
			//연결이 끊어졌을 때 이곳으로 이동한다
			System.out.println(s.getInetAddress()+" 님이 접속을 끊으셨습니다....");
			chattServer.broadcast(s.getInetAddress()+" 님이 채팅방을 나가셨습니다....");
			chattServer.list.remove(this);
		}

	}
}


