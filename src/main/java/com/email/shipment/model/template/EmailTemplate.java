package com.email.shipment.model.template;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Locale;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailTemplate implements Cloneable {
    private Long id;
    private String name;
    private String pathTo;
    private String subject;
    private Reason reason;
    private Locale locale;
    private Context context;
    private List<ImageTemplate> imageTemplates;


}
