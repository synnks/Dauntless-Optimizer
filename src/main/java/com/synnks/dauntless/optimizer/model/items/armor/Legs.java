package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Socket;
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

public final class Legs<P extends Perk> extends Armor<P, Legs<P>> {

    public static final Legs<Power> GNASHER_TREADS = new Legs<>("Gnasher Treads", TOUGH, Power.class, null, null);
    public static final Legs<Mobility> SHRIKEDOWN_GREAVES = new Legs<>("Shrikedown Greaves", BLOODLESS, Mobility.class, null, null);
    public static final Legs<Technique> QUILLSPIKE_BOOTS = new Legs<>("Quillspike Boots", SHELLSHOCK_RESIST, Technique.class, null, null);
    public static final Legs<Defense> PILLARS_OF_STONE = new Legs<>("Pillars of Stone", GUARDIAN, Defense.class, TERRA, SHOCK);
    public static final Legs<Power> VOLCANIC_TREADS = new Legs<>("Volcanic Treads", RAGE, Power.class, BLAZE, FROST);
    public static final Legs<Defense> FIERY_GREAVES = new Legs<>("Fiery Greaves", EVASION, Defense.class, BLAZE, FROST);
    public static final Legs<Utility> SKRAEVWING_BOOTS = new Legs<>("Skraevwing Boots", ADRENALINE, Utility.class, FROST, BLAZE);
    public static final Legs<Utility> DRASKSCALE_GREAVES = new Legs<>("Draskscale Greaves", FLEET_FOOTED, Utility.class, SHOCK, TERRA);
    public static final Legs<Defense> SHOCKING_STRIDE = new Legs<>("Shocking Stride", INSULATED, Defense.class, SHOCK, TERRA);
    public static final Legs<Defense> FEET_OF_ICE = new Legs<>("Feet of Ice", WARMTH, Defense.class, FROST, BLAZE);
    public static final Legs<Power> HELLPLATE_GREAVES = new Legs<>("Hellplate Greaves", FORTRESS, Power.class, BLAZE, FROST);
    public static final Legs<Mobility> LIGHTNING_BOOTS = new Legs<>("Lightning Boots", AETHERIC_FRENZY, Mobility.class, SHOCK, TERRA);
    public static final Legs<Power> DANCE_OF_THE_SWARM = new Legs<>("Dance of the Swarm", CONDITIONING, Power.class, TERRA, SHOCK);
    public static final Legs<Mobility> LIGHTS_WALK = new Legs<>("Light's Walk", AGILITY, Mobility.class, RADIANT, UMBRAL);
    public static final Legs<Utility> DARK_PATH = new Legs<>("Dark Path", NINE_LIVES, Utility.class, UMBRAL, RADIANT);
    public static final Legs<Utility> STRIDE_OF_THORNS = new Legs<>("Stride of Thorns", PREDATOR, Utility.class, TERRA, SHOCK);
    public static final Legs<Mobility> STRIDE_OF_THE_RIFT = new Legs<>("Stride of the Rift", CONDUIT, Mobility.class, UMBRAL, RADIANT);
    public static final Legs<Utility> GREAVES_OF_VALOUR = new Legs<>("Greaves of Valour", AETHERHUNTER, Utility.class, RADIANT, UMBRAL);
    public static final Legs<Technique> BOREAL_MARCH = new Legs<>("Boreal March", ICEBORNE, Technique.class, FROST, BLAZE);

    private Legs(String name, Perk existingPerk, Class<P> socketType, Element resistance, Element weakness) {
        super(name, existingPerk, socketType, resistance, weakness);
    }

    private Legs(String name, Perk existingPerk, Socket<P> socket, Element resistance, Element weakness) {
        super(name, existingPerk, socket, resistance, weakness);
    }

    @Override
    protected Legs<P> socket(P perk) {
        return new Legs<>(getName(), getPerk(), getSocket().socket(perk), getResistance(), getWeakness());
    }
}
