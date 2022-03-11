package com.shash.hellospringboot.models;

import java.util.List;

/**
 * Represents the {@link Response} when inventory items are requested.
 */
public interface GetItemsResponse extends Response {

  /**
   * Returns a list of inventory items that were requested.
   */
  List<InventoryItem> getItems();

  /**
   * Sets the items that were requested.
   */
  void setItems(List<InventoryItem> items);
}
