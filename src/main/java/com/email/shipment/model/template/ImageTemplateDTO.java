package com.email.shipment.model.template;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageTemplateDTO {
    private String contentId;
    private String resourcePath;
    private String contentType;
}