package com.shash.hellospringboot.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the body of the response to be returned when items from the inventory are requested.
 */
public class GetItemsResponseImpl implements GetItemsResponse {

  private final List<InventoryItem> items;
  private final String message;
  private final boolean isOk;

  private GetItemsResponseImpl(List<InventoryItem> items,
                               String message, boolean isOk) {
    this.items = new ArrayList<>(items);
    this.message = message;
    this.isOk = isOk;
  }

  @Override
  public List<InventoryItem> items() {
    return new ArrayList<>(this.items);
  }


  @Override
  public boolean isOk() {
    return this.isOk;
  }

  @Override
  public String message() {
    return this.message;
  }

  public static ItemsResponseBuilder builder() {
    return new ItemsResponseBuilderImpl();
  }

  private static class ItemsResponseBuilderImpl implements ItemsResponseBuilder {

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
