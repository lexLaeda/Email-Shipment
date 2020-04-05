package com.email.shipment.service.email_template_service;

import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.Reason;

import java.util.List;

public interface EmailTemplateService {
    EmailTemplate findById(Long id);
    EmailTemplate findByReason(Reason reason);


    List<EmailTemplate> findAll();

    EmailTemplate addEmailTemplate(EmailTemplate emailTemplate);

    EmailTemplate  updateEmailTemplate(Long id, EmailTemplate emailTemplate);

    void  removeById(Long id);
}
