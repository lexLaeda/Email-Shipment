package com.construction.company.mapper;

import com.construction.company.model.template.ImageTemplate;
import com.construction.company.model.template.ImageTemplateDTO;
import org.springframework.core.io.ClassPathResource;

public class ImageTemplateMapper implements Mapper<ImageTemplate, ImageTemplateDTO> {

    @Override
    public ImageTemplate fromDTO(ImageTemplateDTO dto) {
        return ImageTemplate.builder()
                .contentId(dto.getContentId())
                .classPathResource(new ClassPathResource(dto.getResourcePath()))
                .contentType(dto.getContentType())
                .build();

    }

    @Override
    public ImageTemplateDTO toDTO(ImageTemplate imageTemplate) {
        return ImageTemplateDTO.builder()
                .contentId(imageTemplate.getContentId())
                .resourcePath(imageTemplate.getClassPathResource().getPath())
                .contentType(imageTemplate.getContentType())
                .build();
    }
}
