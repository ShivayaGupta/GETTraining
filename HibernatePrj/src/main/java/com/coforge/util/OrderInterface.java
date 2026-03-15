package com.coforge.util;

import java.util.List;

import com.coforge.entities.Item;
import com.coforge.entities.Order;

public interface OrderInterface {
 List<Order> getAllOrders();

 void insertOrder(Order order);
 void deleteOrder(int id);
 void updateOrder(Order order);
 Order getById(int id);
}
