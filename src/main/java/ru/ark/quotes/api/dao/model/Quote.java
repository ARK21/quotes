package ru.ark.quotes.api.dao.model;


import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "quotes")
public class Quote {

    public Quote() {
    }

    public Quote(String guid, String text) {
        this.guid = guid;
        this.text = text;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "guid", nullable = false)
    private  String guid;

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "likes")
    private long likes;

    @Column(name = "dislikes")
    private long dislikes;

    public String getText() {
        return text;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }

    public Long getId() {
        return id;
    }

    public long getLikes() {
        return likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public String getGuid() {
        return guid;
    }
}
