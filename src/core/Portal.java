package core;

public class Portal {
    public static enum State {
        UNLOCKED(false), LOCKED(true);
        public boolean value;
        private State(boolean value) {
            this.value = value;
        }
    }
    State locked;
    String target; //Should be the id of an area to go to
    
    public Portal(State locked, String target){
        this.locked = locked;
        this.target = target;
    }
    
    public Portal(boolean locked, String target) {
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
    
    public String getTarget(){
        return this.target;
    }
    
    public Item getDoor(Area currentArea){
        for(final Item i : currentArea.getItems()){
            if(i.getPortal() == this) return i;
        }
        return null;
    }
}
