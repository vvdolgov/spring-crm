package hibernate.springdemo.dao;

import hibernate.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer>  getCustomers();
    public List<Customer>  search(String searchName);
    public void saveCustomer(Customer customer);
    public Customer getCustomer(int id);
    public void deleteCustomer(int id);
}
