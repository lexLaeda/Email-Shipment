package com.email.shipment.model.template;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
@Data
@Builder
public class ImageTemplate {
    private String contentId;
    private ClassPathResource classPathResource;
    private String contentType;
}
