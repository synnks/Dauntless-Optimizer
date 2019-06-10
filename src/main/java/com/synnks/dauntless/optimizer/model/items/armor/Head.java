package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.*;

import static com.synnks.dauntless.optimizer.model.Element.*;
import static com.synnks.dauntless.optimizer.model.perks.Defense.*;
import static com.synnks.dauntless.optimizer.model.perks.Mobility.*;
import static com.synnks.dauntless.optimizer.model.perks.Power.KNOCKOUT_KING;
import static com.synnks.dauntless.optimizer.model.perks.Power.RAGE;
import static com.synnks.dauntless.optimizer.model.perks.Technique.EVASIVE_FURY;
import static com.synnks.dauntless.optimizer.model.perks.Technique.SAVAGERY;
import static com.synnks.dauntless.optimizer.model.perks.Utility.*;

public final class Head<P extends Enum & Perk> extends Armor<P, Head<P>> {

    public static final Head<Defense> GNASHER_CAP = new Head<>("Gnasher Cap", BLOODLESS, Defense.class, null, null);
    public static final Head<Technique> SHRIKEDOWN_HELM = new Head<>("Shrikedown Helm", EVASION, Technique.class, null, null);
    public static final Head<Defense> QUILLSPIKE_MASK = new Head<>("Quillshot Mask", SAVAGERY, Defense.class, null, null);
    public static final Head<Defense> SIGHT_OF_STONE = new Head<>("Sight of Stone", TOUGH, Defense.class, TERRA, SHOCK);
    public static final Head<Defense> VOLCANIC_HELM = new Head<>("Volcanic Helm", FIREPROOF, Defense.class, BLAZE, FROST);
    public static final Head<Mobility> FIERY_HELM = new Head<>("Fiery Helm", EVASIVE_FURY, Mobility.class, BLAZE, FROST);
    public static final Head<Mobility> SKRAEVWING_HELMET = new Head<>("Skraevwing Helmet", FLEET_FOOTED, Mobility.class, FROST, BLAZE);
    public static final Head<Power> DRASKSCALE_HELMET = new Head<>("Draskscale Helmet", AETHERIC_ATTUNEMENT, Power.class, SHOCK, TERRA);
    public static final Head<Utility> SHOCKING_GAZE = new Head<>("Shocking Gaze", MEDIC, Utility.class, SHOCK, TERRA);
    public static final Head<Power> BROW_OF_ICE = new Head<>("Brow of Ice", KNOCKOUT_KING, Power.class, FROST, BLAZE);
    public static final Head<Technique> HELLPLATE_CASQUE = new Head<>("Hellplate Casque", KNOCKOUT_KING, Technique.class, FROST, BLAZE);
    public static final Head<Technique> LIGHTNING_HELM = new Head<>("Lightning Helm", ENERGIZED, Technique.class, SHOCK, TERRA);
    public static final Head<Mobility> EYE_OF_THE_SWARM = new Head<>("Eye of the Swarm", SHELLSHOCK_RESIST, Mobility.class, TERRA, SHOCK);
    public static final Head<Technique> LIGHTS_CROWN = new Head<>("Light's Crown", CONDUIT, Technique.class, RADIANT, UMBRAL);
    public static final Head<Power> DARK_WATCH = new Head<>("Dark Watch", RAGE, Power.class, UMBRAL, RADIANT);
    public static final Head<Technique> VISAGE_OF_THORNS = new Head<>("Visage of Thorns", AGILITY, Technique.class, TERRA, SHOCK);
    public static final Head<Utility> GUISE_OF_THE_RIFT = new Head<>("Guise of the Rift", AETHERIC_ATTUNEMENT, Utility.class, UMBRAL, RADIANT);
    public static final Head<Power> CREST_OF_VALOUR = new Head<>("Crest of Valour", LUCENT, Power.class, RADIANT, UMBRAL);
    public static final Head<Utility> BOREAL_EPIPHANY = new Head<>("Boreal Epiphany", CONDITIONING, Utility.class, FROST, BLAZE);

    public static final Head<Technique> PRISMATIC_GRACE = new Head<>("Prismatic Grace", UniqueEffect.PRISMATIC_GRACE, Technique.class, RADIANT, UMBRAL);
    public static final Head<Power> TRAGIC_ECHO = new Head<>("Tragic Echo", UniqueEffect.TRAGIC_ECHO, Power.class, UMBRAL, RADIANT);
    public static final Head<Defense> THE_SKULLFORGE = new Head<>("The Skullforge", UniqueEffect.THE_SKULLFORGE, Defense.class, BLAZE, FROST);

    public Head(String name, Perk perk, Class<P> socketType, Element weakness, Element resistance) {
        super(name, perk, socketType, weakness, resistance);
    }

    private Head(String name, Perk existingPerk, Socket<P> socket, Element resistance, Element weakness) {
        super(name, existingPerk, socket, resistance, weakness);
    }

    @Override
    public Head<P> socket(P perk) {
        return new Head<>(getName(), getPerk(), getSocket().socket(perk), getResistance(), getWeakness());
    }
}
