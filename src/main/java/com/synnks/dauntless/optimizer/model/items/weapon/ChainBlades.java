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

public final class ChainBlades<P1 extends Enum & Perk, P2 extends Enum & Perk> extends Weapon<P1, P2, ChainBlades<P1, P2>> {

    public static final ChainBlades<Technique, Utility> RAGING_TEETH = new ChainBlades<>("Raging Teeth", RAGEHUNTER, null, Technique.class, Utility.class, null);
    public static final ChainBlades<Technique, Mobility> FLIGHT_OF_THE_SHRIKE = new ChainBlades<>("Flight of the Shrike", CONDITIONING, UniqueEffect.SHRIKE, Technique.class, Mobility.class, null);
    public static final ChainBlades<Technique, Defense> QUILLSHOTS_BONEHOOKS = new ChainBlades<>("Quillshot's Bonehooks", ACIDIC, null, Technique.class, Defense.class, null);
    public static final ChainBlades<Technique, Defense> SKARNS_MALICE = new ChainBlades<>("Skarn's Malice", WEIGHTED_STRIKES, UniqueEffect.SKARN, Technique.class, Defense.class, TERRA);
    public static final ChainBlades<Technique, Defense> CHARRED_BLADES = new ChainBlades<>("Charred Blades", AETHERHUNTER, null, Technique.class, Defense.class, BLAZE);
    public static final ChainBlades<Technique, Mobility> WINTER_WINDS = new ChainBlades<>("Winter Winds", NIMBLE, UniqueEffect.SKRAEV, Technique.class, Mobility.class, FROST);
    public static final ChainBlades<Technique, Mobility> EMBER_BLADES = new ChainBlades<>("Ember Blades", EVASIVE_FURY, UniqueEffect.EMBERMANE, Technique.class, Mobility.class, BLAZE);
    public static final ChainBlades<Technique, Power> THUNDERING_CUTTERS = new ChainBlades<>("Thundering Cutters", AETHERIC_ATTUNEMENT, UniqueEffect.DRASK, Technique.class, Power.class, SHOCK);
    public static final ChainBlades<Utility, Mobility> NAYZAGAS_REACH = new ChainBlades<>("Nayzaga's Reach", BARBED, UniqueEffect.NAYZAGA, Utility.class, Mobility.class, SHOCK);
    public static final ChainBlades<Technique, Defense> PANGARS_CLAWS = new ChainBlades<>("Pangar's Claws", WEIGHTED_STRIKES, null, Technique.class, Defense.class, FROST);
    public static final ChainBlades<Power, Power> INFERNOS_FANGS = new ChainBlades<>("Inferno's Fangs", OVERPOWER, UniqueEffect.HELLION, Power.class, Power.class, BLAZE);
    public static final ChainBlades<Technique, Mobility> STORM_BLADES = new ChainBlades<>("Storm Blades", ENERGIZED, UniqueEffect.STORMCLAW, Technique.class, Mobility.class, SHOCK);
    public static final ChainBlades<Technique, Mobility> KHARABAKS_WINGS = new ChainBlades<>("Kharabak's Wings", BLADESTORM, null, Technique.class, Mobility.class, TERRA);
    public static final ChainBlades<Technique, Power> FANGS_OF_DAWN = new ChainBlades<>("Fangs of Dawn", CUNNING, UniqueEffect.REZAKIRI, Technique.class, Power.class, RADIANT);
    public static final ChainBlades<Technique, Utility> EYES_OF_NIGHT = new ChainBlades<>("Eyes of Night", CUNNING, UniqueEffect.SHROWD, Technique.class, Utility.class, UMBRAL);
    public static final ChainBlades<Power, Utility> SOVEREIGNS_LASH = new ChainBlades<>("Sovereign's Lash", SHARPENED, UniqueEffect.KOSHAI, Power.class, Utility.class, TERRA);
    public static final ChainBlades<Technique, Utility> STALKERS_TRAP = new ChainBlades<>("Stalker's Trap", WILD_FRENZY, UniqueEffect.RIFTSTALKER, Technique.class, Utility.class, UMBRAL);
    public static final ChainBlades<Power, Utility> VALOMYRS_REVENGE = new ChainBlades<>("Valomyr's Revenge", AETHERHUNTER, UniqueEffect.VALOMYR, Power.class, Utility.class, RADIANT);
    public static final ChainBlades<Power, Defense> DESTINY_OF_BOREUS = new ChainBlades<>("Destiny of Boreus", CONDITIONING, UniqueEffect.BOREUS, Power.class, Defense.class, FROST);

    public ChainBlades(String name, Perk perk, UniqueEffect uniqueEffect, Class<P1> socket1Type, Class<P2> socket2Type, Element element) {
        super(name, perk, uniqueEffect, socket1Type, socket2Type, element);
    }

    private ChainBlades(String name, Perk perk, UniqueEffect uniqueEffect, Socket<P1> socket1, Socket<P2> socket2, Element element) {
        super(name, perk, uniqueEffect, socket1, socket2, element);
    }

    @Override
    public ChainBlades<P1, P2> socket(P1 perk1, P2 perk2) {
        return new ChainBlades<>(getName(), getPerk(), getUniqueEffect(), getSocket1().socket(perk1), getSocket2().socket(perk2), getElement());
    }
}
