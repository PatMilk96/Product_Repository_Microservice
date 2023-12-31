package ie.atu.product_repository_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyData implements CommandLineRunner {
     private final ProductRepository productRepository;

     @Autowired
    public DummyData(ProductRepository productRepository){
         this.productRepository = productRepository;
     }

     @Override
    public void run(String... args) throws Exception{
         ProductDetails dummy1 = new ProductDetails(1L,  "T-Shirt", 15, 1976756L);
         ProductDetails dummy2 = new ProductDetails(1L,  "Jeans", 45, 578329L);
         ProductDetails dummy3 = new ProductDetails(1L,  "Jacket", 60, 209485L);
         ProductDetails dummy4 = new ProductDetails(1L,  "Shoes", 70, 502947932L);
         ProductDetails dummy5 = new ProductDetails(1L,  "Glasses", 10, 129372L);
         ProductDetails dummy6 = new ProductDetails(1L,  "Watch", 25, 885673L);
         productRepository.save(dummy1);
         productRepository.save(dummy2);
         productRepository.save(dummy3);
         productRepository.save(dummy4);
         productRepository.save(dummy5);
         productRepository.save(dummy6);
     }
}
