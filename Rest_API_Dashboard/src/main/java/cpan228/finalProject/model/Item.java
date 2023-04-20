package cpan228.finalProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Brand brandName;
    @Min(2021)
    private int yearItem;
    @Min(1000)
    private double price;
    @NotNull
    private int quantity;
    @NotNull
    private Long distributionCentreId;

    public enum Brand {

        BALENCIAGA("Balenciaga"), CHANEL("Chanel"), DIOR("Dior"), GUCCI("Gucci"), PRADA("Prada");

        private String name;

        private Brand(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Item(String name, int yearItem, double price, Brand brandName, int quantity, Long distributionCentreId) {
        this.name = name;
        this.yearItem = yearItem;
        this.price = price;
        this.brandName = brandName;
        this.quantity = quantity;
        this.distributionCentreId = distributionCentreId;
    }
}