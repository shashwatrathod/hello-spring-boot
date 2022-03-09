package com.shash.hellospringboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents an Item in our inventory.
 */
@Document("InventoryItems")
public class InventoryItem {
  @Id private String id;

  private String name;
  private String quantity;
  private String price;
  private String description;

  /**
   * Creates a new InventoryItem that stores various data related to the item.
   * @param name name of the item
   * @param quantity quantity of the item
   * @param price price of this item
   * @param description a short description of this item
   */
  public InventoryItem(String id, String name, String quantity, String price, String description) {
    super();
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.description = description;
  }

  /**
   * Copy constructor for the InventoryItem.
   * @param otherItem the InventoryItem to copy.
   */
  public InventoryItem(InventoryItem otherItem) {
    super();
    this.id = otherItem.getId();
    this.quantity = otherItem.getQuantity();
    this.name = otherItem.getName();
    this.price = otherItem.getPrice();
    this.description = otherItem.getDescription();
  }

  // ? Do we need all the setters and getters?

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
