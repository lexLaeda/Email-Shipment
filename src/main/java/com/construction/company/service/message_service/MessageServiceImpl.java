package com.construction.company.service.message_service;

import com.construction.company.model.employe.Person;
import com.construction.company.model.template.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    //TODO: config
    private TemplateEngine htmlTemplateEngine;

    @Override
    public <T extends Person> List<MimeMessage> createMimeMessages(EmailTemplate template, List<T> personList) {
        return personList.stream()
                .map(person->createMimeMessage(template,person))
                .collect(Collectors.toList());
    }

    @Override
    public <T extends Person> MimeMessage createMimeMessage(EmailTemplate template, T person) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            mimeMessageHelper.setSubject(template.getSubject());
            mimeMessageHelper.setTo(person.getContact().getEmail());
            String htmlContent = htmlTemplateEngine.process(template.getPathTo(),template.getContext());
            mimeMessageHelper.setText(htmlContent,true);
            fillMessageHelperWithImages(mimeMessageHelper,template.getPathToImages());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mimeMessage;
    }

    @Override
    public <T extends Person> List<MimeMessage> createMimeMessages(EmailTemplate template, List<T> personList, String pathToFile) {
        return personList.stream()
                .map(person-> createMimeMessage(template,person,pathToFile))
                .collect(Collectors.toList());
    }

    @Override
    public <T extends Person> MimeMessage createMimeMessage(EmailTemplate template, T person, String pathToFile) {
        //TODO add message creation with files
        return null;
    }
    private void fillMessageHelperWithImages(MimeMessageHelper mimeMessageHelper, Set<String> pathToImages) {
        pathToImages.forEach((pathToImage)-> fillMessageHelperWithImage(mimeMessageHelper,pathToImage));
    }
    private void fillMessageHelperWithImage(MimeMessageHelper mimeMessageHelper, String pathToImage){
        try {
            File file = new File(pathToImage);
            mimeMessageHelper.addInline(pathToImage,file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
