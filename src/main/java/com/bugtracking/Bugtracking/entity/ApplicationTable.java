package com.bugtracking.Bugtracking.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name="applicationtable ")
public class ApplicationTable implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4079155191270597798L;

    public ApplicationTable() {

        // TODO Auto-generated constructor stub
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Application [id=" + id + ", name=" + name + ", description=" + description + ", owner=" + owner + "]";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="application_id")
    private Long id;

    @Column(name = "app_name", nullable = false)
    private String name;

    @Column(length = 2000, name = "app_desc")
    private String description;
    @Column(length = 2000, name = "app_owner")
    private String owner;


}

