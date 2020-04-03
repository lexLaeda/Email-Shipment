package com.construction.company.service.message_service;

import com.construction.company.model.person.Person;
import com.construction.company.model.template.EmailTemplate;

import javax.mail.internet.MimeMessage;
import java.util.List;

public interface MessageService {
    <T extends Person> List<MimeMessage> createMimeMessages(EmailTemplate template, List<T> personList);
    <T extends Person> MimeMessage createMimeMessage(EmailTemplate template, T person);
    <T extends Person> List<MimeMessage> createMimeMessages(EmailTemplate template, List<T> personList, List<String> pathsToFiles);
    <T extends Person> MimeMessage createMimeMessage(EmailTemplate template, T person, List<String> pathsToFiles);
}
