package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.perks.*;

import static com.synnks.dauntless.optimizer.model.Element.*;
import static com.synnks.dauntless.optimizer.model.perks.Defense.*;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.*;
import static com.synnks.dauntless.optimizer.model.perks.Power.AETHERHUNTER;
import static com.synnks.dauntless.optimizer.model.perks.Power.RAGE;
import static com.synnks.dauntless.optimizer.model.perks.Technique.ADRENALINE;
import static com.synnks.dauntless.optimizer.model.perks.Technique.PREDATOR;
import static com.synnks.dauntless.optimizer.model.perks.Utility.AETHERIC_FRENZY;
import static com.synnks.dauntless.optimizer.model.perks.Utility.CONDUIT;

public final class Legs extends Armor<Legs> {

    public static final Legs GNASHER_TREADS = new Legs("Gnasher Treads", TOUGH, Power.class, null, null);
    public static final Legs SHRIKEDOWN_GREAVES = new Legs("Shrikedown Greaves", BLOODLESS, Mobility.class, null, null);
    public static final Legs QUILLSPIKE_BOOTS = new Legs("Quillspike Boots", SHELLSHOCK_RESIST, Technique.class, null, null);
    public static final Legs PILLARS_OF_STONE = new Legs("Pillars of Stone", GUARDIAN, Defense.class, TERRA, SHOCK);
    public static final Legs VOLCANIC_TREADS = new Legs("Volcanic Treads", RAGE, Power.class, BLAZE, FROST);
    public static final Legs FIERY_GREAVES = new Legs("Fiery Greaves", EVASION, Defense.class, BLAZE, FROST);
    public static final Legs SKRAEVWING_BOOTS = new Legs("Skraevwing Boots", ADRENALINE, Utility.class, FROST, BLAZE);
    public static final Legs DRASKSCALE_GREAVES = new Legs("Draskscale Greaves", FLEET_FOOTED, Utility.class, SHOCK, TERRA);
    public static final Legs SHOCKING_STRIDE = new Legs("Shocking Stride", INSULATED, Defense.class, SHOCK, TERRA);
    public static final Legs FEET_OF_ICE = new Legs("Feet of Ice", WARMTH, Defense.class, FROST, BLAZE);
    public static final Legs HELLPLATE_GREAVES = new Legs("Hellplate Greaves", FORTRESS, Power.class, BLAZE, FROST);
    public static final Legs LIGHTNING_BOOTS = new Legs("Lightning Boots", AETHERIC_FRENZY, Mobility.class, SHOCK, TERRA);
    public static final Legs DANCE_OF_THE_SWARM = new Legs("Dance of the Swarm", CONDITIONING, Power.class, TERRA, SHOCK);
    public static final Legs LIGHTS_WALK = new Legs("Light's Walk", AGILITY, Mobility.class, RADIANT, UMBRAL);
    public static final Legs DARK_PATH = new Legs("Dark Path", NINE_LIVES, Utility.class, UMBRAL, RADIANT);
    public static final Legs STRIDE_OF_THORNS = new Legs("Stride of Thorns", PREDATOR, Utility.class, TERRA, SHOCK);
    public static final Legs STRIDE_OF_THE_RIFT = new Legs("Stride of the Rift", CONDUIT, Mobility.class, UMBRAL, RADIANT);
    public static final Legs GREAVES_OF_VALOUR = new Legs("Greaves of Valour", AETHERHUNTER, Utility.class, RADIANT, UMBRAL);
    public static final Legs BOREAL_MARCH = new Legs("Boreal March", ICEBORNE, Technique.class, FROST, BLAZE);

    private Legs(String name, Perk existingPerk, Perk socket, Class<? extends Perk> socketType, Element resistance, Element weakness) {
        super(name, existingPerk, socket, socketType, resistance, weakness);
    }

    private Legs(String name, Perk existingPerk, Class<? extends Perk> socketType, Element resistance, Element weakness) {
        this(name, existingPerk, null, socketType, resistance, weakness);
    }

    @Override
    Legs socket(Perk socket) {
        return new Legs(getName(), getExistingPerk(), socket, getSocketType(), getResistance().orElse(null), getWeakness().orElse(null));
    }
}
