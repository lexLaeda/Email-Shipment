package com.email.shipment.service.email_template_service;

import com.email.shipment.exception.EmailTemplateNotFoundException;
import com.email.shipment.mapper.EmailTemplateMapper;
import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.Reason;
import com.email.shipment.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {


    @Autowired
    private EmailTemplateRepository repository;

    private EmailTemplateMapper mapper = new EmailTemplateMapper();

    @Override
    public EmailTemplate findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new EmailTemplateNotFoundException(id.toString()));
    }

    @Override
    public EmailTemplate findByReason(Reason reason) {
        return null;
    }

    @Override
    public List<EmailTemplate> findAll() {
        return repository.findAll();
    }

    @Override
    public EmailTemplate addEmailTemplate(EmailTemplate emailTemplate) {
        return repository.save(emailTemplate);
    }

    @Override
    public EmailTemplate updateEmailTemplate(Long id, EmailTemplate emailTemplate) {
        EmailTemplate emTemFrDB = repository.findById(id)
                .orElseThrow(()->new EmailTemplateNotFoundException(id.toString()));
        emTemFrDB.setName(emailTemplate.getName());
        emTemFrDB.setContext(emailTemplate.getContext());
        emTemFrDB.setLocale(emailTemplate.getLocale());
        emTemFrDB.setImageTemplates(emailTemplate.getImageTemplates());
        emTemFrDB.setPathTo(emailTemplate.getPathTo());
        emTemFrDB.setReason(emailTemplate.getReason());
        emTemFrDB.setSubject(emailTemplate.getSubject());
        return repository.save(emTemFrDB);
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }
}
