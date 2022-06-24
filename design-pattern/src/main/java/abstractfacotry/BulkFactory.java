package abstractfacotry;

import abstractfacotry.domain.Bulk;
import abstractfacotry.domain.Ship;

public class BulkFactory implements Factory<Ship> {

    @Override
    public Ship build() {
        return new Bulk("Bulk AMS RUBY");
    }

}
