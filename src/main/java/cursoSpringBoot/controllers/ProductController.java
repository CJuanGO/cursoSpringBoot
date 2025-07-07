package cursoSpringBoot.controllers;

import cursoSpringBoot.configurations.ExternalizedConfigurations;
import cursoSpringBoot.domain.Product;
import cursoSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {


    @Autowired
    @Lazy
    private ProductService productService;

    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;

    @GetMapping
    private ResponseEntity<?> getProducts(){
        List<Product> products = productService.getProducts();

        return ResponseEntity.ok(products);
    }

}
