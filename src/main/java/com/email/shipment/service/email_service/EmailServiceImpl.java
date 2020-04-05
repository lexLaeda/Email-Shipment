package com.email.shipment.service.email_service;

import com.email.shipment.model.person.Person;
import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.Reason;
import com.email.shipment.service.email_template_service.EmailTemplateServiceImpl;
import com.email.shipment.service.message_service.MessageServiceImpl;
import com.email.shipment.service.person_service.PersonServiceImpl;
import com.email.shipment.service.shipment_service.ShipmentServiceImpl;
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
