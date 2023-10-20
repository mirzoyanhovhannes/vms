package org.vms.actor;

import org.vms.exceptions.NotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActorCatalog {
    private static final Random random = new Random();
    private final List<Actor> actors;

    public ActorCatalog() {
        actors = new ArrayList<>();
    }

    public Actor getActor(ActorId actorId) {
        return actors
                .stream()
                .filter(actor -> actor.getActorId().equals(actorId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(String.format("Actor not found by id %d", actorId.getId())));
    }

    public ActorId makeActor(PersonalData personalData, BigDecimal bankAmount) {
        ActorId actorId = generateActorId();
        actors.add(new Actor(actorId, bankAmount, personalData));

        System.out.printf("Create new actor by id %d%n", actorId.getId());
        return actorId;
    }

    private ActorId generateActorId() {
        return new ActorId(random.nextInt(0, Integer.MAX_VALUE));
    }
}
