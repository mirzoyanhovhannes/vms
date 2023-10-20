package org.vms.offer;

import java.util.Objects;

public class OfferId {
    private final int id;

    public OfferId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferId offerId = (OfferId) o;
        return id == offerId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
