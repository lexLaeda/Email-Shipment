package com.construction.company.service.employee_service;

import com.construction.company.model.employe.Department;
import com.construction.company.model.employe.Employee;
import com.construction.company.model.employe.Sex;
import com.construction.company.model.employe.Speciality;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee addEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return null;
    }

    @Override
    public Employee removeById(Long id) {
        return null;
    }

    @Override
    public Employee dismiss(Long id) {
        return null;
    }

    @Override
    public Employee changeLocation(String buildingPlot, Long id) {
        return null;
    }

    @Override
    public Employee changeSpeciality(Speciality speciality, Department department, Long id) {
        return null;
    }

    @Override
    public Employee changeSalary(BigDecimal salary, Long id) {
        return null;
    }

    @Override
    public List<Employee> findAllNotDismiss() {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public List<Employee> findAllBySex(Sex sex) {
        return null;
    }

    @Override
    public List<Employee> findAllByDepartment(Department department) {
        return null;
    }

    @Override
    public List<Employee> findAllByBuildingPlot(String buildingPlot) {
        return null;
    }

    @Override
    public List<Employee> findAllBirthDayMen() {
        return null;
    }
}
