package com.synnks.dauntless.optimizer.algorithm;

import com.synnks.dauntless.optimizer.filters.LanternFilter;
import com.synnks.dauntless.optimizer.filters.PerkFilter;
import com.synnks.dauntless.optimizer.filters.WeaponFilter;
import com.synnks.dauntless.optimizer.model.items.Equipment;
import com.synnks.dauntless.optimizer.model.items.armor.ArmorSet;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Backtracking implements Algorithm {

    private final PerkFilter perkFilter;
    private final WeaponFilter weaponFilter;
    private final LanternFilter lanternFilter;

    public Backtracking(PerkFilter perkFilter, WeaponFilter weaponFilter, LanternFilter lanternFilter) {
        this.perkFilter = perkFilter;
        this.weaponFilter = weaponFilter;
        this.lanternFilter = lanternFilter;
    }

    private boolean isValid(Solution solution) {
        return solution.evaluate().values().stream().allMatch(i -> i <= 2);
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
        var lanternStep = new Step<>(getEquipmentSupplier(lanternFilter.getSupplier()), Solution::setLantern, consumeStep);
        var legsStep = new Step<>(getEquipmentSupplier(ArmorSet::getAllLegs), Solution::setLegs, lanternStep);
        var armsStep = new Step<>(getEquipmentSupplier(ArmorSet::getAllArms), Solution::setArms, legsStep);
        var torsoStep = new Step<>(getEquipmentSupplier(ArmorSet::getAllTorsos), Solution::setTorso, armsStep);
        var headStep = new Step<>(getEquipmentSupplier(ArmorSet::getAllHeads), Solution::setHead, torsoStep);
        var weaponStep = new Step<>(getEquipmentSupplier(weaponFilter.getSupplier()), Solution::setWeapon, headStep);

        weaponStep.consume(new Solution());

        return solutions;
    }

    private class Step<T> {

        private final Supplier<Collection<? extends T>> valueSupplier;
        private final BiFunction<Solution, ? super T, Solution> consumer;
        private final Step<?> nextStep;

        private Step(Supplier<Collection<? extends T>> valueSupplier, BiFunction<Solution, ? super T, Solution> consumer, Step<?> nextStep) {
            this.valueSupplier = valueSupplier;
            this.consumer = consumer;
            this.nextStep = nextStep;
        }

        void consume(Solution solution) {
            valueSupplier.get().forEach(item -> {
                var newSolution = consumer.apply(solution, item);
                if (isValid(newSolution)) {
                    nextStep.consume(newSolution);
                }
            });
        }
    }
}
