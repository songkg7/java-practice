package observer;

import org.junit.jupiter.api.Test;

class CurrentConditionsDisplayTest {

    @Test
    void update() {
        Weather weather = new Weather();
        CurrentConditionsDisplay condition1 = new CurrentConditionsDisplay(weather, 1);
        CurrentConditionsDisplay condition2 = new CurrentConditionsDisplay(weather, 2);

        weather.setMeasurements(80, 65, 30.4f);
        weather.setMeasurements(82, 70, 29.2f);
    }

}
