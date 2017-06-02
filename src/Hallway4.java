import tbge.*;

/**
 * Created by lynds on 6/1/2017.
 */
public class Hallway4 extends Area {
    public Hallway4() {
        super("Hallway 4");
        this.getDoors().put(Direction.NORTH, new Door("Hallway 3"));
        this.getDoors().put(Direction.SOUTH, new Door("Hallway 5"));
        this.description = "More lockers. More seemingly meaningless posters.";
        this.getLocalActions().put(new VerbPhrase("read", "poster"), this::readPoster);
        this.getLocalActions().put(new VerbPhrase("inspect", "poster"), this::readPoster);
    }

    public boolean readPoster(Context c){
        System.out.print("\n" +
                "~==~?+:+,?=+???ZIZOOO8ZOOO7=~:I?II+IIIIM\n" +
                ".,.??=~?+.+Z888OZDDDNDDDN8D8O=?IIIII7IIM\n" +
                "=:?I7I?.,I$O88ZO888DDDDDDND8D877=I7I?IIM\n" +
                "?=+?I=,?I7OOO$ZO8888DD888DD888DZ?+$7IIIM\n" +
                "I?7I?I?I$ZOOZ$$ZOO888O8OOOOZ7Z88$I+7~+IM\n" +
                "I7~?=7+IOOO77I?I7?ZZ$OZZ$7Z7?IZ8O,+I?IIM\n" +
                "=$I+,~+788$I????++??II7I+7?????OO?.,77IM\n" +
                "?II+II+IO87I????+++=+=?++??+???7ZI,+I7IM\n" +
                "I?~?=:+?$O$I??+?+++==+==++++????$?:++I7M\n" +
                ",I+?:?7I7Z7I???+++========++++++Z+=~.I=M\n" +
                "?I??===7Z$????7I7II+=~====+++??+7+?=?=.M\n" +
                "I~I?=~:IO7??$ZIIZZO$ZI++?7$8O8Z7$+=:~:=M\n" +
                "+,?==.~77?7IIZO7$7$7$I++D$$$$OZIZ+:,I..M\n" +
                "I=~~==?=I:+I777III7?Z7+?8II?III?+?7,=??M\n" +
                "I+=:=,:??=???7?III?I7?++IZIIIIII??.,+I+M\n" +
                "=I+~??:II????+++==+?I??=??++=++++7=+.:?M\n" +
                "~II:I~=:???I?+==+??I+?+=?+???+++?+.=:+~M\n" +
                ",=~=,..,+?II???I???7II?+?7?III?????,..=M\n" +
                ".,,,.~,.~:7I??77I7IIIIII77II+77?I+.:=:=M\n" +
                "..=I.:::..77I+II$$7I?++?II7ZII??I:+?+?=M\n" +
                ",+7??..:.+77$?III7II====III??77$+~I~I??M\n" +
                "~=?~~~.==.,$$$I7II?II++?????I$$,++??,?+M\n" +
                "~=..:,,?,ODIZZZ$7IIIIIIIIIII7$:?II=~I:IM\n" +
                "~,,:~.~,ODDI$O8OZ77?I?????I7$DI77?7~+I?M\n" +
                ",=,~,,+$8DZII77Z8Z$7??I7??IINDDIZ7$,7?7M\n" +
                "?,::,IOZDDD??III778Z$I777$77NNDDI7+$I?+M\n" +
                ",,=Z8DDODDDO?+???II777I7777$DNDD8DZ=II+M\n" +
                "Z888DDD8DDDDZ+++++??IIIIII77DNND8DDDDDZM\n" +
                "DDDDDDNNDDDDD7++++++?????IIIDNNDDDDNNDDM\n" +
                "DDDDDDDNNNDDDD7==+++++?????+DNNDDDDDNNNM\n" +
                "DDDDDDDDNNNDDDD8:===+++++++ODDDDDDNDDNNM\n" +
                "DDDDDDNDDNNNDDDDD8::::~~:::DDDDNNDNDNNNM\n" +
                "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");

        if(!c.getState().contains("read_Boof_Poster")){
            ((ZorCK)(c.getGame())).addPoints(10);
            c.getState().add("read_Boof_Poster");
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean captureInput(VerbPhrase v, Context c) {
        return Game.GO_TO_NEXT;
    }
}
