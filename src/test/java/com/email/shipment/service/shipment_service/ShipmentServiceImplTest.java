package com.email.shipment.service.shipment_service;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.email.shipment.model.person.Sex.MALE;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ShipmentServiceImplTest {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Autowired
    private TemplateEngine htmlTemplateEngine;

    @Autowired
    private ShipmentServiceImpl shipmentService;

    private static final Logger LOG = Logger.getLogger(ShipmentServiceImplTest.class);

    private SimpleMailMessage smm;

    private MimeMessage mimeMessage;


    @BeforeEach
    void setUp() {
        LOG.info("**************START A NEW TEST SENDER**********");
        smm = new SimpleMailMessage();
        smm.setTo("lex_laeda@mail.ru");
        smm.setText("Hello this is a test message");
        smm.setSubject("Test");

        mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setSubject("C днем рождения");
            mimeMessageHelper.setTo("lex_laeda@mail.ru");
            Context context = new Context();
            context.setVariable("sex", MALE);
            context.setVariable("fullname","Aleksey Ermakov");
            String htmlContent = htmlTemplateEngine.process("html/HappyBirthDay.html", context);
            mimeMessageHelper.setText(htmlContent, true);
            mimeMessageHelper.addInline("company_logo", new ClassPathResource("mail/html/image/company_logo.png"), "image/png");


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSendListOfMimeMessages() {

        LOG.info("************Send List of MimeMessages*******");
        List<MimeMessage> mimeMessages = Arrays.asList(mimeMessage,mimeMessage);
        shipmentService.sendListOfMimeMessages(mimeMessages);
        LOG.info("*******************STATUS SENT**************");
    }

    @Test
    void testSendListOfSimpleMailMessages() {
        LOG.info("************Send List of SimpleMessages******");
        List<MimeMessage> mimeMessages = Arrays.asList(mimeMessage,mimeMessage);
        shipmentService.sendListOfMimeMessages(mimeMessages);
        LOG.info("*******************STATUS SENT***************");

    }

    @Test
    void testSendMimeMessage() {
        LOG.info("***************Send MimeMessage**********");
        List<SimpleMailMessage> simpleMailMessages = Arrays.asList(smm,smm);
        shipmentService.sendListOfSimpleMailMessages(simpleMailMessages);
        LOG.info("*******************STATUS SENT**************");
    }

    @Test
    void testSendSimpleMailMessage() {
        LOG.info("************Send SimpleMessage*******");
        shipmentService.sendSimpleMailMessage(smm);
        LOG.info("*******************STATUS SENT**************");
    }
}