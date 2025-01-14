package VTTPday21.inclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VTTPday21.inclass.model.Customer;
import VTTPday21.inclass.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }

    //http://localhost:8080/api/customers/limit?offset=2&limit=2
    @GetMapping("/limit")
    public ResponseEntity<List<Customer>> getCustomersByLimitOffset(@RequestParam("limit") int limit, @RequestParam("offset") int offset){
        List<Customer> customers = customerService.getCustomers(limit, offset);

        return ResponseEntity.ok().body(customers);
    }


    //localhost:8080/api/customers/233
    @GetMapping("/{customer-id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("customer-id") int id){
        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable("customer-id") int id){
        boolean bool =  customerService.deleteCustomerById(id);

        return ResponseEntity.ok().body(bool);
        
    }

    /*  
        {
            "id":6,
            "fullname":"xdxd",
            "email":"xdxd@gamil.com"
        }

    */
    @PutMapping("/{customer-id}")
    public ResponseEntity<Boolean> updateCustomerById(@PathVariable("customer-id") int id, @RequestBody Customer customer){
        boolean bool =  customerService.updateCustomerById(customer);

        return ResponseEntity.ok().body(bool);
        
    }

    @PostMapping("/{customer-id}")
    public ResponseEntity<Boolean> insertCustomer(@PathVariable("customer-id") int id, @RequestBody Customer customer){
        

        boolean bool =  customerService.insertCustomer(customer);

        return ResponseEntity.ok().body(bool);
        
    }


}
