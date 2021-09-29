package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.Calendar;

@Controller
public class PostControl {
    private final PostService service;

    public PostControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", this.service.findPostById(id));
        model.addAttribute("comments", this.service.getAllCommentsById(id));
        return "/edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post) {
        post.setCreated(Calendar.getInstance());
        this.service.savePost(post);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create() {
        return "/create";
    }

    @GetMapping("/post")
    public String printPost(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", this.service.findPostById(id));
        model.addAttribute("comments", this.service.getAllCommentsById(id));
        return "/post";
    }

}
