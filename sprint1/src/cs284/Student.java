package cs284;

public class Student {
	private String id;
	private String name,type;
	private String point,point1,point2,point3,point4;
	private String grade;
	private double total;
	
	public Student(String id,String name,String type,String point,String point1,String point2,String point3,String point4){
		this.id = id;
		this.name = name;
		this.type = type;
		this.point = point;
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.point4 = point4;
	}
	public Student(String id,String name,String type){
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getPoint() {
		return point;
	}
	public String getPoint1() {
		return point1;
	}
	public String getPoint2() {
		return point2;
	}
	public String getPoint3() {
		return point3;
	}
	public String getPoint4() {
		return point4;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setTotal(String point,String point1,String point2,String point3,String point4,String point5 ){
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	}

}
