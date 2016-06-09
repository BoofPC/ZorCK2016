package items;

import core.*;

public class MrSchuchart extends Item{

    public MrSchuchart(){
        super();
        this.name("Mr. Schuchart")
            .look("Mr. Schuchart is sitting in his chair reading essays about the colonization of the Midwest")
            .examine("All these essays talk about multiple shooters in the Kennedy assassination")
            .synonym("mr.schuchart","mr schuchart", "mr. schuchart", "schuchart");
    }

    @Override
    public boolean interact(final Command command, final Context context){
        if(command.getVerb().getTitle().equals("talk")){
            System.out.println("Oh, it's so hard to read these essays with the blinds open...");
            return true;
        }

        else if(command.getVerb().getTitle().equals("take")){
            final String noun = command.getNoun().name();
            switch(noun){
                case "pinata":
                    System.out.println("Oh heck no, that is MY pinata!");
                    break;
                default:
                    System.out.println("I'm not quite sure what you are looking for here but I don't have it...");
            }
            return true;
        }

        else if(command.getVerb().getTitle().equals("stab")){
            final String noun = command.getNoun().name();
            switch(noun){
                case "Mr. Schuchart":
                    System.out.println("Mr. Schuchart is unstabbable. You stab yourself in embarassment.");
                    final Player player = context.getPlayer();
                    player.setDeath(Game.Status.DIE);
                    break;
                default:
                    System.out.println("You can't stab that...");
            }
            return true;
        }

        else if(command.getVerb().getTitle().equals("hit")){
            final String noun = command.getNoun().name();
            switch(noun){
                case "Mr. Schuchart":
                    System.out.println("Well... that's rude.");
                    break;

                case "Pinata":
                    System.out.println("Your flimsy punch only causes Schuchart to laugh as the pinata is unharmed.");
                    break;

                default:
                    System.out.println("Schuchart says 'Wow kid, you've got some anger issues.'");
                    break;

            }
            return true;
        }
        return false;
    }
}
