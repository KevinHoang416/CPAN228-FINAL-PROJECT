package cpan228.finalProject.repository;

import cpan228.finalProject.model.DistributionCentre;
import cpan228.finalProject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributionCentreRepository extends JpaRepository<DistributionCentre, Long> {
}
