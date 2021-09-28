package ru.job4j.forum.control;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.Repository.MemUserStore;
import ru.job4j.forum.model.User;

@Controller
public class RegControl {
    private final MemUserStore mem;

    public RegControl(MemUserStore mem) {
        this.mem = mem;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user,
                       Model model) {
        if (mem.findUserByUsername(user.getName()) != null) {
            String errorMessage = "А user with this name is already registered.";
            model.addAttribute("errorMessage", errorMessage);
            return "reg";
        } else {
            user.setPassword(user.getPassword());
            mem.save(user);
            return "redirect:/login";
        }
    }

    @GetMapping("/reg")
    public String regPage() {
        return "/reg";
    }
}
