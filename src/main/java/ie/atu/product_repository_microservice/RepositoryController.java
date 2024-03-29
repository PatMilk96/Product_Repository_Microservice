package ie.atu.product_repository_microservice;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;
@RestController
public class RepositoryController {
    private final RepositoryService repositoryService;


    public RepositoryController(RepositoryService productService){
        this.repositoryService = productService;
    }

    @PostMapping("/add")
    public String addProduct(@RequestBody @Valid ProductDetails productDetails){
        repositoryService.addProduct(productDetails);
        return String.format("Product: %s, has been added", productDetails.getName());
    }

    @GetMapping("/remove/{productId}")
    public String removeProduct(@PathVariable Long productId) {
        Optional<ProductDetails> optionalProductDetails = repositoryService.findProduct(productId);

        if (optionalProductDetails.isPresent()) {
            repositoryService.removeProduct(productId);
            return String.format("Product with code: %s, has been removed", productId);
        } else {
            return String.format("Product with Id: %s not found, cannot be removed", productId);
        }
    }

    @GetMapping("/find/{productId}")
    public ResponseEntity<?> findProduct(@PathVariable Long productId) {
        Optional<ProductDetails> optionalProductDetails = repositoryService.findProduct(productId);

        if (optionalProductDetails.isPresent()) {
            ProductDetails productDetails = optionalProductDetails.get();
            return ResponseEntity.ok(productDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/buy/{productId}/{amountWanted}")
    public ResponseEntity<String> buyProduct(@PathVariable Long productId, @PathVariable int amountWanted){
        Optional<ProductDetails> optionalProductDetails = repositoryService.findProduct(productId);
        if (optionalProductDetails.isPresent()) {
            ProductDetails productDetails = optionalProductDetails.get();
            int stockAmount = productDetails.getAmount();

            if (stockAmount == 0) {
                return ResponseEntity.status(HttpStatus.OK).body("We're sorry, but this product is out of stock");
            } else if (stockAmount < amountWanted) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body("Sorry, we only have " + stockAmount + " of " + productDetails.getName() + " left in stock :(");
            } else {
                int updatedStock = stockAmount - amountWanted;
                repositoryService.updateProduct(productId, updatedStock);
                String trackNum = String.valueOf(UUID.randomUUID());
                return ResponseEntity.ok(trackNum);
            }
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Product not found");
        }
    }
}
