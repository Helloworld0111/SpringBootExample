package com.bugtracking.Bugtracking.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name="releasetable")
public class ReleaseTable  implements Serializable {
    private static final long serialVersionUID = 2989395939L;
    public ReleaseTable() {

        // TODO Auto-generated constructor stub
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String releaseDate;
    private String description;


}