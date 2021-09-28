package com.bugtracking.Bugtracking.service;

import com.bugtracking.Bugtracking.entity.TicketTable;
import com.bugtracking.Bugtracking.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public TicketTable save(TicketTable table) {
        return ticketRepository.save(table);
    }

    @Override
    public void deleteById(Integer id) {
        ticketRepository.deleteById(id);

    }

    @Override
    public List<TicketTable> findByAll() {
        List<TicketTable> a=ticketRepository.findAll();
        return a;
    }

    @Override
    public TicketTable findById(Integer id) {
        return ticketRepository.findById(id).get();
    }
}
