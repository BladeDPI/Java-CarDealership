package edu.home.car.dealer.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blogPost")
@NamedQueries({
    @NamedQuery(name = CarDeal.FIND_BY_TITLE, query = "from CarDeal bp where bp.title like :title")
})

public class CarDeal extends BaseEntity {

    public static final String FIND_BY_TITLE = "CarDeal.findByTitle";

    @Column
    private String title;
    private String content;
    @Column
    private Date uploadDate;
    @Column
    private String writer;

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

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "CarDeal{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", content='" + content + '\'' +
               ", uploadDate=" + uploadDate +
               ", writer='" + writer + '\'' +
               '}';
    }
}
