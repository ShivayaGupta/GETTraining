package com.coforge.util;

import java.util.List;

import com.coforge.entities.Item;

public interface ItemDaoInterface {
List<Item> getAllItems();
public void insertItem(Item item);
public void updateItem(Item item);
public void deleteItem(int id);
public Item getById(int id);
}
