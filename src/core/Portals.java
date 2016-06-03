package core;

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
    
    public Portal getPortal(final int direction) {
        final Portal portal = portals[direction];
        return portal == null ? new Portal(true, null) : portal;
    }
    
    public Portals setPortal(final int direction, final Portal portal) {
        portals[direction] = portal;
        return this;
    }
    
    public Portal down() {
        return portals[World.DOWN];
    }
    
    public Portals down(final Portal p) {
        portals[World.DOWN] = p;
        return this;
    }
    
    public Portal east() {
        return portals[World.EAST];
    }
    
    public Portals east(final Portal p) {
        portals[World.EAST] = p;
        return this;
    }
    
    public Portal north() {
        return portals[World.NORTH];
    }
    
    public Portals north(final Portal p) {
        portals[World.NORTH] = p;
        return this;
    }
    
    public Portal northeast() {
        return portals[World.NORTHEAST];
    }
    
    public Portals northeast(final Portal p) {
        portals[World.NORTHEAST] = p;
        return this;
    }
    
    public Portal south() {
        return portals[World.SOUTH];
    }
    
    public Portals south(final Portal p) {
        portals[World.SOUTH] = p;
        return this;
    }
    
    public Portal southeast() {
        return portals[World.SOUTHEAST];
    }
    
    public Portals southeast(final Portal p) {
        portals[World.SOUTHEAST] = p;
        return this;
    }
    
    public Portal southwest() {
        return portals[World.SOUTHWEST];
    }
    
    public Portals southwest(final Portal p) {
        portals[World.SOUTHWEST] = p;
        return this;
    }
    
    public Portal up() {
        return portals[World.UP];
    }
    
    public Portals up(final Portal p) {
        portals[World.UP] = p;
        return this;
    }
    
    public Portal west() {
        return portals[World.WEST];
    }
    
    public Portals west(final Portal p) {
        portals[World.WEST] = p;
        return this;
    }
}
