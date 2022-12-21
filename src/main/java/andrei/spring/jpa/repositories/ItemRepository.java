package andrei.spring.jpa.repositories;

import andrei.spring.jpa.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
