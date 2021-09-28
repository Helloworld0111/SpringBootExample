package com.bugtracking.Bugtracking.controller;
import java.util.List;
import java.util.logging.Logger;

import com.bugtracking.Bugtracking.entity.ApplicationTable;
import com.bugtracking.Bugtracking.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<List<ApplicationTable>> getAllApplications() {
        LOGGER.info("Inside the ApplicationsController.getAllApplications");

        try {
            List<ApplicationTable> list = applicationService.findByAll();
            LOGGER.info("Response from get applications:{} : ", list);
            return new ResponseEntity<List<ApplicationTable>>(list, HttpStatus.OK);
        } catch(Exception ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // return applications;
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationTable> getApplication(@PathVariable("id") long id) {
        LOGGER.info("Inside ApplicationsController.getApplication, id :{}", id);
        try {
            return new ResponseEntity<ApplicationTable>(applicationService.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteApplication(@RequestParam("id") long id) {
        LOGGER.info("Inside ApplicationsController.getApplication, id :{}", id);
        try {
            applicationService.deleteById(id);
            return new ResponseEntity<String>("data deleted", HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
    @PostMapping
    public ResponseEntity<String> saveApplication(@RequestBody  ApplicationTable application) {
        LOGGER.info("Inside ApplicationController.saveApplication, application:{}", application);
        try {
            applicationService.save(application);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Application has been saved", HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> updateApplication(@RequestBody  ApplicationTable application) {
        LOGGER.info("Inside ApplicationController.updateApplication, application:{}", application);
        try {
            applicationService.save(application);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Application has been updated", HttpStatus.OK);
    }

}

