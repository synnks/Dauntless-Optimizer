package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.perks.*;

import static com.synnks.dauntless.optimizer.model.Element.*;
import static com.synnks.dauntless.optimizer.model.perks.Defense.*;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.*;
import static com.synnks.dauntless.optimizer.model.perks.Power.KNOCKOUT_KING;
import static com.synnks.dauntless.optimizer.model.perks.Power.RAGE;
import static com.synnks.dauntless.optimizer.model.perks.Technique.EVASIVE_FURY;
import static com.synnks.dauntless.optimizer.model.perks.Technique.SAVAGERY;
import static com.synnks.dauntless.optimizer.model.perks.Utility.*;

public class Head extends Armor<Head> {

    public static final Head GNASHER_CAP = new Head("Gnasher Cap", BLOODLESS, Defense.class, null, null);
    public static final Head SHRIKEDOWN_HELM = new Head("Shrikedown Helm", EVASION, Technique.class, null, null);
    public static final Head QUILLSPIKE_MASK = new Head("Quillshot Mask", SAVAGERY, Defense.class, null, null);
    public static final Head SIGHT_OF_STONE = new Head("Sight of Stone", TOUGH, Defense.class, TERRA, SHOCK);
    public static final Head VOLCANIC_HELM = new Head("Volcanic Helm", FIREPROOF, Defense.class, BLAZE, FROST);
    public static final Head FIERY_HELM = new Head("Fiery Helm", EVASIVE_FURY, Mobility.class, BLAZE, FROST);
    public static final Head SKRAEVWING_HELMET = new Head("Skraevwing Helmet", FLEET_FOOTED, Mobility.class, FROST, BLAZE);
    public static final Head DRASKSCALE_HELMET = new Head("Draskscale Helmet", AETHERIC_ATTUNEMENT, Power.class, SHOCK, TERRA);
    public static final Head SHOCKING_GAZE = new Head("Shocking Gaze", MEDIC, Utility.class, SHOCK, TERRA);
    public static final Head BROW_OF_ICE = new Head("Brow of Ice", KNOCKOUT_KING, Power.class, FROST, BLAZE);
    public static final Head HELLPLATE_CASQUE = new Head("Hellplate Casque", KNOCKOUT_KING, Technique.class, FROST, BLAZE);
    public static final Head LIGHTNING_HELM = new Head("Lightning Helm", ENERGIZED, Technique.class, SHOCK, TERRA);
    public static final Head EYE_OF_THE_SWARM = new Head("Eye of the Swarm", SHELLSHOCK_RESIST, Mobility.class, TERRA, SHOCK);
    public static final Head LIGHTS_CROWN = new Head("Light's Crown", CONDUIT, Technique.class, RADIANT, UMBRAL);
    public static final Head DARK_WATCH = new Head("Dark Watch", RAGE, Power.class, UMBRAL, RADIANT);
    public static final Head VISAGE_OF_THORNS = new Head("Visage of Thorns", AGILITY, Technique.class, TERRA, SHOCK);
    public static final Head GUISE_OF_THE_RIFT = new Head("Guise of the Rift", AETHERIC_ATTUNEMENT, Utility.class, UMBRAL, RADIANT);
    public static final Head CREST_OF_VALOUR = new Head("Crest of Valour", LUCENT, Power.class, RADIANT, UMBRAL);
    public static final Head BOREAL_EPIPHANY = new Head("Boreal Epiphany", CONDITIONING, Utility.class, FROST, BLAZE);

    public static final Head PRISMATIC_GRACE = new Head("Prismatic Grace", null, Technique.class, RADIANT, UMBRAL);
    public static final Head TRAGIC_ECHO = new Head("Tragic Echo", null, Power.class, UMBRAL, RADIANT);
    public static final Head THE_SKULLFORGE = new Head("The Skullforge", null, Defense.class, BLAZE, FROST);

    private Head(String name, Perk existingPerk, Perk socket, Class<? extends Perk> socketType, Element resistance, Element weakness) {
        super(name, existingPerk, socket, socketType, resistance, weakness);
    }

    private Head(String name, Perk existingPerk, Class<? extends Perk> socketType, Element resistance, Element weakness) {
        this(name, existingPerk, null, socketType, resistance, weakness);
    }

    @Override
    Head socket(Perk socket) {
        return new Head(getName(), getExistingPerk(), socket, getSocketType(), getResistance().orElse(null), getWeakness().orElse(null));
    }
}
