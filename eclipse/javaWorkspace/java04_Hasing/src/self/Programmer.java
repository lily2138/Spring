package self;

public class Programmer {
	private String name;
	private int salary;
	private String tech;
	private MyDate birthDate;
	
	private NoteBook noteBook;
	
	
	public Programmer(String name, int salary, String tech, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.tech = tech;
		this.birthDate = birthDate;
	}

	
	public void buyNoteBook(NoteBook noteBook) { //setNoteBook
		this.noteBook = noteBook;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}
	
	public String getProgrammer() {
		return name+" "+ birthDate.getBirthdate()+ " "+tech;
	}


	////getter 다 지정하기
	public String getName() {
		return name;
	}


	public int getSalary() {
		return salary;
	}


	public String getTech() {
		return tech;
	}


	public MyDate getBirthDate() {
		return birthDate;
	}
	
	
	
	
}
