package ie.atu.product_repository_microservice;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepositoryService {
    private final ProductRepository productRepository;

    public RepositoryService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public void addProduct(ProductDetails productDetails) {
        Long productCode = productDetails.getProductCode();
        if(productRepository.existsByProductCode(productCode)){
            throw new ProductAlreadyExistsException("A product with the same product code already exists");
        }
        productRepository.save(productDetails);
    }

    public void removeProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public Optional<ProductDetails> findProduct(Long productId) {
        return productRepository.findById(productId);
    }

    @Transactional
    public void updateProduct(Long productId, int updatedStock) {
        productRepository.updateStock(productId, updatedStock);
    }
}
