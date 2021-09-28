package ru.job4j.forum.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;


@Controller
public class LoginControl {
    private PostService service;

    public LoginControl(PostService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        User temp = service.findUserByName(user.getName());
        if (temp != null) {
            if (temp.getName().equals(user.getName()) && (temp.getPassword().equals(user.getPassword()))) {
                model.addAttribute("user", temp);
                return "redirect:/";
            }
            model.addAttribute("errorMessage", "Username or Password is incorrect !");
            return "/login";
        }
        model.addAttribute("errorMessage", "Username not found.");
        return "/login";
    }
}
