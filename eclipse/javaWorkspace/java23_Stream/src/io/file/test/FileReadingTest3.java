/*
 * Source --- 파일
 * Sink --- 파일...src\\result.txt
 * ::
 * 파일에 있는 내용을 읽어서
 * 또다른 파일로 출력하는 로직을 작성
 * ::
 * 
 */
package io.file.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReadingTest3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		//뒤에 true는 autoFlush 기능이다. 밑에 close를 안해줘도 파일내용이 생성이 된다.
		//filewriter에 있는 true는 실행할때마다 계속 밑에다가 이어서 써진다.
		PrintWriter pw = new PrintWriter(new FileWriter("src\\data\\result.txt",true),true);

		try {
			String line = "";
			while((line=br.readLine())!=null) {
//				System.out.println(line);
				pw.println(line);
			}
//			bw.flush();//입력되는 족족 모아두지 않고 바로 출력된다.
		} finally {
//			pw.close(); //이거 안하면 파일은 생성되는데 내용물이 없게 나온다.---> 닫을 떄 안에있는 내용물을 다 내보내고 닫는다.
			br.close();
		}
	}

}
