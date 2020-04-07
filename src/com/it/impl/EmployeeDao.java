package com.it.impl;

import com.it.bean.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> selectAll();
}
