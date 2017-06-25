package pl.akademiakodu.kwejkapp.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by luke on 25.06.2017.
 */

@Entity
@Table(name="COMMENTS")
public class Comment extends AbstractPersistable<Long>{

    @Column(name="Nick", nullable = false)
    @NotEmpty
    @NotNull
    private String nick;

    @Column(name="Text", nullable = false)
    @NotEmpty
    @NotNull
    private String text;

    @Column(name="Timestamp")
    private LocalDateTime timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MEM_ID", referencedColumnName = "ID")
    private Mem mem;

    public Comment() {
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Mem getMem() {
        return mem;
    }

    public void setMem(Mem mem) {
        this.mem = mem;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "nick='" + nick + '\'' +
                ", text='" + text + '\'' +
                ", timestamp=" + timestamp +
                ", mem=" + mem +
                '}';
    }
}
