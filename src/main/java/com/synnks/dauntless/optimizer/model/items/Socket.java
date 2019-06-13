package com.synnks.dauntless.optimizer.model.items;

import com.synnks.dauntless.optimizer.model.perks.Perk;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public abstract class Socket<P extends Perk> implements Comparable<Socket<? extends Perk>> {

    private final Class<P> socketType;

    private Socket(Class<P> socketType) {
        this.socketType = socketType;
    }

    public static <P extends Perk> Socket<P> of(Class<P> socketType) {
        return new EmptySocket<>(socketType);
    }

    public Socket<P> socket(P perk) {
        return new FullSocket<>(socketType, perk);
    }

    public abstract Optional<P> getPerk();

    public Set<P> getAllPerks() {
        return Perk.getAllPerks(socketType);
    }

    @Override
    public int compareTo(Socket<? extends Perk> o) {
        final var thisSocketed = getPerk().isPresent();
        final var oSocketed = o.getPerk().isPresent();
        var result = socketType.getSimpleName().compareTo(o.socketType.getSimpleName());

        if (result == 0) {
            if (!thisSocketed && !oSocketed) {
                return result;
            }
            if (thisSocketed && !oSocketed) {
                return -1;
            }
            if (!thisSocketed) {
                return 1;
            }
            return getPerk().get().compare(o.getPerk().get());
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final var socket = (Socket<?>) o;
        return Objects.equals(socketType, socket.socketType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socketType);
    }

    private static final class EmptySocket<P extends Perk> extends Socket<P> {

        private EmptySocket(Class<P> socketType) {
            super(socketType);
        }

        @Override
        public Optional<P> getPerk() {
            return Optional.empty();
        }

        @Override
        public String toString() {
            return "EmptySocket{}";
        }
    }

    private static final class FullSocket<P extends Perk> extends Socket<P> {

        private final P perk;

        private FullSocket(Class<P> socketType, P perk) {
            super(socketType);
            this.perk = perk;
        }

        @Override
        public Optional<P> getPerk() {
            return Optional.of(perk);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            final var that = (FullSocket<?>) o;
            return Objects.equals(perk, that.perk);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), perk);
        }

        @Override
        public String toString() {
            return "FullSocket{" +
                    "perk=" + perk +
                    '}';
        }
    }
}
