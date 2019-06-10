package com.synnks.dauntless.optimizer.model.perks;

import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PerkTest {

    public enum MockPerk implements Perk {
        perk1("test perk 1"),
        perk2("test perk 2");

        private final String name;

        MockPerk(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    @Test
    public void testGetName() {
        var perk = new Perk() {
            @Override
            public String toString() {
                return "test perk";
            }
        };

        assertThat(perk.getName(), is("test perk"));
    }

    @Test
    public void testGetGetAllPerks() {
        assertThat(Perk.getAllPerks(MockPerk.class), containsInAnyOrder(MockPerk.values()));
    }

    @Test
    public void testCompare() {
        assertThat(MockPerk.perk1.compare(MockPerk.perk1), is(0));
        assertThat(MockPerk.perk1.compare(MockPerk.perk2), is(-1));
        assertThat(MockPerk.perk2.compare(MockPerk.perk1), is(1));
    }
}