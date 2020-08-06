package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading3{
	FileReading3(){}
	public void readFile(String fileName)throws FileNotFoundException{
			FileReader fileReader = new FileReader(fileName);
			System.out.println("1. FileReader Creating....");
	}
}

public class CompileTest3 {

	public static void main(String[] args) throws FileNotFoundException{
		FileReading3 fr = new FileReading3();
		//readFile»£√‚....
		String path = "c:\\yhk\\poem.txt";
		fr.readFile(path);
		
		System.out.println("2. FileReader Calling....");

	}

}
