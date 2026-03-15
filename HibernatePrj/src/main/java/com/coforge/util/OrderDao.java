package com.coforge.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.coforge.entities.Item;
import com.coforge.entities.Order;

public class OrderDao implements OrderInterface {
   public List<Order> getAllOrders(){
	   try(Session session =HibernateUtil.buildSessionFactory().openSession()){
		   return session.createQuery("From Order",Order.class).list();
	   }
   }
   @Override
	public void insertOrder(Order order) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		try(Session session =HibernateUtil.getSessionFactory().openSession()){
			tx=session.beginTransaction();
			session.persist(order);
			tx.commit();
			System.out.println("order inserted");
			
		}
	}
   @Override
	public void updateOrder(Order order) {
		
		Transaction tx=null;
		try(Session session=HibernateUtil.getSessionFactory().openSession()){
			
		tx=session.beginTransaction();
		session.merge(order);
		tx.commit();
		System.out.println("order updated");
	}
	catch(Exception e) {
		e.printStackTrace();
		}}


@SuppressWarnings("deprecation")
@Override
public void deleteOrder(int ordId) {
    Transaction tx = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        tx = session.beginTransaction();
        Order o = session.get(Order.class, ordId);
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
    }
}


	@Override
	public Order getById(int id) {
		// TODO Auto-generated method stub
	  try(Session sessison =HibernateUtil.getSessionFactory().openSession()){
		  return sessison.get(Order.class,id);
	  }catch(Exception e) {
		  
		  e.printStackTrace();
		  return null;
	  }

	}


   
}
