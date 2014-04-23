package com.bnj.indoortms.api.client.model;

import com.google.api.client.util.Key;

/**
 * Created by wen55527 on 4/23/14.
 */
public class UploadedFile {
    @Key
    private int size;
    @Key
    private String path;
    @Key
    private String name;
    @Key
    private String type;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
