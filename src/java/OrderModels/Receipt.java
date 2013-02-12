package OrderModels;

import LineItem.LineItem;

/**
 *
 * @author Emma Edgar
 */
public class Receipt {
    private double total;
    private double tax;
    private double tip;
    private String receiptString;
    private Item[] items;

    public Receipt() {
        total = 0;
        tax = 0;
        tip = 0;
        receiptString = "Thank you for dining at David's<br>";
    }
    public Receipt(String[] itemArray){
       
        receiptString = "Thank you for dining at David's Diner<br>";
        
        for (String i : itemArray){
            receiptString += i + "<br>";
        }
        
        items = new Item[itemArray.length];
        for (int i = 0; i < itemArray.length; i++){
            
            String[] itemInfo = itemArray[i].split(" - \\$");
            
            String name = itemInfo[0].trim();
            double price = Double.parseDouble(itemInfo[1].trim());
            
            items[i] = new Item(name, price);
        }
        
        total = calcTotal();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public String getReceiptString() {
        tip = total * .20;
        tax = total * .05;
        total += tip + tax;
        receiptString = receiptString + 
                "Tax:    " + tax + "<br>" + 
                "Tip:    " + tip + "<br>" +
                "Total:  " + total + "<br>";
        return receiptString;
    }

    public void setReceiptString(String receiptString) {
        this.receiptString = receiptString;
    }
    
    public void addItem(String item){
        LineItem li = new LineItem();
        
        receiptString = receiptString + 
                Items.valueOf(item).getName() + "  " +
                Items.valueOf(item).getPrice() + "<br>";
        total += Items.valueOf(item).getPrice();
    }
    
    private double calcTotal(){
        
        for (int i = 0; i < items.length; i++){
            total += items[i].getPrice();
        }
        
        return total;
    }
}
