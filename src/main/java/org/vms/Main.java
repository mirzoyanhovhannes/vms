package org.vms;

import org.vms.actor.ActorId;
import org.vms.actor.PersonalData;
import org.vms.offer.OfferId;
import org.vms.product.ProductId;
import org.vms.system.System;
import org.vms.transaction.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System system = new System();

        //product ids
        ProductId productId1 = new ProductId(1);
        ProductId productId2 = new ProductId(2);

        //actors personal data
        PersonalData firstActorPersonalData = new PersonalData("Jon", "Wick");
        PersonalData secondActorPersonalData = new PersonalData("James", "Bond");

        //create 2 actors
        ActorId firstActorId = system.makeActor(firstActorPersonalData, BigDecimal.valueOf(2000));
        ActorId secondActorId = system.makeActor(secondActorPersonalData, BigDecimal.valueOf(1000));

        //create 3 offer
        List<OfferId> offerIds = new ArrayList<>();
        offerIds.add(system.makeOffer(firstActorId, "sale", productId1, 1, BigDecimal.valueOf(500)));
        offerIds.add(system.makeOffer(firstActorId, "purchase", productId2, 2, BigDecimal.valueOf(900)));
        offerIds.add(system.makeOffer(secondActorId, "sale", productId1, 2, BigDecimal.valueOf(1000)));

        for (OfferId offerId : offerIds) {
            system.makeTransaction(LocalDateTime.now(), offerId);
        }

        //print all transaction info
        for (Transaction transaction : system.getTransactionCatalog().getTransactions()) {
            transaction.print();
        }
    }
}