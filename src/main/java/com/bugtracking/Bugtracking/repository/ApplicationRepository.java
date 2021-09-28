package com.bugtracking.Bugtracking.repository;

import com.bugtracking.Bugtracking.entity.ApplicationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository <ApplicationTable,Long>{
}
