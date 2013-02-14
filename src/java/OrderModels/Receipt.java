package OrderModels;

import LineItem.LineItem;
import java.text.DecimalFormat;

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
    private final DecimalFormat PRICE_FORMAT = new DecimalFormat("#.00");
    private Items[] itemEnumArray = {Items.BURGER, Items.CLUB, Items.PASTA, 
        Items.QUICHE, Items.REUBEN, Items.SALMON};
    
    public Receipt() {
        total = 0;
        tax = 0;
        tip = 0;
        receiptString = "Thank you for dining at David's<br>";
    }

    public Receipt(String[] itemArray) {

        receiptString = "Thank you for dining at David's Diner<br>";

        items = new Item[itemArray.length];
          
        
        for (int i = 0; i < itemArray.length; i++){
            for (int j = 0; j < itemEnumArray.length; j++){
                if (itemArray[i].equals(itemEnumArray[j].getName())){
                    items[i] = new Item(itemEnumArray[j].getName(), 
                            itemEnumArray[j].getPrice());
                    receiptString += items[i].toString() + "<br>";
                }
            }
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
        receiptString = receiptString
                + "Tax:    " + PRICE_FORMAT.format(tax) + "<br>"
                + "Tip:    " + PRICE_FORMAT.format(tip) + "<br>"
                + "Total:  " + PRICE_FORMAT.format(total) + "<br>";
        return receiptString;
    }

    public void setReceiptString(String receiptString) {
        this.receiptString = receiptString;
    }

    public void addItem(String item) {
        LineItem li = new LineItem();

        receiptString = receiptString
                + Items.valueOf(item).getName() + "  "
                + Items.valueOf(item).getPrice() + "<br>";
        total += Items.valueOf(item).getPrice();
    }

    private double calcTotal() {

        for (int i = 0; i < items.length; i++) {
            total += items[i].getPrice();
        }

        return total;
    }
}
