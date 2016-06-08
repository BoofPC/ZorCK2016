package core;

public class Portal {
    public static enum State {
        UNLOCKED(false), LOCKED(true);
        public boolean value;
        private State(final boolean value) {
            this.value = value;
        }
    }
    private State locked;
    private final Class<? extends Area> target; //Should be the id of an area to go to
//
    public Portal(final State locked, final Class<? extends Area> target){
        this.locked = locked;
        this.target = target;
    }

    public Portal(final boolean locked, final Class<? extends Area> target) {
        this(locked ? State.LOCKED : State.UNLOCKED, target);
    }

    public boolean isLocked(){
        return this.locked.value;
    }

    public void lock(){
        this.locked = State.LOCKED;
    }

    public void unlock(){
        this.locked = State.UNLOCKED;
    }

    public Class<? extends Area> getTarget(){
        return this.target;
    }

    public Item getDoor(final Area currentArea){
        return currentArea.items().stream().filter(i -> i.portal() == this).findAny()
                .orElse(null);
    }
}
