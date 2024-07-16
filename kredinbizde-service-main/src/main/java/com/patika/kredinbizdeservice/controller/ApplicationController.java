package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {

    @Autowired
    @Qualifier(value = "applicationService")
    private ApplicationService applicationService;

    //Kredi başvurularını kaydeden end-point.
    @PostMapping
    public Application create(@RequestBody Application application) {
        return applicationService.save(application);
    }

    @GetMapping
    public List<Application> getAll() {
        return applicationService.getAll();
    }

    //email adresi ile kullanıcının bütün başvurularını listeleyen end-point.
    @GetMapping("/{email}")
    public List<Application> findByUserEmail(@PathVariable String email) {
        return applicationService.findByUserEmail(email);
    }

    @GetMapping("/byId/{applicationId}")
    public Application findById(@PathVariable int applicationId) {
        return applicationService.findById(applicationId);
    }

    @PutMapping("/{applicationId}")
    public Application update(@PathVariable int applicationId, @RequestBody Application application) {
        return applicationService.update(applicationId, application);
    }




}
