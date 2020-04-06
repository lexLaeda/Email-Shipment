package com.email.shipment.model.template;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ImageTemplateDTO {
    private String contentId;
    private String resourcePath;
    private String contentType;
}
