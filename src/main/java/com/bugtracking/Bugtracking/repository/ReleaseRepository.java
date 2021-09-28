package com.bugtracking.Bugtracking.repository;

import com.bugtracking.Bugtracking.entity.ReleaseTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<ReleaseTable,Integer> {
}
