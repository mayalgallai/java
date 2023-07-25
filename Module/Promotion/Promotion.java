package Module.Promotion;

import java.util.Date;

import Module.Order.Order;

public abstract class Promotion {
    protected Date startDate;
    protected Date endDate;
    protected Validator validator;

    public Promotion(Date startDate, Date endDate, Validator validator) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.validator = validator;
    }

    public Promotion(Date startDate, Date endDate) {
        this(startDate, endDate, null);
    }

    public abstract boolean isValid(Date date);

    public abstract Order applyPromotion(Order order);
}