package com.email.shipment.mapper;

import com.email.shipment.model.template.EmailTemplate;
import com.email.shipment.model.template.EmailTemplateDTO;
import com.email.shipment.model.template.ImageTemplate;
import com.email.shipment.model.template.ImageTemplateDTO;
import org.thymeleaf.context.Context;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmailTemplateMapper implements Mapper<EmailTemplate, EmailTemplateDTO> {
    private ImageTemplateMapper mapper = new ImageTemplateMapper();

    @Override
    public EmailTemplate fromDTO(EmailTemplateDTO dto) {
        Context context = new Context();
        context.setVariables(dto.getVariables());
        return EmailTemplate.builder()
                .id(dto.getId())
                .name(dto.getName())
                .pathTo(dto.getPathTo())
                .subject(dto.getSubject())
                .reason(dto.getReason())
                .locale(dto.getLocale())
                .context(context)
                .imageTemplates(dto.getImageTemplateDTOList().stream()
                        .map(this::getImageTemplate)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public EmailTemplateDTO toDTO(EmailTemplate emailTemplate) {
        Map<String, Object> variables = getVariables(emailTemplate.getContext());
        return EmailTemplateDTO.builder()
                .id(emailTemplate.getId())
                .name(emailTemplate.getName())
                .pathTo(emailTemplate.getPathTo())
                .subject(emailTemplate.getSubject())
                .reason(emailTemplate.getReason())
                .locale(emailTemplate.getLocale())
                .variables(variables)
                .imageTemplateDTOList(emailTemplate.getImageTemplates().stream()
                        .map(this::getImageTemplateDTO)
                        .collect(Collectors.toList()))
                .build();

    }

    private Map<String, Object> getVariables(Context context) {
        Set<String> variablesNames = context.getVariableNames();
        return variablesNames.stream().collect(Collectors.toMap(variableName -> variableName, context::getVariable));
    }

    private ImageTemplate getImageTemplate(ImageTemplateDTO dto) {
        return mapper.fromDTO(dto);
    }

    private ImageTemplateDTO getImageTemplateDTO(ImageTemplate imageTemplate) {
        return mapper.toDTO(imageTemplate);
    }
}
