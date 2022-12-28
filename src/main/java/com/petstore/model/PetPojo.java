package com.petstore.model;

import java.util.List;

public class PetPojo {



private int id;
private List<?> category ;
private String name ;
private List<?>tags;
private List<?>photourl;

    public List<?> getPhotourl() {
        return photourl;
    }

    public void setPhotourl(List<?> photourl) {
        this.photourl = photourl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<?> getCategory() {
        return category;
    }

    public void setCategory(List<?> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public List<?> getTags() {
        return tags;
   }

    public void setTags(List<?> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;



}




