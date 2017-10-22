package com.adverts.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "advert")
@NamedQuery(name = "Advert.findAll", query = "SELECT b FROM advert b")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String author;
    private Date datetime_created;
    private Date datetime_updated;


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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDatetime_created() {
        return datetime_created;
    }

    public void setDatetime_created(Date datetime_created) {
        this.datetime_created = datetime_created;
    }

    public Date getDatetime_updated() {
        return datetime_updated;
    }

    public void setDatetime_updated(Date datetime_updated) {
        this.datetime_updated = datetime_updated;
    }
}
