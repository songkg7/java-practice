package templatemethod;

public class GlassHouse extends HouseTemplate {

    @Override
    protected void buildWalls() {
        System.out.println("Building Glass Walls.");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Building Pillars with glass coating.");
    }
}
