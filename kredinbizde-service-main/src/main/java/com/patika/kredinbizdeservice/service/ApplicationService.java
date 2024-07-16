package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApplicationService {

    private ApplicationRepository applicationRepository = new ApplicationRepository();

    public Application save(Application application) {
        applicationRepository.save(application);
        return application;
    }

    public List<Application> getAll() {
        return applicationRepository.getAll();
    }

    public List<Application> findByUserEmail(String email) {
        Optional<List<Application>> foundApplicationList = applicationRepository.findByUserEmail(email);
        List<Application> applicationList = null;
        if (foundApplicationList.isPresent()) {
            applicationList = foundApplicationList.get();
        }
        return applicationList;
    }

    public Application findById(int id) {
        Optional<Application> foundApplication = applicationRepository.findById(id);
        Application application = null;

        if (foundApplication.isPresent()) {
            application = foundApplication.get();
        }
        return application;
    }

    public Application update(int applicationId, Application application) {
        Optional<Application> foundApplication = applicationRepository.findById(applicationId);
        if (foundApplication.isPresent()) {
            foundApplication.get().setApplicationStatus(application.getApplicationStatus());
            foundApplication.get().setApplicationId(application.getApplicationId());
            foundApplication.get().setAmount(application.getAmount());
            applicationRepository.delete(application);
            applicationRepository.save(foundApplication.get());
            return foundApplication.get();
        }
        return null;


    }
}
