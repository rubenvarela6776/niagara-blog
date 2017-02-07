package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rubenvarela on 2/7/17.
 */
@Controller
public class PostsController {
    @GetMapping("/posts")
    @ResponseBody
    public String viewAllPosts() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewSinglePost(@PathVariable long id) {
        return "view an individual post with ID " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public  String viewCreatePostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public  String createPost() {
        return "create a new post";
    }
}
