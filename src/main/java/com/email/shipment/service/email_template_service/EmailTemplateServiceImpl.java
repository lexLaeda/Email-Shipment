package com.email.shipment.service.email_template_service;

import com.email.shipment.exception.EmailTemplateNotFoundException;
import com.email.shipment.mapper.EmailTemplateMapper;
import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.EmailTemplateDTO;
import com.email.shipment.model.template.Reason;
import com.email.shipment.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {


    @Autowired
    private EmailTemplateRepository repository;

    @Override
    public EmailTemplateDTO findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmailTemplateNotFoundException(id.toString()));
    }

    @Override
    public EmailTemplateDTO findByReason(Reason reason) {
        EmailTemplateMapper mapper = new EmailTemplateMapper();
        return mapper.toDTO(repository.findAll().stream()
                .map(mapper::fromDTO)
                .filter(emailTemplate -> emailTemplate.getReason().equals(reason))
                .findFirst()
                .orElseThrow(()->new EmailTemplateNotFoundException(reason.getName())));
    }

    @Override
    public List<EmailTemplateDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public EmailTemplateDTO addEmailTemplate(EmailTemplateDTO emailTemplateDTO) {
        return repository.save(emailTemplateDTO);
    }

    @Override
    public EmailTemplateDTO updateEmailTemplate(Long id, EmailTemplateDTO emailTemplateDTO) {
        EmailTemplateDTO eTfromDB = repository.findById(id)
                .orElseThrow(() -> new EmailTemplateNotFoundException(id.toString()));

        eTfromDB.setName(emailTemplateDTO.getName());
        eTfromDB.setLocale(emailTemplateDTO.getLocale());
        eTfromDB.setPathTo(emailTemplateDTO.getPathTo());
        eTfromDB.setReason(emailTemplateDTO.getReason());
        eTfromDB.setImageTemplateDTOList(emailTemplateDTO.getImageTemplateDTOList());
        eTfromDB.setSubject(emailTemplateDTO.getSubject());
        eTfromDB.setVariables(emailTemplateDTO.getVariables());

        return repository.insert(eTfromDB);
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }
}
