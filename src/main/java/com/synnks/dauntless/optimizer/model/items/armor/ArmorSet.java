package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.perks.Perk;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.synnks.dauntless.optimizer.model.items.armor.Arms.*;
import static com.synnks.dauntless.optimizer.model.items.armor.Head.*;
import static com.synnks.dauntless.optimizer.model.items.armor.Legs.*;
import static com.synnks.dauntless.optimizer.model.items.armor.Torso.*;

@RequiredArgsConstructor
public enum ArmorSet {

    GNASHER(GNASHER_CAP, GNASHER_CLOAK, GNASHER_GRIPS, GNASHER_TREADS),
    SHRIKE(SHRIKEDOWN_HELM, SHRIKEDOWN_PLATE, SHRIKEDOWN_GLOVES, SHRIKEDOWN_GREAVES),
    QUILLSHOT(QUILLSPIKE_MASK, QUILLSPIKE_JACKET, QUILLSPIKE_GRIPS, QUILLSPIKE_BOOTS),
    SKARN(SIGHT_OF_STONE, HEART_OF_STONE, MIGHT_OF_STONE, PILLARS_OF_STONE),
    CHAROGG(VOLCANIC_HELM, VOLCANIC_AEGIS, VOLCANIC_GRIPS, VOLCANIC_TREADS),
    EMBERMANE(FIERY_HELM, FIERY_BREASTPLATE, FIERY_GAUNTLETS, FIERY_GREAVES),
    SKRAEV(SKRAEVWING_HELMET, SKRAEVWING_JACKET, SKRAEVWING_GLOVES, SKRAEVWING_BOOTS),
    DRASK(DRASKSCALE_HELMET, DRASKSCALE_PLATE, DRASKSCALE_GAUNTLETS, DRASKSCALE_GREAVES),
    NAYZAGA(SHOCKING_GAZE, SHOCKING_HEART, SHOCKING_GRASP, SHOCKING_STRIDE),
    PANGAR(BROW_OF_ICE, CORE_OF_ICE, ARMS_OF_ICE, FEET_OF_ICE),
    HELLION(HELLPLATE_CASQUE, HELLPLATE_CUIRASS, HELLPLATE_BRACERS, HELLPLATE_GREAVES),
    STORMCLAW(LIGHTNING_HELM, LIGHTNING_PLATE, LIGHTNING_GLOVES, LIGHTNING_BOOTS),
    KHARABAK(EYE_OF_THE_SWARM, SHELL_OF_THE_SWARM, CLUTCHES_OF_THE_SWARM, DANCE_OF_THE_SWARM),
    REZAKIRI(LIGHTS_CROWN, LIGHTS_VIRTUE, LIGHTS_REFUGE, LIGHTS_WALK),
    SHROWD(DARK_WATCH, DARK_MORROW, DARK_EMBRACE, DARK_PATH),
    KOSHAI(VISAGE_OF_THORNS, MANTLE_OF_THORNS, GRASP_OF_THORNS, STRIDE_OF_THORNS),
    RIFTSTALKER(GUISE_OF_THE_RIFT, MANTLE_OF_THE_RIFT, HANDS_OF_THE_RIFT, STRIDE_OF_THE_RIFT),
    VALOMYR(CREST_OF_VALOUR, AEGIS_OF_VALOUR, GAUNTLETS_OF_VALOUR, GREAVES_OF_VALOUR),
    BOREUS(BOREAL_EPIPHANY, BOREAL_RESOLVE, BOREAL_MIGHT, BOREAL_MARCH);

    @Getter(AccessLevel.PRIVATE)
    private final Head<? extends Perk> head;
    @Getter(AccessLevel.PRIVATE)
    private final Torso<? extends Perk> torso;
    @Getter(AccessLevel.PRIVATE)
    private final Arms<? extends Perk> arms;
    @Getter(AccessLevel.PRIVATE)
    private final Legs<? extends Perk> legs;

    public static Collection<Head> getAllHeads() {
        return Stream.concat(
                Stream.of(PRISMATIC_GRACE, TRAGIC_ECHO, THE_SKULLFORGE)
                        .map(Armor::getAllFlavours)
                        .flatMap(Collection::stream),
                Arrays.stream(values())
                        .map(ArmorSet::getHead)
                        .map(Armor::getAllFlavours)
                        .flatMap(Collection::stream))
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<Torso> getAllTorsos() {
        return Arrays.stream(values())
                .map(ArmorSet::getTorso)
                .map(Armor::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<Arms> getAllArms() {
        return Arrays.stream(values())
                .map(ArmorSet::getArms)
                .map(Armor::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }

    public static Collection<Legs> getAllLegs() {
        return Arrays.stream(values())
                .map(ArmorSet::getLegs)
                .map(Armor::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }
}
