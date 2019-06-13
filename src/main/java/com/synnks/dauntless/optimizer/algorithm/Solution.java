package com.synnks.dauntless.optimizer.algorithm;

import com.synnks.dauntless.optimizer.model.items.Equipment;
import com.synnks.dauntless.optimizer.model.items.Lantern;
import com.synnks.dauntless.optimizer.model.items.armor.Arms;
import com.synnks.dauntless.optimizer.model.items.armor.Head;
import com.synnks.dauntless.optimizer.model.items.armor.Legs;
import com.synnks.dauntless.optimizer.model.items.armor.Torso;
import com.synnks.dauntless.optimizer.model.items.weapon.Weapon;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class Solution {

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

    public Map<Perk, Integer> evaluate() {
        return Stream.of(getWeapon(), getHead(), getTorso(), getArms(), getLegs(), getLantern())
                .filter(Objects::nonNull)
                .map(Equipment::getAllPerks)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));
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
                '}';
    }
}
