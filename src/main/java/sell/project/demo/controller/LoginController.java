package sell.project.demo.controller;

import java.util.List;
import java.util.Locale.Category;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;
import sell.project.demo.enity.Login;
// import sell.project.demo.enity.Products;
import sell.project.demo.enity.User;
import sell.project.demo.service.LoginService;
// import sell.project.demo.service.SearchProService;
import sell.project.demo.service.UserService;

@Controller
public class LoginController {
    @Autowired
    private LoginService userService;

    @Autowired
    private UserService userService2;

    // @Autowired
    // private SearchProService searchProService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") Login user) {
        Login oauthUser = userService.login(user.getUsername(), user.getPassword());

        ModelAndView modelAndView = new ModelAndView();

        if (Objects.nonNull(oauthUser)) {
            if ("admin".equals(oauthUser.getRole()) || "ADMIN".equals(oauthUser.getRole())) {
                // int userID = oauthUser.getId();
                modelAndView.setViewName("redirect:/thongke");
            } else {
                int userID = oauthUser.getId();
                modelAndView.setViewName("redirect:/home2/" + userID);
            }
        } else {
            modelAndView.addObject("error", true);
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }

    @GetMapping("/home2/{id}")
    public String showhome2(@PathVariable int id, Model model) {
        Login login = userService.getById(id);
        // User user = userService2.getUserById(id);
        model.addAttribute("login", login);
        // model.addAttribute("user", user);
        return "home2";

    }

    // @GetMapping("/home2")

    // public String showhome2(Model model){
    // User user = userService2.;

    // model.addAttribute("user", user);

    // return "home2";
    // }

    // @GetMapping("/home2/{id}")
    // public String showhome2(@PathVariable int id, Model model) {
    // Login login = userService.getById(id);

    // model.addAttribute("login", login);

    // return "home2";

    // }
}
