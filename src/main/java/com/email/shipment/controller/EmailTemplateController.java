package com.email.shipment.controller;

import com.email.shipment.mapper.EmailTemplateMapper;
import com.email.shipment.model.template.EmailTemplateDTO;
import com.email.shipment.service.email_template_service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/templates")
public class EmailTemplateController {

    @Autowired
    private EmailTemplateService service;

    private EmailTemplateMapper mapper = new EmailTemplateMapper();

    @GetMapping("/all")
    public List<EmailTemplateDTO> findAll(){
        return service.findAll().stream()
                .map(emailTemplate -> mapper.toDTO(emailTemplate))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EmailTemplateDTO findById(@PathVariable(name = "id")Long id){
        return mapper.toDTO(service.findById(id));
    }

    @PostMapping("/template")
    public EmailTemplateDTO addPerson(@RequestBody EmailTemplateDTO emailTemplateDTO) {
                service.addEmailTemplate(mapper.fromDTO(emailTemplateDTO));
        return emailTemplateDTO;
    }

    @PutMapping("/{id}")
    public EmailTemplateDTO updatePerson(@PathVariable(name = "id") Long id,
                                         @RequestBody EmailTemplateDTO emailTemplateDTO) {
            service.updateEmailTemplate(id, mapper.fromDTO(emailTemplateDTO));
        return emailTemplateDTO;
    }

    @DeleteMapping()
    public void deletePerson(@PathVariable(name = "id") Long id) {
        service.removeById(id);
    }
}
