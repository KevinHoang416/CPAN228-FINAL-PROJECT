package cpan228.finalProject;

import cpan228.finalProject.model.DistributionCentre;
import cpan228.finalProject.model.Item;
import cpan228.finalProject.repository.DistributionCentreRepository;

import cpan228.finalProject.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import static org.aspectj.runtime.internal.Conversions.longValue;

@EnableMethodSecurity
@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataLoader(DistributionCentreRepository repository, ItemRepository itemRepository) {
		return args -> {
			repository.save(new DistributionCentre("DC Mississauga", "43.65298560734", "-79.68647167344304"));
			repository.save(new DistributionCentre("DC Montreal", "-45.62862596449761", "-73.55126120220694"));
			repository.save(new DistributionCentre("DC Edmonton", "53.56486310364297", "-113.61412251164667"));
			repository.save(new DistributionCentre("DC Calgary", "51.00500218514603", "-114.00775381164665"));

			itemRepository.save(new Item("Skirt", 2022, 3500, Item.Brand.DIOR, 10, longValue(1)));
			itemRepository.save(new Item("T-shirt", 2023, 2000, Item.Brand.GUCCI, 10, longValue(2)));
			itemRepository.save(new Item("T-shirt", 2023, 2000, Item.Brand.GUCCI, 15, longValue(1)));

			itemRepository.save(new Item("Dress",2023, 2580, Item.Brand.GUCCI, 3, longValue(4)));
			itemRepository.save(new Item("Jacket",2022, 3580, Item.Brand.DIOR, 1, longValue(2)));
			itemRepository.save(new Item("Shoes",2022, 2887, Item.Brand.PRADA, 12, longValue(3)));
		};
	}
}
