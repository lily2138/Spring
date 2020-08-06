package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest4 {

	public static void main(String[] args) {
		
		String path = "c:\\yhk\\poem.txt";
		FileReader fr = null;
		try {
			System.out.println("1.fileReader 클래스 생성....");
			fr = new FileReader(path);
			
			System.out.println("2.파일의 내용을 읽어드립니다... read()");
			fr.read();
			//수도꼭지를잠근다,,  close()
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fr.close();
			}catch(IOException e) {
				
			}
		}
		
	}

}
