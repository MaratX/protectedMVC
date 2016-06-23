package com.springapp.mvc;

/**
 * Created by Marat on 22.06.2016.
 */
public class Docs {
    private long Id;
    private String Name;
    private long Link;
    private String format;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLink(long link) {
        Link = link;
    }

    public long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public long getLink() {
        return Link;
    }
}
