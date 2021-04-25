package daopack;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class ItemDAOImpl implements ItemDAO,Cloneable{

	
	private static ItemDAOImpl itemDaoImpl;
	
	public static ItemDAOImpl getItemDaoImpl() {
		if(itemDaoImpl==null) {
			itemDaoImpl=new ItemDAOImpl();
		}
		return itemDaoImpl.getClone();
	}
	
	public ItemDAOImpl getClone() {
		try {
			return (ItemDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private ItemDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item findByID(Integer itemid) throws Exception {
		Item item=null;
		
		Session session= HibernateUtility.getSession();
		Query query=session.createQuery("from Item item where item.itemid=:id");
		query.setParameter("id", itemid);
		List<Item> list=query.list();
		if(list.size()!=0) {			
			item=(Item)list.get(0);
		}
		HibernateUtility.closeSession(null);
		return item;
	}

	@Override
	public List<Item> findAllByType(String type) {
		Session session= HibernateUtility.getSession();
		Query query=session.createQuery("from Item item where item.type=:t");
		query.setParameter("t", type);
		List list=query.list();
		System.out.println(list);
		HibernateUtility.closeSession(null);
		return list;
	}

	@Override
	public List<Item> findAll() {
		Session session= HibernateUtility.getSession();
		Query query=session.createQuery("from Item");
		List list=query.list();
		System.out.println(list);
		HibernateUtility.closeSession(null);
		return list;
	}

	@Override
	public int insertItem(Item item) {
		Session session= HibernateUtility.getSession();
		session.save(item);
		HibernateUtility.closeSession(null);
		return 0;
	}

	@Override
	public int updateItem(Item item) {
		Session session=HibernateUtility.getSession();
		System.out.println(item.getItemid());
		Query q=session.createQuery("update Item item SET item_name=:name,item_unit=:unit,price=:price,type=:type,img_url=:url WHERE item.itemid=:itemid");
		q.setParameter("name", item.getItem_name());
		q.setParameter("unit", item.getItem_unit());
		q.setParameter("price", item.getPrice());
		q.setParameter("type", item.getType());
		q.setParameter("url", item.getImg_url());
		q.setParameter("itemid", item.getItemid());
		int updateditems=q.executeUpdate();
		HibernateUtility.closeSession(null);
		return updateditems;
	}

	@Override
	public int deleteItemByID(Integer itemid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItemByDTO(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}
//	public static void main(String[] args) {
//		Item item=Item.getItemDTO();
//		item.setItem_name("Wheat");
//		item.setItem_unit("kg");
//		item.setPrice(78.5f);
//		item.setType("groceries");
//		item.setImg_url("https://5.imimg.com/data5/ST/QW/MY-38700875/fresh-wheat-crop-500x500.jpg");
//		
//		ItemDAOImpl itemDAOimpl=ItemDAOImpl.getItemDaoImpl();
//		
////		int i=itemDAOimpl.insertItem(item);
////		System.out.println(i);
//		
//		item.setPrice(93.25f);
//		item.setItemid(1);
//		int i=itemDAOimpl.updateItem(item);
//		System.out.println(i);
//		
//	}

}
