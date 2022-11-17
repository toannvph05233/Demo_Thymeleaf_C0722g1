package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("showProduct");
        modelAndView.addObject("products", productService.products);
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("name", "Tuấn Mạnh");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        productService.delete(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        return modelAndView;
    }

    @GetMapping("/create")
    public String getCreate() {
        return "createProduct";
    }

    @ModelAttribute(name = "toan")
    public Product product(){
        return new Product();
    }

    @PostMapping("/create")
    public String create(Product product,@RequestParam MultipartFile upImg) {
        String name = upImg.getOriginalFilename();
        try {
            upImg.transferTo(new File("/Users/johntoan98gmail.com/Desktop/module4/Manager_Products/src/main/webapp/WEB-INF/img/"+ name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImg("/img/"+ name);
        productService.add(product);
        return "redirect:/products";
    }
}
