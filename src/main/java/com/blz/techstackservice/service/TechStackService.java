package com.blz.techstackservice.service;

import com.blz.techstackservice.dto.TechStackDTO;
import com.blz.techstackservice.exception.TechStackNotFoundException;
import com.blz.techstackservice.model.TechStackModel;
import com.blz.techstackservice.repository.TechStackRepository;
import com.blz.techstackservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TechStackService implements ITechStackService {
    @Autowired
    TechStackRepository stackRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    RestTemplate restTemplate;
    @Override
    public TechStackModel insertTechStack(TechStackDTO techStackDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            TechStackModel techStackModel = new TechStackModel(techStackDTO);
            stackRepository.save(techStackModel);
            return techStackModel;
        }
        throw new TechStackNotFoundException("Invalid token", 500);
    }

    @Override
    public TechStackModel updateTechStack(Integer id, TechStackDTO techStackDTO, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> isTechIdPresent = stackRepository.findById(id);
            if (isTechIdPresent.isPresent()) {
                isTechIdPresent.get().setTechName(techStackDTO.getTechName());
                isTechIdPresent.get().setStatus(techStackDTO.isStatus());
                isTechIdPresent.get().setImagePath(techStackDTO.getImagePath());
                isTechIdPresent.get().setCreatorStamp(LocalDateTime.now());
                stackRepository.save(isTechIdPresent.get());
                return isTechIdPresent.get();
            }
            throw new TechStackNotFoundException("TechStack Id Not Found", 500);
        }
        throw new TechStackNotFoundException("Invalid token", 500);
    }

    @Override
    public List<TechStackModel> fetchAllDetails(String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            List<TechStackModel> isDataPresent = stackRepository.findAll();
            if (isDataPresent.size() > 0) {
                return isDataPresent;
            }
            throw new TechStackNotFoundException("Empty TechStack Data Found", 500);
        }
        throw new TechStackNotFoundException("Invalid token", 500);
    }

    @Override
    public TechStackModel fetchDetailsById(Integer id, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> isIdPresent = stackRepository.findById(id);
            if (isIdPresent.isPresent()) {
                return isIdPresent.get();
            }
            throw new TechStackNotFoundException("TechStack Id Not Found", 500);
        }
        throw new TechStackNotFoundException("Invalid token", 500);
    }

    @Override
    public TechStackModel deleteTechStack(Integer id, String token) {
        boolean isUserPresent = restTemplate.getForObject("http://localhost:8068/adminmodule/validateuser/" + token,
                Boolean.class);
        if (isUserPresent) {
            Optional<TechStackModel> isIdPresent = stackRepository.findById(id);
            if (isIdPresent.isPresent()) {
                stackRepository.delete(isIdPresent.get());
                return isIdPresent.get();
            }
            throw new TechStackNotFoundException("TechStack Id Not Found", 500);
        }
        throw new TechStackNotFoundException("Invalid token", 500);
    }
}
