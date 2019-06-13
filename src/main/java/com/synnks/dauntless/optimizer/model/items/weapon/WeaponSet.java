package com.synnks.dauntless.optimizer.model.items.weapon;

import com.synnks.dauntless.optimizer.model.perks.Perk;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.synnks.dauntless.optimizer.model.items.weapon.Axe.*;
import static com.synnks.dauntless.optimizer.model.items.weapon.ChainBlades.*;
import static com.synnks.dauntless.optimizer.model.items.weapon.Hammer.*;
import static com.synnks.dauntless.optimizer.model.items.weapon.Sword.*;
import static com.synnks.dauntless.optimizer.model.items.weapon.WarPike.*;

@RequiredArgsConstructor
public enum WeaponSet {

    GNASHER(RAGING_BITE, RAGING_TEETH, RAGING_CRASH, RAGING_BLADE, RAGING_CRUELTY),
    SHRIKE(SONG_OF_THE_SHRIKE, FLIGHT_OF_THE_SHRIKE, FALL_OF_THE_SHRIKE, CRY_OF_THE_SHRIKE, SCREAM_OF_THE_SHRIKE),
    QUILLSHOT(QUILLSHOTS_FURY, QUILLSHOTS_BONEHOOKS, QUILLSHOTS_ROAR, QUILLSHOTS_TUSK, QUILLSHOTS_JAVELIN),
    SKARN(SKARNS_JUDGEMENT, SKARNS_MALICE, SKARNS_VENGEANCE, SKARNS_RANCOR, SKARNS_SPITE),
    CHAROGG(CHARRED_CLEAVER, CHARRED_BLADES, CHARRED_CRUSHER, CHARRED_SABER, CHARRED_SPEAR),
    EMBERMANE(EMBER_SCYTHE, EMBER_BLADES, EMBER_MAUL, EMBER_CUTLASS, EMBER_PIKE),
    SKRAEV(WINTER_GALE, WINTER_WINDS, WINTER_SQUALL, WINTER_ICE, WINTER_VORTEX),
    DRASK(THUNDERING_SCYTHE, THUNDERING_CUTTERS, THUNDERING_MAUL, THUNDERING_BLADE, THUNDERING_SPEAR),
    NAYZAGA(NAYZAGAS_SCYTHE, NAYZAGAS_REACH, NAYZAGAS_CHARGE, NAYZAGAS_RAZOR, NAYZAGAS_FANG),
    PANGAR(PANGARS_GRACE, PANGARS_CLAWS, PANGARS_RAMPAGE, PANGARS_CALL, PANGARS_TOOTH),
    HELLION(INFERNOS_DECREE, INFERNOS_FANGS, INFERNOS_BURDEN, INFERNOS_RAZOR, INFERNOS_ARROW),
    STORMCLAW(STORM_CUTTER, STORM_BLADES, STORM_HAMMER, STORM_SWORD, STORM_PIKE),
    KHARABAK(KHARABAKS_CLAW, KHARABAKS_WINGS, KHARABAKS_JAW, KHARABAKS_SPUR, KHARABAKS_STING),
    REZAKIRI(EDGE_OF_DAWN, FANGS_OF_DAWN, BREAK_OF_DAWN, CALL_OF_DAWN, SPIRE_OF_DAWN),
    SHROWD(REAPER_OF_NIGHT, EYES_OF_NIGHT, FALL_OF_NIGHT, VERGE_OF_NIGHT, GYRE_OF_NIGHT),
    KOSHAI(SOVEREIGNS_WRATH, SOVEREIGNS_LASH, SOVEREIGNS_GRUDGE, SOVEREIGNS_TORMENT, SOVEREIGNS_SORROW),
    RIFTSTALKER(STALKERS_MERCY, STALKERS_TRAP, STALKERS_PRICE, STALKERS_STRIKE, STALKERS_SPIKE),
    VALOMYR(VALOMYRS_DECREE, VALOMYRS_REVENGE, VALOMYRS_BURDEN, VALOMYRS_REGARD, VALOMYRS_HOPE),
    BOREUS(TURMOIL_OF_BOREUS, DESTINY_OF_BOREUS, BRUTALITY_OF_BOREUS, ONUS_OF_BOREUS, REVOLUTION_OF_BOREUS);

    @Getter(AccessLevel.PRIVATE)
    private final Axe<? extends Perk, ? extends Perk> axe;
    @Getter(AccessLevel.PRIVATE)
    private final ChainBlades<? extends Perk, ? extends Perk> chainBlades;
    @Getter(AccessLevel.PRIVATE)
    private final Hammer<? extends Perk, ? extends Perk> hammer;
    @Getter(AccessLevel.PRIVATE)
    private final Sword<? extends Perk, ? extends Perk> sword;
    @Getter(AccessLevel.PRIVATE)
    private final WarPike<? extends Perk, ? extends Perk> warPike;

    public static Collection<? extends Weapon> getAllWeapons() {
        return Arrays.stream(values())
                .map(weaponSet -> Stream.of(
                        weaponSet.getAxe(),
                        weaponSet.getChainBlades(),
                        weaponSet.getHammer(),
                        weaponSet.getSword(),
                        weaponSet.getWarPike()))
                .flatMap(Function.identity())
                .map(Weapon::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<? extends Weapon> getAllAxes() {
        return Arrays.stream(values())
                .map(WeaponSet::getAxe)
                .map(Weapon::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<? extends Weapon> getAllChainBlades() {
        return Arrays.stream(values())
                .map(WeaponSet::getChainBlades)
                .map(Weapon::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<? extends Weapon> getAllHammers() {
        return Stream.concat(Stream.of(MOLTEN_EDICT), Arrays.stream(values()).map(WeaponSet::getHammer))
                .map(Weapon::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<? extends Weapon> getAllSwords() {
        return Stream.concat(Stream.of(THE_HUNGER), Arrays.stream(values()).map(WeaponSet::getSword))
                .map(Weapon::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<? extends Weapon> getAllWarPikes() {
        return Stream.concat(Stream.of(THE_GODHAND), Arrays.stream(values()).map(WeaponSet::getWarPike))
                .map(Weapon::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<? extends Weapon> getAllRepeaters() {
        return Stream.of(Repeaters.GENERIC_REPEATERS)
                .map(Weapon::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }
}
