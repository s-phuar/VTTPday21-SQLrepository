package VTTPday21.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import VTTPday21.workshop.model.Customer;
import VTTPday21.workshop.model.exception.IDNotFoundException;
import VTTPday21.workshop.utils.sql;


@Repository
public class CustomerRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Customer> getAllCustomers(int limit, int offset){
        List<Customer> customers = new ArrayList<>();

        SqlRowSet sqlRowSet = template.queryForRowSet(sql.sql_getAllCustomers, limit, offset);

        while(sqlRowSet.next()){
            Customer cus = new Customer();
            cus.setId(sqlRowSet.getInt("id"));
            cus.setCompany(sqlRowSet.getString("company"));
            cus.setLast_name(sqlRowSet.getString("last_name"));
            cus.setFirst_name(sqlRowSet.getString("first_name"));
            cus.setEmail_address(sqlRowSet.getString("email_address"));
            cus.setJob_title(sqlRowSet.getString("job_title"));
            cus.setBusiness_phone(sqlRowSet.getString("business_phone"));
            cus.setHome_phone(sqlRowSet.getString("home_phone"));
            cus.setMobile_phone(sqlRowSet.getString("mobile_phone"));
            cus.setFax_number(sqlRowSet.getString("fax_number"));
            cus.setAddress(sqlRowSet.getString("address"));
            cus.setCity(sqlRowSet.getString("city"));
            cus.setState_province(sqlRowSet.getString("state_province"));
            cus.setZip_postal_code(sqlRowSet.getString("zip_postal_code"));
            cus.setCountry_region(sqlRowSet.getString("country_region"));
            cus.setWeb_page(sqlRowSet.getString("web_page"));
            cus.setNotes(sqlRowSet.getString("notes"));
            //include one for attachments

            customers.add(cus);
        }
        return customers;
    }




    public Customer getCustomerById(int id){
        Customer c = null;
        
        try{
            c = template.queryForObject(sql.sql_getCustomerById,BeanPropertyRowMapper.newInstance(Customer.class), id);
        }catch(DataAccessException ex){ //JdbcTemplate class always throws DataAccessException whenever theres an error
            throw new IDNotFoundException("Customer with id: " + id + " is not found");
        }

        return c;

    }




}
