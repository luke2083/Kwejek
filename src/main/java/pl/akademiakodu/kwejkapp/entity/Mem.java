package pl.akademiakodu.kwejkapp.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luke on 24.06.2017.
 */
@Entity
@Table(name ="MEMS")

public class Mem extends AbstractPersistable<Long> {

    @Column(name="TITLE")
    private String title;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;

    @Column(name = "VISIT_COUNT")
    private int visitCount;

    @Column(name = "IMAGE_PATH")
    private String imagePath;

    @OneToMany(mappedBy = "mem")
    private List<Comment> comments;

    public Mem() {
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void increaseCount() {
        this.visitCount++;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Mem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", visitCount=" + visitCount +
                '}';
    }

}
