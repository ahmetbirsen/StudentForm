
public class Student {
	String name;
	String surname;
	String birthYear;
	String city;
	String yearStudy;
	String department;
	String course;
	
	
	public Student(String name, String surname, String birthYear, String city, String yearStudy, String department,
			String course) {
		super();
		this.name = name;
		this.surname = surname;
		this.birthYear = birthYear;
		this.city = city;
		this.yearStudy = yearStudy;
		this.department = department;
		this.course = course;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getBirthYear() {
		return birthYear;
	}


	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getYearStudy() {
		return yearStudy;
	}


	public void setYearStudy(String yearStudy) {
		this.yearStudy = yearStudy;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}
	
	
	
	
}
