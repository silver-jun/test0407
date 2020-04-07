package com.it.dao;

import com.it.bean.Employee;
import com.it.impl.EmployeeDao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements EmployeeDao {
    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String uri = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String user = "hr";
    private static final String password = "tiger";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Connection conn = null;
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet result = null;

    public EmployeeImpl() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(uri, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Employee> selectAll() {
        List<Employee> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT  * FROM employees");
            result = ps.executeQuery();
            while(result.next()){
                Employee employee = new Employee();
                employee.setEmployee_id(Integer.parseInt(result.getString("employee_id")));
                employee.setFirst_name(result.getString("first_name"));
                employee.setLast_name(result.getString("last_name"));
                employee.setEmail(result.getString("email"));
                employee.setPhone_number(result.getString("phone_number"));

                employee.setHire_date(dateFormat.parse(result.getString("hire_date")));
                employee.setJob_id(result.getString("job_id"));
                employee.setSalary(Double.parseDouble(result.getString("salary")));

                if(result.getString("commission_pct") == null){
                    employee.setCommission_pct(0);
                }else{
                    employee.setCommission_pct(Double.parseDouble(result.getString("commission_pct")));
                }

                if(result.getString("manager_id") == null){
                    employee.setManager_id(0);
                }else{
                    employee.setManager_id(Integer.parseInt(result.getString("manager_id")));
                }

                if(result.getString("department_id") == null){
                    employee.setDepartment_id(0);
                }else {
                    employee.setDepartment_id(Integer.parseInt(result.getString("department_id")));
                }

                list.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }
}
