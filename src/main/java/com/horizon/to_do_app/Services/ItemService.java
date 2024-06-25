package com.horizon.to_do_app.Services;

import com.horizon.to_do_app.Models.Item;
import com.horizon.to_do_app.Repositories.Repo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;


@Service
public class ItemService {

    @Autowired
    private Repo repo;

    public void saveItem(Item item) {

        if (item.getId() == null) {
            item.setCreatedAt(Instant.now());
        }
        item.setUpdatedAt(Instant.now());
        repo.save(item);
    }

    public void deleteItem(Long id) {
        repo.deleteById(id);
    }

    public Item getItem(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Iterable<Item> getItems() {
        return repo.findAll();
    }
}