import java.io.*;

public class Course implements Serializable{
	private String courseCode;
	private String courseDescription;

	public Course(String cCode, String cDesc){
		courseCode = cCode;
		courseDescription = cDesc;
	}

	public void setCourseCode(String cCode){
		courseCode = cCode;		
	}

	public String getCourseCode(){
		return courseCode;
	}

	public void setCourseDescription(String cDesc){
		courseDescription = cDesc;		
	}

	public String getCourseDescription(){
		return courseDescription;
	}

	
}