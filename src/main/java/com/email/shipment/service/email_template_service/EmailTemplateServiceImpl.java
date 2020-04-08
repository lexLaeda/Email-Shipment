package com.email.shipment.service.email_template_service;

import com.email.shipment.exception.EmailTemplateNotFoundException;
import com.email.shipment.mapper.EmailTemplateMapper;
import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.EmailTemplateDTO;
import com.email.shipment.model.template.Reason;
import com.email.shipment.repository.EmailTemplateRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;
;


@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {


    @Autowired
    private EmailTemplateRepository repository;

    private Logger logger = Logger.getLogger(EmailTemplateServiceImpl.class);

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
        EmailTemplateDTO saved = repository.save(emailTemplateDTO);
        logger.info(String.format("EmailTemplate with id %s saved", emailTemplateDTO.getId()));
        return saved;
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
        EmailTemplateDTO updated = repository.save(eTfromDB);
        logger.info(String.format("EmailTemplate with id %s was updated", id));
        return updated;
    }

    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
        logger.info(String.format("EmailTemplate with id %s was deleted", id));
    }
}
