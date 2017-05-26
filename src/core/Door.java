package core;

public class Door {
    private String key;
    private boolean locked;
    private String destinationId;

    public Door(String destination, String key){
        this.destinationId = Area.toID(destination);
        this.locked = true;
        this.key = key;
    }

    public Door(String destination){
        this.destinationId = Area.toID(destination);
        this.locked = false;
    }

    public void unlock(String key){
        if(key.equalsIgnoreCase(this.key)){
            this.locked = false;
            System.out.println("The " + this.key + " key opens the door opening the path to " + World.getArea(destinationId).getName());
        }else{
            System.out.println("The " + key + " key doesn't open this door--try the " + this.key + " key.");
        }
    }

    public String pass(){
        if(this.locked){
            System.out.println("You can't go that way, the door is locked. You need the " + this.key + " key to open it.");
            return null;
        } else {
            return this.destinationId;
        }
    }
}
