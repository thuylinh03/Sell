package sell.project.demo.controller;

import java.security.Principal;
import java.util.List;
import sell.project.demo.enity.Products;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sell.project.demo.service.ProductsFormService;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductsController {
    @Autowired
    private ProductsFormService productsFormService;

    public ProductsController(ProductsFormService productsFormService) {
        // super();
        this.productsFormService = productsFormService;
    }

    // @GetMapping("/home")
    // public String showProducts(Model model, Principal principal) {
    // List<Products> products = productsFormService.show_Products();
    // model.addAttribute("products", products);

    // // Lấy thông tin người dùng đang đăng nhập
    // String loggedInId = principal != null ? principal.getName() : null;
    // model.addAttribute("id", loggedInId);

    // return "home";
    // }

    // @GetMapping("/home2/{id}")
    // public String showProductsById(@PathVariable("id") Long id, Model model) {
    // List<Products> products = productsFormService.show_Products();
    // model.addAttribute("products", products);

    // return "home2";
    // }
    // @GetMapping("/home2/{id}")
    // public String showProductsById(@PathVariable("id") String id, Model model) {
    // List<Products> products = productsFormService.show_Products();
    // model.addAttribute("products", products);
    // model.addAttribute("id", id);

    // return "home2";
    // }

    @GetMapping("/products")
    public String search_products(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Products> products = productsFormService.search_products(keyword);
        model.addAttribute("product", products);
        model.addAttribute("keyword", keyword != null ? keyword : "");
        return "products";
    }

    // @GetMapping("/products")
    // public String listProducts(Model model) {
    // model.addAttribute("product", productsFormService.listAll());
    // return "products";
    // }

    @GetMapping("/products/new")
    public String createProductsForm(Model model) {
        Products product = new Products();
        model.addAttribute("product", product);
        return "create_products";
    }

    @PostMapping("/products")
    public String saveProducts(@ModelAttribute("product") Products product) {
        productsFormService.saveProducts(product);
        return "redirect:/products";
    }

    // sửa
    @GetMapping("/products/edit/{id}")
    public String editProductsForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productsFormService.getProductsById(id));
        return "edit_products";
    }

    // update
    @PostMapping("/products/{id}")
    public String updateProducts(@PathVariable int id, @ModelAttribute("product") Products product, Model model) {
        // get products from database by id
        Products existingProducts = productsFormService.getProductsById(id);
        existingProducts.setId(id);
        existingProducts.setImage(product.getImage());
        existingProducts.setName(product.getName());
        existingProducts.setQuantity(product.getQuantity());
        existingProducts.setPrice(product.getPrice());

        // save updated products object
        productsFormService.updateProducts(existingProducts);
        return "redirect:/products";
    }

    // delete
    @GetMapping("/products/{id}")
    public String deleteProducts(@PathVariable int id) {
        productsFormService.delete(id);
        return "redirect:/products";
    }
}
