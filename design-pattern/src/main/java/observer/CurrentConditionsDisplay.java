package observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private int id;
    private float temperature;
    private float humidity;
    private Subject weather;

    public CurrentConditionsDisplay(Subject weather, int id) {
        this.id = id;
        this.weather = weather;
        weather.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(
                "Divice ID: " + id + " Current conditions: " + temperature + " F degrees and " + humidity
                        + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
