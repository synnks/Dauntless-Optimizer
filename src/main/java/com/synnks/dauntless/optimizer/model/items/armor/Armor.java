package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public abstract class Armor<Type extends Armor<Type>> implements Comparable<Armor> {

    @Getter
    private final String name;
    @Getter(AccessLevel.PACKAGE)
    private final Perk existingPerk;
    @Getter(AccessLevel.PACKAGE)
    private final Perk socket;
    @Getter(AccessLevel.PACKAGE)
    private final Class<? extends Perk> socketType;
    private final Element weakness;
    private final Element resistance;

    public Optional<Element> getResistance() {
        return Optional.ofNullable(resistance);
    }

    public Optional<Element> getWeakness() {
        return Optional.ofNullable(weakness);
    }

    @Override
    public int compareTo(Armor o) {
        int result = getName().compareTo(o.getName());
        if (result == 0) {
            result = getExistingPerk().compare(o.getExistingPerk());
        }
        if (result == 0) {
            result = getSocket() != null && o.getSocket() != null ? getSocket().compare(o.getSocket()) : 0;
        }
        return result;
    }

    abstract Type socket(Perk socket);

    public Set<Type> getAllFlavours() {
        return Arrays.stream(getSocketType().getEnumConstants())
                .map(this::socket)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armor<?> armor = (Armor<?>) o;
        return Objects.equals(name, armor.name) &&
                Objects.equals(existingPerk, armor.existingPerk) &&
                Objects.equals(socket, armor.socket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, existingPerk, socket);
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", existingPerk=" + existingPerk +
                (socket != null ? ", socket=" + socket : "") +
                ", weakness=" + weakness +
                ", resistance=" + resistance +
                '}';
    }
}
