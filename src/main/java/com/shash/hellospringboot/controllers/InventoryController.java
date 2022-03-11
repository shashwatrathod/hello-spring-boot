package com.shash.hellospringboot.controllers;

import com.shash.hellospringboot.models.InventoryItem;
import com.shash.hellospringboot.services.CrudInventoryService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


/**
 * Defines various operations on the /inventory endpoint.
 */
@RestController
public class InventoryController {

  @Autowired
  private CrudInventoryService inventoryService;

  @GetMapping("/inventory")
  public List<InventoryItem> getItems(@RequestParam(value = "id", defaultValue = "") String id,
           @RequestParam(value = "name", defaultValue = "") String name) {

    List<InventoryItem> items = new ArrayList<>();

    if (id != null && !id.isEmpty()) {
      InventoryItem item = inventoryService.getItemById(id);
      if (item != null) {
        items.add(item);
      }
    }

    if (name != null && !name.isEmpty()) {
      items.addAll(inventoryService.getItemsByName(name));
    }

    if (items.size() > 0) {
      return items;
    }

    return inventoryService.getAllItems();
  }

  /**
   * Add a new Item to the inventory.
   *
   * @param item the item to be added.
   */
  @PostMapping("/inventory")
  public void addItem(@RequestBody InventoryItem item) {
    boolean result = inventoryService.addItem(item);

    if (!result) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid item");
    }
  }
}
