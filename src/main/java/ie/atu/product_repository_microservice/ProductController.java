package ie.atu.product_repository_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping("/add")
    public String addProduct(@RequestBody ProductDetails productDetails){

        return String.format("Product: %s, has been added", productDetails.getName());
    }
}
