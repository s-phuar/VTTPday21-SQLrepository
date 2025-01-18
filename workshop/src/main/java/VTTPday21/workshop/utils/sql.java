package VTTPday21.workshop.utils;

public class sql {
    
    public static final String sql_getAllCustomers = "SELECT * FROM customers LIMIT ? OFFSET ?";
    public static final String sql_getCustomerById = "SELECT * FROM customers where id = ? ";
    public static final String sql_getAllOrdersByCustomerId = "SELECT * FROM orders where customer_id = ?";


}
