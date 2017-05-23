package verbs;

import core.*;

import java.util.Random;

public class Curse extends Verb {

    // https://en.wiktionary.org/w/index.php?title=Category:English_vulgarities
    public Curse() {
        super("damn", Verb.usage().bare().noun(), "anal", "anus", "arse", "ass", "asshat",
                "asshole", "ballsack", "balls", "bastard", "bitch", "boi", "blowjob", "blow job",
                "bollock", "bollocks", "boner", "boob", "bungus", "bum", "butt", "butthead",
                "buttplug", "clitoris", "clusterfuck", "cock", "cocksucker", "coon", "cunt", "cum",
                "dafuq", "dick", "dickhat", "dickhead", "dickweed", "dildo", "douchebag", "dyke",
                "fag", "faggot", "fellate", "fellatio", "feltcher", "fuck", "f u c k",
                "fudgepacker", "fudge packer", "goddamn", "god damn", "hell", "purgatory", "homo",
                "jizz", "labia", "motherfucker", "muff", "nigger", "nigga", "penis", "piss", "porn",
                "poop", "prick", "pube", "pussy", "queef", "queer", "scrotum", "sex", "shit",
                "shitass", "slut", "smegma", "spunk", "tit", "tosser", "twat", "vagina", "wank",
                "whore", "whoreson");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Random rand = new Random();
        final int n = rand.nextInt(4);
        switch (n) {
            case 0:
                System.out.println("Tough shit, asshole");
                break;
            case 1:
                System.out.println("It's not so bad.  You could have been killed already.");
                break;
            case 2:
                System.out.println("Oh, dear. Such language from a supposed winning adventurer!");
                break;
            default:
                System.out.println("Such language in a high-class establishment like this!");
                break;
        }
    }
}
