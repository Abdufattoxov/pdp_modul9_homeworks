package uz.pdp.modul9.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.modul9.entity.Item;
import uz.pdp.modul9.entity.Store;
import uz.pdp.modul9.repostiroy.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    public List<Store> findAll() {
        return storeRepository.findAll();
    }


    public Store createItem(Store store) {
        return storeRepository.save(store);
    }


    public Item updateItem(Long id, Store store) {
        Store store1 = storeRepository.findById(id).get();
        store1.setName(store.getName());
        store1.setDesc(store.getDesc());
        storeRepository.save(store1);
    }


    public void deleteItem(Long id) {
        storeRepository.deleteById(id);
    }
}
