package com.kip.employee.repositories;

import com.kip.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
