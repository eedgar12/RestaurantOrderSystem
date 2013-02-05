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

    public Receipt() {
        total = 0;
        tax = 0;
        tip = 0;
        receiptString = "Thank you for dining at David's\n";
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
                "Tax:    " + tax + "\n" + 
                "Tip:    " + tip + "\n" +
                "Total:  " + total + "\n";
        return receiptString;
    }

    public void setReceiptString(String receiptString) {
        this.receiptString = receiptString;
    }
    
    public void addItem(String item){
        LineItem li = new LineItem();
        
        receiptString = receiptString + 
                Items.valueOf(item).getName() + "  " +
                Items.valueOf(item).getPrice();
        total += Items.valueOf(item).getPrice();
    }
    
}
