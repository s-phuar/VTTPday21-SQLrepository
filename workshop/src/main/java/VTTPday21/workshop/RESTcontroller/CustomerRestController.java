package VTTPday21.workshop.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import VTTPday21.workshop.model.Customer;
import VTTPday21.workshop.model.Orders;
import VTTPday21.workshop.service.CustomerService;


@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    
    @Autowired
    private CustomerService customerService;

    //use thunderclient
    //localhost:8080/api/customers
    @GetMapping(path="", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> getAllCustomers(
        @RequestParam(name="limit", defaultValue = "5") int limit,
        @RequestParam(name= "offset", defaultValue = "0") int offset){
    
        List<Customer> cusList = customerService.getallCustomers(limit, offset);

        return ResponseEntity.ok().body(cusList);
    }
    
    //localhost:8080/api/customers/{id}
    @GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerById(
        @PathVariable(name="id") int id){

        Customer cus = customerService.getCustomerById(id);

        return ResponseEntity.ok().body(cus);
    }

    //localhost:8080/api/customers/{id}/orders
    @GetMapping(path="/{id}/orders", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Orders>> getCustomerOrdersById(
        @PathVariable(name="id") int id){

        List<Orders> orderList = customerService.getOrdersByCustomerId(id);

        return ResponseEntity.ok().body(orderList);
    }


}
