package strategy.shipbuildstrategy;

public class BulkShipStrategy implements BuildStrategy<Bulk> {

    @Override
    public Bulk build() {
        return new Bulk();
    }
}
