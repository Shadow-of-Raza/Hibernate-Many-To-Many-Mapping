package con.mavan.HibernateManyToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentid;
	@Column(length = 40, nullable = false)
	private String studentname;
	
	@ManyToMany (cascade = CascadeType.ALL)
	@JoinTable (name = "STU_COU", joinColumns= {
			@JoinColumn (name = "studentid")}, inverseJoinColumns = {
			@JoinColumn (name = "courseid")
			})
	private List<Courses> course;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String studentname) {
		super();
		this.studentname = studentname;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	
	
	
	public List<Courses> getCourse() {
		return course;
	}
	public void setCourse(List<Courses> course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + "]";
	}
	
}
