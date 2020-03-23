package com.construction.company.model.template;

import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmailTEmplateMapper implements Mapper<EmailTemplate,EmailTemplateDTO> {
    @Override
    public EmailTemplate fromDTO(EmailTemplateDTO dto) {
        Context context = new Context();
        context.setVariables(dto.getVariables());
        return EmailTemplate.builder()
                .id(dto.getId())
                .name(dto.getName())
                .pathTo(dto.getPathTo())
                .subject(dto.getPathTo())
                .reason(dto.getReason())
                .locale(dto.getLocale())
                .context(context)
                .pathToImages(dto.getPathToImages())
                .build();
    }

    @Override
    public EmailTemplateDTO toDTO(EmailTemplate emailTemplate) {
        Map<String, Object> variables = getVariables(emailTemplate.getContext());
        return EmailTemplateDTO.builder()
                .id(emailTemplate.getId())
                .name(emailTemplate.getName())
                .pathTo(emailTemplate.getPathTo())
                .subject(emailTemplate.getPathTo())
                .reason(emailTemplate.getReason())
                .locale(emailTemplate.getLocale())
                .variables(variables)
                .pathToImages(emailTemplate.getPathToImages())
                .build();

    }

    private Map<String, Object> getVariables(Context context){
        Set<String> variablesNames = context.getVariableNames();
        return variablesNames.stream().collect(Collectors.toMap(variableName->variableName, context::getVariable));
    }
}
