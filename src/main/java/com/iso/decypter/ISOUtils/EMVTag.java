package com.iso.decypter.ISOUtils;

public class EMVTag {
    private String tag;
    private String title;
    private String description;

    public EMVTag(String tag, String title, String description) {
        this.tag = tag;
        this.title = title;
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
}
