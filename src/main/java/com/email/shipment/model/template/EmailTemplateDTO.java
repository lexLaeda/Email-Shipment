package com.email.shipment.model.template;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Locale;
import java.util.Map;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "email_templates")
public class EmailTemplateDTO {
    @Id
    private Long id;

    private String name;

    private String pathTo;

    private String subject;

    private Reason reason;

    private Locale locale;

    private Map<String, Object> variables;

    private List<ImageTemplateDTO> imageTemplateDTOList;
}
