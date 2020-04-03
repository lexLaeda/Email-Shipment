package com.construction.company.service.email_template_service;

import com.construction.company.model.template.EmailTemplate;
import com.construction.company.model.template.Reason;

import java.util.List;
import java.util.Map;

public interface EmailTemplateService {
    EmailTemplate getEmailTemplateById(Long Id);
    EmailTemplate getEmailTemplateByReason(Reason reason);


    List<EmailTemplate> findAll();
}
