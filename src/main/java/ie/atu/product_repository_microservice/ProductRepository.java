package ie.atu.product_repository_microservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDetails, Long> {
}
