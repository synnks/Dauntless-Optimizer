package com.synnks.dauntless.optimizer.model.items.armor;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import com.synnks.dauntless.optimizer.model.perks.PerkTest;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ArmorTest {

    private static final class MockArmor extends Armor<PerkTest.MockPerk, MockArmor> {

        private MockArmor(String name, Perk perk, Element weakness, Element resistance) {
            super(name, perk, PerkTest.MockPerk.class, weakness, resistance);
        }

        private MockArmor(String name, Perk perk, Socket<PerkTest.MockPerk> socket, Element weakness, Element resistance) {
            super(name, perk, socket, weakness, resistance);
        }

        @Override
        public MockArmor socket(PerkTest.MockPerk perk) {
            return new MockArmor(getName(), getPerk(), getSocket().socket(perk), getWeakness(), getResistance());
        }
    }

    @Test
    public void testConstructors() {
        var armor = new MockArmor("Test Armor", PerkTest.MockPerk.perk1, null, null);

        assertThat(armor.getName(), is("Test Armor"));
        assertThat(armor.getSocket().getPerk(), is(Optional.empty()));
        assertThat(armor.getPerk(), is(PerkTest.MockPerk.perk1));
        assertThat(armor.getWeakness(), nullValue());
        assertThat(armor.getResistance(), nullValue());

        var socketedArmor = new MockArmor("Test Socketed Armor", PerkTest.MockPerk.perk1, Socket.of(PerkTest.MockPerk.class).socket(PerkTest.MockPerk.perk1), null, null);

        assertThat(socketedArmor.getName(), is("Test Socketed Armor"));
        assertThat(socketedArmor.getSocket().getPerk(), is(Optional.of(PerkTest.MockPerk.perk1)));
        assertThat(socketedArmor.getPerk(), is(PerkTest.MockPerk.perk1));
        assertThat(socketedArmor.getWeakness(), nullValue());
        assertThat(socketedArmor.getResistance(), nullValue());
    }

    @Test
    public void testGetAllPerks() {
        var armor = new MockArmor("Test Armor", PerkTest.MockPerk.perk1, null, null);
        var armorWithPerk1 = armor.socket(PerkTest.MockPerk.perk1);
        var armorWithPerk2 = armor.socket(PerkTest.MockPerk.perk2);

        var armorWithPerk1Perks = armorWithPerk1.getAllPerks();
        var armorWithPerk2Perks = armorWithPerk2.getAllPerks();

        assertThat(armorWithPerk1Perks.get(PerkTest.MockPerk.perk1), is(2));
        assertThat(armorWithPerk1Perks.get(PerkTest.MockPerk.perk2), nullValue());

        assertThat(armorWithPerk2Perks.get(PerkTest.MockPerk.perk1), is(1));
        assertThat(armorWithPerk2Perks.get(PerkTest.MockPerk.perk2), is(1));
    }

    @Test
    public void testCompareTo() {
        var referenceArmor = new MockArmor("Armor1", PerkTest.MockPerk.perk1, null, null);
        var armorWithSameNameAndSamePerk = new MockArmor("Armor1", PerkTest.MockPerk.perk1, null, null);
        var armorWithDifferentNameAndSamePerk = new MockArmor("Armor2", PerkTest.MockPerk.perk1, null, null);
        var armorWithSameNameAndDifferentPerk = new MockArmor("Armor1", PerkTest.MockPerk.perk2, null, null);

        assertThat(referenceArmor.compareTo(armorWithSameNameAndSamePerk), is(0));
        assertThat(armorWithSameNameAndSamePerk.compareTo(referenceArmor), is(0));
        assertThat(referenceArmor.compareTo(armorWithDifferentNameAndSamePerk), is(-1));
        assertThat(armorWithDifferentNameAndSamePerk.compareTo(referenceArmor), is(1));
        assertThat(referenceArmor.compareTo(armorWithSameNameAndDifferentPerk), is(-1));
        assertThat(armorWithSameNameAndDifferentPerk.compareTo(referenceArmor), is(1));
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Test
    public void testGetAllFlavours() {
        var flavours = new MockArmor("Test Armor", PerkTest.MockPerk.perk1, null, null).getAllFlavours();
        var perks = flavours.stream().map(armor -> armor.getSocket().getPerk().get()).collect(Collectors.toUnmodifiableSet());

        assertThat(perks, containsInAnyOrder(PerkTest.MockPerk.values()));
    }

    @Test
    public void testEqualsAndHashCode() {
        var referenceArmor = new MockArmor("Armor1", PerkTest.MockPerk.perk1, null, null);
        var armorWithSameNameAndSamePerk = new MockArmor("Armor1", PerkTest.MockPerk.perk1, null, null);
        var armorWithDifferentNameAndSamePerk = new MockArmor("Armor2", PerkTest.MockPerk.perk1, null, null);
        var armorWithSameNameAndDifferentPerk = new MockArmor("Armor1", PerkTest.MockPerk.perk2, null, null);

        assertThat(referenceArmor.equals(armorWithSameNameAndSamePerk), is(true));
        assertThat(referenceArmor.equals(armorWithDifferentNameAndSamePerk), is(false));
        assertThat(referenceArmor.equals(armorWithSameNameAndDifferentPerk), is(false));

        assertThat(referenceArmor.hashCode(), is(armorWithSameNameAndSamePerk.hashCode()));
    }

    @Test
    public void testToString() {
        var string = new MockArmor("Test Armor", PerkTest.MockPerk.perk1, null, null).toString();

        assertThat(string.contains("name='Test Armor'"), is(true));
        assertThat(string.contains("perk=" + PerkTest.MockPerk.perk1.toString()), is(true));
        assertThat(string.contains("weakness=null"), is(true));
        assertThat(string.contains("resistance=null"), is(true));
    }
}