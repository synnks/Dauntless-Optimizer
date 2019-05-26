package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.perks.*;

import static com.synnks.dauntless.optimizer.model.Element.*;
import static com.synnks.dauntless.optimizer.model.perks.Defense.*;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.CONDITIONING;
import static com.synnks.dauntless.optimizer.model.perks.Power.*;
import static com.synnks.dauntless.optimizer.model.perks.Technique.*;
import static com.synnks.dauntless.optimizer.model.perks.Utility.*;

public final class Arms extends Armor<Arms> {

    public static final Arms GNASHER_GRIPS = new Arms("Gnasher Grips", RAGEHUNTER, Power.class, null, null);
    public static final Arms SHRIKEDOWN_GLOVES = new Arms("Shrikedown Gloves", WEIGHTED_STRIKES, Mobility.class, null, null);
    public static final Arms QUILLSPIKE_GRIPS = new Arms("Quillspike Grips", BARBED, Technique.class, null, null);
    public static final Arms MIGHT_OF_STONE = new Arms("Might of Stone", FORTRESS, Defense.class, TERRA, SHOCK);
    public static final Arms VOLCANIC_GRIPS = new Arms("Volcanic Grips", RAGE, Utility.class, BLAZE, FROST);
    public static final Arms FIERY_GAUNTLETS = new Arms("Fiery Gauntlets", FIREPROOF, Technique.class, BLAZE, FROST);
    public static final Arms SKRAEVWING_GLOVES = new Arms("Skraevwing Gloves", WARMTH, Mobility.class, FROST, BLAZE);
    public static final Arms DRASKSCALE_GAUNTLETS = new Arms("Draskscale Gauntlets", SHARPENED, Utility.class, SHOCK, TERRA);
    public static final Arms SHOCKING_GRASP = new Arms("Shocking Grasp", AETHERIC_ATTUNEMENT, Utility.class, SHOCK, TERRA);
    public static final Arms ARMS_OF_ICE = new Arms("Arms of Ice", KNOCKOUT_KING, Defense.class, FROST, BLAZE);
    public static final Arms HELLPLATE_BRACERS = new Arms("Hellplate Bracers", MOLTEN, Power.class, BLAZE, FROST);
    public static final Arms LIGHTNING_GLOVES = new Arms("Lightning Gloves", INSULATED, Mobility.class, SHOCK, TERRA);
    public static final Arms CLUTCHES_OF_THE_SWARM = new Arms("Clutches of the Swarm", CONDITIONING, Mobility.class, TERRA, SHOCK);
    public static final Arms LIGHTS_REFUGE = new Arms("Light's Refuge", CONDUIT, Technique.class, RADIANT, UMBRAL);
    public static final Arms DARK_EMBRACE = new Arms("Dark Embrace", MEDIC, Utility.class, UMBRAL, RADIANT);
    public static final Arms GRASP_OF_THORNS = new Arms("Grasp of Thorns", EVASIVE_FURY, Power.class, TERRA, SHOCK);
    public static final Arms HANDS_OF_THE_RIFT = new Arms("Hands of the Rift", EVASIVE_FURY, Mobility.class, UMBRAL, RADIANT);
    public static final Arms GAUNTLETS_OF_VALOUR = new Arms("Gauntlets of Valour", LUCENT, Defense.class, RADIANT, UMBRAL);
    public static final Arms BOREAL_MIGHT = new Arms("Boreal Might", RAGE, Power.class, FROST, BLAZE);

    private Arms(String name, Perk existingPerk, Perk socket, Class<? extends Perk> socketType, Element resistance, Element weakness) {
        super(name, existingPerk, socket, socketType, resistance, weakness);
    }

    private Arms(String name, Perk existingPerk, Class<? extends Perk> socketType, Element resistance, Element weakness) {
        this(name, existingPerk, null, socketType, resistance, weakness);
    }

    @Override
    Arms socket(Perk socket) {
        return new Arms(getName(), getExistingPerk(), socket, getSocketType(), getResistance().orElse(null), getWeakness().orElse(null));
    }
}

