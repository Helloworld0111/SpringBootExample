package com.bugtracking.Bugtracking.entity;

import javax.persistence.*;

@Entity
@Table(name="tickettable")
public class TicketTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private ApplicationTable application;

    @ManyToOne
    @JoinTable(name ="ticket_release", joinColumns = @JoinColumn(name = "ticket_fk"), inverseJoinColumns = @JoinColumn(name = "release_fk"))
    private ReleaseTable release;

    private String status;

    public TicketTable() {
    }

    public TicketTable(String title, String description,
                  ApplicationTable application, ReleaseTable release, String status) {
        this.title = title;
        this.description = description;
        this.application = application;
        this.release = release;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApplicationTable getApplication() {
        return application;
    }

    public void setApplication(ApplicationTable application) {
        this.application = application;
    }

    public ReleaseTable getRelease() {
        return release;
    }

    public void setRelease(ReleaseTable release) {
        this.release = release;
    }
}

