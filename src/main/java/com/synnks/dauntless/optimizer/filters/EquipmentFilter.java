package com.synnks.dauntless.optimizer.filters;

import com.synnks.dauntless.optimizer.model.items.Equipment;

import java.util.Collection;
import java.util.function.Supplier;

public interface EquipmentFilter<T extends Equipment> {

    Supplier<Collection<? extends T>> getSupplier();
}
