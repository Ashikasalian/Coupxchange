package com.example.coupxchange;


public class Free {
    private String url;
    private String store;
    private String code;
    private String description;
    private String end_date;
    private String start_date;
    private String title;
    private long timestamp;
    private String status;

    public Free(String code,String description,String end_date, String start_date,String status, String store, long timestamp, String title,String url) {
        this.url=url;
        this.store = store;
        this.code = code;
        this.description = description;
        this.end_date=end_date;
        this.start_date=start_date;
        this.status=status;
        this.timestamp=timestamp;
        this.title=title;
    }

    public Free() {
        // Required empty constructor
    }

    public String getStore() {
        return store;
    }

    public String getTitle() {
        return title;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }



    public void setStore(String store) {
        this.store = store;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setStart_date(String start_date) {this.start_date = start_date;}

    public void setTitle(String title) {
        this.store = title;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
