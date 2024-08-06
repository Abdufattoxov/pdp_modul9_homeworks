package com.nemo.modul9homework7.controller;

import com.nemo.modul9homework7.entity.Store;
import com.nemo.modul9homework7.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Admin", description = "Admin API-lari")
@RestController
@RequestMapping("/admin/store")
public class StoreAdminController {

    @Autowired
    private StoreService storeService;

    @Operation(summary = "Create New Store", description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully Created", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Store.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RuntimeException.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = RuntimeException.class)) }) })
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Store> create(@Valid @RequestBody Store entity) {
        Store createdStore = storeService.createStore(entity);
        return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
    }
}

