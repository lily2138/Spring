package chatting.gui.client;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ButtonHandler implements ActionListener {
	
	ChattingService service;
	ButtonHandler(ChattingService service){
		this.service = service;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼 클릭하면 FileDilog창 떠서 어떤 경로에 어떤 출력용 파일을 지정할 것인가를 입력
		//지정된 경로의 파일로 TextArea의 입력내용을 다 뿌린다.
	
		
		String fileName = "";
		try{
			fileWriting(fileName);
		}catch(IOException ioe){}
	}
	
	public void fileWriting(String fileName) throws IOException{
		//TextArea에 입력된 내용을 다 받아와서
		//지정된 경로에 출력하는 로직을 작성..
		
	}	
}





















