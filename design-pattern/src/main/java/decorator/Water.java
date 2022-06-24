package decorator;

public class Water extends Decorator {

    public Water(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String recipe() {
        return super.recipe() + " + 물";
    }
}
