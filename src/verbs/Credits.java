package verbs;

import core.Command;
import core.Context;
import core.Verb;

public class Credits extends Verb {

    public Credits() {
        super("credits", new String[] {"c"}, new boolean[] {true, false, false});
    }

    public static void printlnp(String s) {
        System.out.println(s);
        pause(750);
    }

    public static void printlnp(String... strs) {
        for (String s : strs) {
            printlnp(s);
        }
    }

    public void run(Command command, Context construct) {
        //@formatter:off
            printlnp(
"",
"",
"",
"",
"",
"",
"",
"",
"d8888888P                    a88888b. dP     dP",
"     .d8'                   d8'   `88 88   .d8'",
"   .d8'   .d8888b. 88d888b. 88        88aaa8P' ",
" .d8'     88'  `88 88'  `88 88        88   `8b.",
"d8'       88.  .88 88       Y8.   .88 88     88",
"Y8888888P `88888P' dP        Y88888P' dP     dP",
"",
"",
"Created By Mr Booth's CompSci Classes",
"",
"",
"Core Programming:",
"\tSamantha Miller",
"\tHelen Keith",
"\tPeter Mattsen",
"\tCole Van Pelt",
"\tAidan Anderson",
"\tCody McCay",
"",
"",
"Story Writers:",
"\tChaz McCarty",
"\tJoy Clark",
"\tBecca Dotson",
"\tBrett Dayley",
"\tKalo Antonio",
"\tJacob Nelson",
"\tCameron Kluge",
"\tJason Gordon",
"",
"",
"Map and Item Designers:",
"\tKevin White",
"\tBailee Barrick",
"\tCalvin Fischer",
"",
"",
"Content Programmers:",
"\tAlex Johnson",
"\tCurtis Holden",
"\tWarren Coons",
"\tMae Pontius",
"\tGrace Smith",
"\tEric Ma",
"\tJosh Weston",
"\tDavid Thomas",
"\tBrayden Howard",
"\tNick Slatton",
"\tRyan Allen",
"\tMadison Largey",
"\tTrishana Place",
"\tStone Van Beynum",
"\tRachel Flowers",
"",
"",
"",
"",
"",
"© 2016 - ",
"\thttps://github.com/BoofPC/ZorCK2016",
"",
"",
"         `-:+osyyo++-         ",
"       :sddddmNNNNNNNdo       ",
"      .yddyhdmmmmmmmmhmm:     ",
"     `sdyo++o+yyyhsss++hd`    ",
"     .hmo//:::-::/:/:::/h:    ",
"     .sho//:::------::::s`    ",
"     .ho/+oosso/:-:/+ooo/     ",
"     :s:+ssssosso/osyyso+     ",
"     ./-/++++++++:+o+++//     ",
"     `:///:--:///::/::::-     ",
"      `-++/++/+++//++++/:     ",
"       `o+/+oo//////o++/:     ",
"        +yso++++/:///+s+      ",
"      :dysdhso+++++++o:       ",
"    `:hNy+oshhyo++++sdNh`     ",
" `/ymNNNm+///+ssssssshMNmy+-  ",
"hmNNNNNNNNo:-::////+oyMNNNNNNy",
"mNNNNMMMNNNy:--::::/:dNNNNNNMm",
"dNNNNNNNNNNmmy-.````sNNNNNNNNm",
"",
"",
"",
"",
"",
"",
"",
"",
"",
"",
"",
"",
"",
"",
"");
          //@formatter:on
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
