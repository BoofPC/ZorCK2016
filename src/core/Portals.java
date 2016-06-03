package core;

import core.World.Direction;

/**
 * A convenience class to make setting and getting portals nicer. 
 */
public final class Portals {
    private final Portal[] portals;
    public final static int PORTAL_SIZE = 10; 
    
    public Portals() {
        portals = new Portal[PORTAL_SIZE];
    }
    
    public Portal[] getPortals() {
        return portals;
    }
    
    public Portal getPortal(final Direction direction) {
        final Portal portal = portals[direction.ordinal()];
        return portal == null ? new Portal(Portal.State.LOCKED, null) : portal;
    }
    
    public Portals setPortal(final Direction direction, final Portal portal) {
        portals[direction.ordinal()] = portal;
        return this;
    }
    
    public Portal down() {
        return portals[Direction.DOWN.ordinal()];
    }
    
    public Portals down(final Portal p) {
        portals[Direction.DOWN.ordinal()] = p;
        return this;
    }
    
    public Portal east() {
        return portals[Direction.EAST.ordinal()];
    }
    
    public Portals east(final Portal p) {
        portals[Direction.EAST.ordinal()] = p;
        return this;
    }
    
    public Portal north() {
        return portals[Direction.NORTH.ordinal()];
    }
    
    public Portals north(final Portal p) {
        portals[Direction.NORTH.ordinal()] = p;
        return this;
    }
    
    public Portal northeast() {
        return portals[Direction.NORTHEAST.ordinal()];
    }
    
    public Portals northeast(final Portal p) {
        portals[Direction.NORTHEAST.ordinal()] = p;
        return this;
    }
    
    public Portal south() {
        return portals[Direction.SOUTH.ordinal()];
    }
    
    public Portals south(final Portal p) {
        portals[Direction.SOUTH.ordinal()] = p;
        return this;
    }
    
    public Portal southeast() {
        return portals[Direction.SOUTHEAST.ordinal()];
    }
    
    public Portals southeast(final Portal p) {
        portals[Direction.SOUTHEAST.ordinal()] = p;
        return this;
    }
    
    public Portal southwest() {
        return portals[Direction.SOUTHWEST.ordinal()];
    }
    
    public Portals southwest(final Portal p) {
        portals[Direction.SOUTHWEST.ordinal()] = p;
        return this;
    }
    
    public Portal northwest() {
        return portals[Direction.NORTHWEST.ordinal()];
    }
    
    public Portals northwest(final Portal p) {
        portals[Direction.NORTHWEST.ordinal()] = p;
        return this;
    }
    
    public Portal up() {
        return portals[Direction.UP.ordinal()];
    }
    
    public Portals up(final Portal p) {
        portals[Direction.UP.ordinal()] = p;
        return this;
    }
    
    public Portal west() {
        return portals[Direction.WEST.ordinal()];
    }
    
    public Portals west(final Portal p) {
        portals[Direction.WEST.ordinal()] = p;
        return this;
    }
}
