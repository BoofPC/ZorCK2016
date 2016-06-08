package core;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class Verb {
    private final String title;
    private final List<String> synonyms;
    /**
     * Usage is a data class determining which verbs can 'take' what other parts of speech. Right
     * now commands can only be one verb and up to one other part, but eventually they could
     * theoretically be more
     *
     * Currently the array is [none, noun, direction] e.g., the verb "look" would have the usage
     * array [true, false, true] because you can write "look" or "look east" but not "look cat" The
     * verb "take" would have the usage array [false, true, false] because you cannot simply "take"
     * nor can you "take up," but you can "take cat"
     */
    private final Usage usage;

    public Verb(final String title, final Usage usage, final List<String> synonyms) {
        this.title = title;
        this.usage = usage;
        this.synonyms = synonyms;
    }

    public Verb(final String title, final Usage usage, final String... synonyms) {
        this(title, usage, Arrays.asList(synonyms));
    }

    public String getTitle() {
        return this.title;
    }

    public List<String> getSynonyms() {
        return this.synonyms;
    }

    public boolean hasMatching(final String input) {
        return this.title.equals(input) || this.synonyms.contains(input);
    }

    public Usage getUsage() {
        return this.usage;
    }

    public abstract void run(Command command, Context construct);

    public static Verb fromLambda(final String title, final List<String> synonyms,
            final Usage usage, final BiConsumer<Command, Context> f) {
        return new Verb(title, usage, synonyms) {
            @Override
            public void run(final Command command, final Context construct) {
                f.accept(command, construct);
            }
        };
    }

    public static Usage usage() {
        return new Usage();
    }

    public static class Usage {
        private boolean bare = false;
        private boolean noun = false;
        private boolean direction = false;
        private boolean arbitrary = false;

        public Usage() {}

        public boolean isBare() {
            return this.bare;
        }

        public Usage bare() {
            this.bare = true;
            return this;
        }

        public Usage notBare() {
            this.bare = false;
            return this;
        }

        public boolean isNoun() {
            return this.noun;
        }

        public Usage noun() {
            this.noun = true;
            return this;
        }

        public Usage notNoun() {
            this.noun = false;
            return this;
        }

        public boolean isDirection() {
            return this.direction;
        }

        public Usage direction() {
            this.direction = true;
            return this;
        }

        public Usage notDirection() {
            this.direction = false;
            return this;
        }

        public boolean isArbitrary() {
            return this.arbitrary;
        }

        public Usage arbitrary() {
            this.arbitrary = true;
            return this;
        }

        public Usage notArbirary() {
            this.arbitrary = false;
            return this;
        }
    }
}
