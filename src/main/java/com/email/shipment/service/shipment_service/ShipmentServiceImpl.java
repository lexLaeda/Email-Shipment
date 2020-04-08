package com.email.shipment.service.shipment_service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    private static final Logger LOG = Logger.getLogger(ShipmentServiceImpl.class);

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
        try{
        javaMailSender.send(mimeMessage);
        } catch (MailException ex){
            try {
                LOG.error("Can`t send message to users " + Arrays.toString(mimeMessage.getReplyTo()));
            } catch (MessagingException e) {
                LOG.error("Can`t send message to users and adress is null");
                e.printStackTrace();
            }
        }
        return mimeMessage;
    }

    @Override
    public SimpleMailMessage sendSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        try {
            javaMailSender.send(simpleMailMessage);
        } catch (MailException ex){
            LOG.error("Can`t send message to users " + Arrays.toString(simpleMailMessage.getTo()));
        }

        return simpleMailMessage;
    }
}
