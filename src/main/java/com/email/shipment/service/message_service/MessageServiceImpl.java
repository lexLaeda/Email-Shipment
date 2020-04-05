package com.email.shipment.service.message_service;

import com.email.shipment.model.person.Person;
import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.ImageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private TemplateEngine htmlTemplateEngine;

    @Override
    public <T extends Person> List<MimeMessage> createMimeMessages(EmailTemplate template, List<T> personList) {
        return personList.stream()
                .map(person -> createMimeMessage(template, person))
                .collect(Collectors.toList());
    }

    @Override
    public <T extends Person> MimeMessage createMimeMessage(EmailTemplate template, T person) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            helper.setSubject(template.getSubject());
            helper.setTo(person.getContact().getEmail());
            String htmlContent = htmlTemplateEngine.process(template.getPathTo(), template.getContext());
            helper.setText(htmlContent, true);
            fillMessageHelperWithImages(helper, template.getImageTemplates());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mimeMessage;
    }

    @Override
    public <T extends Person> List<MimeMessage> createMimeMessages(EmailTemplate template, List<T> personList, List<String> pathsToFile) {
        return personList.stream()
                .map(person -> createMimeMessage(template, person, pathsToFile))
                .collect(Collectors.toList());
    }

    @Override
    public <T extends Person> MimeMessage createMimeMessage(EmailTemplate template, T person, List<String> pathsToFile) {
        MimeMessage mimeMessage = createMimeMessage(template, person);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            pathsToFile.forEach(pathToFile->addAttachmentToFile(helper,pathToFile));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return mimeMessage;
    }
    private void addAttachmentToFile(MimeMessageHelper helper, String pathToFile){
        File file = new File(pathToFile);
        try {
            helper.addAttachment(file.getName(),file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    private void fillMessageHelperWithImages(MimeMessageHelper helper, List<ImageTemplate> imageTemplates) {
        imageTemplates.forEach((imageTemplate) ->
                fillMessageHelperWithImage(helper, imageTemplate.getContentId(),
                        imageTemplate.getClassPathResource(), imageTemplate.getContentType()));
    }

    private void fillMessageHelperWithImage(MimeMessageHelper helper,
                                            String contentId, ClassPathResource classPathResource,
                                            String contentType) {
        try {
            helper.addInline(contentId, classPathResource, contentType);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
