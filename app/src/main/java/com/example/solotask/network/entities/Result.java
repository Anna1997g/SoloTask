package com.example.solotask.network.entities;

import android.annotation.SuppressLint;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity(tableName = "resultItems")
public class Result  {
    @PrimaryKey(autoGenerate = true)
    private int id1;
    @ColumnInfo
    private boolean isFavorite;
    @SerializedName("id")
    @Expose
    @ColumnInfo
    private String id;
    @SerializedName("type")
    @Expose
    @ColumnInfo
    private String type;
    @SerializedName("sectionId")
    @Expose
    @ColumnInfo
    private String sectionId;
    @SerializedName("sectionName")
    @Expose
    @ColumnInfo
    private String sectionName;
    @SerializedName("webPublicationDate")
    @Expose
    @ColumnInfo
    private String webPublicationDate;
    @SerializedName("webTitle")
    @Expose
    @ColumnInfo
    private String webTitle;
    @SerializedName("webUrl")
    @Expose
    @ColumnInfo
    private String webUrl;
    @SerializedName("apiUrl")
    @Expose
    @ColumnInfo
    private String apiUrl;
    @SerializedName("fields")
    @Expose
    @Embedded
    private Fields fields;
    @SerializedName("isHosted")
    @Expose
    @ColumnInfo
    private Boolean isHosted;
    @SerializedName("pillarId")
    @Expose
    @ColumnInfo
    private String pillarId;
    @SerializedName("pillarName")
    @Expose
    @ColumnInfo
    private String pillarName;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    public void setWebPublicationDate(String webPublicationDate) {
        this.webPublicationDate = webPublicationDate;
    }

    public String getWebTitle() {
        return webTitle;
    }

    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public Boolean getIsHosted() {
        return isHosted;
    }

    public void setIsHosted(Boolean isHosted) {
        this.isHosted = isHosted;
    }

    public String getPillarId() {
        return pillarId;
    }

    public void setPillarId(String pillarId) {
        this.pillarId = pillarId;
    }

    public String getPillarName() {
        return pillarName;
    }

    public void setPillarName(String pillarName) {
        this.pillarName = pillarName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return id.equals(result.id) &&
                type.equals(result.type) &&
                sectionId.equals(result.sectionId) &&
                sectionName.equals(result.sectionName) &&
                webPublicationDate.equals(result.webPublicationDate) &&
                webTitle.equals(result.webTitle) &&
                webUrl.equals(result.webUrl) &&
                apiUrl.equals(result.apiUrl) &&
                fields.equals(result.fields) &&
                isHosted.equals(result.isHosted) &&
                pillarId.equals(result.pillarId) &&
                pillarName.equals(result.pillarName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, sectionId, sectionName, webPublicationDate, webTitle, webUrl, apiUrl, fields, isHosted, pillarId, pillarName);
    }

    @Override
    public String toString() {
        return "Result{" +
                "id1=" + id1 +
                ", isFavorite=" + isFavorite +
                ", id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", webPublicationDate='" + webPublicationDate + '\'' +
                ", webTitle='" + webTitle + '\'' +
                ", webUrl='" + webUrl + '\'' +
                ", apiUrl='" + apiUrl + '\'' +
                ", fields=" + fields +
                ", isHosted=" + isHosted +
                ", pillarId='" + pillarId + '\'' +
                ", pillarName='" + pillarName + '\'' +
                '}';
    }
}
