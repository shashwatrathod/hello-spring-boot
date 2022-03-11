package com.shash.hellospringboot.controllers;

import com.shash.hellospringboot.models.GetItemsResponse;
import com.shash.hellospringboot.models.InventoryItem;
import com.shash.hellospringboot.models.Response;
import com.shash.hellospringboot.services.CrudInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  public GetItemsResponse getItems() {

    GetItemsResponse result = inventoryService.getAllItems();

    if (!result.getIsOk()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getMessage());
    }

    return result;
  }

  @GetMapping("/inventory/id/{id}")
  public GetItemsResponse getItemById(@PathVariable("id") String id) {
    GetItemsResponse result = inventoryService.getItemById(id);

    if (!result.getIsOk()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getMessage());
    }

    return result;
  }

  @GetMapping("/inventory/name/{id}")
  public GetItemsResponse getItemsByName(@PathVariable("name") String name) {
    GetItemsResponse result = inventoryService.getItemsByName(name);

    if (!result.getIsOk()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getMessage());
    }

    return result;
  }

  /**
   * Add a new Item to the inventory.
   *
   * @param item the item to be added.
   */
  @PostMapping("/inventory")
  public ResponseEntity<Response> addItem(@RequestBody InventoryItem item) {
    Response result = inventoryService.addItem(item);

    if (!result.getIsOk()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getMessage());
    }

    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PutMapping("/inventory/{id}")
  public Response updateItem(@PathVariable("id") String id, @RequestBody InventoryItem item) {
    Response result = inventoryService.updateItem(id, item);

    if (!result.getIsOk()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getMessage());
    }

    return result;
  }

  @DeleteMapping("/inventory/{id}")
  public Response deleteItem(@PathVariable("id") String id) {
    Response result = inventoryService.deleteItem(id);

    if (!result.getIsOk()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, result.getMessage());
    }

    return result;
  }
}
