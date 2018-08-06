package com.sensenets.sinopec.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date uts;

    private String name;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return uts
     */
    public Date getUts() {
        return uts;
    }

    /**
     * @param uts
     */
    public void setUts(Date uts) {
        this.uts = uts;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}