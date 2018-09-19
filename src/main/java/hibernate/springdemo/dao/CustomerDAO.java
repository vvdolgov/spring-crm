package hibernate.springdemo.dao;

import hibernate.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer>  getCustomers();
}
