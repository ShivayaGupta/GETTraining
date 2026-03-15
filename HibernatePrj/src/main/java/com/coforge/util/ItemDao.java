package com.coforge.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.coforge.entities.Item;
import com.coforge.entities.Order;

//import jakarta.transaction.Transaction;

public class ItemDao implements ItemDaoInterface{

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		try(Session session =HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("from Item",Item.class).list();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	
		
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try(Session session =HibernateUtil.getSessionFactory().openSession()){
			tx=session.beginTransaction();
			session.persist(item);
			tx.commit();
			System.out.println("item inserted");
			
		}
	}

	@Override
	public void updateItem(Item item) {
		
		Transaction tx=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			
		tx=session.beginTransaction();
		session.merge(item);
		tx.commit();
		System.out.println("Item updated");
	}
	catch(Exception e) {
		e.printStackTrace();
		}}
 
	@Override
	public void deleteItem(int id) {
		
		Transaction tx = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        tx = session.beginTransaction();
	        Item o = session.get(Item.class, id);
	        if (o != null) {
	            session.delete(o);
	            tx.commit();
	            System.out.println("After deletion:");
	        } else {
	            tx.commit();
	            System.out.println("no order with this id");
	        }

	} catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    }	}
	
 
 

	@Override
	public Item getById(int id) {
		// TODO Auto-generated method stub
	  try(Session sessison =HibernateUtil.getSessionFactory().openSession()){
		  return sessison.get(Item.class,id);
	  }catch(Exception e) {
		  
		  e.printStackTrace();
		  return null;
	  }

	}
 
}
