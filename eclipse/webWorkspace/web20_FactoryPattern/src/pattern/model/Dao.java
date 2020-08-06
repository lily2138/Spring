package pattern.model;

import java.sql.SQLException;

public class Dao {
	private static Dao dao = new Dao();
	private Dao() {}
	public static Dao getInstance() {
		return dao;
	}
	
	public NoteBook findNoteBook(String model) throws SQLException{
		//디비연결됐다 치고....
		System.out.println(model);
		NoteBook notebook = new NoteBook(model,140000);
		return notebook;
	}
}
