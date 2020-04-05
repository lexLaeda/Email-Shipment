package com.email.shipment.repository;


import com.email.shipment.model.template.EmailTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailTemplateRepository extends MongoRepository<EmailTemplate, Long> {
}
