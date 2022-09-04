package com.blz.techstackservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TechStackDTO {
    @NotBlank(message = "image path cannot be empty")
    private String imagePath;
    @NotBlank(message = "status cannot be empty")
    private boolean status;
    @NotBlank(message = "tech name cannot be empty")
    private String techName;
}
