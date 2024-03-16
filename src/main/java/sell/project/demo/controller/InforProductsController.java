package sell.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import sell.project.demo.enity.Products;
import sell.project.demo.service.ProductsInforService;

@Controller
public class InforProductsController {
    @Autowired
    private ProductsInforService productsInfo;

    public void ProductsController(ProductsInforService productsInfo) {
        this.productsInfo = productsInfo;
    }

    @GetMapping("/thongtinSp/{id}")
    public String getProductsById(@PathVariable int id, Model model) {

        Products product = productsInfo.getProductsById(id);

        model.addAttribute("product", product);
        return "thongtinSp";
    }

    @GetMapping("/home/{id}")
    public String infoProductsById(@PathVariable int id, Model model) {

        Products product = productsInfo.getProductsById(id);

        model.addAttribute("product", product);
        return "home";
    }
}
