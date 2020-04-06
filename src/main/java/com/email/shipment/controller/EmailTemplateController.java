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

    @GetMapping("/all")
    public List<EmailTemplateDTO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EmailTemplateDTO findById(@PathVariable(name = "id")Long id){
        return service.findById(id);
    }

    @PostMapping("/template")
    public EmailTemplateDTO addTemplate(@RequestBody EmailTemplateDTO emailTemplateDTO) {
                service.addEmailTemplate(emailTemplateDTO);
        return emailTemplateDTO;
    }

    @PutMapping("/{id}")
    public EmailTemplateDTO updateTemplate(@PathVariable(name = "id") Long id,
                                         @RequestBody EmailTemplateDTO emailTemplateDTO) {
            service.updateEmailTemplate(id, emailTemplateDTO);
        return emailTemplateDTO;
    }

    @DeleteMapping()
    public void deleteTemplate(@PathVariable(name = "id") Long id) {
        service.removeById(id);
    }
}
