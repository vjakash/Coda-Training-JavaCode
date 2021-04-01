package day19;


import java.util.List;

public interface CustomerDAO {
	public CustomerDTO findByID(Integer customerid) throws Exception;
	public List<CustomerDTO> findAll();
	public int insertCustomer(CustomerDTO userDTO);
	public int updateCustomer(CustomerDTO userDTO);
	public int deleteCustomerByID(Integer customerid);
	public int deleteCustomerByDTO(CustomerDTO userDTO);
}
