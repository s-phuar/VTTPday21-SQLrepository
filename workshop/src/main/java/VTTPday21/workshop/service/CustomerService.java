package VTTPday21.workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import VTTPday21.workshop.model.Customer;
import VTTPday21.workshop.model.Orders;
import VTTPday21.workshop.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getallCustomers(int limit, int offset){
        return customerRepository.getAllCustomers(limit, offset);
    }


    public Customer getCustomerById(int id){
        return customerRepository.getCustomerById(id);
    }

    public List<Orders> getOrdersByCustomerId(int id){
        return customerRepository.getOrdersByCustomerId(id);
    }




}
