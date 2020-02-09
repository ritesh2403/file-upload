package Service;

import java.util.List;

import Entity.Customer;

interface CustomerService {

	public List<Customer> customers();
	
	public void save(Customer cust);
	
	public Customer getCustomer(int id);
	
	public void deleteCusomer(int id);
	

}
