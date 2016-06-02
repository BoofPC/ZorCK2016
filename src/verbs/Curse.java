package verbs;

import core.*;
import java.util.Random;

public class Curse extends Verb {

    public Curse() {
        super("damn",
                new String[]{"anal",
                    "anus",
                    "arse",
                    "ass",
                    "asshole",
                    "ballsack",
                    "balls",
                    "bastard",
                    "bitch",
                    "blowjob",
                    "blow job",
                    "boner",
                    "boob",
                    "bum",
                    "butt",
                    "buttplug",
                    "clitoris",
                    "cock",
                    "cocksucker",
                    "coon",
                    "crap",
                    "cunt",
                    "dick",
                    "dildo",
                    "dyke",
                    "fag",
                    "fellate",
                    "fellatio",
                    "feltcher",
                    "fuck",
                    "f u c k",
                    "fudgepacker",
                    "fudge packer",
                    "goddamn",
                    "god damn",
                    "hell",
                    "homo",
                    "jizz",
                    "labia",
                    "motherfucker",
                    "muff",
                    "nigger",
                    "nigga",
                    "penis",
                    "piss",
                    "poop",
                    "prick",
                    "pube",
                    "pussy",
                    "queef",
                    "queer",
                    "scrotum",
                    "sex",
                    "shit",
                    "slut",
                    "smegma",
                    "spunk",
                    "tit",
                    "tosser",
                    "twat",
                    "vagina",
                    "wank",
                    "whore"},
                new boolean[]{true, true, false});
    }

    public void run(Command command, Context construct) {
        Random rand = new Random();
        int n = rand.nextInt(4);
        if (n == 0) {
            System.out.println("Tough shit, asshole");
        } else if (n == 1) {
            System.out.println("Its not so bad.  You could have "
                    + "been killed already.");
        } else if (n == 2) {
            System.out.println("Oh, dear. Such language from a "
                    + "supposed winning adventurer!");
        } else {
            System.out.println("Such language in a high-class establishment like this!");
        }
    }
}
