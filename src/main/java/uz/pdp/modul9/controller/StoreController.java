package uz.pdp.modul9.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.modul9.entity.Item;
import uz.pdp.modul9.entity.Store;
import uz.pdp.modul9.service.ItemService;
import uz.pdp.modul9.service.StoreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    @GetMapping("/stores")
    public ResponseEntity<List<Store>> getItems(){
        return ResponseEntity.ok(storeService.findAll());
    }

    @PostMapping("/create_store")
    public ResponseEntity<Store> create_item(@RequestBody Store store){
        return ResponseEntity.ok(storeService.createItem(store));
    }

    @PutMapping("/edit_store/{id}")
    public ResponseEntity<Item> edit_item(@RequestBody Store store  , @PathVariable Long id){
        return ResponseEntity.ok(storeService.updateItem(id, store));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItme(@PathVariable Long id){
        storeService.deleteItem(id);
    }
}
