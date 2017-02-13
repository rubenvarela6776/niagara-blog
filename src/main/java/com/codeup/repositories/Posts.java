package com.codeup.repositories;
import com.codeup.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rubenvarela on 2/9/17.
 */
@Repository
public interface Posts extends CrudRepository <Post, Long> {
//    public Post findByUser(User user);


    @Query("select p from Post p where p.title like ?1")
    public List<Post> findByTitleLike(String title);
}
