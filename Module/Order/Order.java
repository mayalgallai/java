package Module.Order;
import Module.Product.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import Module.PaymentMethod.PaymentMethod;


public class Order {
    private int id;
    private Date date;
    private ArrayList<OrderItem> orderItems= new ArrayList<OrderItem>();
    public Order(int id, Date date){
        this.id=id;
        this.date=date;
    }
    public Order(int id, Date date,ArrayList<OrderItem> items){
        this.id=id;
        this.date=date;
        if(items!=null){
            this.orderItems=items;
        }
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
    public void addItem(OrderItem item){
        if(!orderItems.contains(item)){
            orderItems.add(item);
        }
    }
    public void addItem(int qty, double price, Product product)
      //TODO: Implement this method to check if the product is in the order or not
        //if the product is in the list change only the qty and price, otherwise, add 
        //the new item to the list
    {     OrderItem o=new OrderItem(qty,price,product);
           if(orderItems.contains(o))
           {orderItems.remove(o);}
        orderItems.add(o);
     }
    
    public void removeItem(OrderItem item){
        if(orderItems.contains(item)){
            orderItems.remove(item);
        }
    }
    public void removeItem(Product product){
        this.removeItem(new OrderItem(0,0,product));
     
    }
    public String toString(){
        String r="========= Order =============================================================\n";
        r+=String.format("Order number: %1$10d     Order Date: %2$te/%2$tm/%2$tY \n", id,date);
        for (OrderItem orderItem : orderItems) {
            r+=(orderItem.toString()+" \n");
        }
        r+=String.format("============== T O T A L =================: %1$15.3f",getOrderTotal());
        return r;
    }
     public double getOrderTotal(){
        double total=0;
        for (OrderItem orderItem : orderItems) {
            total+=(orderItem.getQty()*orderItem.getPrice());
        }
        return total;
    }
    public double getOrderTotal(PaymentMethod pay){
      
        return pay.calculateAmount(this.getOrderTotal());
    }
    public double getTotalAmount() {
        return 0;
    }
    public Product[] getProducts() {
        return null;
    }
    public void setTotalAmount(double d) {
    }
    public Map<String, Double> getItemPrices() {
        return null;
    }
    public Object getItemCategory(String item) {
        return null;
    }

}
