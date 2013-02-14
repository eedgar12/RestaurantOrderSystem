package OrderModels;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

/**
 *
 * @author Emma Edgar
 */

/*
 * Notes from class:
 * An entity has 2 states: Attached and Detached.  
 * Inside a transaction, the entity is attached.  This means all changes are
 * automatically saved.  When the values are passed to something outside of the
 * transaction, the entity is detached and all changes have to be saved manually.
 * 
 * "updates" only works with attached states. "merge" works with both attached
 * and detached.
 */
@Entity
@Table(name = "LineItem")
@NamedQueries({
    @NamedQuery(name = "itemByName", query = "SELECT s.price FROM LineItem s WHERE s.name = :name"),
    @NamedQuery(name = "itemByID", query = "SELECT s.price FROM LineItem s WHERE s.id = :ID")})
public class LineItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    
    /*
     * REFERENCE FOR JOINS
     * @ElementCollection
     * @CollectionTable(name="tags")
     * privateList<String> tags = new ArrayList<String>();
     */
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
   
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LineItem)) {
            return false;
        }
        LineItem other = (LineItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LineItem.LineItem[ id=" + id + " ]";
    }
}
