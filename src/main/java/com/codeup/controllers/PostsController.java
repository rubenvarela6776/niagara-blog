package com.codeup.controllers;
import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.Posts;
import com.codeup.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rubenvarela on 2/7/17.
 */
@Controller
public class PostsController {

    PostService service;
    Posts postsDao;

    @Autowired
    public PostsController(PostService service, Posts postsDao) {
        this.service = service;
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String viewAllPosts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewSinglePost(Model viewModel, @PathVariable long id) {
        viewModel.addAttribute("post", postsDao.findOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model viewModel, @PathVariable long id) {
        Post post = postsDao.findOne(id);
        viewModel.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(Model viewModel, @ModelAttribute Post post) {
        postsDao.save(post);
        viewModel.addAttribute("post", post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postsDao.delete(postsDao.findOne(post.getId()));
        return "redirect:/posts";
    }

    @GetMapping("/posts/search")
    public String searchTitle(@RequestParam(name = "term") String term, Model model) {
        System.out.println(term);
        model.addAttribute("ListOfPosts", postsDao.findByTitleLike("%" + term + "%"));
        return "posts/index";
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm(Model viewModel, @ModelAttribute Post post) {
        viewModel.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public  String createPost(@ModelAttribute Post post, Model viewModel) {
        User user = new User();
        user.setId(2);
//        post.setUser(user);
        postsDao.save(post);
        viewModel.addAttribute("post", post);
        return "redirect:/posts";
    }
}