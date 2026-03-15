package com.coforge.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
 private int accNo;
 private String accHolderName;
 private String accType;
 private double balance;
}
