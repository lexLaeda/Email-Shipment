package com.construction.company.service.employee_service;

import com.construction.company.model.employe.Department;
import com.construction.company.model.employe.Employee;
import com.construction.company.model.employe.Sex;
import com.construction.company.model.employe.Speciality;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee findById(Long id);
    Employee removeById(Long id);
    Employee dismiss(Long id);
    Employee changeLocation(String buildingPlot, Long id);
    Employee changeSpeciality(Speciality speciality, Department department, Long id);
    Employee changeSalary(BigDecimal salary, Long id);
    List<Employee> findAllNotDismiss();
    List<Employee> findAll();
    List<Employee> findAllBySex(Sex sex);
    List<Employee> findAllByDepartment(Department department);
    List<Employee> findAllByBuildingPlot(String buildingPlot);
    List<Employee> findAllBirthDayMen();
}
