package manytomany;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ManyToManyClient {
	public static void main(String[] args) {
		Student student=new Student();
		student.setSname("ramu");
		student.setMarks(450);
		
		Student student2=new Student();
		student2.setSname("somu");
		student2.setMarks(250);
		
		Training t1=new Training();
		t1.setTname("java");
		t1.setStartDate(new Date());
		
		Training t2=new Training();
		t2.setTname("jee");
		t2.setStartDate(new Date());
		
		Set<Training> trainings=new HashSet<Training>();
		trainings.add(t1);
		trainings.add(t2);
		Set<Training> trainings2=new HashSet<Training>();
		trainings2.add(t1);
		
		student.setTrainings(trainings);
		student2.setTrainings(trainings2);
		
		Session session= HibernateUtility.getSession();
		session.save(student);
		session.save(student2);
		//session.save(t1);
		//session.save(t2);
		
		HibernateUtility.closeSession(null);
	}
}
