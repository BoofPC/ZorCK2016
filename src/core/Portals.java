package core;

import core.World.Direction;

/**
 * A convenience class to make setting and getting portals nicer.
 */
public final class Portals {
    private final Portal[] portals;
    public final static int PORTAL_SIZE = 10;

    public Portals() {
        this.portals = new Portal[Portals.PORTAL_SIZE];
    }

    public Portal[] getPortals() {
        return this.portals;
    }

    public Portal getPortal(final Direction direction) {
        final Portal portal = this.portals[direction.ordinal()];
        return portal == null ? new Portal(Portal.State.LOCKED, null) : portal;
    }

    public Portals setPortal(final Direction direction, final Portal portal) {
        this.portals[direction.ordinal()] = portal;
        return this;
    }

    public Portal down() {
        return this.getPortal(Direction.DOWN);
    }

    public Portals down(final Portal p) {
        return this.setPortal(Direction.DOWN, p);
    }

    public Portal east() {
        return this.getPortal(Direction.EAST);
    }

    public Portals east(final Portal p) {
        return this.setPortal(Direction.EAST, p);
    }

    public Portal north() {
        return this.getPortal(Direction.NORTH);
    }

    public Portals north(final Portal p) {
        return this.setPortal(Direction.NORTH, p);
    }

    public Portal northeast() {
        return this.getPortal(Direction.NORTHEAST);
    }

    public Portals northeast(final Portal p) {
        return this.setPortal(Direction.NORTHEAST, p);
    }

    public Portal south() {
        return this.getPortal(Direction.SOUTH);
    }

    public Portals south(final Portal p) {
        return this.setPortal(Direction.SOUTH, p);
    }

    public Portal southeast() {
        return this.getPortal(Direction.SOUTHEAST);
    }

    public Portals southeast(final Portal p) {
        return this.setPortal(Direction.SOUTHEAST, p);
    }

    public Portal southwest() {
        return this.getPortal(Direction.SOUTHWEST);
    }

    public Portals southwest(final Portal p) {
        return this.setPortal(Direction.SOUTHWEST, p);
    }

    public Portal northwest() {
        return this.getPortal(Direction.NORTHWEST);
    }

    public Portals northwest(final Portal p) {
        return this.setPortal(Direction.NORTHWEST, p);
    }

    public Portal up() {
        return this.getPortal(Direction.UP);
    }

    public Portals up(final Portal p) {
        return this.setPortal(Direction.UP, p);
    }

    public Portal west() {
        return this.getPortal(Direction.WEST);
    }

    public Portals west(final Portal p) {
        return this.setPortal(Direction.WEST, p);
    }
}
