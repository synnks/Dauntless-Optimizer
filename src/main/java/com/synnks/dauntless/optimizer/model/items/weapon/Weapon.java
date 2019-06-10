package com.synnks.dauntless.optimizer.model.items.weapon;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Equipment;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import com.synnks.dauntless.optimizer.model.perks.UniqueEffect;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Weapon<P1 extends Enum & Perk, P2 extends Enum & Perk, Type extends Weapon<P1, P2, Type>> implements Equipment<Type>, Comparable<Weapon<?, ?, ?>> {

    @Getter
    private final String name;
    @Getter(AccessLevel.PACKAGE)
    private final Perk perk;
    @Getter(AccessLevel.PACKAGE)
    private final UniqueEffect uniqueEffect;
    @Getter(AccessLevel.PACKAGE)
    private final Socket<P1> socket1;
    @Getter(AccessLevel.PACKAGE)
    private final Socket<P2> socket2;
    @Getter(AccessLevel.PACKAGE)
    private final Element element;

    public Weapon(String name, Perk perk, UniqueEffect uniqueEffect, Class<P1> socket1Type, Class<P2> socket2Type, Element element) {
        this.name = name;
        this.perk = perk;
        this.uniqueEffect = uniqueEffect;
        this.socket1 = Socket.of(socket1Type);
        this.socket2 = Socket.of(socket2Type);
        this.element = element;
    }

    protected Weapon(String name, Perk perk, UniqueEffect uniqueEffect, Socket<P1> socket1, Socket<P2> socket2, Element element) {
        this.name = name;
        this.perk = perk;
        this.uniqueEffect = uniqueEffect;
        this.socket1 = socket1;
        this.socket2 = socket2;
        this.element = element;
    }

    @Override
    public Map<Perk, Integer> getAllPerks() {
        return Stream.of(getPerk(), getUniqueEffect(), getSocket1().getPerk().orElse(null), getSocket2().getPerk().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), perk -> 1, Integer::sum));
    }

    @Override
    public int compareTo(Weapon<?, ?, ?> o) {
        var result = getName().compareTo(o.getName());
        if (result == 0) {
            result = getPerk().compare(o.getPerk());
        }
        if (result == 0) {
            result = getSocket1().compareTo(o.getSocket1());
        }
        if (result == 0) {
            result = getSocket2().compareTo(o.getSocket2());
        }
        return result;
    }

    public abstract Type socket(P1 perk1, P2 perk2);

    @Override
    public Set<Type> getAllFlavours() {
        final var flavours = new HashSet<Type>();
        for (var p1 : getSocket1().getAllPerks()) {
            for (var p2 : getSocket2().getAllPerks()) {
                flavours.add(socket(p1, p2));
            }
        }
        return Collections.unmodifiableSet(flavours);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final var weapon = (Weapon<?, ?, ?>) o;
        return Objects.equals(name, weapon.name) &&
                Objects.equals(perk, weapon.perk) &&
                Objects.equals(socket1, weapon.socket1) &&
                Objects.equals(socket2, weapon.socket2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, perk, socket1, socket2);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", perk=" + perk +
                ", uniqueEffect=" + uniqueEffect +
                ", socket1=" + socket1 +
                ", socket2=" + socket2 +
                ", element=" + element +
                '}';
    }
}
