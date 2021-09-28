package com.bugtracking.Bugtracking.service;

import com.bugtracking.Bugtracking.entity.ApplicationTable;

import java.util.List;

public interface ApplicationService {
    ApplicationTable save(ApplicationTable application);
    void deleteById(Long id);
    List<ApplicationTable> findByAll();
    ApplicationTable findById(Long id);
}
