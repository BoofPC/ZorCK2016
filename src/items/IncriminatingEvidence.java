package items;

import core.Item;

class IncriminatingEvidence extends Item {
    
    public IncriminatingEvidence() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Incriminating Evidence")
                .examine("It's Incriminating Evidence of Mr.Booth...")
                .synonym("Evidence","Criminal","IE");
    }
    
}
