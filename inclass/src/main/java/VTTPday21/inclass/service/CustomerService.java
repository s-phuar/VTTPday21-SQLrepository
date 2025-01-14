package VTTPday21.inclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTTPday21.inclass.model.Customer;
import VTTPday21.inclass.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.getCustomers();
    }

    public List<Customer> getCustomers(int limit, int offset){
        return customerRepository.getCustomers(limit, offset);
    }

    public Customer getCustomerById(int id){
        return customerRepository.getCustomerById(id);
    }

    public boolean deleteCustomerById(int id){
        return customerRepository.deleteCustomerById(id);
    }

    public boolean updateCustomerById(Customer customer){
        return customerRepository.updateCustomerById(customer);
    }

    public boolean insertCustomer(Customer customer){
        return customerRepository.insertCustomer(customer);
    }


}
