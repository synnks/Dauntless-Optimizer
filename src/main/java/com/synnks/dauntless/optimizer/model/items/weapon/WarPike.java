package com.synnks.dauntless.optimizer.model.items.weapon;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.*;

import static com.synnks.dauntless.optimizer.model.Element.*;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.CONDITIONING;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.NIMBLE;
import static com.synnks.dauntless.optimizer.model.perks.Power.*;
import static com.synnks.dauntless.optimizer.model.perks.Technique.*;
import static com.synnks.dauntless.optimizer.model.perks.Utility.AETHERIC_ATTUNEMENT;
import static com.synnks.dauntless.optimizer.model.perks.Utility.ENERGIZED;

public final class WarPike<P1 extends Perk, P2 extends Perk> extends Weapon<P1, P2> {

    public static final WarPike<Technique, Utility> RAGING_CRUELTY = new WarPike<>("Raging Cruelty", RAGEHUNTER, null, Technique.class, Utility.class, null);
    public static final WarPike<Technique, Mobility> SCREAM_OF_THE_SHRIKE = new WarPike<>("Scream of the Shrike", CONDITIONING, UniqueEffect.SHRIKE, Technique.class, Mobility.class, null);
    public static final WarPike<Technique, Defense> QUILLSHOTS_JAVELIN = new WarPike<>("Quillshot's Javelin", ACIDIC, null, Technique.class, Defense.class, null);
    public static final WarPike<Technique, Defense> SKARNS_SPITE = new WarPike<>("Skarn's Spite", WEIGHTED_STRIKES, UniqueEffect.SKARN, Technique.class, Defense.class, TERRA);
    public static final WarPike<Technique, Defense> CHARRED_SPEAR = new WarPike<>("Charred Spear", AETHERHUNTER, null, Technique.class, Defense.class, BLAZE);
    public static final WarPike<Technique, Mobility> WINTER_VORTEX = new WarPike<>("Winter Vortex", NIMBLE, UniqueEffect.SKRAEV, Technique.class, Mobility.class, FROST);
    public static final WarPike<Power, Mobility> EMBER_PIKE = new WarPike<>("Ember Pike", EVASIVE_FURY, UniqueEffect.EMBERMANE, Power.class, Mobility.class, BLAZE);
    public static final WarPike<Technique, Power> THUNDERING_SPEAR = new WarPike<>("Thundering Spear", AETHERIC_ATTUNEMENT, UniqueEffect.DRASK, Technique.class, Power.class, SHOCK);
    public static final WarPike<Utility, Mobility> NAYZAGAS_FANG = new WarPike<>("Nayzaga's Fang", BARBED, UniqueEffect.NAYZAGA, Utility.class, Mobility.class, SHOCK);
    public static final WarPike<Technique, Defense> PANGARS_TOOTH = new WarPike<>("Pangar's Tooth", WEIGHTED_STRIKES, null, Technique.class, Defense.class, FROST);
    public static final WarPike<Technique, Defense> INFERNOS_ARROW = new WarPike<>("Inferno's Arrow", OVERPOWER, UniqueEffect.HELLION, Technique.class, Defense.class, BLAZE);
    public static final WarPike<Technique, Mobility> STORM_PIKE = new WarPike<>("Storm Pike", ENERGIZED, UniqueEffect.STORMCLAW, Technique.class, Mobility.class, SHOCK);
    public static final WarPike<Technique, Mobility> KHARABAKS_STING = new WarPike<>("Kharabak's Sting", BLADESTORM, UniqueEffect.KHARABAK, Technique.class, Mobility.class, TERRA);
    public static final WarPike<Technique, Power> SPIRE_OF_DAWN = new WarPike<>("Spire of Dawn", CUNNING, UniqueEffect.REZAKIRI, Technique.class, Power.class, RADIANT);
    public static final WarPike<Technique, Utility> GYRE_OF_NIGHT = new WarPike<>("Gyre of Night", CUNNING, UniqueEffect.SHROWD, Technique.class, Utility.class, UMBRAL);
    public static final WarPike<Power, Utility> SOVEREIGNS_SORROW = new WarPike<>("Sovereign's Sorrow", SHARPENED, UniqueEffect.KOSHAI, Power.class, Utility.class, TERRA);
    public static final WarPike<Technique, Utility> STALKERS_SPIKE = new WarPike<>("Stalker's Spike", WILD_FRENZY, UniqueEffect.RIFTSTALKER, Technique.class, Utility.class, UMBRAL);
    public static final WarPike<Power, Utility> VALOMYRS_HOPE = new WarPike<>("Valomyr's Hope", AETHERHUNTER, UniqueEffect.VALOMYR, Power.class, Utility.class, RADIANT);
    public static final WarPike<Power, Defense> REVOLUTION_OF_BOREUS = new WarPike<>("Revolution of Boreus", CONDITIONING, UniqueEffect.BOREUS, Power.class, Defense.class, FROST);

    public static final WarPike<Power, Technique> THE_GODHAND = new WarPike<>("The Godhand", null, UniqueEffect.THE_GODHAND, Power.class, Technique.class, RADIANT);

    public WarPike(String name, Perk perk, UniqueEffect uniqueEffect, Class<P1> socket1Type, Class<P2> socket2Type, Element element) {
        super(name, perk, uniqueEffect, socket1Type, socket2Type, element);
    }

    private WarPike(String name, Perk perk, UniqueEffect uniqueEffect, Socket<P1> socket1, Socket<P2> socket2, Element element) {
        super(name, perk, uniqueEffect, socket1, socket2, element);
    }

    @Override
    protected WarPike<P1, P2> socket(P1 perk1, P2 perk2) {
        return new WarPike<>(getName(), getPerk(), getUniqueEffect(), getSocket1().socket(perk1), getSocket2().socket(perk2), getElement());
    }
}
