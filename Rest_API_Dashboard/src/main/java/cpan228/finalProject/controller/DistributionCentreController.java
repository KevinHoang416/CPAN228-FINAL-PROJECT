package cpan228.finalProject.controller;

import cpan228.finalProject.model.DistributionCentre;
import cpan228.finalProject.model.Item;
import cpan228.finalProject.model.dto.CreateDC;
import cpan228.finalProject.model.dto.CreateItem;
import cpan228.finalProject.repository.DistributionCentreRepository;
import cpan228.finalProject.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/distributioncentre")
public class DistributionCentreController {

    private final DistributionCentreRepository repository;

    public DistributionCentreController(DistributionCentreRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    public Iterable<DistributionCentre> allDistributionCentres() {
        return repository.findAll();
    }

    @PostMapping
    public DistributionCentre createItem(@Valid @RequestBody CreateDC dc) {
        return repository.save(dc.toDC());
    }

    @DeleteMapping("/{id}")
    public void deleteDistributionCentre(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

}