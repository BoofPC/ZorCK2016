package items;

import core.*;

public class WhiteChocolate extends Item {
    public WhiteChocolate() {
        super();
        this.usage().take(Item.TAKABLE).food(Item.EDIBLE);
        this.name("White Chocolate").description("Its looks light and disgusting")
                .synonym("white chocolate", "chocolate", "chocolate bar")
                .taste("It tastes like hell");
    }
}
