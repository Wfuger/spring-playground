package com.example;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * Created by willfuger on 2/19/17.
 */
public class Article {

    private String title;
    private String createdBy;
    private Comment[] comments;

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    Article() {

    }
}
