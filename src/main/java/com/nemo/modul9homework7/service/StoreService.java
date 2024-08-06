package com.nemo.modul9homework7.service;

import com.nemo.modul9homework7.entity.Store;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    public Store createStore(Store store) {
        return store;
    }

    public Store getStoreById(Long id) {
        Store store = new Store();
        store.setId(id);
        store.setName("Sample Store");
        store.setEmail("store@example.com");
        store.setEmployeeCount(10);
        store.setDesc("Sample Description");
        return store;
    }
}

