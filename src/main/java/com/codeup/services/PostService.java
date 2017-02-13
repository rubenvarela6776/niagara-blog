package com.codeup.services;
import com.codeup.models.Post;
import java.util.List;
import com.codeup.repositories.Posts;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
/**
 * Created by rubenvarela on 2/9/17.
 */
@Service("postService")
public class PostService {
    private List<Post> posts = new ArrayList<>();
    private Posts repository;

    public PostService(Posts repository) {
        this.repository = repository;
    }

    public PostService() {
        createPosts();
    }

    private void createPosts() {
        for (int i = 0; i < 100; i++) {
            posts.add(
                new Post("Title" + (i + 1), "Body" + (i + 1))
            );
        }
    }

    public void save(Post post) {
//        post.setId(posts.size() + 1);
//        posts.add(post);
        repository.save(post);
    }

    public List<Post> findAllPosts() {
        return (List<Post>) repository.findAll();
    }

    public Post findOnePost(long id) {
        return repository.findOne(id);
    }
}
