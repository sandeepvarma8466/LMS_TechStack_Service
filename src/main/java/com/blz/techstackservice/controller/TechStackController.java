package com.blz.techstackservice.controller;

import com.blz.techstackservice.dto.TechStackDTO;
import com.blz.techstackservice.model.TechStackModel;
import com.blz.techstackservice.service.ITechStackService;
import com.blz.techstackservice.util.TeckStackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/techstackmodule")
public class TechStackController {
    @Autowired
    ITechStackService techStackService;

    @PostMapping("/inserttechstack")
    public ResponseEntity<TeckStackResponse> insertTechStack(@Valid @RequestBody TechStackDTO techStackDTO, @RequestHeader String token) {
        TechStackModel stackModel = techStackService.insertTechStack(techStackDTO, token);
        TeckStackResponse stackResponse = new TeckStackResponse(200,"TechStack inserted successfully",stackModel);
        return new ResponseEntity<>(stackResponse, HttpStatus.OK);
    }

    @PutMapping("/updatetechstack/{id}")
    public ResponseEntity<TeckStackResponse> updateTechStack(@PathVariable("id") Integer id,@Valid @RequestBody TechStackDTO techStackDTO,
                                          @RequestHeader String token) {
        TechStackModel stackModel = techStackService.updateTechStack(id, techStackDTO, token);
        TeckStackResponse stackResponse = new TeckStackResponse(200,"TechStack updated successfully",stackModel);
        return new ResponseEntity<>(stackResponse, HttpStatus.OK);
    }

    @GetMapping("/fetchtechstack")
    public ResponseEntity<TeckStackResponse> fetchAllDetails(@RequestHeader String token) {
        List<TechStackModel> stackModel = techStackService.fetchAllDetails(token);
        TeckStackResponse stackResponse = new TeckStackResponse(200,"TechStack fetched successfully",stackModel);
        return new ResponseEntity<>(stackResponse, HttpStatus.OK);
    }

    @GetMapping("/fetchtechstackby/{id}")
    public ResponseEntity<TeckStackResponse> fetchDetailsById(@PathVariable("id") Integer id, @RequestHeader String token) {
        TechStackModel stackModel = techStackService.fetchDetailsById(id, token);
        TeckStackResponse stackResponse = new TeckStackResponse(200,"TechStack fetched by id successfully",stackModel);
        return new ResponseEntity<>(stackResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deletetechstack/{id}")
    public ResponseEntity<TeckStackResponse> deleteTechStack(@PathVariable Integer id, @RequestHeader String token) {
        TechStackModel stackModel = techStackService.deleteTechStack(id, token);
        TeckStackResponse stackResponse = new TeckStackResponse(200,"TechStack deleted successfully",stackModel);
        return new ResponseEntity<>(stackResponse, HttpStatus.OK);
    }
}
