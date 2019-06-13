package com.synnks.dauntless.optimizer.algorithm;

import com.synnks.dauntless.optimizer.filters.PerkFilter;
import com.synnks.dauntless.optimizer.filters.WeaponFilter;
import com.synnks.dauntless.optimizer.model.items.Equipment;
import com.synnks.dauntless.optimizer.model.items.Lantern;
import com.synnks.dauntless.optimizer.model.items.armor.ArmorSet;
import com.synnks.dauntless.optimizer.model.items.weapon.Weapon;
import com.synnks.dauntless.optimizer.model.items.weapon.WeaponSet;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Backtracking implements Algorithm {

    private final PerkFilter perkFilter;
    private final WeaponFilter weaponFilter;

    public Backtracking(PerkFilter perkFilter, WeaponFilter weaponFilter) {
        this.perkFilter = perkFilter;
        this.weaponFilter = weaponFilter;
    }

    public Backtracking(PerkFilter perkFilter) {
        this(perkFilter, null);
    }

    private boolean isValid(Solution solution) {
        return solution.evaluate().values().stream().allMatch(i -> i <= 2);
    }

    private Supplier<Collection<? extends Weapon>> getWeaponSupplier() {
        return perkFilter.filter(Optional.ofNullable(weaponFilter).map(WeaponFilter::getSupplier).orElse(WeaponSet::getAllWeapons));
    }

    private <T extends Equipment> Supplier<Collection<? extends T>> getEquipmentSupplier(Supplier<Collection<? extends T>> supplier) {
        return perkFilter.filter(supplier);
    }

    @Override
    public Collection<Solution> solve() {
        var solutions = new HashSet<Solution>();

        var voidStep = new Step<Void>(Collections::emptySet, (s, v) -> s, null);
        var consumeStep = new Step<>(() -> Set.of(new Solution()), (solution, ignore) -> {
            solutions.add(solution);
            return solution;
        }, voidStep);
        var lanternStep = new Step<>(getEquipmentSupplier(Lantern::getAllLanterns), Solution::setLantern, consumeStep);
        var legsStep = new Step<>(getEquipmentSupplier(ArmorSet::getAllLegs), Solution::setLegs, lanternStep);
        var armsStep = new Step<>(getEquipmentSupplier(ArmorSet::getAllArms), Solution::setArms, legsStep);
        var torsoStep = new Step<>(getEquipmentSupplier(ArmorSet::getAllTorsos), Solution::setTorso, armsStep);
        var headStep = new Step<>(getEquipmentSupplier(ArmorSet::getAllHeads), Solution::setHead, torsoStep);
        var weaponStep = new Step<>(getWeaponSupplier(), Solution::setWeapon, headStep);

        weaponStep.consume(new Solution());

        return solutions;
    }

    private class Step<T> {

        private final Supplier<Collection<? extends T>> valueSupplier;
        private final BiFunction<Solution, T, Solution> consumer;
        private final Step<?> nextStep;

        private Step(Supplier<Collection<? extends T>> valueSupplier, BiFunction<Solution, T, Solution> consumer, Step<?> nextStep) {
            this.valueSupplier = valueSupplier;
            this.consumer = consumer;
            this.nextStep = nextStep;
        }

        void consume(Solution solution) {
            valueSupplier.get().forEach(o -> {
                var newSolution = consumer.apply(solution, o);
                if (isValid(newSolution)) {
                    nextStep.consume(newSolution);
                }
            });
        }
    }
}
