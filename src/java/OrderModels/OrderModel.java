package OrderModels;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
//        
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
//        orderItems = new LineItem[items.size()];
////        for (int i = 0; i < items.size(); i++){
//            LineItem li = (LineItem) items.get(i);
//            orderItems[i] = li;
//        }
        
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
//        LineItem item = (LineItem)query.getSingleResult();
        LineItem item = new LineItem();
        return item;
    }
    
    private LineItem getItemByID(int id){
        TypedQuery<LineItem> query = em.createNamedQuery("itemByID", LineItem.class);
        
        LineItem item = query.setParameter("ID", id).getSingleResult();
        return item;
    }
    
}
