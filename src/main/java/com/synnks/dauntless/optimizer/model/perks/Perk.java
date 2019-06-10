package com.synnks.dauntless.optimizer.model.perks;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public interface Perk {

    default int compare(Perk otherPerk) {
        return getName().compareTo(otherPerk.getName());
    }

    default String getName() {
        return toString();
    }

    static <P extends Enum & Perk> Set<P> getAllPerks(Class<P> perkType) {
        return Arrays.stream(perkType.getEnumConstants()).collect(Collectors.toUnmodifiableSet());
    }
}
