package com.construction.company.service.email_template_service;

import com.construction.company.model.template.EmailTemplate;
import com.construction.company.model.template.EmailTemplateDTO;
import com.construction.company.model.template.Reason;

import java.util.List;
import java.util.Map;

public interface EmailTemplateService {
    EmailTemplate findById(Long Id);
    EmailTemplate findByReason(Reason reason);


    List<EmailTemplate> findAll();

    EmailTemplateDTO addEmailTemplate(EmailTemplate fromDTO);

    EmailTemplateDTO updateEmailTemplate(Long id, EmailTemplate fromDTO);

    EmailTemplateDTO removeById(Long id);
}
