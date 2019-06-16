package com.synnks.dauntless.optimizer.filters;

import com.synnks.dauntless.optimizer.model.items.weapon.*;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public interface WeaponFilter extends EquipmentFilter<Weapon> {

    class WeaponClass implements WeaponFilter {

        private static final Map<Class<? extends Weapon>, Supplier<Collection<? extends Weapon>>> supplierMap = Map.of(
                Axe.class, WeaponSet::getAllAxes,
                ChainBlades.class, WeaponSet::getAllChainBlades,
                Hammer.class, WeaponSet::getAllHammers,
                Sword.class, WeaponSet::getAllSwords,
                WarPike.class, WeaponSet::getAllWarPikes,
                Repeaters.class, WeaponSet::getAllRepeaters);

        private final Class<? extends Weapon> weaponClass;

        private WeaponClass(Class<? extends Weapon> weaponClass) {
            this.weaponClass = weaponClass;
        }

        public static WeaponClass is(Class<? extends Weapon> weaponClass) {
            return new WeaponClass(weaponClass);
        }

        @Override
        public Supplier<Collection<? extends Weapon>> getSupplier() {
            return supplierMap.get(weaponClass);
        }
    }

    class SpecificWeapon implements WeaponFilter {

        private final Weapon weapon;

        private SpecificWeapon(Weapon weapon) {
            this.weapon = weapon;
        }

        public static SpecificWeapon is(Weapon weapon) {
            return new SpecificWeapon(weapon);
        }

        @Override
        public Supplier<Collection<? extends Weapon>> getSupplier() {
            return weapon::getAllFlavours;
        }
    }

    class AllWeapons implements WeaponFilter {

        @Override
        public Supplier<Collection<? extends Weapon>> getSupplier() {
            return WeaponSet::getAllWeapons;
        }
    }
}
