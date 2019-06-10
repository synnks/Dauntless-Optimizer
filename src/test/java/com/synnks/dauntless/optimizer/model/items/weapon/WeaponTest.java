package com.synnks.dauntless.optimizer.model.items.weapon;

import com.synnks.dauntless.optimizer.model.Element;
import com.synnks.dauntless.optimizer.model.items.Socket;
import com.synnks.dauntless.optimizer.model.perks.Perk;
import com.synnks.dauntless.optimizer.model.perks.PerkTest;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class WeaponTest {

    private static final class MockWeapon extends Weapon<PerkTest.MockPerk, PerkTest.MockPerk, MockWeapon> {

        private MockWeapon(String name, Perk perk, Element element) {
            super(name, perk, null, PerkTest.MockPerk.class, PerkTest.MockPerk.class, element);
        }

        private MockWeapon(String name, Perk perk, Socket<PerkTest.MockPerk> socket1, Socket<PerkTest.MockPerk> socket2, Element element) {
            super(name, perk, null, socket1, socket2, element);
        }

        @Override
        public MockWeapon socket(PerkTest.MockPerk perk1, PerkTest.MockPerk perk2) {
            return new MockWeapon(getName(), getPerk(), getSocket1().socket(perk1), getSocket2().socket(perk2), getElement());
        }
    }

    @Test
    public void testConstructors() {
        var weapon = new MockWeapon("Test Weapon", PerkTest.MockPerk.perk1, null);

        assertThat(weapon.getName(), is("Test Weapon"));
        assertThat(weapon.getSocket1().getPerk(), is(Optional.empty()));
        assertThat(weapon.getSocket2().getPerk(), is(Optional.empty()));
        assertThat(weapon.getPerk(), is(PerkTest.MockPerk.perk1));
        assertThat(weapon.getElement(), nullValue());

        var socketedWeapon = new MockWeapon("Test Socketed Weapon", PerkTest.MockPerk.perk1, Socket.of(PerkTest.MockPerk.class).socket(PerkTest.MockPerk.perk1), Socket.of(PerkTest.MockPerk.class).socket(PerkTest.MockPerk.perk2), null);

        assertThat(socketedWeapon.getName(), is("Test Socketed Weapon"));
        assertThat(socketedWeapon.getSocket1().getPerk(), is(Optional.of(PerkTest.MockPerk.perk1)));
        assertThat(socketedWeapon.getSocket2().getPerk(), is(Optional.of(PerkTest.MockPerk.perk2)));
        assertThat(socketedWeapon.getPerk(), is(PerkTest.MockPerk.perk1));
        assertThat(socketedWeapon.getElement(), nullValue());
    }

    @Test
    public void testGetAllPerks() {
        var weapon = new MockWeapon("Test Weapon", PerkTest.MockPerk.perk1, null);
        var weaponWithPerk1 = weapon.socket(PerkTest.MockPerk.perk1, PerkTest.MockPerk.perk1);
        var weaponWithPerk2 = weapon.socket(PerkTest.MockPerk.perk2, PerkTest.MockPerk.perk2);

        var weaponWithPerk1Perks = weaponWithPerk1.getAllPerks();
        var weaponWithPerk2Perks = weaponWithPerk2.getAllPerks();

        assertThat(weaponWithPerk1Perks.get(PerkTest.MockPerk.perk1), is(3));
        assertThat(weaponWithPerk1Perks.get(PerkTest.MockPerk.perk2), nullValue());

        assertThat(weaponWithPerk2Perks.get(PerkTest.MockPerk.perk1), is(1));
        assertThat(weaponWithPerk2Perks.get(PerkTest.MockPerk.perk2), is(2));
    }

    @Test
    public void testCompareTo() {
        var referenceWeapon = new MockWeapon("Weapon1", PerkTest.MockPerk.perk1, null);
        var weaponWithSameNameAndSamePerk = new MockWeapon("Weapon1", PerkTest.MockPerk.perk1, null);
        var weaponWithDifferentNameAndSamePerk = new MockWeapon("Weapon2", PerkTest.MockPerk.perk1, null);
        var weaponWithSameNameAndDifferentPerk = new MockWeapon("Weapon1", PerkTest.MockPerk.perk2, null);

        assertThat(referenceWeapon.compareTo(weaponWithSameNameAndSamePerk), is(0));
        assertThat(weaponWithSameNameAndSamePerk.compareTo(referenceWeapon), is(0));
        assertThat(referenceWeapon.compareTo(weaponWithDifferentNameAndSamePerk), is(-1));
        assertThat(weaponWithDifferentNameAndSamePerk.compareTo(referenceWeapon), is(1));
        assertThat(referenceWeapon.compareTo(weaponWithSameNameAndDifferentPerk), is(-1));
        assertThat(weaponWithSameNameAndDifferentPerk.compareTo(referenceWeapon), is(1));
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Test
    public void testGetAllFlavours() {
        var flavours = new MockWeapon("Test Weapon", PerkTest.MockPerk.perk1, null).getAllFlavours();
        var perks1 = flavours.stream().map(armor -> armor.getSocket1().getPerk().get()).collect(Collectors.toUnmodifiableSet());
        var perks2 = flavours.stream().map(armor -> armor.getSocket2().getPerk().get()).collect(Collectors.toUnmodifiableSet());

        assertThat(perks1, containsInAnyOrder(PerkTest.MockPerk.values()));
        assertThat(perks2, containsInAnyOrder(PerkTest.MockPerk.values()));
    }

    @Test
    public void testEqualsAndHashCode() {
        var referenceWeapon = new MockWeapon("Weapon1", PerkTest.MockPerk.perk1, null);
        var weaponWithSameNameAndSamePerk = new MockWeapon("Weapon1", PerkTest.MockPerk.perk1, null);
        var weaponWithDifferentNameAndSamePerk = new MockWeapon("Weapon2", PerkTest.MockPerk.perk1, null);
        var weaponWithSameNameAndDifferentPerk = new MockWeapon("Weapon1", PerkTest.MockPerk.perk2, null);

        assertThat(referenceWeapon.equals(weaponWithSameNameAndSamePerk), is(true));
        assertThat(referenceWeapon.equals(weaponWithDifferentNameAndSamePerk), is(false));
        assertThat(referenceWeapon.equals(weaponWithSameNameAndDifferentPerk), is(false));

        assertThat(referenceWeapon.hashCode(), is(weaponWithSameNameAndSamePerk.hashCode()));
    }

    @Test
    public void testToString() {
        var string = new MockWeapon("Test Weapon", PerkTest.MockPerk.perk1, null).toString();

        assertThat(string.contains("name='Test Weapon'"), is(true));
        assertThat(string.contains("perk=" + PerkTest.MockPerk.perk1.toString()), is(true));
        assertThat(string.contains("element=null"), is(true));
    }

}