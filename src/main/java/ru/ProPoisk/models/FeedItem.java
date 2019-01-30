package ru.ProPoisk.models;

import ru.ProPoisk.DAO.UserDaoImpl;

/**

 */

public class FeedItem {
    private int id;
    private int authorId;
    private String authorName;
    private String text;
    private String dateTime;

    public FeedItem(int authorId, String text, String dateTime) {
        this.authorId = authorId;
        this.text = text;
        this.dateTime = dateTime;

        User author = UserDaoImpl.getInstance().getUser(authorId);
        if( author != null) {
            this.authorName = author.getName();
        } else {
            this.authorName = "unknown";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthorName(){
        return authorName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "FeedItem{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", text='" + text + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
