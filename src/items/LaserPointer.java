/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;
import core.*;
import items.*;

/**
 *
 * @author fischer5731c
 */
public class LaserPointer extends Item {
    public LaserPointer(){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.setName("Laser Pointer");
        this.addSynonym("laser");
        this.addSynonym("pointer");
        this.addSynonym("laserpionter");
    }

    @Override
    public void interact(Command command, Context context) {
        
    }
}
