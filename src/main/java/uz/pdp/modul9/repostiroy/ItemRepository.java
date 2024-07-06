package uz.pdp.modul9.repostiroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.modul9.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
