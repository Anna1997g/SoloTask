package com.example.solotask.network.entities;

import android.annotation.SuppressLint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Fields {
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fields fields = (Fields) o;
        return thumbnail.equals(fields.thumbnail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thumbnail);
    }
}
