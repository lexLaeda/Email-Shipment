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
    private static final Long TESTID = 10000L;
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
                .id(TESTID)
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
        service.removeById(TESTID);
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
    void testFindById() {
        EmailTemplateDTO emailTemplateDTO = service.findById(TESTID);

        assertEquals(birthDay.getPathTo(),emailTemplateDTO.getPathTo());
    }

    @Test
    void testFindByReason() {
        EmailTemplateDTO emailTemplateDTO = service.findByReason(Reason.BIRTHDAY);
        assertEquals(birthDay.getPathTo(),emailTemplateDTO.getPathTo());
    }

    @Test
    void testFindAll() {
        List<EmailTemplateDTO> list = service.findAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);
        assertEquals(birthDay.getPathTo(),list.get(0).getPathTo());
    }

    @Test
    void testAddEmailTemplate() {
        assertNotNull(service.addEmailTemplate(birthDay));

        assertEquals(birthDay,service.addEmailTemplate(birthDay));

    }

    @Test
    void testUpdateEmailTemplate() {
        service.addEmailTemplate(birthDay);
        EmailTemplateDTO upBirthday = birthDay;
        String updatedName = "updatedBirthDayTemplate";
        upBirthday.setName(updatedName);
        service.updateEmailTemplate(TESTID,upBirthday);
        assertEquals(upBirthday.getName(),service.findById(TESTID).getName());
    }

    @Test
    void testRemoveById() {
        List<EmailTemplateDTO> all = service.findAll();
        service.removeById(TESTID);
        List<EmailTemplateDTO> allAfterRemove = service.findAll();
        assertEquals(1, all.size() - allAfterRemove.size());
    }
}