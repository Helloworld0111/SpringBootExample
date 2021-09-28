package com.bugtracking.Bugtracking.controller;

import com.bugtracking.Bugtracking.entity.ReleaseTable;

import com.bugtracking.Bugtracking.service.ReleaseService;
import org.slf4j.Logger;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/release")
public class ReleaseController {
    private static final Logger LOGGER= LoggerFactory.getLogger(ReleaseController.class);

    @Autowired
    private ReleaseService releaseService;

    @GetMapping
    public ResponseEntity<List<ReleaseTable>> getAllReleases() {
        List<ReleaseTable> list = releaseService.findByAll();
        return new ResponseEntity<List<ReleaseTable>>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReleaseTable> getRelease(@PathVariable("id") int id) {
        LOGGER.info("Inside ReleaseController.getRelease, id :{}", id);
        try {
            return new ResponseEntity<ReleaseTable>(releaseService.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting release", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<String> deleteRelease(@RequestParam("id") int  id) {
        LOGGER.info("Inside ReleaseController.getRelease, id :{}", id);
        try {
            releaseService.deleteById(id);
            return new ResponseEntity<String>("data deleted", HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting release", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
        @PostMapping
        public ResponseEntity<String> saveApplication(@RequestBody  ReleaseTable release) {
            LOGGER.info("Inside ReleaseController.saveApplication, application:{}", release);
            try {
                releaseService.save(release);
            } catch (Exception ex) {
                LOGGER.error("Exception while getting applications", ex);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>("Application has been saved", HttpStatus.OK);
        }
        @PutMapping
        public ResponseEntity<String> updateApplication(@RequestBody  ReleaseTable release) {
            LOGGER.info("Inside ApplicationController.updateApplication, application:{}", release);
            try {
                releaseService.save(release);
            } catch (Exception ex) {
                LOGGER.error("Exception while getting applications", ex);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>("Application has been updated", HttpStatus.OK);
        }

    }

