import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import Module.Order.Order;
import Module.Order.OrderItem;
import Module.PaymentMethod.Cash;
import Module.PaymentMethod.PaymentMethod;
import Module.Product.Category;
import Module.Product.Product;


public class DepartmentStore {
    public static final String csvFile="./MOCK_DATA.csv";
    public static final String delimiter=",";
    public static void main(String[] args) {
       
        // Read input file and store products in the array list of products
        ArrayList<Order> orders=new ArrayList<Order>();
        ArrayList<Product> products=new ArrayList<Product>();
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                int id = Integer.parseInt(tempArr[0]);
                String name=tempArr[1];
                Category category=Category.valueOf(tempArr[2]);
                double cost=Double.parseDouble(tempArr[3]);
                double price=cost*1.45;
                Product p =new Product(id,name,category,cost,price);
                //System.out.println(p.toString());        
                products.add(p);
            }
            br.close();            
        } catch (Exception e) {
            System.out.println("Error reading the file:\n"+e.toString());
        }
        // Create a random number of orders
        Random r=new Random(10);
        int numberOrders = (int)(10*r.nextDouble());
        for(int i=1;i<=numberOrders;++i){
            Order o=new Order(i+100, new Date());
            int numberItems=(int)(10*r.nextDouble());
            for(int j=1;j<=numberItems;++j){
                int productIndex=(int)(1000*r.nextDouble());
                Product p = products.get(productIndex);
                int qty=(int)(10*r.nextDouble());
                OrderItem item = new OrderItem(qty, p.getUnitprice(), p);
                o.addItem(item);
            }
            System.out.println(o.toString());
            orders.add(o) ; 
        }
            OrderItem i=new OrderItem(10,99.9,products.get(1));
            Order o=orders.get(0);
            orders.get(0).addItem(i);
            //System.out.println(orders.get(0).toString());
             orders.get(0).addItem(7,77.7,products.get(1));
            System.out.println(orders.get(0).toString());
            o.removeItem(products.get(1));
            System.out.println(orders.get(0).toString());
             
             System.out.println(o.toString());
             PaymentMethod pay=new Cash(0.05);
             System.out.println(o.getOrderTotal(pay));
             
        
    }
}
