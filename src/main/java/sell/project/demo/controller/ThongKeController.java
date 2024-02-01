package sell.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sell.project.demo.enity.Products;
import sell.project.demo.service.ProductsFormService;
import sell.project.demo.service.SearchProService;

@Controller
public class ThongKeController {
    @Autowired
    private SearchProService searchProService;

    @Autowired
    private ProductsFormService productsFormService;

    @GetMapping("/thongke")
    public String search_pro(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Products> products = productsFormService.search_products(keyword);
        model.addAttribute("product", products);
        model.addAttribute("keyword", keyword != null ? keyword : "");
        return "thongke";
    }
}
