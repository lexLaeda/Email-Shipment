package com.construction.company.service.email_service;

import com.construction.company.model.employe.Department;
import com.construction.company.model.template.Reason;

public interface EmailService {
    String congratulateAllIfBirthDay();
    String congratulateAllWithHoliday(Long id);
    String sendDocsToAllEmployersByDepartment(Department department, String pathToFile, Reason reason);
}
