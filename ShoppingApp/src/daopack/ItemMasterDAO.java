package daopack;

import java.sql.SQLException;
import java.util.List;

public interface ItemMasterDAO {
	public ItemDTO findByID(Integer itemid) throws Exception;
	public List<ItemDTO> findAllByType(String type);
	public List<ItemDTO> findAll();
	public int insertItem(ItemDTO itemDTO);
	public int updateItem(ItemDTO itemDTO);
	public int deleteItemByID(Integer itemid);
	public int deleteItemByDTO(ItemDTO itemDTO);
}
