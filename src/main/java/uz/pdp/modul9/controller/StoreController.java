package uz.pdp.modul9.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.modul9.entity.Store;

@RestController
@RequestMapping(value = "/store/*")
public class StoreController {

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Store> create(@Valid @RequestBody Store entity) {
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Store> update(@Valid @RequestBody Store entity) {
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>("Successfully Deleted - Store", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Store> get(@PathVariable Long id) {
        return new ResponseEntity<>(new Store(id, "Hello", "Lorem Ipsum"), HttpStatus.OK);
    }

}
