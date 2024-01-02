package ie.atu.product_repository_microservice;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public String removeProduct(@PathVariable Long productId) {
        Optional<ProductDetails> optionalProductDetails = productService.findProduct(productId);

        if (optionalProductDetails.isPresent()) {
            productService.removeProduct(productId);
            return String.format("Product with code: %s, has been removed", productId);
        } else {
            return String.format("Product with code: %s not found, cannot be removed", productId);
        }
    }

    @GetMapping("/find/{productId}")
    public String findProduct(@PathVariable Long productId) {
        Optional<ProductDetails> optionalProductDetails = productService.findProduct(productId);

        if (optionalProductDetails.isPresent()) {
            ProductDetails productDetails = optionalProductDetails.get();
            String productName = productDetails.getName();
            return String.format("Product: %s, with code: %s, has been found", productName, productId);
        } else {
            return String.format("Product with code: %s not found", productId);
        }
    }
}
