package con.mavan.HibernateManyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Courses 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseid;
	@Column(length = 40, nullable = false, unique = true)
	private String coursename;
	
	@ManyToMany (mappedBy = "course")
	private List<Student> student;
	
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courses(String coursename) {
		super();
		this.coursename = coursename;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Courses [courseid=" + courseid + ", coursename=" + coursename + "]";
	}
	
	
}
