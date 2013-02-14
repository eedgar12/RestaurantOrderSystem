package OrderModels;

/**
 * @author Emma Edgar
 * This Enum represents the items for purchase at a restaurant.  This class
 * was designed to be used in place of a database.
 */
public enum ItemsEnum {
    BURGER(6.99, "Classic Burger"),
    CLUB(5.95, "Turkey Club"),
    REUBEN(6.49, "Reuben Sandwich"),
    QUICHE(7.89, "Quiche"), 
    PASTA(9.89, "Shrimp Pasta"), 
    SALMON(9.85, "Pan Seared Salmon");
    
    private double price;
    private String name;
    
    ItemsEnum(double price, String name){
        this.price = price;
        this.name = name;
    }

    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "ItemsEnum{" + "price=" + price + ", name=" + name + '}';
    }
    
}
