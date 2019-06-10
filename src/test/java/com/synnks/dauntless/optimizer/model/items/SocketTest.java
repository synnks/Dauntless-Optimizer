package com.synnks.dauntless.optimizer.model.items;

import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import com.synnks.dauntless.optimizer.model.perks.PerkTest.MockPerk;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SocketTest {

    private enum MockPerk2 implements Perk {
        perk1("Perk 1");

        private final String name;

        MockPerk2(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @Test
    public void testGetPerkFromEmptySocket() {
        final var socket = Socket.of(MockPerk.class);

        assertThat(socket.getPerk(), is(Optional.empty()));
    }

    @Test
    public void testGetPerkFromFullSocket() {
        final var socket = Socket.of(MockPerk.class).socket(MockPerk.perk1);

        assertThat(socket.getPerk(), is(Optional.of(MockPerk.perk1)));
    }

    @Test
    public void testGetAllPerks() {
        final var socket = Socket.of(MockPerk.class);

        assertThat(socket.getAllPerks(), containsInAnyOrder(MockPerk.values()));
    }

    @Test
    public void testCompareEmptySocketsOfSameTypes() {
        final var socket1 = Socket.of(MockPerk.class);
        final var socket2 = Socket.of(MockPerk.class);

        assertThat(socket1.compareTo(socket2), is(0));
        assertThat(socket2.compareTo(socket1), is(0));
    }

    @Test
    public void testCompareEmptySocketsOfDifferentTypes() {
        final var socket1 = Socket.of(MockPerk.class);
        final var socket2 = Socket.of(MockPerk2.class);

        assertThat(socket1.compareTo(socket2), is(-1));
        assertThat(socket2.compareTo(socket1), is(1));
    }

    @Test
    public void testCompareFullSocketsOfSameTypeSocketedWithSamePerk() {
        final var socket1 = Socket.of(MockPerk.class).socket(MockPerk.perk1);
        final var socket2 = Socket.of(MockPerk.class).socket(MockPerk.perk1);

        assertThat(socket1.compareTo(socket2), is(0));
        assertThat(socket2.compareTo(socket1), is(0));
    }

    @Test
    public void testCompareFullSocketsOfSameTypeSocketedWithDifferentPerks() {
        final var socket1 = Socket.of(MockPerk.class).socket(MockPerk.perk1);
        final var socket2 = Socket.of(MockPerk.class).socket(MockPerk.perk2);

        assertThat(socket1.compareTo(socket2), is(-1));
        assertThat(socket2.compareTo(socket1), is(1));
    }

    @Test
    public void testCompareFullSocketsOfDifferentTypes() {
        final var socket1 = Socket.of(MockPerk.class).socket(MockPerk.perk1);
        final var socket2 = Socket.of(MockPerk2.class).socket(MockPerk2.perk1);

        assertThat(socket1.compareTo(socket2), is(-1));
        assertThat(socket2.compareTo(socket1), is(1));
    }

    @Test
    public void testCompareFullSocketToEmptySocketOfSameType() {
        final var socket1 = Socket.of(MockPerk.class).socket(MockPerk.perk1);
        final var socket2 = Socket.of(MockPerk.class);

        assertThat(socket1.compareTo(socket2), is(-1));
        assertThat(socket2.compareTo(socket1), is(1));
    }

    @Test
    public void testCompareFullSocketToEmptySocketOfDifferentTypes() {
        final var socket1 = Socket.of(MockPerk.class).socket(MockPerk.perk1);
        final var socket2 = Socket.of(MockPerk2.class);

        assertThat(socket1.compareTo(socket2), is(-1));
        assertThat(socket2.compareTo(socket1), is(1));
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Test
    public void testEqualsAndHashCodeEmptySocket() {
        final var referenceSocket = Socket.of(MockPerk.class);
        final var emptySocketOfSameType = Socket.of(MockPerk.class);
        final var emptySocketOfDifferentType = Socket.of(MockPerk2.class);
        final var fullSocketOfSameType = Socket.of(MockPerk.class).socket(MockPerk.perk1);
        final var fullSocketOfDifferentType = Socket.of(MockPerk2.class).socket(MockPerk2.perk1);

        assertThat(referenceSocket.equals(emptySocketOfSameType), is(true));
        assertThat(referenceSocket.equals(emptySocketOfDifferentType), is(false));
        assertThat(referenceSocket.equals(fullSocketOfSameType), is(false));
        assertThat(referenceSocket.equals(fullSocketOfDifferentType), is(false));

        assertThat(referenceSocket.hashCode(), is(emptySocketOfSameType.hashCode()));
    }

    @SuppressWarnings("EqualsBetweenInconvertibleTypes")
    @Test
    public void testEqualsAndHashCodeFullSocket() {
        final var referenceSocket = Socket.of(MockPerk.class).socket(MockPerk.perk1);
        final var emptySocketOfSameType = Socket.of(MockPerk.class);
        final var emptySocketOfDifferentType = Socket.of(MockPerk2.class);
        final var fullSocketOfSameTypeWithSamePerk = Socket.of(MockPerk.class).socket(MockPerk.perk1);
        final var fullSocketOfSameTypeWithDifferentPerk = Socket.of(MockPerk.class).socket(MockPerk.perk2);
        final var fullSocketOfDifferentType = Socket.of(MockPerk2.class).socket(MockPerk2.perk1);

        assertThat(referenceSocket.equals(emptySocketOfSameType), is(false));
        assertThat(referenceSocket.equals(emptySocketOfDifferentType), is(false));
        assertThat(referenceSocket.equals(fullSocketOfSameTypeWithSamePerk), is(true));
        assertThat(referenceSocket.equals(fullSocketOfSameTypeWithDifferentPerk), is(false));
        assertThat(referenceSocket.equals(fullSocketOfDifferentType), is(false));

        assertThat(referenceSocket.hashCode(), is(fullSocketOfSameTypeWithSamePerk.hashCode()));
    }

}