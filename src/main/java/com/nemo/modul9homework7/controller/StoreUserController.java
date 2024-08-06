package com.nemo.modul9homework7.controller;

import com.nemo.modul9homework7.entity.Store;
import com.nemo.modul9homework7.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User", description = "User API-lari")
@RestController
@RequestMapping("/user/store")
public class StoreUserController {

    @Autowired
    private StoreService storeService;

    @Operation(summary = "Get Store by ID", description = "Fetch a store by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Retrieved", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Store.class)) }),
            @ApiResponse(responseCode = "404", description = "Store Not Found", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RuntimeException.class)) }) })
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<Store> get(@PathVariable Long id) {
        Store store = storeService.getStoreById(id);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }
}

