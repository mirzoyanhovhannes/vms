package org.vms.offer;

import org.vms.actor.Actor;
import org.vms.product.Product;

import java.math.BigDecimal;

public class Offer {
    private final OfferId offerId;
    private final int quantity;
    private final BigDecimal totalPrice;
    private final String  type;
    private final Actor actor;
    private final Product product;

    public Offer(OfferId offerId, int quantity, BigDecimal totalPrice, String type, Actor actor, Product product) {
        this.offerId = offerId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.type = type;
        this.actor = actor;
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void complete(double percent) {
        actor.updateAmount(percent, this);
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public OfferId getOfferId() {
        return offerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Actor getActor() {
        return actor;
    }

    public Product getProduct() {
        return product;
    }
}
