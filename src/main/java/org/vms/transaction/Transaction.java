package org.vms.transaction;

import org.vms.actor.ActorId;
import org.vms.offer.Offer;
import org.vms.product.ProductId;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final ActorId actorId;
    private final ProductId productId;
    private final int quantity;
    private final LocalDateTime time;
    private final BigDecimal totalPrice;
    private final String type;

    public Transaction(LocalDateTime time, Offer offer) {
        this.time = time;
        this.actorId = offer.getActor().getActorId();
        this.productId = offer.getProduct().getProductId();
        this.quantity = offer.getQuantity();
        this.totalPrice = offer.getTotalPrice();
        this.type = offer.getType();
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("actorId=").append(actorId.getId());
        sb.append(", productId=").append(productId.getId());
        sb.append(", quantity=").append(quantity);
        sb.append(", time=").append(time);
        sb.append(", totalPrice=").append(totalPrice);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
