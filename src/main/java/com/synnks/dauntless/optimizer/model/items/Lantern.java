package com.synnks.dauntless.optimizer.model.items;

import com.synnks.dauntless.optimizer.model.perks.Perk;
import com.synnks.dauntless.optimizer.model.perks.Utility;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lantern implements Equipment {

    public static final Lantern DRASKS_EYE = new Lantern("Drask's Eye");
    public static final Lantern EMBERMANES_RAPTURE = new Lantern("Embermane's Rapture");
    public static final Lantern PANGARS_SHINE = new Lantern("Pangar's Shine");
    public static final Lantern SHRIKES_ZEAL = new Lantern("Shrike's Zeal");
    public static final Lantern SKARNS_DEFIANCE = new Lantern("Skarn's Defiance");
    public static final Lantern KOSHAIS_BLOOM = new Lantern("Koshai's Bloom");

    @Getter
    private final String name;
    @Getter(AccessLevel.PRIVATE)
    private final Socket<Utility> socket;

    private Lantern(String name) {
        this.name = name;
        this.socket = Socket.of(Utility.class);
    }

    private Lantern(String name, Socket<Utility> socket) {
        this.name = name;
        this.socket = socket;
    }

    @Override
    public Map<Perk, Integer> getAllPerks() {
        return getSocket().getPerk().map(perk -> Map.<Perk, Integer>of(perk, 1)).orElse(Collections.emptyMap());
    }

    public Set<Lantern> getAllFlavours() {
        return getSocket().getAllPerks().stream()
                .map(this::socket)
                .collect(Collectors.toUnmodifiableSet());
    }

    public Lantern socket(Utility perk) {
        return new Lantern(getName(), getSocket().socket(perk));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Lantern lantern = (Lantern) o;
        return Objects.equals(name, lantern.name) &&
                Objects.equals(socket, lantern.socket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, socket);
    }

    @Override
    public String toString() {
        return "Lantern{" +
                "name='" + name + '\'' +
                ", socket=" + socket +
                '}';
    }

    public static Set<Lantern> getAllLanterns() {
        return Stream.of(DRASKS_EYE, EMBERMANES_RAPTURE, PANGARS_SHINE, SHRIKES_ZEAL, SKARNS_DEFIANCE, KOSHAIS_BLOOM)
                .map(Lantern::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }
}
