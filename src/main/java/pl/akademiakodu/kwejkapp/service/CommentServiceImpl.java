package pl.akademiakodu.kwejkapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.kwejkapp.dao.CommentDao;
import pl.akademiakodu.kwejkapp.entity.Comment;

import java.time.LocalDateTime;

/**
 * Created by luke on 25.06.2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public void save(Comment comment) {
        comment.setTimestamp(LocalDateTime.now());
        commentDao.save(comment);
    }
}
