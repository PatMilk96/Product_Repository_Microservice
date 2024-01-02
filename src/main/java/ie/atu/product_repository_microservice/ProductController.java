package ie.atu.product_repository_microservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDetails productDetails){
        productService.addProduct(productDetails);
        return String.format("Product: %s, has been added", productDetails.getName());
    }

    @GetMapping("/remove/{productId}")
    public String removeProduct(@PathVariable Long productId){
        productService.removeProduct(productId);
        return String.format("Product with code: %s, has been removed", productId);
    }
}
