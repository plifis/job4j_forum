package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.service.PostService;


@Controller
public class CommentControl {
    private final PostService service;

    public CommentControl(PostService service) {
        this.service = service;
    }

    @PostMapping("/comment")
    public String addComment(@RequestParam("id") int id,
                             @ModelAttribute Comment comment) {
        this.service.findPostById(id).addComment(this.service.saveComment(comment));
        return "redirect:/";
    }
}
