package day19;


import java.sql.SQLException;
import java.util.List;

public interface InvoiceMasterDAO {
	public InvoiceMasterDTO findByID(Integer invoiceid) throws Exception;
	public List<InvoiceMasterDTO> findAll();
	public int insertItem(InvoiceMasterDTO invoiceMasterDTO);
	public int updateItem(InvoiceMasterDTO invoiceMasterDTO);
	public int deleteItemByID(Integer invoiceid);
	public int deleteItemByDTO(InvoiceMasterDTO invoiceMasterDTO);
}
