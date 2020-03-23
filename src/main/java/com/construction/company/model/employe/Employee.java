package com.construction.company.model.employe;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person{
    private List<JobHistoryEntry> jobHistory;
    private EmployeeType employeeType;
    private Speciality specialty;
    private Department department;
    private BigDecimal salary;
    private String buildingPlot;
    private boolean isDismissed;
    private LocalDate entryDate;
    private LocalDate exitDate;
}
