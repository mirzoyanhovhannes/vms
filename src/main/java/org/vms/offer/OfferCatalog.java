package org.vms.offer;

import org.vms.actor.Actor;
import org.vms.exceptions.NotFoundException;
import org.vms.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OfferCatalog {
    private static final Random random = new Random();
    private final List<Offer> offers;

    public OfferCatalog() {
        this.offers = new ArrayList<>();
    }

    public Offer getOffer(OfferId offerId) {
        return offers.stream()
                .filter(offer -> offer.getOfferId().equals(offerId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("Offer not found by id %d", offerId.getId())));
    }

    public OfferId makeOffer(Actor actor, String  offerType, Product product, int quantity, BigDecimal price) {
        OfferId offerId = generateOfferId();
        offers.add(new Offer(offerId, quantity, price, offerType, actor, product));

        System.out.printf("Create new offer by id %d%n", offerId.getId());
        return offerId;
    }

    public void removeOffer(Offer offer) {
        offers.remove(offer);
    }

    private OfferId generateOfferId() {
        return new OfferId(random.nextInt(0, Integer.MAX_VALUE));
    }
}
