package sell.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import sell.project.demo.enity.User;
import sell.project.demo.enity.UserDto;
import sell.project.demo.service.UserService;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping(path = "/signup")
    public ModelAndView register(@ModelAttribute UserDto userDto, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            userService.register(userDto);
            modelAndView.setViewName("redirect:/login");
        } catch (Exception e) {
            modelAndView.setViewName("redirect:/signup");
            // model.addAttribute("error", true);
        }
        return modelAndView;
    }
}