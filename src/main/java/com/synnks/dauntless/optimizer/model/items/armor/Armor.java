package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Equipment;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Armor<P extends Enum & Perk, Type extends Armor<P, Type>> implements Equipment<Type>, Comparable<Armor<?, ?>> {

    @Getter
    private final String name;
    @Getter(AccessLevel.PACKAGE)
    private final Perk perk;
    @Getter(AccessLevel.PACKAGE)
    private final Socket<P> socket;
    @Getter(AccessLevel.PACKAGE)
    private final Element weakness;
    @Getter(AccessLevel.PACKAGE)
    private final Element resistance;

    public Armor(String name, Perk perk, Class<P> socketType, Element weakness, Element resistance) {
        this.name = name;
        this.perk = perk;
        this.socket = Socket.of(socketType);
        this.weakness = weakness;
        this.resistance = resistance;
    }

    protected Armor(String name, Perk perk, Socket<P> socket, Element weakness, Element resistance) {
        this.name = name;
        this.perk = perk;
        this.socket = socket;
        this.weakness = weakness;
        this.resistance = resistance;
    }

    @Override
    public Map<Perk, Integer> getAllPerks() {
        return Stream.of(getPerk(), getSocket().getPerk().orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Function.identity(), perk -> 1, Integer::sum));
    }

    @Override
    public int compareTo(Armor<?, ?> o) {
        var result = getName().compareTo(o.getName());
        if (result == 0) {
            result = getPerk().compare(o.getPerk());
        }
        if (result == 0) {
            result = getSocket().compareTo(o.getSocket());
        }
        return result;
    }

    public abstract Type socket(P perk);

    public Set<Type> getAllFlavours() {
        return getSocket().getAllPerks().stream()
                .map(this::socket)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final var armor = (Armor<?, ?>) o;
        return Objects.equals(name, armor.name) &&
                Objects.equals(perk, armor.perk) &&
                Objects.equals(socket, armor.socket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, perk, socket);
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", perk=" + perk +
                ", socket=" + socket +
                ", weakness=" + weakness +
                ", resistance=" + resistance +
                '}';
    }
}
