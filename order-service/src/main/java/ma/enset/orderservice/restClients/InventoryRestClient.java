package ma.enset.orderservice.restClients;

import ma.enset.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient(url="http://localhost:8087",name="inventory-service")
public interface InventoryRestClient {
    @GetMapping("/api/products")
    //Retourner la liste des produits
    List<Product> getAllProducts();
}
