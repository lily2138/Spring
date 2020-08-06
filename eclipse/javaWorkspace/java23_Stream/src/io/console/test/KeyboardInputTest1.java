package io.console.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 키보드로 데이타를 읽어들여서
 * 콘솔로 출력하는 로직을 작성
 * ::
 * Source --- 킵드
 * Sink --- 콘솔
 * ::
 * 1. 스트림 생성: 입력스트림만 필요 ... 출력스트림 안필요 (콘솔로 출력하기 때문에)
 * 		InputStreamReader, BufferedReader
 * 2. 읽어들인다...
 * 		readLine()
 * 3. 콘솔로 출력
 * 		System.out.println()
 */
public class KeyboardInputTest1 {
	public static void main(String[] args) {
		//1.
		System.out.println("1.Stream 생성......");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		
		
		//2.
		try {
			System.out.println("2.readLine으로 읽어 드립니다...");
			String line = br.readLine();
			while(line!=null) {
				//3.
				System.out.println("Reading Data : "+line);
				line = br.readLine();
			}
			
		}catch (IOException e) {
		
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				
			}
		}
		

	}

}
