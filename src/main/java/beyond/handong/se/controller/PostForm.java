package beyond.handong.se.controller;

import java.util.Date;

public class PostForm {
    private Long writerId;
    private String writerName;

    private String type;
    private String title;
    private String content;

    private String country;
    private String category;

    private Long helpfulNum;
    private Long scrapNum;
    private Long viewNum;

    private Date writeDate;
    private Date lastEditDate;

    public Long getWriterId() {
        return writerId;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getHelpfulNum() {
        return helpfulNum;
    }

    public void setHelpfulNum(Long helpfulNum) {
        this.helpfulNum = helpfulNum;
    }

    public Long getScrapNum() {
        return scrapNum;
    }

    public void setScrapNum(Long scrapNum) {
        this.scrapNum = scrapNum;
    }

    public Long getViewNum() {
        return viewNum;
    }

    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }
}