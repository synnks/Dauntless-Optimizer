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

public final class Sword<P1 extends Perk, P2 extends Perk> extends Weapon<P1, P2> {

    public static final Sword<Utility, Defense> RAGING_BLADE = new Sword<>("Raging Blade", RAGEHUNTER, null, Utility.class, Defense.class, null);
    public static final Sword<Mobility, Mobility> CRY_OF_THE_SHRIKE = new Sword<>("Cry of the Shrike", CONDITIONING, UniqueEffect.SHRIKE, Mobility.class, Mobility.class, null);
    public static final Sword<Technique, Defense> QUILLSHOTS_TUSK = new Sword<>("Quillshot's Tusk", ACIDIC, null, Technique.class, Defense.class, null);
    public static final Sword<Power, Defense> SKARNS_RANCOR = new Sword<>("Skarn's Rancor", KNOCKOUT_KING, UniqueEffect.SKARN, Power.class, Defense.class, TERRA);
    public static final Sword<Power, Defense> CHARRED_SABER = new Sword<>("Charred Saber", AETHERHUNTER, null, Power.class, Defense.class, BLAZE);
    public static final Sword<Technique, Mobility> WINTER_ICE = new Sword<>("Winter Ice", NIMBLE, UniqueEffect.SKRAEV, Technique.class, Mobility.class, FROST);
    public static final Sword<Technique, Mobility> EMBER_CUTLASS = new Sword<>("Ember Cutlass", EVASIVE_FURY, UniqueEffect.EMBERMANE, Technique.class, Mobility.class, BLAZE);
    public static final Sword<Power, Utility> THUNDERING_BLADE = new Sword<>("Thundering Blade", AETHERIC_ATTUNEMENT, UniqueEffect.DRASK, Power.class, Utility.class, SHOCK);
    public static final Sword<Utility, Mobility> NAYZAGAS_RAZOR = new Sword<>("Nayzaga's Razor", BARBED, UniqueEffect.NAYZAGA, Utility.class, Mobility.class, SHOCK);
    public static final Sword<Power, Defense> PANGARS_CALL = new Sword<>("Pangar's Call", KNOCKOUT_KING, null, Power.class, Defense.class, FROST);
    public static final Sword<Power, Power> INFERNOS_RAZOR = new Sword<>("Inferno's Razor", OVERPOWER, UniqueEffect.HELLION, Power.class, Power.class, BLAZE);
    public static final Sword<Technique, Mobility> STORM_SWORD = new Sword<>("Storm Sword", ENERGIZED, UniqueEffect.STORMCLAW, Technique.class, Mobility.class, SHOCK);
    public static final Sword<Technique, Mobility> KHARABAKS_SPUR = new Sword<>("Kharabak's Spur", BLADESTORM, null, Technique.class, Mobility.class, TERRA);
    public static final Sword<Technique, Utility> CALL_OF_DAWN = new Sword<>("Call of Dawn", CUNNING, UniqueEffect.REZAKIRI, Technique.class, Utility.class, RADIANT);
    public static final Sword<Power, Utility> VERGE_OF_NIGHT = new Sword<>("Verge of Night", CUNNING, UniqueEffect.SHROWD, Power.class, Utility.class, UMBRAL);
    public static final Sword<Power, Utility> SOVEREIGNS_TORMENT = new Sword<>("Sovereign's Torment", SHARPENED, UniqueEffect.KOSHAI, Power.class, Utility.class, TERRA);
    public static final Sword<Technique, Utility> STALKERS_STRIKE = new Sword<>("Stalker's Strike", WILD_FRENZY, UniqueEffect.RIFTSTALKER, Technique.class, Utility.class, UMBRAL);
    public static final Sword<Power, Utility> VALOMYRS_REGARD = new Sword<>("Valomyr's Regard", AETHERHUNTER, UniqueEffect.VALOMYR, Power.class, Utility.class, RADIANT);
    public static final Sword<Power, Defense> ONUS_OF_BOREUS = new Sword<>("Onus of Boreus", CONDITIONING, UniqueEffect.BOREUS, Power.class, Defense.class, FROST);

    public static final Sword<Power, Utility> THE_HUNGER = new Sword<>("The Hunger", null, UniqueEffect.THE_HUNGER, Power.class, Utility.class, UMBRAL);

    public Sword(String name, Perk perk, UniqueEffect uniqueEffect, Class<P1> socket1Type, Class<P2> socket2Type, Element element) {
        super(name, perk, uniqueEffect, socket1Type, socket2Type, element);
    }

    private Sword(String name, Perk perk, UniqueEffect uniqueEffect, Socket<P1> socket1, Socket<P2> socket2, Element element) {
        super(name, perk, uniqueEffect, socket1, socket2, element);
    }

    @Override
    protected Sword<P1, P2> socket(P1 perk1, P2 perk2) {
        return new Sword<>(getName(), getPerk(), getUniqueEffect(), getSocket1().socket(perk1), getSocket2().socket(perk2), getElement());
    }
}
