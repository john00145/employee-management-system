package com.ph.employee_management_system.Employee.Repository;

import com.ph.employee_management_system.Employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
