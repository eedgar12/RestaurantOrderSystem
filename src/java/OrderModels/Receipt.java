package OrderModels;

import java.text.DecimalFormat;

/**
 * @author Emma Edgar
 * This class represents a receipt object.
 */
public class Receipt {

    private double total;
    private double subTotal;
    private double tax;
    private double tip;
    private String receiptString;
    private Item[] items;
    private final DecimalFormat PRICE_FORMAT = new DecimalFormat("#.00");
    private ItemsEnum[] itemEnumArray = {ItemsEnum.BURGER, ItemsEnum.CLUB, ItemsEnum.PASTA, 
        ItemsEnum.QUICHE, ItemsEnum.REUBEN, ItemsEnum.SALMON};
    private final String WELCOME = "Thank you for dining at David's<br><br>";
    
    public Receipt() {
        total = 0;
        tax = 0;
        tip = 0;
        receiptString = WELCOME;
    }

    /**
     * Constructor
     * Used with real database
     * @param orderItems 
     */
    public Receipt(LineItem[] orderItems){
        receiptString = WELCOME;
        addItems(orderItems);
    }
    
    /**
     * Constructor
     * Used with fake databasse
     * @param itemArray 
     */
    public Receipt(String[] itemArray) {
        receiptString = WELCOME;
        addItems(itemArray);
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
        createReceipt();
        return receiptString;
    }

    public void setReceiptString(String receiptString) {
        this.receiptString = receiptString;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public ItemsEnum[] getItemEnumArray() {
        return itemEnumArray;
    }

    public void setItemEnumArray(ItemsEnum[] itemEnumArray) {
        this.itemEnumArray = itemEnumArray;
    }

    public String getWelcome() {
        return WELCOME;
    }
    
    private double calcTip(){
        tip = subTotal * .20;
        return tip;
    }
    
    private double calcTax(){
        tax = subTotal * .05;
        return tax;
    }
    
    private double calcSubTotal() {

        for (int i = 0; i < items.length; i++) {
            subTotal += items[i].getPrice();
        }

        return subTotal;
    }
    private double calcTotal(){
        total = subTotal + tip + tax;
        return total;
    }
    
    private String createReceipt(){
        calcSubTotal();
        calcTip();
        calcTax();
        calcTotal();
        receiptString = receiptString
                + "<br>"
                + "Sub Total: $" + PRICE_FORMAT.format(subTotal) + "<br>"
                + "Tax:       $" + PRICE_FORMAT.format(tax) + "<br>"
                + "Tip:       $" + PRICE_FORMAT.format(tip) + "<br>"
                + "Total:     $" + PRICE_FORMAT.format(total) + "<br>";
        return receiptString;
    }
    
    private void addItems(LineItem[] orderItems){
        items = new Item[orderItems.length];
        for(int i = 0; i < items.length; i++){
            items[i] = new Item(orderItems[i].getName(), orderItems[i].getPrice());
            receiptString += orderItems[i].toString() + "<br>";
        }
    }
 
    private void addItems(String[] itemArray){
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
    }
}
