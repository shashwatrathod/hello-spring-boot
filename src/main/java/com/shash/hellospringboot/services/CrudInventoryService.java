package com.shash.hellospringboot.services;

import com.shash.hellospringboot.models.GetItemsResponse;
import com.shash.hellospringboot.models.InventoryItem;
import com.shash.hellospringboot.models.Response;


/**
 * Contains the business logic for implementing CRUD operations on
 * the Inventory.
 */
public interface CrudInventoryService {

  /**
   * Adds a new item to the inventory.
   *
   * @param newItem the item to be added.
   *
   * @return whether the item was successfully added.
   */
  Response addItem(InventoryItem newItem);

  /**
   * Get all the items in the inventory.
   *
   * @return list of items in the inventory.
   */
  GetItemsResponse getAllItems();

  /**
   * Gets all the items in the inventory with the specified name.
   *
   * @param name name of the items to find.
   *
   * @return list of items that match the given condition.
   */
  GetItemsResponse getItemsByName(String name);

  /**
   * Gets the item that matches the given id.
   *
   * @param id id of the item to be found.
   *
   * @return item with the given id.
   */
  GetItemsResponse getItemById(String id);

  /**
   * Updates the item with the given id with the given item.
   *
   * @param id
   *
   * @param updatedItem
   *
   * @return
   */
  Response updateItem(String id, InventoryItem updatedItem);

  Response deleteItem(String id);
}
