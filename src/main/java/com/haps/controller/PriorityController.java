package com.haps.controller;

import com.haps.entity.Patient;
import com.haps.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
@CrossOrigin
public class PriorityController {

    private final PatientRepository repo;

    public PriorityController(PatientRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public List<Patient> getPriorityPatients(){

        return repo.findAllByOrderBySeverityLevelDescAgeDesc();  // ← fixed

    }

}