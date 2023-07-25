package Module.PaymentMethod;
public class Cash extends SuperPament implements PaymentMethod {
    private double discountPercentage;

    public Cash(double discountPercentage){
        this.discountPercentage=discountPercentage;
    }
    @Override
    public double calculateAmount(double amount) {
    
        return amount-(amount*discountPercentage);
    }
}
