package Module.Product;
public class Product {
    private int id;
    private String name;
    private Category category;
    private double cost;
    private double unitprice;
    public Product(int id, String name, Category category, double cost, double price){
        this.id=id;
        this.name=name;
        this.category=category;
        this.cost=cost;
        this.unitprice=price;
    } 
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }
    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }
    public double getUnitprice() {
        return unitprice;
    }
    public String toString(){
        return String.format("|%10d", id)+
                String.format("|%-40s",name)+
                String.format("|%-17s",category)+
                String.format("|%8.3f",cost)+
                String.format("|%8.3f|",unitprice);
    }
    public void setDiscount(double discount) {
    }
}
