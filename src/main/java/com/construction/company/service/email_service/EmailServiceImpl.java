package com.construction.company.service.email_service;

import com.construction.company.model.employe.Department;
import com.construction.company.model.employe.Employee;
import com.construction.company.model.template.EmailTemplate;
import com.construction.company.model.template.Reason;
import com.construction.company.service.email_template_service.EmailTemplateServiceImpl;
import com.construction.company.service.employee_service.EmployeeServiceImpl;
import com.construction.company.service.message_service.MessageServiceImpl;
import com.construction.company.service.shipment_service.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmailTemplateServiceImpl emailTemplateService;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @Override
    public String congratulateAllIfBirthDay() {
        List<Employee> employees = employeeService.findAllBirthDayMen();
        EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateByReason(Reason.BIRTHDAY);
        List<MimeMessage> mimeMessages = messageService.createMimeMessages(emailTemplate, employees);
        shipmentService.sendListOfMimeMessages(mimeMessages);
        return mimeMessages.toString();
    }

    @Override
    public String congratulateAllWithHoliday(Long id) {
        List<Employee> employees = employeeService.findAll();
        EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateById(id);
        List<MimeMessage> mimeMessages = messageService.createMimeMessages(emailTemplate, employees);
        shipmentService.sendListOfMimeMessages(mimeMessages);
        return mimeMessages.toString();
    }

    @Override
    public String sendDocsToAllEmployersByDepartment(Department department, String pathToFile, Reason reason) {
        List<Employee> employees = employeeService.findAllByDepartment(department);
        EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateByReason(reason);
        List<MimeMessage> mimeMessages = messageService.createMimeMessages(emailTemplate,employees);
        shipmentService.sendListOfMimeMessages(mimeMessages);
        return mimeMessages.toString();
    }
}
