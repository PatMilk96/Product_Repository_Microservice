package ie.atu.product_repository_microservice;

public class ProductAlreadyExistsException extends RuntimeException{

    public ProductAlreadyExistsException(String message){
        super(message);
    }
}
