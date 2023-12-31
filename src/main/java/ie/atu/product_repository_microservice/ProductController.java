package ie.atu.product_repository_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
