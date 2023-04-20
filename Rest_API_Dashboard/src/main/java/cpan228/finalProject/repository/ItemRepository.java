package cpan228.finalProject.repository;

import cpan228.finalProject.model.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Iterable<Item> findAllByName (String name);
    Iterable<Item> findItemByBrandNameAndName (Item.Brand brandName, String name);
    @Transactional
    void deleteItemByDistributionCentreIdAndId (Long idDc, Long id);
}