package com.coforge.HebernatePrj;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

import com.coforge.entities.Item;
import com.coforge.entities.Order;
import com.coforge.util.ItemDao;
import com.coforge.util.OrderDao;

import jakarta.persistence.criteria.LocalDateField;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
//   
//    SessionFactory sf = new Configuration().configure().buildSessionFactory();
//    Session session =sf.openSession();
////    Transaction tx= session.beginTransaction();
////    Item tem = new Item(5,"laptop",70000.0);
////    session.persist(tem);
////    tx.commit();
////    System.out.println("item inserted");
//    List<Item> itemList=session.createQuery("From Item",Item.class).list();
//    itemList.forEach(item1->System.out.println(item1));
//    Item upItem=new Item(1,"laptop",900000);
//    Transaction tx1=session.beginTransaction();
//    session.merge(upItem);
//    tx1.commit();
//    System.out.println("after updation");
//    
//    List<Item>itemList1=session.createQuery("from item",Item.class).list();
//    itemList1.forEach(item1->System.out.println(item1));
//    System.out.println("remove item");
//    Item i=session.get(Item.class,3);
//    if(i!=null) {
//    	tx1=session.beginTransaction();
//    	session.remove(i);
//    	System.out.println("after deletion");
//    	itemList=session.createQuery("from item",Item.class).list();
//         itemList.forEach(item1->System.out.println(item1));
//         
//    }else
//    	System.out.println("");
//    session.close();
//    sf.close();
//    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        //EmployeeDao dao=context.getBean(EmployeeDao.class);
//      Employees emp = new Employees(130,"shivaya",90000.0);
//      dao.insertEmployee(emp);
//      
    	   
    	ItemDao dao=new ItemDao();
      Scanner sc = new Scanner(System.in);
//      System.out.println("enter 1 for viewEmployee,2 for add employee,3 for get employee by id, 4 for update ,5 for delete ");
//      int ch= sc.nextInt();
   // assume: Scanner sc and dao are already created above
      int ch;  // declare outside so it's visible in while condition

      do {
          System.out.println("enter 1 for view Item, 2 for add Item, 3 for get Item by id, 4 for updateItem, 5 for delete, 0 to exit");
          ch = sc.nextInt();

          switch (ch) {
              case 1:
                  dao.getAllItems().forEach(e -> System.out.println(e));
                  break;

              case 2:
                  System.out.println("enter Item details");
                  int id = sc.nextInt();
                  String name = sc.next();
                  double cost = sc.nextDouble(); // was Double; using primitive is fine
                  Item it = new Item(id, name, cost);
                  dao.insertItem(it);
                  break;

              case 3:
                  System.out.println("enter item id");
                  int id1 = sc.nextInt();
                  System.out.println("retrieving");
                  System.out.println(dao.getById(id1));
                  break;

              case 4:
                  System.out.println("enter item id");
                  int id2 = sc.nextInt();
                  System.out.println("enter updated item name");
                  String s = sc.next();

                  System.out.println("Enter updated item cost");
                  double ss = sc.nextDouble();
                  Item it2 = new Item(id2,s,ss); // assumes a ctor that sets only salary
                  dao.updateItem(it2);
                  break;

              case 5:
                  System.out.println("enter item id");
                 int id3 = sc.nextInt();
                  dao.deleteItem(id3); // ensure method name matches your DAO
                  break;

              case 0:
                  // exit
                  break;

              default:
                  System.out.println("invalid choice");
          }
      } while (ch != 0);
      
      

int ch1;
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
OrderDao ordDao=new OrderDao();

do {
    System.out.println("\n1. View all orders");
    System.out.println("2. Add order");
    System.out.println("3. Get order by id");
    System.out.println("4. Update order");
    System.out.println("5. Delete order");
    System.out.println("0. Exit");
    System.out.print("Enter choice: ");
    ch1 = sc.nextInt();


    switch (ch1) {
        case 1:
            ordDao.getAllOrders().forEach(System.out::println);
            break;

        case 2:
            System.out.println("Enter order data (id, customerName, orderDate yyyy-MM-dd):");
            int addId = sc.nextInt();
            String addName = sc.next();
            String addDateStr = sc.next();
            LocalDate addDate = LocalDate.parse(addDateStr, fmt);
            Order addOrder = new Order(addId, addName, addDate);

            ordDao.insertOrder(addOrder);
            System.out.println("Inserted.");
            break;

        case 3:
            System.out.println("Enter order id:");
            int gid = sc.nextInt();
            System.out.println(ordDao.getById(gid));
            break;

        case 4:
            System.out.println("Enter updated data (id, customerName, orderDate yyyy-MM-dd):");
            int upId = sc.nextInt();
            String upName = sc.next();
            String upDateStr = sc.next();
            LocalDate upDate = LocalDate.parse(upDateStr, fmt);
            Order upOrder = new Order(upId, upName, upDate);
            ordDao.updateOrder(upOrder);
            System.out.println("Updated.");
            break;


        case 5:
            System.out.println("Enter order id to delete:");
            int delId = sc.nextInt();
            ordDao.deleteOrder(delId);
            System.out.println("Deleted.");
            break;

        case 0:
            break;

        default:
            System.out.println("Invalid choice.");
    }
} while (ch1 != 0);

   	          
    	//ItemDao dao=new ItemDao();
//    	dao.getAllItems().forEach(item->System.out.println(item));
//    	//dao.insertItem(new Item(9,"Graphics Card",7000));
//    	dao.getAllItems().forEach(item->System.out.println(item));
//    	System.out.println(dao.getById(2));
//    	
//    	OrderDao ordDao=new OrderDao();
//    	ordDao.getAllOrders().forEach(ord->System.out.println(ord));
//
//LocalDate date = LocalDate.parse("2020-11-07");
//Order ord11 = new Order(2, "shivaya", date);
//
//    	
//       //ordDao.insertOrder(ord11);
//        Order ord1=new Order(1,"pragya",date);
//        ordDao.updateOrder(ord1);
//        ordDao.deleteOrder(1);
//        System.out.println(ordDao.getById(2));
    }
}
