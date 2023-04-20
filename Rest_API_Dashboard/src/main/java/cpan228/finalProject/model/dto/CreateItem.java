package cpan228.finalProject.model.dto;

import cpan228.finalProject.model.Item;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CreateItem {
    @NotBlank
    private String name;
    @NotNull
    private Item.Brand brandName;
    @Min(2021)
    private int yearItem;
    @Min(1000)
    private double price;
    @NotNull
    private int quantity;
    @NotNull
    private Long distributionCentreId;

    public Item toItem() {
        return Item.builder()
                .name(this.getName())
                .yearItem(this.getYearItem())
                .price(this.getPrice())
                .quantity(this.getQuantity())
                .brandName(this.getBrandName())
                .distributionCentreId(this.getDistributionCentreId())
                .build();
    }
}
