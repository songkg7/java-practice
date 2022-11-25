package basic.time;

import java.time.ZonedDateTime;
import java.util.Objects;

public record Event(
        String name,
        ZonedDateTime eventDateTime
) {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(name, event.name)
                && Objects.equals(eventDateTime.toEpochSecond(), event.eventDateTime.toEpochSecond());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, eventDateTime.toEpochSecond());
    }
}
