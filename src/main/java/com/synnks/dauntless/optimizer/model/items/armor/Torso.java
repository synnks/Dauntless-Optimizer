package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.*;

import static com.synnks.dauntless.optimizer.model.Element.*;
import static com.synnks.dauntless.optimizer.model.perks.Defense.*;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.EVASION;
import static com.synnks.dauntless.optimizer.model.perks.Power.AETHERHUNTER;
import static com.synnks.dauntless.optimizer.model.perks.Power.RAGE;
import static com.synnks.dauntless.optimizer.model.perks.Technique.*;
import static com.synnks.dauntless.optimizer.model.perks.Utility.*;

public final class Torso<P extends Perk> extends Armor<P, Torso<P>> {

    public static final Torso<Defense> GNASHER_CLOAK = new Torso<>("Gnasher Cloak", TOUGH, Defense.class, null, null);
    public static final Torso<Mobility> SHRIKEDOWN_PLATE = new Torso<>("Shrikedown Plate", EVASION, Mobility.class, null, null);
    public static final Torso<Technique> QUILLSPIKE_JACKET = new Torso<>("Quillspike Mask", Technique.SAVAGERY, Technique.class, null, null);
    public static final Torso<Defense> HEART_OF_STONE = new Torso<>("Heart of Stone", GUARDIAN, Defense.class, TERRA, SHOCK);
    public static final Torso<Utility> VOLCANIC_AEGIS = new Torso<>("Volcanic Aegis", AETHERHUNTER, Utility.class, BLAZE, FROST);
    public static final Torso<Mobility> FIERY_BREASTPLATE = new Torso<>("Fiery Breastplate", EVASIVE_FURY, Mobility.class, BLAZE, FROST);
    public static final Torso<Mobility> SKRAEVWING_JACKET = new Torso<>("Skraevwing Jacket", ADRENALINE, Mobility.class, FROST, BLAZE);
    public static final Torso<Power> DRASKSCALE_PLATE = new Torso<>("Draskscale Plate", AETHERIC_ATTUNEMENT, Power.class, SHOCK, TERRA);
    public static final Torso<Defense> SHOCKING_HEART = new Torso<>("Shocking Heart", MEDIC, Defense.class, SHOCK, TERRA);
    public static final Torso<Power> CORE_OF_ICE = new Torso<>("Core of Ice", FORTRESS, Power.class, FROST, BLAZE);
    public static final Torso<Technique> HELLPLATE_CUIRASS = new Torso<>("Hellplate Cuirass", MOLTEN, Technique.class, BLAZE, FROST);
    public static final Torso<Mobility> LIGHTNING_PLATE = new Torso<>("Lightning Plate", ENERGIZED, Mobility.class, SHOCK, TERRA);
    public static final Torso<Technique> SHELL_OF_THE_SWARM = new Torso<>("Shell of the Swarm", BLADESTORM, Technique.class, TERRA, SHOCK);
    public static final Torso<Utility> LIGHTS_VIRTUE = new Torso<>("Light's Virtue", CUNNING, Utility.class, RADIANT, UMBRAL);
    public static final Torso<Power> DARK_MORROW = new Torso<>("Dark Morrow", RAGE, Power.class, UMBRAL, RADIANT);
    public static final Torso<Utility> MANTLE_OF_THORNS = new Torso<>("Mantle of Thorns", PREDATOR, Utility.class, TERRA, SHOCK);
    public static final Torso<Utility> MANTLE_OF_THE_RIFT = new Torso<>("Mantle of the Rift", CONDUIT, Utility.class, UMBRAL, RADIANT);
    public static final Torso<Power> AEGIS_OF_VALOUR = new Torso<>("Aegis of Valour", NINE_LIVES, Power.class, RADIANT, UMBRAL);
    public static final Torso<Defense> BOREAL_RESOLVE = new Torso<>("Boreal Resolve", RAGE, Defense.class, FROST, BLAZE);

    private Torso(String name, Perk existingPerk, Class<P> socketType, Element resistance, Element weakness) {
        super(name, existingPerk, socketType, resistance, weakness);
    }

    private Torso(String name, Perk existingPerk, Socket<P> socket, Element resistance, Element weakness) {
        super(name, existingPerk, socket, resistance, weakness);
    }

    @Override
    protected Torso<P> socket(P perk) {
        return new Torso<>(getName(), getPerk(), getSocket().socket(perk), getResistance(), getWeakness());
    }
}
