package com.synnks.dauntless.optimizer.model.items;

import com.synnks.dauntless.optimizer.model.perks.Perk;

import java.util.Map;

public interface Equipment {

    Map<Perk, Integer> getAllPerks();
}
