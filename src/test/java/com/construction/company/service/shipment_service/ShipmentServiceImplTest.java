package com.construction.company.service.shipment_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import static com.construction.company.model.person.Sex.MALE;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ShipmentServiceImplTest {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Autowired
    private TemplateEngine htmlTemplateEngine;

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void sendListOfMimeMessages() {
    }

    @Test
    void sendListOfSimpleMailMessages() {
    }

    @Test
    void sendMimeMessage() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setSubject("C днем рождения");
            mimeMessageHelper.setTo("lex_laeda@mail.ru");

            Context context = new Context();
            context.setVariable("sex", MALE);
            context.setVariable("fullname","Aleksey Ermakov");

            BufferedImage bImage = ImageIO.read(new File("src/main/resources/mail/html/image/company_logo.png"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", bos );
            byte [] data = bos.toByteArray();
            InputStreamSource imageSource = new ByteArrayResource(data);
            String htmlContent = htmlTemplateEngine.process("html/HappyBirthDay.html", context);
            mimeMessageHelper.setText(htmlContent, true);
            mimeMessageHelper.addInline("company_logo", new ClassPathResource("mail/html/image/company_logo.png"), "image/png");

            shipmentService.sendMimeMessage(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void sendSimpleMailMessage() {
    }
}