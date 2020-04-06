package com.email.shipment.service.email_template_service;

import com.email.shipment.model.person.Sex;
import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.EmailTemplateDTO;
import com.email.shipment.model.template.ImageTemplateDTO;
import com.email.shipment.model.template.Reason;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmailTemplateServiceImplTest {

    @Autowired
    private EmailTemplateService service;

    private EmailTemplateDTO birthDay;
    private ObjectMapper mapper;
    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
        Map<String, Object> variables = new HashMap<>();
        variables.put("sex", Sex.MALE);
        variables.put("fullname","Aleksey Ermakov");
        ImageTemplateDTO imDTO = ImageTemplateDTO.builder()
                .contentId("company_logo")
                .resourcePath("mail/html/image/company_logo.png")
                .contentType("image/png")
                .build();
        List<ImageTemplateDTO> images = Arrays.asList(imDTO);
        birthDay = EmailTemplateDTO.builder()
                .id(1L)
                .name("BirthDayTemplate")
                .pathTo("html/HappyBirthDay.html")
                .locale(Locale.ENGLISH)
                .reason(Reason.BIRTHDAY)
                .subject("Happy BirthDay")
                .variables(variables)
                .imageTemplateDTOList(images)
                .build();
        service.addEmailTemplate(birthDay);
    }
    @AfterEach
    void setAfter(){
        service.removeById(10000L);
    }
    @Test
    void testSerialization() throws JsonProcessingException {
        String JsonString = mapper.writeValueAsString(birthDay);
        assertNotNull(JsonString);
        EmailTemplateDTO emailTemplateDTO = mapper.readValue(JsonString,EmailTemplateDTO.class);
        assertNotNull(emailTemplateDTO);
        assertEquals(birthDay.getPathTo(),emailTemplateDTO.getPathTo());
    }
    @Test
    void findById() {
        EmailTemplateDTO emailTemplateDTO = service.findById(1L);

        assertEquals(birthDay.getPathTo(),emailTemplateDTO.getPathTo());
    }

    @Test
    void findByReason() {
        EmailTemplateDTO emailTemplateDTO = service.findByReason(Reason.BIRTHDAY);
        assertEquals(birthDay.getPathTo(),emailTemplateDTO.getPathTo());
    }

    @Test
    void findAll() {
        List<EmailTemplateDTO> list = service.findAll();
        assertNotNull(list);
        assertEquals(1,list.size());
        assertEquals(birthDay.getPathTo(),list.get(0).getPathTo());
    }

    @Test
    void addEmailTemplate() {
    }

    @Test
    void updateEmailTemplate() {
    }

    @Test
    void removeById() {
    }
}