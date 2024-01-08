package ie.atu.product_repository_microservice;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepositoryService {
    private final ProductRepository productRepository;

    public RepositoryService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public void addProduct(ProductDetails productDetails) {
        productRepository.save(productDetails);
    }

    public void removeProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public Optional<ProductDetails> findProduct(Long productId) {
        return productRepository.findById(productId);
    }
}