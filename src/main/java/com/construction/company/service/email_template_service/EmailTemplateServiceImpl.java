package com.construction.company.service.email_template_service;

import com.construction.company.model.template.EmailTemplate;
import com.construction.company.model.template.Reason;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {
    @Override
    public EmailTemplate getEmailTemplateById(Long Id) {
        return null;
    }

    @Override
    public EmailTemplate getEmailTemplateByReason(Reason reason) {
        return null;
    }

    @Override
    public List<EmailTemplate> findAll() {
        return null;
    }
}
