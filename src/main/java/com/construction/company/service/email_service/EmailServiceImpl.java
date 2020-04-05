package com.construction.company.service.email_service;

import com.construction.company.model.person.Person;
import com.construction.company.model.template.EmailTemplate;
import com.construction.company.model.template.Reason;
import com.construction.company.service.email_template_service.EmailTemplateServiceImpl;
import com.construction.company.service.message_service.MessageServiceImpl;
import com.construction.company.service.person_service.PersonServiceImpl;
import com.construction.company.service.shipment_service.ShipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private PersonServiceImpl personService;

    @Autowired
    private EmailTemplateServiceImpl emailTemplateService;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private ShipmentServiceImpl shipmentService;

    @Override
    public String congratulateAllIfBirthDay() {
        List<Person> persons = personService.findAllByBirthDate(LocalDate.now());
        EmailTemplate emailTemplate = emailTemplateService.findByReason(Reason.BIRTHDAY);
        List<MimeMessage> mimeMessages = messageService.createMimeMessages(emailTemplate, persons);
        shipmentService.sendListOfMimeMessages(mimeMessages);
        return mimeMessages.toString();
    }

    @Override
    public String sendMessageToAllPersons(Long id) {
        List<Person> persons = personService.findAll();
        return sendMessageToPersons(persons, id);
    }

    @Override
    public String sendMessageToPersons(List<Person> persons, Long id) {
        EmailTemplate emailTemplate = emailTemplateService.findById(id);
        List<MimeMessage> mimeMessages = messageService.createMimeMessages(emailTemplate, persons);
        shipmentService.sendListOfMimeMessages(mimeMessages);
        return mimeMessages.toString();
    }

    @Override
    public String sendMessageToPerson(Person person, Long id) {
        List<Person> persons = Arrays.asList(person);
        return sendMessageToPersons(persons, id);
    }


}
