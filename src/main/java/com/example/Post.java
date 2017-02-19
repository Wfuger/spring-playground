package com.example;

/**
 * Created by willfuger on 2/19/17.
 */
public class Post {
    private String author;
    private String content;
    private Comment[] comments;

    public Comment[] getComments() { return comments; }
    public String getAuthor() { return author; }
    public String getContent() { return content; }

    public void setComments(Comment[] comments) { this.comments = comments; }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setContent(String content) { this.content = content; }
}
