package com.bugtracking.Bugtracking.service;

import com.bugtracking.Bugtracking.entity.ApplicationTable;
import com.bugtracking.Bugtracking.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service
    public class ApplicationServiceImpl implements ApplicationService {
        @Autowired
        private ApplicationRepository applicationRepository;

        public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
            this.applicationRepository = applicationRepository;
        }


        public ApplicationTable save(ApplicationTable application) {

            return applicationRepository.save(application);
        }

        public void deleteById(Long id) {
            applicationRepository.deleteById(id);

        }

        public List<ApplicationTable> findByAll() {
            List<ApplicationTable> a=applicationRepository.findAll();
            return a;

        }
        public ApplicationTable findById(Long id)
        {
            return applicationRepository.findById(id).get();

        }



    }
