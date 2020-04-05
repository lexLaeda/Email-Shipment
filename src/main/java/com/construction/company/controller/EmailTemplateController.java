package com.construction.company.controller;

import com.construction.company.mapper.EmailTemplateMapper;
import com.construction.company.model.template.EmailTemplateDTO;
import com.construction.company.service.email_template_service.EmailTemplateService;
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
        return service.addEmailTemplate(mapper.fromDTO(emailTemplateDTO));
    }

    @PutMapping("/{id}")
    public EmailTemplateDTO updatePerson(@PathVariable(name = "id") Long id,
                                         @RequestBody EmailTemplateDTO emailTemplateDTO) {
        return service.updateEmailTemplate(id, mapper.fromDTO(emailTemplateDTO));
    }

    @DeleteMapping()
    public EmailTemplateDTO deletePerson(@PathVariable(name = "id") Long id) {
        return service.removeById(id);
    }
}
