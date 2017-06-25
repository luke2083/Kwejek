package pl.akademiakodu.kwejkapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.kwejkapp.entity.Comment;

/**
 * Created by luke on 25.06.2017.
 */

@Repository
public interface CommentDao extends CrudRepository<Comment, Long> {

}
