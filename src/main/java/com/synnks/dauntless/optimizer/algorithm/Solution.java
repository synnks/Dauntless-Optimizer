package com.synnks.dauntless.optimizer.algorithm;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Equipment;
import com.synnks.dauntless.optimizer.model.items.Lantern;
import com.synnks.dauntless.optimizer.model.items.armor.*;
import com.synnks.dauntless.optimizer.model.items.weapon.Weapon;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class Solution implements Comparable<Solution> {

    private final Weapon weapon;
    private final Head head;
    private final Torso torso;
    private final Arms arms;
    private final Legs legs;
    private final Lantern lantern;

    public Solution() {
        this(null, null, null, null, null, null);
    }

    private Solution(Weapon weapon, Head head, Torso torso, Arms arms, Legs legs, Lantern lantern) {
        this.weapon = weapon;
        this.head = head;
        this.torso = torso;
        this.arms = arms;
        this.legs = legs;
        this.lantern = lantern;
    }

    public Solution setWeapon(Weapon weapon) {
        return new Solution(weapon, head, torso, arms, legs, lantern);
    }

    public Solution setHead(Head head) {
        return new Solution(weapon, head, torso, arms, legs, lantern);
    }

    public Solution setTorso(Torso torso) {
        return new Solution(weapon, head, torso, arms, legs, lantern);
    }

    public Solution setArms(Arms arms) {
        return new Solution(weapon, head, torso, arms, legs, lantern);
    }

    public Solution setLegs(Legs legs) {
        return new Solution(weapon, head, torso, arms, legs, lantern);
    }

    public Solution setLantern(Lantern lantern) {
        return new Solution(weapon, head, torso, arms, legs, lantern);
    }

    @Override
    public int compareTo(Solution o) {
        var nullSafeComparator = Comparator.nullsFirst(String::compareTo);
        return Comparator.<Solution, String>comparing(solution -> solution.getWeapon().getName(), nullSafeComparator)
                .thenComparing(solution -> solution.getHead().getName(), nullSafeComparator)
                .thenComparing(solution -> solution.getTorso().getName(), nullSafeComparator)
                .thenComparing(solution -> solution.getArms().getName(), nullSafeComparator)
                .thenComparing(solution -> solution.getLegs().getName(), nullSafeComparator)
                .thenComparing(solution -> solution.getLantern().getName(), nullSafeComparator)
                .compare(this, o);
    }

    public Map<Perk, Integer> evaluate() {
        return Stream.of(getWeapon(), getHead(), getTorso(), getArms(), getLegs(), getLantern())
                .filter(Objects::nonNull)
                .map(Equipment::getAllPerks)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
    }

    private Map<Element, Integer> getElements() {
        var map = new HashMap<Element, Integer>();
        map.put(Element.BLAZE, 0);
        map.put(Element.FROST, 0);
        map.put(Element.SHOCK, 0);
        map.put(Element.TERRA, 0);
        map.put(Element.UMBRAL, 0);
        map.put(Element.RADIANT, 0);

        Stream.of(getHead(), getTorso(), getArms(), getLegs())
                .filter(Objects::nonNull)
                .map(Elements::new)
                .filter(Elements::notNull)
                .forEach(elements -> {
                    map.put(elements.getWeakness(), map.get(elements.getWeakness()) - 1);
                    map.put(elements.getResistance(), map.get(elements.getResistance()) + 1);
                });

        return map;
    }

    @Getter
    private static class Elements {

        private final Element weakness;
        private final Element resistance;

        private Elements(Armor armor) {
            this.weakness = armor.getWeakness();
            this.resistance = armor.getResistance();
        }

        private boolean notNull() {
            return weakness != null && resistance != null;
        }
    }

    @Override
    public String toString() {
        return "Solution{" +
                "weapon=" + weapon +
                ", head=" + head +
                ", torso=" + torso +
                ", arms=" + arms +
                ", legs=" + legs +
                ", lantern=" + lantern +
                ", perks=" + evaluate() +
                ", elements=" + getElements() +
                '}';
    }
}
