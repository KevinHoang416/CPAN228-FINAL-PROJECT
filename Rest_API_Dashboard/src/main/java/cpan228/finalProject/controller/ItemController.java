package cpan228.finalProject.controller;

import cpan228.finalProject.model.DistributionCentre;
import cpan228.finalProject.model.Item;
import cpan228.finalProject.model.dto.CreateItem;
import cpan228.finalProject.repository.DistributionCentreRepository;
import cpan228.finalProject.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemRepository itemRepository;
    private final DistributionCentreRepository repository;
    public ItemController(ItemRepository itemRepository, DistributionCentreRepository repository) {
        this.itemRepository = itemRepository;
        this.repository = repository;
    }
    @GetMapping
    public Iterable<Item> allItems() {
        return itemRepository.findAll();
    }

    @PostMapping
    public Item createItem(@Valid @RequestBody CreateItem item) {
       return itemRepository.save(item.toItem());
    }

    @DeleteMapping("/{id}/{idDc}")
    public void deleteItem(@PathVariable("id") Long id, @PathVariable("idDc") Long idDc) {
        itemRepository.deleteItemByDistributionCentreIdAndId(idDc, id);
    }

    @GetMapping("/{name}")
    public Iterable<Optional<DistributionCentre>> listDCByItem(@PathVariable("name") String name){
        Iterable<Item> items = itemRepository.findAllByName(name);

        List<Optional<DistributionCentre>> listDCs = new ArrayList<>();
        for(Item item: items){
            Long idDc = item.getDistributionCentreId();
            listDCs.add(repository.findById(idDc));
        }
        List<Optional<DistributionCentre>> DCs = listDCs;
        return DCs;
    }
    @GetMapping("/DC/{name}/{brand}")
    public Iterable<Optional<DistributionCentre>> listDCByNameAndBrand(@PathVariable("name") String name,
                                                             @PathVariable("brand") Item.Brand brand){

        Iterable<Item> items = itemRepository.findItemByBrandNameAndName(brand, name);
        List<Optional<DistributionCentre>> listDCs2 = new ArrayList<>();
        for(Item item: items){
            Long idDc = item.getDistributionCentreId();
            listDCs2.add(repository.findById(idDc));
        }
        List<Optional<DistributionCentre>> DCs = listDCs2;
        return DCs;
    }

    @GetMapping("/{name}/{brand}")
    public Iterable<Item> listItemByNameAndBrand(@PathVariable("name") String name,
                                                             @PathVariable("brand") Item.Brand brand){

        return itemRepository.findItemByBrandNameAndName(brand, name);
    }


}