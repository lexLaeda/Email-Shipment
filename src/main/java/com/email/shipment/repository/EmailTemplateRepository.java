package com.email.shipment.repository;


import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.EmailTemplateDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTemplateRepository extends MongoRepository<EmailTemplateDTO, Long> {
}
