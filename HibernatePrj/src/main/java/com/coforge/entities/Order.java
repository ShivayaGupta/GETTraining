package com.coforge.entities;

import java.time.LocalDate;
//import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="order_table")
public class Order {
  @Id
  private int ordId;
  @Column(name="customerName")
  private String custName;
  @Column(name="orderdate")
  private LocalDate ordDate;
  //private List<Item> itemList;
}
