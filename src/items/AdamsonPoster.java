package items;

import core.*;

/**
 * This is an ASCII art poster of Adamson. To view the image, the player must read the poster.
 */
public class AdamsonPoster extends Item {

    public AdamsonPoster() {
        super();
        this.usage().take(Item.TAKABLE).read(Item.READABLE);

        this.name("Adamson Poster")
            .synonym("adamson poster", "poster", "flier", "picture")
            .description("It is the most beautiful image you have ever laid your eyes upon.")
        //@formatter:off
            .text(
          ".............`````...----.........................\n"
        + ".............``.-:::::::::::--....................\n"
        + "..............-:::-------::/:::---................\n"
        + ".............:/:::-....---:://///hy-..............\n"
        + "............:+//::--...---:////+++mm-.............\n"
        + "...........-+++/:::-------::://+++sNy.............\n"
        + "..........`so++/:::-------:::///++smd-............\n"
        + "..........`hoo+///:/:://+oosoo++++oddo............\n"
        + "`````.....`yosyddhso//ydmmdmhddhyhhhdh............\n"
        + "``````....:ohNmmNmmms/omNmmdhhhddyoymoh:..........\n"
        + "````````.ysoymdmNNNNo:/dddddmmdhsy+yhdh:..........\n"
        + "````````.-+./dNmdyydo::+hyssssoosossos/-..........\n"
        + "`````````.-:/ossssyho:-:+yysssyyyoooo+:...........\n"
        + "```````````./yhyyyhs+/-///yhso+ooo+o+o:...........\n"
        + "```````````.:hhsssyhhyyhddh/+++++/+++o-...........\n"
        + "``````....`..hysso+dNMMNmds++sysoo+oos............\n"
        + ".............+hyyyhsydhyoosshmdsoossy+............\n"
        + "..............yhyhmmmmdhyhhyyosyyyhhh-............\n"
        + "...............ydhsyhdhyhhhyoooyhddd+-/-......---.\n"
        + "................oddysssoo++o+sydmmdo-.sy.-.-------\n"
        + ".................-ydyssshyssydmmmh/-`/ddy+-.------\n"
        + "...................ymmmmmmmmmmmh+-..odddddho:-----\n"
        + "...............-/oyhdmNNNNNNmh/-...yhddddddddho:--\n"
        + ".............+ydmmN+hNNNNmhs+:...-yhddddddddhhddyo\n"
        + "...........-hddddm+.-dms/----.``/dhdddddddddddddhh\n"
        + "..........-ddddddy/sy-.```...``+ddhdhdddhddddddddd\n"
        + "..........yddhhdssMMd   ```` `sddddhdhddhddddddddd\n"
        + ".....----/ddhhds/MMMM+ ```  -hddddddddddhddddddddd\n"
        + "......---sdhhdyoNMMMMN.`   /ddddhhddddddddddhhdddh");
        //@formatter:on
    }

    @Override
    public void interact(final Command command, final Context context) {

    }

}
