package com.shash.hellospringboot.controllers;

import com.shash.hellospringboot.models.InventoryItem;
import com.shash.hellospringboot.services.CrudInventoryService;
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

  //TODO: map to new item models
  @GetMapping("/inventory")
  public List<InventoryItem> getItemsByName
          (@RequestParam(value = "name", defaultValue = "") String name) {

    if (name != null && !name.isEmpty()) {
      return inventoryService.getItemsByName(name);
    }

    return inventoryService.getAllItems();
  }

  @PostMapping("/inventory")
  public void addItem(@RequestBody InventoryItem item) {
    boolean result = inventoryService.addItem(item);

    if (!result) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid item");
    }
  }
}
