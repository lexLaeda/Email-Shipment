package com.construction.company.controller;

import com.construction.company.model.template.EmailTemplate;
import com.construction.company.service.email_template_service.EmailTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/templates")
public class EmailTemplateController {

    @Autowired
    private EmailTemplateService service;

    @GetMapping("/all")
    public List<EmailTemplate> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EmailTemplate findById(@PathVariable(name = "id")Long id){
        return service.
    }
}
