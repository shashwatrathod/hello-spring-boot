package com.shash.hellospringboot.services;

import com.shash.hellospringboot.models.GetItemsResponse;
import com.shash.hellospringboot.models.GetItemsResponseImpl;
import com.shash.hellospringboot.models.InventoryItem;
import com.shash.hellospringboot.models.Response;
import com.shash.hellospringboot.models.ResponseImpl;
import com.shash.hellospringboot.repositories.InventoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Contains various methods that perform CRUD operations on
 * Inventory.
 */
@Service
public class CrudInventoryServiceImpl implements CrudInventoryService {

  @Autowired
  private InventoryRepository inventoryRepository;

  @Override
  public Response addItem(InventoryItem newItem) {

    //TODO: Run validations
    if (newItem == null) {
      new ResponseImpl("The item is null", false);
    }
    inventoryRepository.save(newItem);

    return new ResponseImpl("", true);
  }

  @Override
  public GetItemsResponse getAllItems() {
    return new GetItemsResponseImpl(inventoryRepository.findAll(), "", true);
  }

  @Override
  public GetItemsResponse getItemsByName(String name) {
    if (name == null || name.isEmpty()) {
      return new GetItemsResponseImpl(null, "Invalid name", false);
    }
    return new GetItemsResponseImpl(inventoryRepository.findItemsByName(name),
            "", true);
  }

  @Override
  public GetItemsResponse getItemById(String id) {
    if (id == null || id.isEmpty()) {
      return new GetItemsResponseImpl(null, "Invalid name", false);
    }

    List<InventoryItem> items = new ArrayList<>();

    InventoryItem item = inventoryRepository.findItemById(id);

    if (item != null) {
      items.add(item);
    }

    return new GetItemsResponseImpl(items,
            "", true);
  }

  @Override
  public Response updateItem(String id, InventoryItem updatedItem) {

    if (updatedItem == null) {
      return new ResponseImpl("The new item can't be null.", false);
    }

    InventoryItem item = inventoryRepository.findItemById(id);

    if (item == null) {
      return new ResponseImpl("Couldn't find an item with the given ID.", false);
    }

    updatedItem.setId(item.getId());


    inventoryRepository.save(updatedItem);

    return new ResponseImpl("", true);
  }

  @Override
  public Response deleteItem(String id) {
    return null;
  }
}
