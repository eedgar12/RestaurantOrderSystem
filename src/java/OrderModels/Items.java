/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderModels;

/**
 *
 * @author Toshiba laptop
 */
public enum Items {
    BURGER(6.99, "Classic Burger"),
    CLUB(5.95, "Turkey Club"),
    REUBEN(6.49, "Reuben Sandwich"),
    QUICHE(7.89, "Quiche"), 
    PASTA(9.89, "Shrimp Pasta"), 
    SALMON(9.85, "Pan Seared Salmon");
    
    private double price;
    private String name;
    
    Items(double price, String name){
        this.price = price;
        this.name = name;
    }

    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
//    public String getLineItem(String item){
//        return getName(item) + " " + getPrice(item);
//                
//    }
   
}
