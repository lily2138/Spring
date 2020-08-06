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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadingTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src\\hope.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("src\\data\\result.txt"));

		try {
			String line = "";
			while((line=br.readLine())!=null) {
//				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}
//			bw.flush();//입력되는 족족 모아두지 않고 바로 출력된다.
		} finally {
			bw.close(); //이거 안하면 파일은 생성되는데 내용물이 없게 나온다.---> 닫을 떄 안에있는 내용물을 다 내보내고 닫는다.
			br.close();
		}
	}

}
