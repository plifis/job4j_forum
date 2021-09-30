package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.List;


@Controller
public class CommentControl {
    private final PostService service;

    public CommentControl(PostService service) {
        this.service = service;
    }

    @PostMapping("/comment")
    public String addComment(@RequestParam("id") int id,
                             @ModelAttribute Comment comment) {
        Comment temp = this.service.saveComment(comment);
        Post post = this.service.findPostById(id);
        post.addComment(temp);
        return "redirect:/";
    }
}
