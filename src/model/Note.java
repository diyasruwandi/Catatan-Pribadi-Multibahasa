/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author DIYAS
 */
public class Note implements Serializable {

    private int id;
    private String title;
    private String content;
    private String imagePath;
    private String createdAt;

    public Note(int id, String title, String content, String imagePath, String createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imagePath = imagePath;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
