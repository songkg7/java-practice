package basic.finalorder;

import java.util.ArrayList;
import java.util.List;

public abstract class MemoryRepository {

    private final List<String> lists = new ArrayList<>();

    public final void save(String s) {
        lists.add(to(s));
    }

    public abstract String to(String s);

    public List<String> getLists() {
        return lists;
    }
}
