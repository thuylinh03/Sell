package sell.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sell.project.demo.enity.Login;
import sell.project.demo.enity.User;
import sell.project.demo.service.LoginService;
import sell.project.demo.service.UserService;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/canhan/{id}")
    public String userProfile(@PathVariable int id, Model model) {

        Login login = loginService.getById(id);

        User user = userService.getUserByLoginId(id);
        model.addAttribute("user", user);
        model.addAttribute("login", login);
        return "canhan";
    }
}
