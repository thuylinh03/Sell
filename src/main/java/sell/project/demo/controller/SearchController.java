package sell.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import sell.project.demo.enity.Login;
import sell.project.demo.enity.Products;
import sell.project.demo.service.LoginService;
import sell.project.demo.service.SearchProService;

@Controller
public class SearchController {

    @Autowired
    private SearchProService searchProService;

    @Autowired
    private LoginService loginService;

    @GetMapping("/search")
    public String search(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Products> products = searchProService.search(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword != null ? keyword : "");
        return "search";
    }

    @GetMapping("/search2/{id}")
    public String search2(
            @PathVariable int id,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model) {
        List<Products> products = searchProService.search(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword != null ? keyword : "");
        Login login = loginService.getById(id);
        model.addAttribute("login", login);
        return "search2";
    }

}
