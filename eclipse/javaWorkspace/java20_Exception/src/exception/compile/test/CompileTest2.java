package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading2{
	FileReading2(){}
	public void readFile(String fileName) throws FileNotFoundException{
			FileReader fileReader = new FileReader(fileName);
			System.out.println("1. FileReader Creating....");
	}
}

public class CompileTest2 {

	public static void main(String[] args) {
		FileReading2 fr = new FileReading2();
		//readFile»£√‚....
		String path = "c:\\yhk\\poem.txt";
		try {
			fr.readFile(path);

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("2. FileReader Calling....");

	}

}
