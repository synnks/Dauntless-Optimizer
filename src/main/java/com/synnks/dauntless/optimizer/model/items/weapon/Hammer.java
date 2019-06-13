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

public final class Hammer<P1 extends Perk, P2 extends Perk> extends Weapon<P1, P2> {

    public static final Hammer<Power, Utility> RAGING_CRASH = new Hammer<>("Raging Crash", RAGEHUNTER, null, Power.class, Utility.class, null);
    public static final Hammer<Power, Mobility> FALL_OF_THE_SHRIKE = new Hammer<>("Fall of the Shrike", CONDITIONING, UniqueEffect.SHRIKE, Power.class, Mobility.class, null);
    public static final Hammer<Power, Defense> QUILLSHOTS_ROAR = new Hammer<>("Quillshot's Roar", ACIDIC, null, Power.class, Defense.class, null);
    public static final Hammer<Power, Defense> SKARNS_VENGEANCE = new Hammer<>("Skarn's Vengeance", KNOCKOUT_KING, UniqueEffect.SKARN, Power.class, Defense.class, TERRA);
    public static final Hammer<Power, Power> CHARRED_CRUSHER = new Hammer<>("Charred Crusher", AETHERHUNTER, null, Power.class, Power.class, BLAZE);
    public static final Hammer<Power, Mobility> EMBER_MAUL = new Hammer<>("Ember Maul", EVASIVE_FURY, UniqueEffect.EMBERMANE, Power.class, Mobility.class, BLAZE);
    public static final Hammer<Power, Mobility> WINTER_SQUALL = new Hammer<>("Winter Squall", NIMBLE, UniqueEffect.SKRAEV, Power.class, Mobility.class, FROST);
    public static final Hammer<Power, Defense> THUNDERING_MAUL = new Hammer<>("Thundering Maul", AETHERIC_ATTUNEMENT, UniqueEffect.DRASK, Power.class, Defense.class, SHOCK);
    public static final Hammer<Power, Utility> NAYZAGAS_CHARGE = new Hammer<>("Nayzaga's Charge", SAVAGERY, UniqueEffect.NAYZAGA, Power.class, Utility.class, SHOCK);
    public static final Hammer<Power, Defense> PANGARS_RAMPAGE = new Hammer<>("Pangar's Rampage", KNOCKOUT_KING, null, Power.class, Defense.class, FROST);
    public static final Hammer<Power, Power> INFERNOS_BURDEN = new Hammer<>("Inferno's Burden", OVERPOWER, UniqueEffect.HELLION, Power.class, Power.class, BLAZE);
    public static final Hammer<Power, Mobility> STORM_HAMMER = new Hammer<>("Storm Hammer", AETHERIC_ATTUNEMENT, UniqueEffect.STORMCLAW, Power.class, Mobility.class, SHOCK);
    public static final Hammer<Power, Technique> KHARABAKS_JAW = new Hammer<>("Kharabak's Jaw", DECONSTRUCTION, UniqueEffect.KHARABAK, Power.class, Technique.class, TERRA);
    public static final Hammer<Power, Mobility> BREAK_OF_DAWN = new Hammer<>("Break of Dawn", CUNNING, UniqueEffect.REZAKIRI, Power.class, Mobility.class, RADIANT);
    public static final Hammer<Power, Utility> FALL_OF_NIGHT = new Hammer<>("Fall of Night", CUNNING, UniqueEffect.SHROWD, Power.class, Utility.class, UMBRAL);
    public static final Hammer<Power, Utility> SOVEREIGNS_GRUDGE = new Hammer<>("Sovereign's Grudge", SHARPENED, UniqueEffect.KOSHAI, Power.class, Utility.class, TERRA);
    public static final Hammer<Technique, Utility> STALKERS_PRICE = new Hammer<>("Stalker's Price", WILD_FRENZY, UniqueEffect.RIFTSTALKER, Technique.class, Utility.class, UMBRAL);
    public static final Hammer<Power, Utility> VALOMYRS_BURDEN = new Hammer<>("Valomyr's Burden", AETHERHUNTER, UniqueEffect.VALOMYR, Power.class, Utility.class, RADIANT);
    public static final Hammer<Power, Defense> BRUTALITY_OF_BOREUS = new Hammer<>("Brutality of Boreus", CONDITIONING, UniqueEffect.BOREUS, Power.class, Defense.class, FROST);

    public static final Hammer<Power, Defense> MOLTEN_EDICT = new Hammer<>("Molten Edict", null, UniqueEffect.MOLTEN_EDICT, Power.class, Defense.class, BLAZE);

    public Hammer(String name, Perk perk, UniqueEffect uniqueEffect, Class<P1> socket1Type, Class<P2> socket2Type, Element element) {
        super(name, perk, uniqueEffect, socket1Type, socket2Type, element);
    }

    private Hammer(String name, Perk perk, UniqueEffect uniqueEffect, Socket<P1> socket1, Socket<P2> socket2, Element element) {
        super(name, perk, uniqueEffect, socket1, socket2, element);
    }

    @Override
    protected Hammer<P1, P2> socket(P1 perk1, P2 perk2) {
        return new Hammer<>(getName(), getPerk(), getUniqueEffect(), getSocket1().socket(perk1), getSocket2().socket(perk2), getElement());
    }
}
