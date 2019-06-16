package com.synnks.dauntless.optimizer.filters;

import com.synnks.dauntless.optimizer.model.items.Lantern;

import java.util.Collection;
import java.util.function.Supplier;

public interface LanternFilter extends EquipmentFilter<Lantern> {

    class SpecificLantern implements LanternFilter {

        private final Lantern lantern;

        private SpecificLantern(Lantern lantern) {
            this.lantern = lantern;
        }

        public static SpecificLantern is(Lantern lantern) {
            return new SpecificLantern(lantern);
        }

        @Override
        public Supplier<Collection<? extends Lantern>> getSupplier() {
            return lantern::getAllFlavours;
        }
    }

    class AllLanterns implements LanternFilter {

        @Override
        public Supplier<Collection<? extends Lantern>> getSupplier() {
            return Lantern::getAllLanterns;
        }
    }
}
