package uz.pdp.modul9.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.modul9.entity.Item;


@RestController @RequestMapping(value = "/item/")
public class ItemController {

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Item> create(@Valid @RequestBody Item item) {
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Item> update(@Valid @RequestBody Item item) {
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>("Successfully Deleted - Item", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Item> get(@PathVariable Long id) {
        return new ResponseEntity<>(new Item(id,"Swagger", "Lorem Ipsum", 216.86D), HttpStatus.OK);
    }
}

