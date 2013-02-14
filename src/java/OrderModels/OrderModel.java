package OrderModels;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Emma Edgar
 */
public class OrderModel {

    EntityManager em;
    private LineItem[] orderItems;
    private Receipt receipt;
    
    public OrderModel(String[] itemArray, EntityManager em){
        this.em = em;
        orderItems = new LineItem[itemArray.length];
        
        for(int i = 0; i<orderItems.length; i++){
            orderItems[i] = getItemByName(itemArray[i]);
        }
        receipt = new Receipt(orderItems);
    }
    
    public OrderModel(int[] itemArray){
        orderItems = new LineItem[itemArray.length];
        for(int i = 0; i<orderItems.length; i++){
            orderItems[i] = getItemByID(itemArray[i]);
        }
        receipt = new Receipt(orderItems);
    }
    
    public String getReceipt(){
        return receipt.getReceiptString();
    }
    
    private String getNameByID(int id) {
        TypedQuery<LineItem> query = em.createNamedQuery("nameOfItemByID", LineItem.class);
        LineItem item = query.setParameter("ID", id).getSingleResult();
        return item.getName();
    }

    
    /*
     * For the purpose of this project, assume that each item has a unique name
     */
    private double getPriceByName(String name) {
        TypedQuery<LineItem> query = em.createNamedQuery("itemByName", LineItem.class);
        LineItem item = query.setParameter("name", name).getSingleResult();        
        return item.getPrice();
    }

    private double getPriceByID(double id) {
        Query query = em.createNamedQuery("itemByID", LineItem.class);
        query.setParameter("ID", id);
        LineItem item = (LineItem)query.getSingleResult();
        return item.getPrice();
        
    }
    
    /*
     * 
     * Currently the method called------------------------------------
     */
    private LineItem getItemByName(String name){
        Query query;
        query = em.createNamedQuery("itemByName");
        query.setParameter("name", name);
        List<LineItem> items = query.getResultList();
        System.out.println(items.toString());
        LineItem item = new LineItem();
        item = items.get(0);
        return item;
    }
    
    private LineItem getItemByID(int id){
        TypedQuery<LineItem> query = em.createNamedQuery("itemByID", LineItem.class);
        
        LineItem item = query.setParameter("ID", id).getSingleResult();
        return item;
    }
  
    
}
