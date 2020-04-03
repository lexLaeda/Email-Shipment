package com.construction.company.model.template;

import lombok.Data;
import org.springframework.core.io.ClassPathResource;
@Data
public class ImageTemplate {
    private String contentId;
    private ClassPathResource classPathResource;
    private String contentType;
}
