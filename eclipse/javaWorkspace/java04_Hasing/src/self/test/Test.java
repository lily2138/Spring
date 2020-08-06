package self.test;

import self.MyDate;
import self.NoteBook;
import self.Programmer;

public class Test {
	
	public static void main(String[] args) {
	
		Programmer pro1 = new Programmer("James",400,"Java", new MyDate(2019,4,11));
		System.out.println(pro1.getProgrammer());
		
		System.out.println(pro1.getName()+"¥‘¿Ã ±∏∏≈«— ≥Î∆Æ∫œ ¡§∫∏");
		pro1.buyNoteBook(new NoteBook("LG",1600000));
		
		NoteBook jamesNote = pro1.getNoteBook();
		System.out.println(jamesNote.getNoteBook());
		
		
		
	}
}
