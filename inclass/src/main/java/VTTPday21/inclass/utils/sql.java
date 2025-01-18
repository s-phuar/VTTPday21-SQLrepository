package VTTPday21.inclass.utils;

public class sql {
    
    public static final String sql_getAllRooms = "SELECT * FROM room";
    public static final String sql_getRooms_LimitOffSet = "SELECT * FROM room LIMIT ? OFFSET ?";
    public static final String sql_getRoomsById = "SELECT * FROM room where id = ?";
    public static final String sql_deleteRoomById = "DELETE FROM room where id like ?";
    public static final String sql_updateRoomById = "UPDATE room set roomtype = ?, price = ? WHERE id = ?";
    public static final String sql_insertRoom = "INSERT INTO room (roomtype, price) values (?, ?)";

    public static final String sql_getallCustomers = "SELECT * FROM customer";
    public static final String sql_getCustomers_LimitOffSet = "SELECT * FROM customer LIMIT ? OFFSET ?";
    public static final String sql_getCustomersById = "SELECT * FROM customer where id = ?";
    public static final String sql_deleteCustomerById = "DELETE FROM customer where id = ?";
    public static final String sql_updateCustomerById = "UPDATE customer set fullname = ?, email = ? WHERE id = ?";
    public static final String sql_insertCustomer = "INSERT INTO customer (fullname, email) values (?, ?)";


    public static final String sql_insertEmployee = "insert into employee (first_name, last_name, email, job_title, department, employment_date, salary, active) values (? , ?, ?, ?, ?, ?, ?, ?)";
    public static final String sql_updateemployee = "update employee set " + 
    "first_name = ?," +
    "last_name = ?," +
    "job_title = ?," +
    "department = ?," +
    "employment_date = ?," +
    "salary = ?," +
    "active = ?" +
    "where id = ?";
    public static final String sql_selectEmployeeById = "select * from employee where id = ?";
    public static final String sql_selectEmployees = "select * from employee";


}
