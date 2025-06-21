package hackathun_java1.hackathun.controller;

import hackathun_java1.hackathun.model.User;
import hackathun_java1.hackathun.security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        User user = userDetails.getUser();

        model.addAttribute("username", user.getUsername());
        model.addAttribute("role", user.getRole());

        return "home"; // renderiza home.html
    }
}
