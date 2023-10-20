package org.vms.system;

import org.vms.actor.Actor;
import org.vms.actor.ActorCatalog;
import org.vms.actor.ActorId;
import org.vms.actor.PersonalData;
import org.vms.offer.Offer;
import org.vms.offer.OfferCatalog;
import org.vms.offer.OfferId;
import org.vms.product.Product;
import org.vms.product.ProductCatalog;
import org.vms.product.ProductId;
import org.vms.transaction.TransactionCatalog;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class System {
    private BigDecimal backAmount = new BigDecimal(0);
    private final double percent = 0.5;
    private final ActorCatalog actorCatalog;
    private final OfferCatalog offerCatalog;
    private final ProductCatalog productCatalog;
    private final TransactionCatalog transactionCatalog;

    public System() {
        actorCatalog = new ActorCatalog();
        offerCatalog = new OfferCatalog();
        productCatalog = new ProductCatalog();
        transactionCatalog = new TransactionCatalog();
    }

    public ActorId makeActor(PersonalData personalData, BigDecimal bankAmount) {
        return actorCatalog.makeActor(personalData, bankAmount);
    }

    public OfferId makeOffer(ActorId actorId, String offerType, ProductId productId, int quantity, BigDecimal price) {
        Actor a = actorCatalog.getActor(actorId);
        Product p = productCatalog.getProduct(productId);

        return offerCatalog.makeOffer(a, offerType, p, quantity, price);
    }

    public void makeTransaction(LocalDateTime time, OfferId offerId) {
        Offer o = offerCatalog.getOffer(offerId);
        offerCatalog.removeOffer(o);

        this.transactionCatalog.makeTransaction(LocalDateTime.now(), o);
        o.complete(percent);

        updateAmount(o);
    }

    public TransactionCatalog getTransactionCatalog() {
        return transactionCatalog;
    }

    private void updateAmount(Offer offer) {
        backAmount = backAmount.add(offer.getTotalPrice().multiply(BigDecimal.valueOf(percent)));
    }

}
