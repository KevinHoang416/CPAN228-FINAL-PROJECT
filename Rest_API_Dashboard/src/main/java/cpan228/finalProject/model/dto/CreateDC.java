package cpan228.finalProject.model.dto;

import cpan228.finalProject.model.DistributionCentre;
import cpan228.finalProject.model.Item;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDC {
    @NotBlank
    private String name;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    public DistributionCentre toDC() {
        return DistributionCentre.builder()
                .name(this.getName())
                .latitude(this.getLatitude())
                .longitude(this.getLongitude())
                .build();
    }
}
