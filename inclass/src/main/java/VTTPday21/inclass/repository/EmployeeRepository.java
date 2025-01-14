package VTTPday21.inclass.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import VTTPday21.inclass.model.Employee;
import VTTPday21.inclass.utils.sql;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Employee> getAllEmployees(){
        List<Employee> empList = new ArrayList<>();
        SqlRowSet sqlRowSet = template.queryForRowSet(sql.sql_selectEmployees);

        while(sqlRowSet.next()){
            Employee emp = new Employee();
            emp.setFirst_name(sqlRowSet.getString("first_name"));
            emp.setLast_name(sqlRowSet.getString("last_name"));
            emp.setJob_title(sqlRowSet.getString("job_title"));
            emp.setDepartment(sqlRowSet.getString("department"));
            emp.setEmployment_date(sqlRowSet.getDate("employment_date"));
            emp.setSalary(sqlRowSet.getFloat("salary"));
            emp.setActive(sqlRowSet.getBoolean("active"));

            empList.add(emp);
        }
        System.out.println("\n\n\n\n");

        return empList;        
    }


    


}
