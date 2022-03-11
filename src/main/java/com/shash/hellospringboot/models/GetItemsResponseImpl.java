package com.shash.hellospringboot.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the body of the response to be returned when items from the inventory are requested.
 */
public class GetItemsResponseImpl extends ResponseImpl implements GetItemsResponse {

  private final List<InventoryItem> items;

  protected GetItemsResponseImpl(List<InventoryItem> items,
                               String message, boolean isOk) {
    super(message, isOk);
    this.items = new ArrayList<>(items);
  }

  @Override
  public List<InventoryItem> items() {
    return new ArrayList<>(this.items);
  }

  public static ItemsResponseBuilder builder() {
    return new ItemsResponseBuilderImpl();
  }

  protected static class ItemsResponseBuilderImpl extends ResponseBuilderImpl
          implements ItemsResponseBuilder {

    private List<InventoryItem> items;
    private String message;
    private boolean isOk;

    private ItemsResponseBuilderImpl() {
      this.items = new ArrayList<>();
      this.message = "";
      this.isOk = true;
    }

    @Override
    public ItemsResponseBuilder setItems(List<InventoryItem> items) {
      this.items = new ArrayList<>(items);
      return this;
    }

    @Override
    public ItemsResponseBuilder setIsOk(boolean isOk) {
      this.isOk = isOk;
      return this;
    }

    @Override
    public ItemsResponseBuilder setMessage(String message) {
      this.message = message;
      return this;
    }

    @Override
    public GetItemsResponse build() {
      return new GetItemsResponseImpl(items, message, isOk);
    }
  }

}
