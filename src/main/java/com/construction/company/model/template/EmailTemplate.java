package com.construction.company.model.template;

import com.construction.company.model.employe.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

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
    private Set<String> pathToImages;


}
