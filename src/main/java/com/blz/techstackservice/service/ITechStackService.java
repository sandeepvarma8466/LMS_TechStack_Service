package com.blz.techstackservice.service;

import com.blz.techstackservice.dto.TechStackDTO;
import com.blz.techstackservice.model.TechStackModel;

import java.util.List;

public interface ITechStackService {
    TechStackModel insertTechStack(TechStackDTO techStackDTO, String token);

    TechStackModel updateTechStack(Integer id, TechStackDTO techStackDTO, String token);

    List<TechStackModel> fetchAllDetails(String token);

    TechStackModel fetchDetailsById(Integer id, String token);

    TechStackModel deleteTechStack(Integer id, String token);
}
