package com.construction.company.service.shipment_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Override
    public List<MimeMessage> sendListOfMimeMessages(List<MimeMessage> mimeMessages) {

        return mimeMessages.stream()
                .map(this::sendMimeMessage)
                .collect(Collectors.toList());
    }

    @Override
    public List<SimpleMailMessage> sendListOfSimpleMailMessages(List<SimpleMailMessage> simpleMailMessages) {
        return simpleMailMessages.stream()
                .map(this::sendSimpleMailMessage)
                .collect(Collectors.toList());
    }

    @Override
    public MimeMessage sendMimeMessage(MimeMessage mimeMessage) {
        javaMailSender.send(mimeMessage);
        return mimeMessage;
    }

    @Override
    public SimpleMailMessage sendSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        javaMailSender.send(simpleMailMessage);
        return simpleMailMessage;
    }
}
