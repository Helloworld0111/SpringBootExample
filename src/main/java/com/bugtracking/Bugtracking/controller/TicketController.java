package com.bugtracking.Bugtracking.controller;

import com.bugtracking.Bugtracking.entity.ReleaseTable;
import com.bugtracking.Bugtracking.entity.TicketTable;
import com.bugtracking.Bugtracking.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    private static final Logger LOGGER= LoggerFactory.getLogger(TicketController.class);

    @GetMapping
    public ResponseEntity<List<TicketTable>> getAllTickets() {
        List<TicketTable> list = ticketService.findByAll();
        return new ResponseEntity<List<TicketTable>>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TicketTable> getTicket(@PathVariable("id") int id) {
        LOGGER.info("Inside ApplicationsController.getTicket, id :{}", id);
        try {
            return new ResponseEntity<TicketTable>(ticketService.findById(id), HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting ticket", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<String> saveApplication(@RequestBody TicketTable ticket) {
        LOGGER.info("Inside ReleaseController.saveApplication, application:{}", ticket);
        try {
            ticketService.save(ticket);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Application has been saved", HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<String> updateApplication(@RequestBody  TicketTable ticket) {
        LOGGER.info("Inside ApplicationController.updateApplication, application:{}", ticket);
        try {
            ticketService.save(ticket);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting applications", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Application has been updated", HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteTicket(@RequestParam("id") int  id) {
        LOGGER.info("Inside TicketController.getTicket, id :{}", id);
        try {
            ticketService.deleteById(id);
            return new ResponseEntity<String>("data deleted", HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error("Exception while getting tickets", ex);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
