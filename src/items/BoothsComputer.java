package items;

import core.*;

public class BoothsComputer extends Item{
    
    public BoothsComputer(){
        super();
        this.usage().active(Item.ON).lock(Item.LOCKED);
        this.name("Booths Computer")
            .examine("It's whirring and puffing as only computers and cats can do")
            .synonym("booths computer", "booth's computer", "computer", 
                    "boofs computer", "boof's computer")
            .taste("It tastes like plastic")
            .smell("It smells like burning circuitry. Maybe he should get that checked out?");
    }
    
    @Override
    public boolean interact(Command command, Context context){
        String verb = command.getVerb().getTitle();
        if(verb.equals("stab")||verb.equals("hit")||verb.equals("eat")){
            System.out.println("You attempted something stupid and broke your best "
                    + "bet at fixing your grade");
            System.out.println("Suicide is always an option");
            this.usage().active(Item.STATIC).lock(Item.LOCKED);
            return true;
        }else if(verb.equals("use")||verb.equals("unlock")){
            
        }
        return false;
    }
}
