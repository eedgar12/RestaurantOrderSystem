package OrderModels;

import OrderModels.LineItem;
import OrderModels.Receipt;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author Emma Edgar
 */
public class Test {

    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantOrderSystemPU");
    EntityManager em = emf.createEntityManager();
    private LineItem[] orderItems;
    private Receipt receipt;

    private LineItem getItemByName(String name) {
        Query query;
//        em = new EntityManager();
        query = em.createNamedQuery("itemByName");
        query.setParameter("name", name);
        LineItem item = (LineItem)query.getSingleResult();
//        LineItem item = new LineItem();
        return item;
    }
    
    public String getReceiptString(LineItem li){
        return "RECEIPT";
    }
    
    public static void main(String[] args) {
        Test t = new Test();
        String name = "Classic Burger";
        String receiptstuff = t.getReceiptString(t.getItemByName(name));
        
        System.out.println(receiptstuff);
    }
}
