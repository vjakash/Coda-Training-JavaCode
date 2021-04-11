package daopack;


import java.sql.SQLException;
import java.util.List;

public interface InvoiceMasterDAO {
	public InvoiceMasterDTO findByID(String invoiceid) throws Exception;
	public List<InvoiceMasterDTO> findAll();
	public int insertItem(InvoiceMasterDTO invoiceMasterDTO);
	public int updateItem(InvoiceMasterDTO invoiceMasterDTO);
	public int deleteItemByID(String invoiceid);
	public int deleteItemByDTO(InvoiceMasterDTO invoiceMasterDTO);
}
