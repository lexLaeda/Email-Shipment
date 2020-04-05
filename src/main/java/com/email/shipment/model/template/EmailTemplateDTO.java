package com.email.shipment.model.template;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Locale;
import java.util.Map;


@Data
@Builder
public class EmailTemplateDTO {
    private Long id;
    private String name;
    private String pathTo;
    private String subject;
    private Reason reason;
    private Locale locale;
    private Map<String, Object> variables;
    private List<ImageTemplateDTO> imageTemplateDTOList;
}
