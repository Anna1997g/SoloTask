package com.example.solotask.network.entities;

import android.annotation.SuppressLint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class BaseResponse {
    @SerializedName("response")
    @Expose
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponse that = (BaseResponse) o;
        return response.equals(that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response);
    }
}
