package day19;


import java.sql.SQLException;
import java.util.List;

public interface InvoiceTransactionDAO {
	public InvoiceTransactionDTO findByID(Integer invoiceid) throws Exception;
	public List<InvoiceTransactionDTO> findAll();
	public int insertInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO);
	public int updateInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO);
	public int deleteInvoiceTransactionByID(Integer invoiceid);
	public int deleteInvoiceTransactionByDTO(InvoiceTransactionDTO invoiceTransactionDTO);
}
