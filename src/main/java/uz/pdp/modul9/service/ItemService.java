package uz.pdp.modul9.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.modul9.entity.Item;
import uz.pdp.modul9.repostiroy.ItemRepository;
import uz.pdp.modul9.repostiroy.UploadRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final UploadRepository uploadRepository;
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        /*Upload va Item entity lari orasidagi bog'liklik berilmagani uchun hamma Path lar bir hil file niki bo'ldi.*/
        item.setPath(uploadRepository.findById(1L).get().getUploadedPath());
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item item) {
        Item item1 = itemRepository.findById(id).get();
        item1.setName(item.getName());
        item1.setDescription(item.getDescription());
        item1.setPrice(item.getPrice());
        return itemRepository.save(item1);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
