package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

@Controller
public class RegControl {
    private final PostService service;

    public RegControl(PostService service) {
        this.service = service;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user,
                       Model model) {
        if (service.findUserByName(user.getUsername()) != null) {
            String errorMessage = "А user with this name is already registered.";
            model.addAttribute("errorMessage", errorMessage);
            return "/reg";
        }
        user.setEnabled(true);
        user.setPassword(this.service.encode(user.getPassword()));
        user.setAuthority(this.service.findAuthorityByRole("ROLE_USER"));
        service.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String regPage() {
        return "/reg";
    }
}
