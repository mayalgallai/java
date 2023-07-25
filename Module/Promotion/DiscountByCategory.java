package Module.Promotion;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Module.Order.Order;

public class DiscountByCategory extends Promotion {
    private Map<String, Double> categoryDiscounts;

    public DiscountByCategory(Date startDate, Date endDate, Validator validator) {
        super(startDate, endDate, validator);
        categoryDiscounts = new HashMap<>();
    }

    public void addDiscount(String category, double discount) {
        categoryDiscounts.put(category, discount);
    }

    public Map<String, Double> getCategoryDiscounts() {
        return categoryDiscounts;
    }

    @Override
    public boolean isValid(Date date) {
        return (validator == null || validator.validate(date)) && date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0;
    }

    @Override
    public Order applyPromotion(Order order) {
        if (isValid(order.getDate())) {
            Map<String, Double> itemPrices = order.getItemPrices();
            double totalDiscount = 0.0;
            for (String category : categoryDiscounts.keySet()) {
                double discount = categoryDiscounts.get(category);
                for (String item : itemPrices.keySet()) {
                    if (order.getItemCategory(item).equals(category)) {
                        double itemPrice = itemPrices.get(item);
                        double itemDiscount = itemPrice * discount;
                        totalDiscount += itemDiscount;
                        itemPrices.put(item, itemPrice - itemDiscount);
                    }
                }
            }
            order.setTotalAmount(order.getTotalAmount() - totalDiscount);
        }
        return order;
    }

   
   
}
