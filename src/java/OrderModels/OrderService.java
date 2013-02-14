package OrderModels;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author Emma Edgar
 * This class talks to a database and receipt object to compute and return
 * receipt strings.
 */
public class OrderService {

    private EntityManager em;
    private LineItem[] orderItems;
    private Receipt receipt;

    public OrderService(String[] itemArray, EntityManager em){
        this.em = em;
        initializeReciept(itemArray);
    }
    
    public OrderService(int[] itemArray){
        initializeReciept(itemArray);
    }
    
    public String getReceipt(){
        return receipt.getReceiptString();
    }
      public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public LineItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(LineItem[] orderItems) {
        this.orderItems = orderItems;
    }


    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
    /*
     * For the purpose of this project, assume that each item has a unique name
     */
    private LineItem getItemByName(String name){
        Query query;
        query = em.createNamedQuery("itemByName");
        query.setParameter("name", name);
        List<LineItem> items = query.getResultList();
        System.out.println(items.toString());
        LineItem item = items.get(0);
        return item;
    }
    
    private LineItem getItemByID(int id){
        Query query;
        query = em.createNamedQuery("itemByID");
        query.setParameter("ID", id);
        List<LineItem> items = query.getResultList();
        System.out.println(items.toString());
        LineItem item = items.get(0);
        return item;
    }
    
    private void initializeReciept(String[] itemArray){
        orderItems = new LineItem[itemArray.length];
        
        for(int i = 0; i<orderItems.length; i++){
            orderItems[i] = getItemByName(itemArray[i]);
        }
        receipt = new Receipt(orderItems);
    }
    
    private void initializeReciept(int[] itemArray){
        orderItems = new LineItem[itemArray.length];
        for(int i = 0; i<orderItems.length; i++){
            orderItems[i] = getItemByID(itemArray[i]);
        }
        receipt = new Receipt(orderItems);
    }
    
}
