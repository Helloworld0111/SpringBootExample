package com.bugtracking.Bugtracking.service;


import com.bugtracking.Bugtracking.entity.TicketTable;

import java.util.List;

public interface TicketService {
    TicketTable save(TicketTable table);
    void deleteById(Integer id);
    List<TicketTable> findByAll();
    TicketTable findById(Integer id);
}
