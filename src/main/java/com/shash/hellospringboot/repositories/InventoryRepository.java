package com.shash.hellospringboot.repositories;

import com.shash.hellospringboot.models.InventoryItem;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Defines various methods that implement advanced queries on
 * the Inventory.
 */
public interface InventoryRepository extends MongoRepository<InventoryItem, String> {

  /**
   * Gets the list of items with the same name as {@code name}.
   *
   * @param name name of the inventory item(s) to fetch.
   *
   * @return list of inventory items with the specified name.
   */
  @Query(value = "{name: '?0'}")
  List<InventoryItem> findItemsByName(String name);

  /**
   * Finds the inventory item with the given id.
   *
   * @param id id of the item to be fetched.
   *
   * @return the item with the specified id.
   */
  @Query(value = "{id: '?0'}")
  InventoryItem findItemById(String id);
}
