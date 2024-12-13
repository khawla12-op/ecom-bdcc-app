package ma.enset.inventoryservice.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder @ToString
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
}