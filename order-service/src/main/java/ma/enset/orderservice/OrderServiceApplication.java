package ma.enset.orderservice;

import ma.enset.orderservice.model.Product;
import ma.enset.orderservice.repositories.OrderRepository;
import ma.enset.orderservice.repositories.ProductItemRepository;
import ma.enset.orderservice.restClients.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(
        OrderRepository orderRepository,
        ProductItemRepository productItemRepository,
        InventoryRestClient inventoryRestClient){
      return args ->{
          List<Product> allProducts= inventoryRestClient.getAllProducts();
          allProducts.forEach(product->{
            System.out.println(product.getName());
        });

      };
    }
}


