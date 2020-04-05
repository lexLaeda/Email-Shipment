package com.email.shipment.service.shipment_service;

import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;
import java.util.List;

public interface ShipmentService {
    List<MimeMessage> sendListOfMimeMessages(List<MimeMessage> mimeMessages);
    List<SimpleMailMessage> sendListOfSimpleMailMessages(List<SimpleMailMessage> simpleMailMessages);
    MimeMessage sendMimeMessage(MimeMessage mimeMessage);
    SimpleMailMessage sendSimpleMailMessage(SimpleMailMessage simpleMailMessage);
}
