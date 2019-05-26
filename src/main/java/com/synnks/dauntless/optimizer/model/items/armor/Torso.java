package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.perks.*;

import static com.synnks.dauntless.optimizer.model.Element.*;
import static com.synnks.dauntless.optimizer.model.perks.Defense.*;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.EVASION;
import static com.synnks.dauntless.optimizer.model.perks.Power.AETHERHUNTER;
import static com.synnks.dauntless.optimizer.model.perks.Power.RAGE;
import static com.synnks.dauntless.optimizer.model.perks.Technique.*;
import static com.synnks.dauntless.optimizer.model.perks.Utility.*;

public final class Torso extends Armor<Torso> {

    public static final Torso GNASHER_CLOAK = new Torso("Gnasher Cloak", TOUGH, Defense.class, null, null);
    public static final Torso SHRIKEDOWN_PLATE = new Torso("Shrikedown Plate", EVASION, Mobility.class, null, null);
    public static final Torso QUILLSPIKE_JACKET = new Torso("Quillspike Mask", Technique.SAVAGERY, Technique.class, null, null);
    public static final Torso HEART_OF_STONE = new Torso("Heart of Stone", GUARDIAN, Defense.class, TERRA, SHOCK);
    public static final Torso VOLCANIC_AEGIS = new Torso("Volcanic Aegis", AETHERHUNTER, Utility.class, BLAZE, FROST);
    public static final Torso FIERY_BREASTPLATE = new Torso("Fiery Breastplate", EVASIVE_FURY, Mobility.class, BLAZE, FROST);
    public static final Torso SKRAEVWING_JACKET = new Torso("Skraevwing Jacket", ADRENALINE, Mobility.class, FROST, BLAZE);
    public static final Torso DRASKSCALE_PLATE = new Torso("Draskscale Plate", AETHERIC_ATTUNEMENT, Power.class, SHOCK, TERRA);
    public static final Torso SHOCKING_HEART = new Torso("Shocking Heart", MEDIC, Defense.class, SHOCK, TERRA);
    public static final Torso CORE_OF_ICE = new Torso("Core of Ice", FORTRESS, Power.class, FROST, BLAZE);
    public static final Torso HELLPLATE_CUIRASS = new Torso("Hellplate Cuirass", MOLTEN, Technique.class, BLAZE, FROST);
    public static final Torso LIGHTNING_PLATE = new Torso("Lightning Plate", ENERGIZED, Mobility.class, SHOCK, TERRA);
    public static final Torso SHELL_OF_THE_SWARM = new Torso("Shell of the Swarm", BLADESTORM, Technique.class, TERRA, SHOCK);
    public static final Torso LIGHTS_VIRTUE = new Torso("Light's Virtue", CUNNING, Utility.class, RADIANT, UMBRAL);
    public static final Torso DARK_MORROW = new Torso("Dark Morrow", RAGE, Power.class, UMBRAL, RADIANT);
    public static final Torso MANTLE_OF_THORNS = new Torso("Mantle of Thorns", PREDATOR, Utility.class, TERRA, SHOCK);
    public static final Torso MANTLE_OF_THE_RIFT = new Torso("Mantle of the Rift", CONDUIT, Utility.class, UMBRAL, RADIANT);
    public static final Torso AEGIS_OF_VALOUR = new Torso("Aegis of Valour", NINE_LIVES, Power.class, RADIANT, UMBRAL);
    public static final Torso BOREAL_RESOLVE = new Torso("Boreal Resolve", RAGE, Defense.class, FROST, BLAZE);

    private Torso(String name, Perk existingPerk, Perk socket, Class<? extends Perk> socketType, Element resistance, Element weakness) {
        super(name, existingPerk, socket, socketType, resistance, weakness);
    }

    private Torso(String name, Perk existingPerk, Class<? extends Perk> socketType, Element resistance, Element weakness) {
        this(name, existingPerk, null, socketType, resistance, weakness);
    }

    @Override
    Torso socket(Perk socket) {
        return new Torso(getName(), getExistingPerk(), socket, getSocketType(), getResistance().orElse(null), getWeakness().orElse(null));
    }
}
