package com.bugtracking.Bugtracking.repository;

import com.bugtracking.Bugtracking.entity.TicketTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketTable,Integer> {
}
