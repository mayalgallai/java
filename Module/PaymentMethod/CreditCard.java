package Module.PaymentMethod;
public class CreditCard extends SuperPament implements PaymentMethod {
    private double overhead;
    public CreditCard(double overhead){
        this.overhead=overhead;
    } 
    @Override
    public double calculateAmount(double amount) {
        return amount+(amount*overhead);
    }
    
}
