package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest5 {

	public static void main(String[] args)throws FileNotFoundException,IOException {
		
		String path = "c:\\yhk\\poem.txt";
		FileReader fr = null;
		try {
			System.out.println("1.fileReader 클래스 생성....");
			fr = new FileReader(path);
				
			System.out.println("2.파일의 내용을 읽어드립니다... read()");
			fr.read();
				//수도꼭지를잠근다,,  close()
		}finally {
			fr.close();
		}
		//try~finally 이 없으면 예외가 발생했을 때, fr.close까지 도달하지 않을 수 있다.
	}

}
