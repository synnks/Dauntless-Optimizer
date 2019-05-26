package com.synnks.dauntless.optimizer.model.items.armor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Getter
    private final Head head;
    @Getter
    private final Torso torso;
    @Getter
    private final Arms arms;
    @Getter
    private final Legs legs;

    public static Set<Head> getAllHeads() {
        return get(ArmorSet::getHead);
    }

    public static Set<Torso> getAllTorsos() {
        return get(ArmorSet::getTorso);
    }

    public static Set<Arms> getAllArms() {
        return get(ArmorSet::getArms);
    }

    public static Set<Legs> getAllLegs() {
        return get(ArmorSet::getLegs);
    }

    private static <Type extends Armor<Type>> Set<Type> get(Function<ArmorSet, Type> mapper) {
        return Arrays.stream(values())
                .map(mapper)
                .map(Armor::getAllFlavours)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableSet());
    }
}
