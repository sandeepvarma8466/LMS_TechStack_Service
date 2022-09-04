package com.blz.techstackservice.model;

import com.blz.techstackservice.dto.TechStackDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tech_stack")
@Data
@NoArgsConstructor
public class TechStackModel {
    @Id
    @GenericGenerator(name = "tech_stack", strategy = "increment")
    @GeneratedValue(generator = "tech_stack")
    private int id;
    @JsonIgnore
    private LocalDateTime creatorStamp;

    private String creatorUser;
    private String imagePath;
    private boolean status;
    private String techName;

    public TechStackModel(TechStackDTO techStackDTO) {
        this.imagePath = techStackDTO.getImagePath();
        this.status = techStackDTO.isStatus();
        this.techName = techStackDTO.getTechName();
        this.creatorStamp = LocalDateTime.now();
    }
}
