package curriculum.vo;

public class Student {
	private int studId;
	private String name;
	private int age;
	private Curriculum curriculum;
		
	public Student(int studId, String name, int age, Curriculum curriculum) {
		this.studId = studId;
		this.name = name;
		this.age = age;
		this.curriculum = curriculum;
	}
	
	public Student(int studId, String name, int age) {
		this.studId = studId;
		this.name = name;
		this.age = age;
	}

	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public String toString() {
		return "-----학생 정보-----\n학생ID: "+studId+"\t\t이름: "+name+"\t\t나이: "+age+curriculum.toString();
	}

}
