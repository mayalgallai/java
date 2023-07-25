package Module.Order;
import Module.Product.Product;
public class OrderItem {
    private int qty;
    private double price;
    private Product product;
    public OrderItem(int qty, double price, Product product){
        this.setQty(qty);
        this.setPrice(price);
        this.setProduct(product);
    }
    public void setQty(int qty) {
        if (qty>0){
            this.qty = qty;
        }else{
            this.qty = 1;
        }
    }
    public int getQty() {
        return qty;
    }
    public void setPrice(double price) {
        if (price>0){
            this.price = price;
        }
    }
    public double getPrice() {
        return price;
    }
    public void setProduct(Product product) {
        if(product!=null){
            this.product = product;
        }
    }
    public Product getProduct() {
        return product;
    }
    public boolean equals(Object item){
        return this.product==((OrderItem)item).product;
    }
    public String toString(){
        String r="";
        r+=String.format("%1$-10d %2$-30s  %3$10d  %4$10.3f %5$10.3f", 
                    product.getId(), product.getName(), qty,price, qty*price);
        return r;
    }
}
