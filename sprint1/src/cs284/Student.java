package cs284;

public class Student {
	private String id;
	private String name,type;
	private int point;
	private String grade;
	
	
	public Student(String id,String name,String type){
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPoint(int point) {
		this.point = point;
}
}
