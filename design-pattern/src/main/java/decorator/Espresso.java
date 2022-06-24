package decorator;

public class Espresso implements Coffee {

    @Override
    public String recipe() {
        return "에스프레소";
    }
}
