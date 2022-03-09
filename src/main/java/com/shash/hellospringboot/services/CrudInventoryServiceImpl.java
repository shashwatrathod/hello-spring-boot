package com.shash.hellospringboot.services;

import com.shash.hellospringboot.models.InventoryItem;
import com.shash.hellospringboot.repositories.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CrudInventoryServiceImpl implements CrudInventoryService {

  @Autowired
  private InventoryRepository inventoryRepository;

  @Override
  public boolean addItem(InventoryItem newItem) {
    //TODO: Run validations
    if (newItem == null) {
      return false;
    }
    inventoryRepository.save(newItem);
    return true;
  }

  @Override
  public List<InventoryItem> getAllItems() {
    return inventoryRepository.findAll();
  }

  @Override
  public List<InventoryItem> getItemsByName(String name) {
    if (name == null || name.isEmpty()) {
      return new ArrayList<InventoryItem>();
    }
    return inventoryRepository.findItemsByName(name);
  }

  @Override
  public InventoryItem getItemById(String id) {
    if (id == null || id.isEmpty()) {
      return null;
    }
    return inventoryRepository.findItemById(id);
  }
}