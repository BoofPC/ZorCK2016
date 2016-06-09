package items;

import core.Item;

class IncriminatingEvidence extends Item {

    public IncriminatingEvidence() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("incriminating evidence")
                .examine("It's Incriminating Evidence of Mr.Booth...")
                .synonym("evidence","criminal");
    }

}
