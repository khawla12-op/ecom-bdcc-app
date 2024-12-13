package ma.enset.inventoryservice;

import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ma.enset.inventoryservice.entities.Product;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().id("01").name("Computer").price(2300).quantity(12).build());
            productRepository.save(Product.builder().id("02").name("Smartphone").price(800).quantity(25).build());
            productRepository.save(Product.builder().id("03").name("Tablet").price(1200).quantity(8).build());
            productRepository.save(Product.builder().id("04").name("Monitor").price(450).quantity(15).build());
            productRepository.save(Product.builder().id("05").name("Keyboard").price(50).quantity(30).build());
        };
    }


}
