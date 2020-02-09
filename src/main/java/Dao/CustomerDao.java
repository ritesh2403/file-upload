package Dao;

import java.util.List;

import Entity.Customer;

public interface CustomerDao {

	public List<Customer> customers();

	public void save(Customer cust);

	public Customer getCustomer(int id);

	public void deleteCusomer(int id);
}
