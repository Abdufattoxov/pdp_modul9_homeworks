package uz.pdp.modul9.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.modul9.entity.Item;
import uz.pdp.modul9.service.ItemService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems(){
        return ResponseEntity.ok(itemService.findAll());
    }

    @PostMapping("/create_items")
    public ResponseEntity<Item> create_item(@RequestBody Item item){
        return ResponseEntity.ok(itemService.createItem(item));
    }

    @PutMapping("/edit_item/{id}")
    public ResponseEntity<Item> edit_item(@RequestBody Item item, @PathVariable Long id){
        return ResponseEntity.ok(itemService.updateItem(id, item));
    }

    @DeleteMapping("/delete_item/{id}")
    public void deleteItme(@PathVariable Long id){
        itemService.deleteItem(id);
    }
}
