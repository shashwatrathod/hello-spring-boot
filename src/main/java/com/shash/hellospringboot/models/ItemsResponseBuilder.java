package com.shash.hellospringboot.models;

import java.util.List;

/**
 * Represents a builder for the {@link GetItemsResponse} class.
 */
public interface ItemsResponseBuilder extends ResponseBuilder {

  /**
   * Sets the items to be returned from the response. By default,
   * <var>items</var> is an empty list.
   *
   * @param items the items to be returned.
   *
   * @return this ResponseBuilder.
   */
  ItemsResponseBuilder setItems(List<InventoryItem> items);
}
