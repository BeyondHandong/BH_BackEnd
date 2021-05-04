package beyond.handong.se.model;

import java.util.ArrayList;
import java.util.Date;

public class Post {

    /** Post 는 게시글 작성 관련해서 DB에 담을 정보들을 정의한 model 이다.
     *  1. 글 번호 -> id| if type is not "공지" or "FAQ", print id
     *  2. 제목 -> title
     *  3. 작성자 -> writer
     *  4. 작성 일시 -> writeDate
     *  5. 수정 일시 -> lastEditDate
     *  6. 내용 -> content
     *  7. 고마워요숫자 -> helpfulNum
     *  8. 스크랩수 -> scrapNum
     *  9. 조회수 -> viewNum
     *
     *  TODO : check if it is enough to construct the table -Jerome
     * */

    private Long id;        // primary key
    private String writer;
    private String type;
    private String title;
    private String content;
    private Long helpfulNum;
    private Long scrapNum;
    private Long viewNum;
    private Date writeDate;
    private Date lastEditDate;

    // Multiple variables in a single post object
    private ArrayList<Long> imgId;          // PK of PostImage, Post_ID is FK
    private ArrayList<Long> countryId;      // PK of Country, Post_ID is FK
    private ArrayList<Long> categoryId;     // PK of Category, Post_ID is FK
    private ArrayList<Long> commentId;      // PK of Comment, Post_ID is FK
    private ArrayList<Long> scrapListId;    // PK of MyScrapList, Post_ID is FK
    private ArrayList<Long> commentOrder;
    private ArrayList<Long> commentLayer;
    private ArrayList<Long> commentGroup;


    private ArrayList<String> imgPath;
    private ArrayList<String> country;
    private ArrayList<String> category;
    private ArrayList<String> comment;
    private ArrayList<String> commentWriteDate;
    private ArrayList<String> commentWriter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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

    public ArrayList<Long> getImgId() {
        return imgId;
    }

    public void setImgId(ArrayList<Long> imgId) {
        this.imgId = imgId;
    }

    public ArrayList<Long> getCountryId() {
        return countryId;
    }

    public void setCountryId(ArrayList<Long> countryId) {
        this.countryId = countryId;
    }

    public ArrayList<Long> getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(ArrayList<Long> categoryId) {
        this.categoryId = categoryId;
    }

    public ArrayList<Long> getCommentId() {
        return commentId;
    }

    public void setCommentId(ArrayList<Long> commentId) {
        this.commentId = commentId;
    }

    public ArrayList<Long> getScrapListId() {
        return scrapListId;
    }

    public void setScrapListId(ArrayList<Long> scrapListId) {
        this.scrapListId = scrapListId;
    }

    public ArrayList<Long> getCommentOrder() {
        return commentOrder;
    }

    public void setCommentOrder(ArrayList<Long> commentOrder) {
        this.commentOrder = commentOrder;
    }

    public ArrayList<Long> getCommentLayer() {
        return commentLayer;
    }

    public void setCommentLayer(ArrayList<Long> commentLayer) {
        this.commentLayer = commentLayer;
    }

    public ArrayList<Long> getCommentGroup() {
        return commentGroup;
    }

    public void setCommentGroup(ArrayList<Long> commentGroup) {
        this.commentGroup = commentGroup;
    }

    public ArrayList<String> getImgPath() {
        return imgPath;
    }

    public void setImgPath(ArrayList<String> imgPath) {
        this.imgPath = imgPath;
    }

    public ArrayList<String> getCountry() {
        return country;
    }

    public void setCountry(ArrayList<String> country) {
        this.country = country;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public ArrayList<String> getComment() {
        return comment;
    }

    public void setComment(ArrayList<String> comment) {
        this.comment = comment;
    }

    public ArrayList<String> getCommentWriteDate() {
        return commentWriteDate;
    }

    public void setCommentWriteDate(ArrayList<String> commentWriteDate) {
        this.commentWriteDate = commentWriteDate;
    }

    public ArrayList<String> getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(ArrayList<String> commentWriter) {
        this.commentWriter = commentWriter;
    }
}
