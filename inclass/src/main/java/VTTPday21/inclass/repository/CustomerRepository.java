package VTTPday21.inclass.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import VTTPday21.inclass.model.Customer;
import VTTPday21.inclass.model.exception.ResourceNotFoundException;
import VTTPday21.inclass.utils.sql;

@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();

        //returns a list of Customer objects
        customers = template.query(sql.sql_getallCustomers, BeanPropertyRowMapper.newInstance(Customer.class));

        return customers;
    }


    public List<Customer> getCustomers(int limit, int offset){
        List<Customer> customers = new ArrayList<>();

        //get set of rows
        SqlRowSet sqlRowSet = template.queryForRowSet(sql.sql_getCustomers_LimitOffSet, limit, offset);

        while(sqlRowSet.next()){
            Customer customer = new Customer();
            customer.setId(sqlRowSet.getInt("id"));
            customer.setFullname(sqlRowSet.getString("fullname"));
            customer.setEmail(sqlRowSet.getString("email"));

            customers.add(customer);
        }

        return customers;
    }


    public Customer getCustomerById(int id){
        //returns exactly 1 object
        Customer c = null;
        
        try{
            c = template.queryForObject(sql.sql_getCustomersById,BeanPropertyRowMapper.newInstance(Customer.class), id);
        }catch(DataAccessException ex){
            throw new ResourceNotFoundException("Customer with id: " + id + " is not found");
        }

        return c;

    }



    public boolean deleteCustomerById(int id){
        int customerDeleted = template.update(sql.sql_deleteCustomerById, id);

        if(customerDeleted > 0){
            return true;
        }
        return false;
    }

    public boolean updateCustomerById(Customer customer){
        int customerUpdated = template.update(sql.sql_updateCustomerById, customer.getFullname(), customer.getEmail(), customer.getId());

        //int is number of rows affected by the update oeparation
        if(customerUpdated > 0){
            return true;
        }
        return false;
    }


    public boolean insertCustomer(Customer customer){
        int customerUpdated = template.update(sql.sql_insertCustomer, customer.getFullname(), customer.getEmail());

        if(customerUpdated > 0){
            return true;
        }
        return false;

    }

}
