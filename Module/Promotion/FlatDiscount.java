package Module.Promotion;

import java.util.Date;

import Module.Order.Order;

public class FlatDiscount extends Promotion {
    private double discount;

    public FlatDiscount(Date startDate, Date endDate, Validator validator, double discount) {
        super(startDate, endDate, validator);
        this.discount = discount;
    }

    public FlatDiscount(Date startDate, Date endDate, double discount) {
        super(startDate, endDate);
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean isValid(Date date) {
        return (validator == null || validator.validate(date)) && date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }
    @Override
    public Order applyPromotion (Order order) {
        if (isValid(order.getDate())) {
            double discountAmount = discount * order.getTotalAmount();
            order.setTotalAmount(order.getTotalAmount() - discountAmount);
        }
        return order;
    }

   
   
}
