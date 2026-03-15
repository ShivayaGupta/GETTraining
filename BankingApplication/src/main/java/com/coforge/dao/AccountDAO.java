package com.coforge.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coforge.Model.Account;


import jakarta.servlet.ServletContextEvent;

import com.coforge.Listener.DbConnectionListener;
//import java.sql.Connection;

public class AccountDAO {
public List<Account> getAllAccounts(Connection con) throws SQLException{
	
	String query="select * from account";
	Statement st =con.createStatement();
	ResultSet rs= st.executeQuery(query);
	List<Account> accList = new ArrayList<Account>();
	while(rs.next()) {
		Account acc= new Account();
		acc.setAccNo(rs.getInt("accno"));
		acc.setAccHolderName(rs.getString("accHoldername"));
		acc.setAccType(rs.getString("accType"));
		acc.setBalance(rs.getDouble("balance"));
		accList.add(acc);
	}
	return accList;
}
public void AddAccount(Connection con,Account acc)throws ClassNotFoundException, SQLException {
	String query="insert into account(accno,accHolderName,acctype,balance) values(?,?,?,?) ";
	
	try(PreparedStatement ps=con.prepareStatement(query)){
		      // ps.setLong(1, employee.getEid());
		       ps.setInt(1, acc.getAccNo());
		       ps.setString(2, acc.getAccHolderName());
		       ps.setString(3, acc.getAccType());
		       ps.setDouble(4, acc.getBalance());
		      
		    	ps.executeUpdate();
				System.out.println("row inserted");
	}
catch(SQLException e) {
	e.printStackTrace();
}

}
public void deposit(Connection con, int acc, int amt) throws ClassNotFoundException, SQLException {
    // get current balance
    String query1 = "SELECT balance FROM account WHERE accno = ?";
    int b = 0;
    boolean found = false;

    try (PreparedStatement ps = con.prepareStatement(query1)) {
        ps.setInt(1, acc); // FIX: use account number
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                b = rs.getInt("balance");
                found = true;
            }
        }
    }
    if (!found) {
        throw new SQLException("Account not found for accno=" + acc);
    }

    // update balance
    String query = "UPDATE account SET balance = ? WHERE accno = ?"; // FIX: consistent column name
    try (PreparedStatement ps1 = con.prepareStatement(query)) {
        ps1.setInt(1, b + amt); // FIX: new balance
        ps1.setInt(2, acc);     // FIX: account number
        ps1.executeUpdate();    // FIX: execute the update
    }
}
public List<Account> searchAccounts(Connection con, String q) throws SQLException {
    String sql = "SELECT accno, accholdername, acctype, balance " +
                 "FROM account " +
                 "WHERE accno = ? OR accholdername LIKE ?";
    int accNo = Integer.MIN_VALUE; // a value that won't match any real accno if term isn't numeric
    try {
        accNo = Integer.parseInt(q.trim());
    } catch (NumberFormatException ignore) {
        // not numeric; keep accNo at a non-matching sentinel
    }

    List<Account> results = new ArrayList<>();
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, accNo);
        ps.setString(2, "%" + q + "%");
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Account acc = new Account();
                acc.setAccNo(rs.getInt("accno"));
                acc.setAccHolderName(rs.getString("accholdername"));
                acc.setAccType(rs.getString("acctype"));
                acc.setBalance(rs.getDouble("balance"));
                results.add(acc);
            }
        }
    }
    return results;
}
public void withdraw(Connection con, int acc, int amt) throws ClassNotFoundException, SQLException {
    // get current balance
    String query1 = "SELECT balance FROM account WHERE accno = ?";
    int b = 0;
    boolean found = false;

    try (PreparedStatement ps = con.prepareStatement(query1)) {
        ps.setInt(1, acc); // FIX: use account number
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                b = rs.getInt("balance");
                found = true;
            }
        }
    }

    if (!found) {
        throw new SQLException("Account not found for accno=" + acc);
    }

    // update balance
    String query = "UPDATE account SET balance = ? WHERE accno = ?"; // FIX: consistent column name
    try (PreparedStatement ps1 = con.prepareStatement(query)) {
        ps1.setInt(1, b - amt); // FIX: new balance
        ps1.setInt(2, acc);     // FIX: account number
        ps1.executeUpdate();    // FIX: execute the update
    }
}
public int deleteAccount(Connection con, int accNoInt) throws SQLException {
    String query = "delete from account where accno = ?";
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, accNoInt);
        return ps.executeUpdate();
    }
}
}

