package com.synnks.dauntless.optimizer.model.items;

import com.synnks.dauntless.optimizer.model.perks.Perk;

import java.util.Map;
import java.util.Set;

public interface Equipment<Type extends Equipment<Type>> {

    Map<Perk, Integer> getAllPerks();

    Set<Type> getAllFlavours();
}
