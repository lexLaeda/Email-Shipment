package com.construction.company.model.employe;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Person person;
    private List<JobHistoryEntry> jobHistory;
    private EmployeeType employeeType;
    private Speciality specialty;
    private Department department;
    private BigDecimal salary;
    private String buildingPlot;
    private boolean isDismissed;
}
