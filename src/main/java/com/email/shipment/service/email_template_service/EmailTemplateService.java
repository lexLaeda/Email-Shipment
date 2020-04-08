package com.email.shipment.service.email_template_service;

import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.EmailTemplateDTO;
import com.email.shipment.model.template.Reason;

import java.util.List;

public interface EmailTemplateService {
    EmailTemplateDTO findById(Long id);

    EmailTemplateDTO findByReason(Reason reason);

    List<EmailTemplateDTO> findAll();

    EmailTemplateDTO addEmailTemplate(EmailTemplateDTO emailTemplateDTO);

    EmailTemplateDTO updateEmailTemplate(Long id, EmailTemplateDTO emailTemplateDTO);

    void  removeById(Long id);
}
