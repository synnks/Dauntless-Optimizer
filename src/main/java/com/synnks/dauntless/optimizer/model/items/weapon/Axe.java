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

public final class Axe<P1 extends Enum & Perk, P2 extends Enum & Perk> extends Weapon<P1, P2, Axe<P1, P2>> {

    public static final Axe<Power, Utility> RAGING_BITE = new Axe<>("Raging Bite", RAGEHUNTER, null, Power.class, Utility.class, null);
    public static final Axe<Power, Mobility> SONG_OF_THE_SHRIKE = new Axe<>("Song of the Shrike", CONDITIONING, UniqueEffect.SHRIKE, Power.class, Mobility.class, null);
    public static final Axe<Power, Defense> QUILLSHOTS_FURY = new Axe<>("Quillshot's Fury", ACIDIC, null, Power.class, Defense.class, null);
    public static final Axe<Power, Defense> SKARNS_JUDGEMENT = new Axe<>("Skarn's Judgement", KNOCKOUT_KING, UniqueEffect.SKARN, Power.class, Defense.class, TERRA);
    public static final Axe<Power, Defense> CHARRED_CLEAVER = new Axe<>("Charred Cleaver", AETHERHUNTER, null, Power.class, Defense.class, BLAZE);
    public static final Axe<Power, Mobility> EMBER_SCYTHE = new Axe<>("Ember Scythe", EVASIVE_FURY, UniqueEffect.EMBERMANE, Power.class, Mobility.class, BLAZE);
    public static final Axe<Power, Mobility> WINTER_GALE = new Axe<>("Winter Gale", NIMBLE, UniqueEffect.SKRAEV, Power.class, Mobility.class, FROST);
    public static final Axe<Power, Defense> THUNDERING_SCYTHE = new Axe<>("Thundering Scythe", AETHERIC_ATTUNEMENT, UniqueEffect.DRASK, Power.class, Defense.class, SHOCK);
    public static final Axe<Power, Utility> NAYZAGAS_SCYTHE = new Axe<>("Nayzaga's Scythe", SAVAGERY, UniqueEffect.NAYZAGA, Power.class, Utility.class, SHOCK);
    public static final Axe<Power, Defense> PANGARS_GRACE = new Axe<>("Pangar's Grace", KNOCKOUT_KING, null, Power.class, Defense.class, FROST);
    public static final Axe<Power, Power> INFERNOS_DECREE = new Axe<>("Inferno's Decree", OVERPOWER, UniqueEffect.HELLION, Power.class, Power.class, BLAZE);
    public static final Axe<Power, Mobility> STORM_CUTTER = new Axe<>("Storm Cutter", ENERGIZED, UniqueEffect.STORMCLAW, Power.class, Mobility.class, SHOCK);
    public static final Axe<Power, Technique> KHARABAKS_CLAW = new Axe<>("Kharabak's Claw", DECONSTRUCTION, UniqueEffect.KHARABAK, Power.class, Technique.class, TERRA);
    public static final Axe<Power, Mobility> EDGE_OF_DAWN = new Axe<>("Edge of Dawn", CUNNING, UniqueEffect.REZAKIRI, Power.class, Mobility.class, RADIANT);
    public static final Axe<Power, Utility> REAPER_OF_NIGHT = new Axe<>("Reaper of Night", CUNNING, UniqueEffect.SHROWD, Power.class, Utility.class, UMBRAL);
    public static final Axe<Power, Utility> SOVEREIGNS_WRATH = new Axe<>("Sovereign's Wrath", SHARPENED, UniqueEffect.KOSHAI, Power.class, Utility.class, TERRA);
    public static final Axe<Technique, Utility> STALKERS_MERCY = new Axe<>("Stalker's Mercy", WILD_FRENZY, UniqueEffect.RIFTSTALKER, Technique.class, Utility.class, UMBRAL);
    public static final Axe<Power, Utility> VALOMYRS_DECREE = new Axe<>("Valomyr's Decree", AETHERHUNTER, UniqueEffect.VALOMYR, Power.class, Utility.class, RADIANT);
    public static final Axe<Power, Defense> TURMOIL_OF_BOREUS = new Axe<>("Turmoil of Boreus", CONDITIONING, UniqueEffect.BOREUS, Power.class, Defense.class, FROST);

    public Axe(String name, Perk perk, UniqueEffect uniqueEffect, Class<P1> socket1Type, Class<P2> socket2Type, Element element) {
        super(name, perk, uniqueEffect, socket1Type, socket2Type, element);
    }

    private Axe(String name, Perk perk, UniqueEffect uniqueEffect, Socket<P1> socket1, Socket<P2> socket2, Element element) {
        super(name, perk, uniqueEffect, socket1, socket2, element);
    }

    @Override
    public Axe<P1, P2> socket(P1 perk1, P2 perk2) {
        return new Axe<>(getName(), getPerk(), getUniqueEffect(), getSocket1().socket(perk1), getSocket2().socket(perk2), getElement());
    }
}
