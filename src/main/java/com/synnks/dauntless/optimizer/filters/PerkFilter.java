package com.synnks.dauntless.optimizer.filters;

import com.synnks.dauntless.optimizer.model.items.Equipment;
import com.synnks.dauntless.optimizer.model.perks.Perk;

import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PerkFilter {

    private final Set<Perk> perks;

    private PerkFilter(Perk... perks) {
        this.perks = Set.of(perks);
    }

    public <T extends Equipment> Supplier<Collection<? extends T>> filter(Supplier<Collection<? extends T>> supplier) {
        return () -> supplier.get().stream()
                .filter(equipment -> perks.containsAll(equipment.getAllPerks().keySet()))
                .collect(Collectors.toUnmodifiableSet());
    }

    public static PerkFilter of(Perk... perks) {
        return new PerkFilter(perks);
    }
}
