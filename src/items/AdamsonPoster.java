package items;

import core.Item;
/**
 * This is an ASCII art poster of Adamson. To view the image, the player must
 * read the poster.
 * @author Samantha
 */
public class AdamsonPoster extends Item {
    
    public AdamsonPoster() {
        super();
        //can take
        setUsageKey(1, 1);
        //can read
        setUsageKey(6, 2);
        
        setName("Adamson Poster");
        addSynonym("poster");
        addSynonym("flier");
        addSynonym("picture");
        
        setDescription("It is the most beautiful image you have ever laid your"
                + "eyes upon.");
        
        setText(".............`````...----.........................\n" +
                ".............``.-:::::::::::--....................\n" +
                "..............-:::-------::/:::---................\n" +
                ".............:/:::-....---:://///hy-..............\n" +
                "............:+//::--...---:////+++mm-.............\n" +
                "...........-+++/:::-------::://+++sNy.............\n" +
                "..........`so++/:::-------:::///++smd-............\n" +
                "..........`hoo+///:/:://+oosoo++++oddo............\n" +
                "`````.....`yosyddhso//ydmmdmhddhyhhhdh............\n" +
                "``````....:ohNmmNmmms/omNmmdhhhddyoymoh:..........\n" +
                "````````.ysoymdmNNNNo:/dddddmmdhsy+yhdh:..........\n" +
                "````````.-+./dNmdyydo::+hyssssoosossos/-..........\n" +
                "`````````.-:/ossssyho:-:+yysssyyyoooo+:...........\n" +
                "```````````./yhyyyhs+/-///yhso+ooo+o+o:...........\n" +
                "```````````.:hhsssyhhyyhddh/+++++/+++o-...........\n" +
                "``````....`..hysso+dNMMNmds++sysoo+oos............\n" +
                ".............+hyyyhsydhyoosshmdsoossy+............\n" +
                "..............yhyhmmmmdhyhhyyosyyyhhh-............\n" +
                "...............ydhsyhdhyhhhyoooyhddd+-/-......---.\n" +
                "................oddysssoo++o+sydmmdo-.sy.-.-------\n" +
                ".................-ydyssshyssydmmmh/-`/ddy+-.------\n" +
                "...................ymmmmmmmmmmmh+-..odddddho:-----\n" +
                "...............-/oyhdmNNNNNNmh/-...yhddddddddho:--\n" +
                ".............+ydmmN+hNNNNmhs+:...-yhddddddddhhddyo\n" +
                "...........-hddddm+.-dms/----.``/dhdddddddddddddhh\n" +
                "..........-ddddddy/sy-.```...``+ddhdhdddhddddddddd\n" +
                "..........yddhhdssMMd   ```` `sddddhdhddhddddddddd\n" +
                ".....----/ddhhds/MMMM+ ```  -hddddddddddhddddddddd\n" +
                "......---sdhhdyoNMMMMN.`   /ddddhhddddddddddhhdddh");
    }
}
