package com.myvideo.model.domain;

public class DownloadDo extends BaseDo {

    public static final String TYPE_THUNDER_URL = "thunderUrl";

    public static final String TYPE_MAGNET_URL = "magnetUrl";

    private String downloadUrl;

    private String downloadName;

    private String downloadType;

    public DownloadDo() {

    }

    public DownloadDo(String downloadName, String downloadUrl, String downloadType) {
        this.downloadName = downloadName;
        this.downloadUrl = downloadUrl;
        this.downloadType = downloadType;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadName() {
        return downloadName;
    }

    public void setDownloadName(String downloadName) {
        this.downloadName = downloadName;
    }

    public String getDownloadType() {
        return downloadType;
    }

    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    @Override
    public String toString() {
        return "DownloadDo{" +
                "downloadUrl='" + downloadUrl + '\'' +
                ", downloadName='" + downloadName + '\'' +
                ", downloadType='" + downloadType + '\'' +
                '}';
    }
}
