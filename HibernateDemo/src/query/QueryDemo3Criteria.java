package query;


import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import onetomany.Address;
import onetomany.Employee;
import utility.HibernateUtility;

public class QueryDemo3Criteria {
	public static void main(String[] args) {
		QueryDemo3Criteria obj=new QueryDemo3Criteria();
		obj.query3();
	}
	public static void display(Criteria criteria)
	{
		List<Employee> employees=criteria.list();
		Iterator<Employee> iter=employees.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().getEname());
		}
	}
	public void query1() {
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		display(criteria);
	}
	public void query11()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("ename"));
		display(criteria);
	}
	public void query2()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		//criteria.add(Restrictions.eq("name", "ramu"));
		//or
		criteria.add(Property.forName("ename").eq("sam"));
		Employee emp=(Employee)criteria.uniqueResult();
		System.out.println(emp.getEname());
	}
	public void query3()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Address.class);
		criteria.add(Restrictions.eq("emp.ename", "sam"));
		//or
//		criteria.add(Property.forName("emp.ename").eq("sam"));
		List<Address> addresses=criteria.list();
		Iterator<Address> iter=addresses.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next().getCity());
		}
	}
	public void query4()
	{
		Session session=HibernateUtility.getSession();
		int f[]={ Integer.valueOf(20),Integer.valueOf(40)};
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.between("esal",new Float(20),new Float(40)));
		//or
//		criteria.add(Property.forName("esal").in(f));
		display(criteria);
	}
	public void query5()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("ename", "s%").ignoreCase());
		display(criteria);	
	}
	public void query6()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.
			add(Restrictions.like("ename", "R%").ignoreCase())
			.add(Restrictions.gt("esal",  Float.valueOf(20)));
		display(criteria);
	}
	public void query7()
	{
		Session session=HibernateUtility.getSession();
		Criteria criteria=session.createCriteria(Employee.class);
		criteria.add(
				Restrictions.or(Restrictions.like("ename", "R%").ignoreCase(),
				Restrictions.gt("esal",Float.valueOf(20))));
				display(criteria);
	}
	public void query8()
	{
		Session session=HibernateUtility.getSession();
		DetachedCriteria dc=DetachedCriteria.forClass(Employee.class);
		dc.add(
				Restrictions.or(Restrictions.like("ename", "R%"),
				Restrictions.gt("esal", Float.valueOf(20)))
			);
		Criteria criteria=dc.getExecutableCriteria(session);
		display(criteria);
	}
}