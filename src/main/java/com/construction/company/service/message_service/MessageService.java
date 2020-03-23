package com.construction.company.service.message_service;

import com.construction.company.model.employe.Person;
import com.construction.company.model.template.EmailTemplate;

import javax.mail.internet.MimeMessage;
import java.util.List;

public interface MessageService {
    <T extends Person> List<MimeMessage> createMimeMessages(EmailTemplate template, List<T> personList);
    <T extends Person> MimeMessage createMimeMessage(EmailTemplate template, T person);
    <T extends Person> List<MimeMessage> createMimeMessages(EmailTemplate template, List<T> personList, String pathToFile);
    <T extends Person> MimeMessage createMimeMessage(EmailTemplate template, T person, String pathToFile);
}
