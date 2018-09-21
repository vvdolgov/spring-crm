package hibernate.springdemo.dao;

import hibernate.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Customer> customerQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        List<Customer> customerList = customerQuery.getResultList();
        return customerList;
    }

    @Override
    public List<Customer> search(String searchName) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Customer> customers;
        if(searchName!=null&&searchName.trim().length()>0) {
            Query<Customer> query = currentSession.createQuery("from Customer where lower(firstName) " +
                    "like :theName or lower(lastName) like :theName", Customer.class);
            query.setParameter("theName", "%" + searchName.toLowerCase() + "%");
            customers = query.getResultList();
        }
        else
        {
            customers = getCustomers();
        }
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
            currentSession.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = currentSession.get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = getCustomer(id);
        currentSession.delete(customer);
    }


}
