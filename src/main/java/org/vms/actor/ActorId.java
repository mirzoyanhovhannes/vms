package org.vms.actor;

import java.util.Objects;

public class ActorId {
    private int id;

    public ActorId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorId actorId = (ActorId) o;
        return id == actorId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
