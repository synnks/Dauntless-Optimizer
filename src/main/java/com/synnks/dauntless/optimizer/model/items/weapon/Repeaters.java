package com.synnks.dauntless.optimizer.model.items.weapon;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.Mobility;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import com.synnks.dauntless.optimizer.model.perks.Technique;
import com.synnks.dauntless.optimizer.model.perks.UniqueEffect;

public final class Repeaters<P1 extends Perk, P2 extends Perk> extends Weapon<P1, P2> {

    public static final Repeaters<Technique, Mobility> GENERIC_REPEATERS = new Repeaters<>("Generic Repeaters", null, null, Technique.class, Mobility.class, null);

    public Repeaters(String name, Perk perk, UniqueEffect uniqueEffect, Class<P1> socket1Type, Class<P2> socket2Type, Element element) {
        super(name, perk, uniqueEffect, socket1Type, socket2Type, element);
    }

    private Repeaters(String name, Perk perk, UniqueEffect uniqueEffect, Socket<P1> socket1, Socket<P2> socket2, Element element) {
        super(name, perk, uniqueEffect, socket1, socket2, element);
    }

    @Override
    protected Repeaters<P1, P2> socket(P1 perk1, P2 perk2) {
        return new Repeaters<>(getName(), getPerk(), getUniqueEffect(), getSocket1().socket(perk1), getSocket2().socket(perk2), getElement());
    }
}
