package org.vms.actor;

import org.vms.offer.Offer;

import java.math.BigDecimal;

public class Actor {
    private ActorId actorId;
    private BigDecimal bankAmount;
    private PersonalData personalData;

    public Actor(ActorId actorId, BigDecimal bankAmount, PersonalData personalData) {
        this.actorId = actorId;
        this.bankAmount = bankAmount;
        this.personalData = personalData;
    }

    public void updateAmount(double percent, Offer o) {
        if ("sale".equals(o.getType())) {
            bankAmount = bankAmount.add(o.getTotalPrice().multiply(BigDecimal.valueOf(1 - percent)));
        } else if ("purchase".equals(o.getType())){
            bankAmount = bankAmount.subtract(o.getTotalPrice().multiply(BigDecimal.valueOf(1 + percent)));
        }
        System.out.println("Bank Amount value after update" + bankAmount.doubleValue());
    }

    public ActorId getActorId() {
        return actorId;
    }
}
