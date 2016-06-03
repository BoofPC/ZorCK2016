package verbs;

import core.*;

public class Credits extends Verb {

    public Credits() {
        super("credits",
                new String[]{"c"},
                Verb.usage().bare());
    }
    
    public static void printlnp(String s) {
        System.out.println(s);
        pause(750);
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        command.getNoun();

        construct.getPlayer();
        construct.getWorld();

        printlnp("\n\n\n\n\n\n\n");
        printlnp("d8888888P                    a88888b. dP     dP");
        printlnp("     .d8'                   d8'   `88 88   .d8'");
        printlnp("   .d8'   .d8888b. 88d888b. 88        88aaa8P' ");
        printlnp(" .d8'     88'  `88 88'  `88 88        88   `8b.");
        printlnp("d8'       88.  .88 88       Y8.   .88 88     88");
        printlnp("Y8888888P `88888P' dP        Y88888P' dP     dP");
        printlnp("");
        printlnp("");
        printlnp("Created By Mr Booth's CompSci Classes");
        printlnp("");
        printlnp("");
        printlnp("Core Programming:");
        printlnp("\tSamantha Miller");
        printlnp("\tHelen Keith");
        printlnp("\tPeter Mattsen");
        printlnp("\tCole Van Pelt");
        printlnp("\tAidan Anderson");
        printlnp("\tCody McCay");
        printlnp("");
        printlnp("");
        printlnp("Story Writers:");
        printlnp("\tChaz McCarty");
        printlnp("\tJoy Clark");
        printlnp("\tBecca Dotson");
        printlnp("\tBrett Dayley");
        printlnp("\tKalo Antonio");
        printlnp("\tJacob Nelson");
        printlnp("\tCameron Kluge");
        printlnp("\tJason Gordon");
        printlnp("");
        printlnp("");
        printlnp("Map and Item Designers:");
        printlnp("\tKevin White");
        printlnp("\tBailee Barrick");
        printlnp("\tCalvin Fischer");
        printlnp("");
        printlnp("");
        printlnp("Content Programmers:");
        printlnp("\tAlex Johnson");
        printlnp("\tCurtis Holden");
        printlnp("\tWarren Coons");
        printlnp("\tMae Pontius");
        printlnp("\tGrace Smith");
        printlnp("\tEric Ma");
        printlnp("\tJosh Weston");
        printlnp("\tDavid Thomas");
        printlnp("\tBrayden Howard");
        printlnp("\tNick Slatton");
        printlnp("\tRyan Allen");
        printlnp("\tMadison Largey");
        printlnp("\tTrishana Place");
        printlnp("\tStone Van Beynum");
        printlnp("\tRachel Flowers");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("© 2016 - ");
        printlnp("\thttps://github.com/BoofPC/ZorCK2016");
        printlnp("");
        printlnp("");
        printlnp("         `-:+osyyo++-         ");
        printlnp("       :sddddmNNNNNNNdo       ");
        printlnp("      .yddyhdmmmmmmmmhmm:     ");
        printlnp("     `sdyo++o+yyyhsss++hd`    ");
        printlnp("     .hmo//:::-::/:/:::/h:    ");
        printlnp("     .sho//:::------::::s`    ");
        printlnp("     .ho/+oosso/:-:/+ooo/     ");
        printlnp("     :s:+ssssosso/osyyso+     ");
        printlnp("     ./-/++++++++:+o+++//     ");
        printlnp("     `:///:--:///::/::::-     ");
        printlnp("      `-++/++/+++//++++/:     ");
        printlnp("       `o+/+oo//////o++/:     ");
        printlnp("        +yso++++/:///+s+      ");
        printlnp("      :dysdhso+++++++o:       ");
        printlnp("    `:hNy+oshhyo++++sdNh`     ");
        printlnp(" `/ymNNNm+///+ssssssshMNmy+-  ");
        printlnp("hmNNNNNNNNo:-::////+oyMNNNNNNy");
        printlnp("mNNNNMMMNNNy:--::::/:dNNNNNNMm");
        printlnp("dNNNNNNNNNNmmy-.````sNNNNNNNNm");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
        printlnp("");
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
