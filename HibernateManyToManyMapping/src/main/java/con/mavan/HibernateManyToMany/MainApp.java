package con.mavan.HibernateManyToMany;

import java.io.ObjectInputFilter.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp 
{
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addAnnotatedClass(Courses.class);
		config.addAnnotatedClass(Student.class);
		
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		// Object for Courses
		Courses c1 = new Courses();
		c1.setCoursename("MERN Full Stack");
		Courses c2 = new Courses();
		c2.setCoursename("MEAN Full Stack");
		//Object for student
		Student s1 = new Student();
		s1.setStudentname("Mansi");
		Student s2 = new Student();
		s2.setStudentname("Nancy");
		Student s3 = new Student();
		s3.setStudentname("Ansar");
		
		s1.setCourse(Arrays.asList(c1,c2));
		s2.setCourse(Arrays.asList(c2));
		s3.setCourse(Arrays.asList(c1));
		
		// Cascade type.ALL
		session.save(s1);
		//session.save(c1);
		session.save(s2);
		//session.save(c2);
		
		trans.commit();
		session.close();
	}
}
