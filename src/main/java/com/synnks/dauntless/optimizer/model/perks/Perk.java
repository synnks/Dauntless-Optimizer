package com.synnks.dauntless.optimizer.model.perks;

public interface Perk {

    default int compare(Perk otherPerk) {
        return toString().compareTo(otherPerk.toString());
    }
}
