package com.codeup.controllers;
import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.Posts;
import com.codeup.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
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
        model.addAttribute("posts", Collections.emptyList());
        return "posts/index";
    }

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> retrieveAllAds() {
        return (List<Post>) postsDao.findAll();
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
    public  String createPost(@Valid Post post, Errors validation, Model viewModel) {
        if(validation.hasErrors()) {
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("post", post);
            return "/posts/create";
        }

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }
}