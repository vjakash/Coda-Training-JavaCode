package manytomany;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ManyToManyReadClient {

	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
//		Student student=(Student)session.get(Student.class, 1);
//		for(Training t:student.getTrainings()) {
//			System.out.println(t.getTname());
//		}
		Training training =(Training)session.get(Training.class,1);
		System.out.println(training);
		for(Student s:training.getStudents()) {
			System.out.println(s.getSname());
		}
		HibernateUtility.closeSession(null);
		
		
	}
}
