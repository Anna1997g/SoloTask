package com.example.solotask.network.entities;

import android.annotation.SuppressLint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class Response {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("userTier")
    @Expose
    private String userTier;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("startIndex")
    @Expose
    private Integer startIndex;
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("orderBy")
    @Expose
    private String orderBy;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserTier() {
        return userTier;
    }

    public void setUserTier(String userTier) {
        this.userTier = userTier;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return status.equals(response.status) &&
                userTier.equals(response.userTier) &&
                total.equals(response.total) &&
                startIndex.equals(response.startIndex) &&
                pageSize.equals(response.pageSize) &&
                currentPage.equals(response.currentPage) &&
                pages.equals(response.pages) &&
                orderBy.equals(response.orderBy) &&
                results.equals(response.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, userTier, total, startIndex, pageSize, currentPage, pages, orderBy, results);
    }
}
