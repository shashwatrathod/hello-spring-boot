package com.shash.hellospringboot.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the body of the response to be returned when items from the inventory are requested.
 */
public class GetItemsResponseImpl extends ResponseImpl implements GetItemsResponse {

  private List<InventoryItem> items;

  public GetItemsResponseImpl() {}

  public GetItemsResponseImpl(List<InventoryItem> items,
                               String message, boolean isOk) {
    super(message, isOk);
    this.items = new ArrayList<>(items);
  }

  @Override
  public List<InventoryItem> getItems() {
    return new ArrayList<>(this.items);
  }

  @Override
  public void setItems(List<InventoryItem> items) {
    this.items = items;
  }
}
