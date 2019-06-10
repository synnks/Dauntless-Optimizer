package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.*;

import static com.synnks.dauntless.optimizer.model.Element.*;
import static com.synnks.dauntless.optimizer.model.perks.Defense.*;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.CONDITIONING;
import static com.synnks.dauntless.optimizer.model.perks.Power.*;
import static com.synnks.dauntless.optimizer.model.perks.Technique.*;
import static com.synnks.dauntless.optimizer.model.perks.Utility.*;

public final class Arms<P extends Enum & Perk> extends Armor<P, Arms<P>> {

    public static final Arms<Power> GNASHER_GRIPS = new Arms<>("Gnasher Grips", RAGEHUNTER, Power.class, null, null);
    public static final Arms<Mobility> SHRIKEDOWN_GLOVES = new Arms<>("Shrikedown Gloves", WEIGHTED_STRIKES, Mobility.class, null, null);
    public static final Arms<Technique> QUILLSPIKE_GRIPS = new Arms<>("Quillspike Grips", BARBED, Technique.class, null, null);
    public static final Arms<Defense> MIGHT_OF_STONE = new Arms<>("Might of Stone", FORTRESS, Defense.class, TERRA, SHOCK);
    public static final Arms<Utility> VOLCANIC_GRIPS = new Arms<>("Volcanic Grips", RAGE, Utility.class, BLAZE, FROST);
    public static final Arms<Technique> FIERY_GAUNTLETS = new Arms<>("Fiery Gauntlets", FIREPROOF, Technique.class, BLAZE, FROST);
    public static final Arms<Mobility> SKRAEVWING_GLOVES = new Arms<>("Skraevwing Gloves", WARMTH, Mobility.class, FROST, BLAZE);
    public static final Arms<Utility> DRASKSCALE_GAUNTLETS = new Arms<>("Draskscale Gauntlets", SHARPENED, Utility.class, SHOCK, TERRA);
    public static final Arms<Utility> SHOCKING_GRASP = new Arms<>("Shocking Grasp", AETHERIC_ATTUNEMENT, Utility.class, SHOCK, TERRA);
    public static final Arms<Defense> ARMS_OF_ICE = new Arms<>("Arms of Ice", KNOCKOUT_KING, Defense.class, FROST, BLAZE);
    public static final Arms<Power> HELLPLATE_BRACERS = new Arms<>("Hellplate Bracers", MOLTEN, Power.class, BLAZE, FROST);
    public static final Arms<Mobility> LIGHTNING_GLOVES = new Arms<>("Lightning Gloves", INSULATED, Mobility.class, SHOCK, TERRA);
    public static final Arms<Mobility> CLUTCHES_OF_THE_SWARM = new Arms<>("Clutches of the Swarm", CONDITIONING, Mobility.class, TERRA, SHOCK);
    public static final Arms<Technique> LIGHTS_REFUGE = new Arms<>("Light's Refuge", CONDUIT, Technique.class, RADIANT, UMBRAL);
    public static final Arms<Utility> DARK_EMBRACE = new Arms<>("Dark Embrace", MEDIC, Utility.class, UMBRAL, RADIANT);
    public static final Arms<Power> GRASP_OF_THORNS = new Arms<>("Grasp of Thorns", EVASIVE_FURY, Power.class, TERRA, SHOCK);
    public static final Arms<Mobility> HANDS_OF_THE_RIFT = new Arms<>("Hands of the Rift", EVASIVE_FURY, Mobility.class, UMBRAL, RADIANT);
    public static final Arms<Defense> GAUNTLETS_OF_VALOUR = new Arms<>("Gauntlets of Valour", LUCENT, Defense.class, RADIANT, UMBRAL);
    public static final Arms<Power> BOREAL_MIGHT = new Arms<>("Boreal Might", RAGE, Power.class, FROST, BLAZE);

    public Arms(String name, Perk existingPerk, Class<P> socketType, Element resistance, Element weakness) {
        super(name, existingPerk, socketType, resistance, weakness);
    }

    private Arms(String name, Perk existingPerk, Socket<P> socket, Element resistance, Element weakness) {
        super(name, existingPerk, socket, resistance, weakness);
    }

    @Override
    public Arms<P> socket(P perk) {
        return new Arms<>(getName(), getPerk(), getSocket().socket(perk), getResistance(), getWeakness());
    }
}

