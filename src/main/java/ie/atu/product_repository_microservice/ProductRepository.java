package ie.atu.product_repository_microservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<ProductDetails, Long> {
    boolean existsByProductCode(Long productCode);
    @Modifying
    @Query("UPDATE ProductDetails p SET p.amount = :updatedStock WHERE p.id = :productId")
    void updateStock(@Param("productId") Long productId, @Param("updatedStock") int updateStock);
}
