package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
	FileReading(){}
	public void readFile(String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName);
			System.out.println("FileReader Creaating....");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

public class CompileTest1 {

	public static void main(String[] args) {
		FileReading fr = new FileReading();
		//readFile»£√‚....
		String path = "c:\\yhk\\poem.txt";
		fr.readFile(path);
		System.out.println("FileReader Calling....");

	}

}
