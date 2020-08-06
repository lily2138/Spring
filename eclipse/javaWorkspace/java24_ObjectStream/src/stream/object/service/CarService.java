package stream.object.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import stream.object.vo.Car;

/*
 * 직렬화 / 역직렬화 기능을 모두 다 담겠다.
 * Car를 여러개 던지고 여러개 받을수 있다.
 */
public class CarService {
	//직렬화 기능...
	public void outputCar(ArrayList<Car> list, String path) throws Exception{
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		
		oos.writeObject(list);
		
		oos.close();
	}
	
	//역직렬화 기능..
	public ArrayList<Car> inputCar(String path) throws Exception{
		ArrayList<Car> list = null;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		list = (ArrayList<Car>) ois.readObject();
		
		return list;
	}
}









