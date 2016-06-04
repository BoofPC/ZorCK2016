package verbs;

import java.util.Arrays;

import core.*;

public class Credits extends Verb {

    public Credits() {
        super("credits",
                Arrays.asList("c"),
                Verb.usage().bare());
    }

    public static void printlnp(final String s) {
        System.out.println(s);
        Credits.pause(750);
    }

    @Override
    public void run(final Command command, final Context construct) {
        command.getDirection();
        command.getNoun();

        construct.getPlayer();
        construct.getWorld();

        Credits.printlnp("\n\n\n\n\n\n\n");
        Credits.printlnp("d8888888P                    a88888b. dP     dP");
        Credits.printlnp("     .d8'                   d8'   `88 88   .d8'");
        Credits.printlnp("   .d8'   .d8888b. 88d888b. 88        88aaa8P' ");
        Credits.printlnp(" .d8'     88'  `88 88'  `88 88        88   `8b.");
        Credits.printlnp("d8'       88.  .88 88       Y8.   .88 88     88");
        Credits.printlnp("Y8888888P `88888P' dP        Y88888P' dP     dP");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("Created By Mr Booth's CompSci Classes");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("Core Programming:");
        Credits.printlnp("\tSamantha Miller");
        Credits.printlnp("\tHelen Keith");
        Credits.printlnp("\tPeter Mattsen");
        Credits.printlnp("\tCole Van Pelt");
        Credits.printlnp("\tAidan Anderson");
        Credits.printlnp("\tCody McCay");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("Story Writers:");
        Credits.printlnp("\tChaz McCarty");
        Credits.printlnp("\tJoy Clark");
        Credits.printlnp("\tBecca Dotson");
        Credits.printlnp("\tBrett Dayley");
        Credits.printlnp("\tKalo Antonio");
        Credits.printlnp("\tJacob Nelson");
        Credits.printlnp("\tCameron Kluge");
        Credits.printlnp("\tJason Gordon");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("Map and Item Designers:");
        Credits.printlnp("\tKevin White");
        Credits.printlnp("\tBailee Barrick");
        Credits.printlnp("\tCalvin Fischer");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("Content Programmers:");
        Credits.printlnp("\tAlex Johnson");
        Credits.printlnp("\tCurtis Holden");
        Credits.printlnp("\tWarren Coons");
        Credits.printlnp("\tMae Pontius");
        Credits.printlnp("\tGrace Smith");
        Credits.printlnp("\tEric Ma");
        Credits.printlnp("\tJosh Weston");
        Credits.printlnp("\tDavid Thomas");
        Credits.printlnp("\tBrayden Howard");
        Credits.printlnp("\tNick Slatton");
        Credits.printlnp("\tRyan Allen");
        Credits.printlnp("\tMadison Largey");
        Credits.printlnp("\tTrishana Place");
        Credits.printlnp("\tStone Van Beynum");
        Credits.printlnp("\tRachel Flowers");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("© 2016 - ");
        Credits.printlnp("\thttps://github.com/BoofPC/ZorCK2016");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("         `-:+osyyo++-         ");
        Credits.printlnp("       :sddddmNNNNNNNdo       ");
        Credits.printlnp("      .yddyhdmmmmmmmmhmm:     ");
        Credits.printlnp("     `sdyo++o+yyyhsss++hd`    ");
        Credits.printlnp("     .hmo//:::-::/:/:::/h:    ");
        Credits.printlnp("     .sho//:::------::::s`    ");
        Credits.printlnp("     .ho/+oosso/:-:/+ooo/     ");
        Credits.printlnp("     :s:+ssssosso/osyyso+     ");
        Credits.printlnp("     ./-/++++++++:+o+++//     ");
        Credits.printlnp("     `:///:--:///::/::::-     ");
        Credits.printlnp("      `-++/++/+++//++++/:     ");
        Credits.printlnp("       `o+/+oo//////o++/:     ");
        Credits.printlnp("        +yso++++/:///+s+      ");
        Credits.printlnp("      :dysdhso+++++++o:       ");
        Credits.printlnp("    `:hNy+oshhyo++++sdNh`     ");
        Credits.printlnp(" `/ymNNNm+///+ssssssshMNmy+-  ");
        Credits.printlnp("hmNNNNNNNNo:-::////+oyMNNNNNNy");
        Credits.printlnp("mNNNNMMMNNNy:--::::/:dNNNNNNMm");
        Credits.printlnp("dNNNNNNNNNNmmy-.````sNNNNNNNNm");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("Safety Pig!");
        Credits.printlnp("");
        Credits.printlnp("                               _");
        Credits.printlnp("  _._ _..._ .-',     _.._(`))");
        Credits.printlnp(" '-. `     '  /-._.-'    ',/");
        Credits.printlnp("    )         \\            '.");
        Credits.printlnp("   / _    _    |             \\");
        Credits.printlnp("  |  a    a    /              |");
        Credits.printlnp("  \\   .-.                     ;  ");
        Credits.printlnp("   '-('' ).-'       ,'       ;");
        Credits.printlnp("      '-;           |      .'");
        Credits.printlnp("        \\           \\    /");
        Credits.printlnp("         | 7  .__  _.-\\   \\");
        Credits.printlnp("         | |  |  ``/  /`  /");
        Credits.printlnp("       /,_|  |   /,_/   /");
        Credits.printlnp("           /,_/      '`-'");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");
        Credits.printlnp("");

    }

    public static void pause(final int time) {
        try {
            Thread.sleep(time);
        } catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
