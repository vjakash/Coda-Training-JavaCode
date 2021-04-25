package daopack;

import java.util.List;

public interface ItemDAO {
	public Item findByID(Integer itemid) throws Exception;
	public List<Item> findAllByType(String type);
	public List<Item> findAll();
	public int insertItem(Item item);
	public int updateItem(Item item);
	public int deleteItemByID(Integer itemid);
	public int deleteItemByDTO(Item item);
}
