package Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Entity.Customer;

@Repository
public class CustomerDaoImp implements CustomerDao {
private static  Map<Integer,Customer>customer=new HashMap<>();
	static{
		
		customer.put(1, new Customer(1,"ritesh","ghorui","ghorui@gmail.com"));
		customer.put(2, new Customer(2,"will","smith","smith@gmail.com"));
		customer.put(3, new Customer(3,"divine","gully","gully@gmail.com"));
		
	}
	@Override
	public List<Customer> customers() {
	
		
		return new ArrayList(customer.values());
	}

	@Override
	public void save(Customer cust) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomer(int id) {
		return customer.get(id);
		
	}

	@Override
	public void deleteCusomer(int id) {
		// TODO Auto-generated method stub

	}

}
