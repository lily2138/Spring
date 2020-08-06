package com.encore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kickboard {	

		public static int execute(File path) throws FileNotFoundException {
			int result = -1;
			Scanner sc = new Scanner(path);
			
			// 구현하세요
			
			return result;
		}
		
		public static void main(String[] args) throws FileNotFoundException {
			System.out.println(execute(new File("input.txt")));
		}
}
