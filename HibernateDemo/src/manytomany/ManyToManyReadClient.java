package manytomany;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ManyToManyReadClient {

	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
//		Student student=(Student)session.get(Student.class, 2);
//		for(Training t:student.getTrainings()) {
//			System.out.println(t.getTname());
//		}
		Training training =(Training)session.get(Training.class,32768);
		for(Student s:training.getStudents()) {
			System.out.println(s.getSname());
		}
		HibernateUtility.closeSession(null);
		
		
	}
}
